package Esercizio;

public class RiproduttoreMultimediale {
    public static void main(String[] args) {
        Audio a = new Audio("MiaCanzone", 4, 6);
        //a.play();

        Video v = new Video("MioVideo", 8, 6, 4);
        v.play();
    }
}
