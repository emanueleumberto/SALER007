public class Test {

    private int num1;
    private int num2;

    public Test(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int somma() { return num1 + num2; }
    public int differenza() { return num1 - num2; }
    public int moltiplicazione() {
        return num1 * num2;
    }
    public int divisione() {
        return num1 / num2;
        /*try {
            return num1 / num2;
        } catch (ArithmeticException e) {
            System.out.println("Non puoi dividere per 0");
            return 0;
        }*/
    }

@Override
    public String toString()   {
        return "Test: " + "num1=" + num1 + ", num2=" + num2 +
                " Somma: " + somma() + " Differenza: " + differenza() +
                " Moltiplicazione: " + moltiplicazione() + " Divisione: " + divisione();
       /* try {
            return "Test: " + "num1=" + num1 + ", num2=" + num2 +
                    " Somma: " + somma() + " Differenza: " + differenza() +
                    " Moltiplicazione: " + moltiplicazione() + " Divisione: " + divisione();
        } catch (Exception e) {
            return "Test: " + "num1=" + num1 + ", num2=" + num2;
        }*/
    }
}
