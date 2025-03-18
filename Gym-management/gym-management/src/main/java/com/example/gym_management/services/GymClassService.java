package com.example.gym_management.services;

import com.example.gym_management.models.GymClass;
import com.example.gym_management.models.Membership;
import com.example.gym_management.payloadDTO.BookingDTO;
import com.example.gym_management.payloadDTO.GymClassDTO;
import com.example.gym_management.payloadDTO.ResponseGymClassDTO;
import com.example.gym_management.repositories.GymClassRepository;
import com.example.gym_management.repositories.MembershipRepository;
import com.example.gym_management.security.entity.ERole;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.exception.MyAPIException;
import com.example.gym_management.security.repository.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymClassService {

    @Autowired @Qualifier("createGymClass") ObjectProvider<GymClass> gymClassObjectProvider;
    @Autowired GymClassRepository gymClassRepository;
    @Autowired UserRepository userRepository;
    @Autowired MembershipRepository membershipRepository;

    public ResponseGymClassDTO createGymClass(GymClassDTO gymClassDTO) {

        // add check for username exists in database
        if(!userRepository.existsByUsername(gymClassDTO.getUsernameInstructor())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username not exists!.");
        }

        User user = userRepository.findByUsername(gymClassDTO.getUsernameInstructor()).get();
        System.out.println(user);


        if(!user.getRoles().stream().anyMatch(u -> u.getRoleName().equals(ERole.ROLE_INSTRUCTOR))) {
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "User not INSTRUCTOR!");
        }


        GymClass gc = gymClassObjectProvider.getObject();
        gc.setGymClassName(gymClassDTO.getGymClassName());
        gc.setStartTime(gymClassDTO.getStartTime());
        gc.setEndTime(gymClassDTO.getStartTime().plusHours(1));
        gc.setNumClientMax(gymClassDTO.getNumClientMax());
        gc.setInstructor(user);

        System.out.println(gc);
        gymClassRepository.save(gc);
        System.out.println("GymClass " + gc.getGymClassName() + " created!");

        ResponseGymClassDTO response = new ResponseGymClassDTO();
        response.setId(gc.getId());
        response.setGymClassName(gc.getGymClassName());
        response.setStartTime(gc.getStartTime());
        response.setEndTime(gc.getEndTime());
        response.setNumClientMax(gc.getNumClientMax());
        response.setUsernameInstructor(gc.getInstructor().getUsername());

        return response;
    }

    public List<ResponseGymClassDTO> getGymClassList() {
        return gymClassRepository.findAll().stream().map(gc -> {
            ResponseGymClassDTO response = new ResponseGymClassDTO();
            response.setId(gc.getId());
            response.setGymClassName(gc.getGymClassName());
            response.setStartTime(gc.getStartTime());
            response.setEndTime(gc.getEndTime());
            response.setNumClientMax(gc.getNumClientMax());
            response.setUsernameInstructor(gc.getInstructor().getUsername());
            return response;
        }).collect(Collectors.toList());
    }

    public List<User> getClientsByGymClass(Long gymClassId) {
        return gymClassRepository.findById(gymClassId).get().getGymClassClients();
    }

    public void createBooking(BookingDTO bookingDTO) {

        User user = userRepository.findByUsername(bookingDTO.getUsername()).get();
        List<GymClass> classList = gymClassRepository.findByGymClassName(bookingDTO.getGymClassName());
        GymClass gymClass = classList
                    .stream()
                    .filter(c -> c.getStartTime() == bookingDTO.getStartTime())
                    .findFirst()
                    .get();
        Membership membership = membershipRepository.findByUserId(user.getId()).get();

        // Controllo se abbonamento non è scaduto
        if(membership.getEndMembership().isBefore(LocalDate.now())) {
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Membership not active!.");
        }

        // Controllo se abbonamento è attivo
        if(!membership.isActive()) {
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Membership not active!.");
        }

        // Controllo se ci sono posti disponibili
        if(gymClass.getNumClientMax() < gymClass.getGymClassClients().size()) {
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Gym Class full!.");
        }

        // Controllo se ci sono già prenotazioni allo stesso orario
        if(getGymClassBooking(user,gymClass)) {
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "booking not found");
        }

        gymClass.getGymClassClients().add(user);

        gymClassRepository.save(gymClass);
    }

    public void deleteBooking(Long clasId, Long userId) {
        GymClass gymClass = gymClassRepository.findById(clasId).get();
        gymClass.setGymClassClients(
                gymClass.getGymClassClients()
                                .stream()
                                .filter(u -> u.getId() != userId)
                                .collect(Collectors.toList()));
        gymClassRepository.save(gymClass);
    }

    private boolean getGymClassBooking(User user, GymClass gymClass) {
        // Metodo che deve controllare se esiste già una prenotazione di un Utente allo stesso orario del corso che si vuole prenotare
        List<GymClass> classList = gymClassRepository.findAll(); // Leggo tutti i corsi disponibili
        List<GymClass> bookingUser = classList
                                        .stream()
                                        .filter(c -> c.getGymClassClients().contains(user)) // filtro tutti i corsi a cui lo User è iscritto
                                        .collect(Collectors.toList());
        // controllo se tra tutti i corsi a cui sono iscritto è presente almeno un corso che ha orario identico a quello a cui mi voglio iscrivere
        return bookingUser.stream().anyMatch(c -> c.getStartTime().equals(gymClass.getStartTime()));
    }

}
