package com.example.gym_management.security.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.gym_management.security.entity.ERole;
import com.example.gym_management.security.entity.Role;
import com.example.gym_management.security.entity.User;
import com.example.gym_management.security.payload.RegisterDto;
import com.example.gym_management.security.repository.RoleRepository;
import com.example.gym_management.security.repository.UserRepository;
import com.example.gym_management.security.service.AuthService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;

	@Autowired @Qualifier("createUserAdmin") ObjectProvider<RegisterDto> adminObjectProvider;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");

		// Get or create Role DB
		List<Role> roleList = roleRepository.findAll();
		if (roleList.size() == 0) {
			// Metodo da lanciare solo la prima volta
			// Serve per salvare i ruoli nel DB
			setRoleDefault();
		}

		// Get or create Admin DB
		List<User> userList = userRepository.findAll();
		if (userList.size() == 0) {
			setAdminDefault();
		}
		
	}
	
	private void setRoleDefault() {
		// Gli utenti possono essere CLIENTE, ISTRUTTORE, ADMIN.
		// I ruoli sono gestiti con ROLE_CLIENT, ROLE_INSTRUCTOR, ROLE_ADMIN.

		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role client = new Role();
		client.setRoleName(ERole.ROLE_CLIENT);
		roleRepository.save(client);
		
		Role instructor = new Role();
		instructor.setRoleName(ERole.ROLE_INSTRUCTOR);
		roleRepository.save(instructor);

	}
	
	private void setAdminDefault() {
		/*User user = new User();
		user.setName("Mario Rossi");
		user.setUsername("mariorossi");
		user.setEmail("mariorossi@example.com");
		user.setPassword(passwordEncoder.encode("Pa$$w0rd!"));

		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN).get();
		roles.add(userRole);
		user.setRoles(roles);
		System.out.println(user);
		userRepository.save(user);*/

		authService.register(adminObjectProvider.getObject());

		System.out.println("Admin registered successfully!.");
	}

}
