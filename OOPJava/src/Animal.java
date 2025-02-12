public class Animal {

    public String name; // public -> tutti posso accedere in lettura/scrittura a questo membro
    protected int age; // protected -> permette l'accesso ad elementi dello stesso package in cui è definito sia in oggetti definiti in altri package purchè siano estensioni della classe di riferimento
    private String type; // private -> nessuno dall'esterno di questa classe può accedere al membro
    String category; // package -> permette l'accesso ad elementi dello stesso package in cui è definito

    public Animal(String name, int age, String type, String category) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.category = category;
    }

}
