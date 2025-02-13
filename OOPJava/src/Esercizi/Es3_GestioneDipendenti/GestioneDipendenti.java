package Esercizi.Es3_GestioneDipendenti;

public class GestioneDipendenti {

    public static void main(String[] args) {
        //Dipendente d1 = new Dipendente("0001", "Mario Rossi", Dipartimento.PRODUZIONE);
        //Dipendente d2 = new Dipendente("0002", "Giuseppe Verdi", Dipartimento.AMMINISTRAZIONE);
        //Dipendente d3 = new Dipendente("0003", "Francesca Neri", Dipartimento.VENDITE);

        DipendenteFullTime d1 = new DipendenteFullTime("0001", "Mario Rossi", Dipartimento.PRODUZIONE);
        DipendenteFullTime d2 = new DipendenteFullTime("0002", "Giuseppe Verdi", Dipartimento.AMMINISTRAZIONE);
        DipendentePartTime d3 = new DipendentePartTime("0003", "Francesca Neri", Dipartimento.VENDITE);
        Dirigente d4 = new Dirigente("0004", "Antonio Bianchi");
        DipendentePartTime d5 = new DipendentePartTime("0005", "Luigi Gialli", Dipartimento.PRODUZIONE);
        /*System.out.println(d1.info());
        System.out.println(d2.info());
        System.out.println(d3.info());
        System.out.println(d4.info());
        System.out.println(d5.info());*/

        Dipendente[] arrDipendenti = new Dipendente[5];
        arrDipendenti[0] = d1;
        arrDipendenti[1] = d2;
        arrDipendenti[2] = d3;
        arrDipendenti[3] = d4;
        arrDipendenti[4] = d5;

        for (int i=0; i< arrDipendenti.length; i++) {
            /*if(arrDipendenti[i] instanceof DipendenteFullTime) {
                DipendenteFullTime df = (DipendenteFullTime) arrDipendenti[i];
                df.info();
            } else if(arrDipendenti[i] instanceof DipendentePartTime) {
                DipendentePartTime dp = (DipendentePartTime) arrDipendenti[i];
                dp.info();
            } else if(arrDipendenti[i] instanceof Dirigente) {
                Dirigente d = (Dirigente) arrDipendenti[i];
                d.info();
            }*/
            System.out.println(arrDipendenti[i].info());
        }


        // Overloading dei metodi
        // In una classe posso avere metodi con lo stesso nome ma con firma diversa
        // Firma diversa per -> Numero di paramentri || Tipo di parametri || Posizione dei parametri
        /*d1.test();
        d1.test(5);
        d1.test(5, "Ciao");
        d1.test("Ciao");
        d1.test("Ciao", 5);*/
    }

}
