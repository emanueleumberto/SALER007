package Ereditarieta;

public class GestioneVeicoli {

    public static void main(String[] args) {
        Automobile a1 = new Automobile("Fiat", "500", "Rosso", 1200, 5);
        //System.out.println(a1.info());

        Moto m1 = new Moto("Honda", "Hornet", "Nero", 1000);
        //System.out.println(m1.info());

        Camper c1 = new Camper("Laika", "Camping", "Bianco", 1900, 7);
        //System.out.println(c1.info());

        Automobile a2 = new Automobile("Ford", "Fiesta", "Blu", 1500, 3);
        //System.out.println(a2.info());

        Moto m2 = new Moto("Ducati", "Monster", "Nero", 800);
        //System.out.println(m2.info());

        // Automobile[] arrAuto = new Automobile[3];
        // Moto[] arrMoto = new Moto[3];
        // Camper[] arrCamper = new Camper[3];

        Veicolo[] arrVeicoli = new Veicolo[5];
        arrVeicoli[0] = a1;
        arrVeicoli[1] = m1;
        arrVeicoli[2] = c1;
        arrVeicoli[3] = a2;
        arrVeicoli[4] = m2;

        for(int i=0; i< arrVeicoli.length; i++) {
            Veicolo v = arrVeicoli[i];
            if(v instanceof Automobile) {
                Automobile a = (Automobile) v;
                System.out.println(a.info());
            } else if(v instanceof Moto) {
                Moto m = (Moto) v;
                System.out.println(m.info());
            } else if(v instanceof Camper) {
                Camper c = (Camper) v;
                System.out.println(c.info());
            }
        }



    }

}
