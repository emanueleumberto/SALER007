package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) {
        // Lambda Functions
        // (args) -> { blocco di istruzioni }
        // (args) -> espressione

        List<String> lista = new ArrayList<String>();
        lista.add("Javascript");
        lista.add("Java");
        lista.add("Python");
        lista.add("NodeJS");
        lista.add("Php");

        for (int i = 0; i < lista.size(); i++) {
            //System.out.println(lista.get(i));
        }
        System.out.println("*************");
        for(String s : lista) {
            //System.out.println(s);
        }
        System.out.println("*************");
        //lista.forEach(ele -> System.out.println(ele));

        // Stream
        // Gli Stream permettono di modificare raggruppamenti di dati.
        // Uno Strem mi restituisce un flusso di dati su cui posso effettuare delle operazioni
        // l'elenco di operazioni di uno stream è chiamata pipeline

        Collection<String> c1 = new ArrayList<String>();
        c1.add("Javascript");
        c1.add("Java");
        c1.add("Python");
        c1.add("NodeJS");
        c1.add("Php");

        List<String> c2 = Arrays.asList("Javascript", "Java", "Python", "NodeJS", "Php");

        String[] arrStr = {"Javascript", "Java", "Python", "NodeJS", "Php"};
        List<String> c3 = Arrays.asList(arrStr);


        Random rand = new Random();
        double d = rand.nextDouble();


        // Sorgente
        // La sorgente dello Stream è l'elemento che lo genera
        Stream<String> myStream1 = c3.stream();
        Stream<String> myStream2 = Stream.of("Javascript", "Java", "Python", "NodeJS", "Php");
        Stream<Integer> myStream3 = Stream.iterate(0, n -> n+2).limit(10);
        Stream<Double> myStream4 = Stream.generate(new Random()::nextDouble).limit(10);
        Stream<String> myStream5 = Stream.<String>builder().add("Javascript").add("Java").add("Python").build();

        //myStream4.forEach(System.out::println);
        //myStream5.forEach(ele -> System.out.println(ele));

        // Posso operare su uno Stream in due modi
        // Tramite operazioni intermedie
        // Tramite operazioni finali

        // Operazioni intermedie
        // Sono tutte quelle operazioni che effettuano una trasformazione dello Stream e restituiscono uno Stream modificato.
        // La concatenazione di operazioni intermedie viene chiamata pipeline

        // iteration
        // filtering
        // mapping

        Stream<String> myStream = Stream.of("Javascript", "Java", "Python", "NodeJS", "Php", "Java", "C++");
        myStream.distinct()
                .filter(e -> e.length() > 3)
                .map(e -> e + "!!!")
                .sorted()
                .limit(3);
                //.forEach(System.out::println);

        // FlatMap
        Faker fake = new Faker(new Locale("it-IT"));
        List<User> listaUtenti = new ArrayList<User>();
        for (int i = 0; i < 3; i++) {
            listaUtenti.add(new User(
                            fake.name().firstName(),
                            fake.name().lastName(),
                            fake.address().city(),
                            fake.number().numberBetween(18, 80))
            );
        }

        listaUtenti.get(0).addHobby("Calcio");
        listaUtenti.get(0).addHobby("Tennis");
        listaUtenti.get(1).addHobby("Calcio");
        listaUtenti.get(2).addHobby("Surf");
        //listaUtenti.forEach(System.out::println);

        listaUtenti.stream()
                .flatMap(u -> u.getHobby().stream())
                .distinct()
                .forEach(System.out::println);

        OptionalDouble age = listaUtenti.stream()
                .mapToInt(User::getAge)
                //.forEach(System.out::println);
                //.max();
                //.min();
                //.sum();
                .average();

        System.out.println(age);

        // Operazioni finali
        // Sono tutte quelle operazioni che restituiscono un valore finale
        // Terminando la manipolazione dello Stream

        // Matching
        // Reduction
        // Collection

        Integer[] numArr = {8,5,6,2,7,4,3};
        int res = 0; // Accumulatore
        for (int i = 0; i < numArr.length; i++) {
            res += numArr[i];
        }

        // Reduction
        Stream<Integer> myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        Integer numReduction = myStreamNum.reduce(0, (acc, val) -> acc + val);
        //System.out.println(numReduction);
        //myStreamNum.forEach(System.out::println);

        // Collection -> Collectors.toList() | Collectors.toSet() | Collectors.toMap()
        myStream = Stream.of("Javascript", "Java", "Python", "NodeJS", "Php", "Java", "C++");
        List<String> myStreamMod =  myStream.distinct()
                .filter(e -> e.length() > 3)
                .sorted()
                .collect(Collectors.toList());
        //myStreamMod.forEach(System.out::println);

        // Matching
        myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        //myStreamNum.anyMatch(e -> e > 5); // true
        //myStreamNum.allMatch(e -> e > 5); // false
        //myStreamNum.noneMatch(e -> e > 5); // False


        // Collectors
        // Collectors.toList() -> Raccolgo tutti gli elementi manipolati dallo Stream in una List
        // Collectors.toSet() -> Raccolgo tutti gli elementi manipolati dallo Stream in un Set
        // Collectors.toMap() -> Raccolgo tutti gli elementi manipolati dallo Stream in un Map,
        //                       specificando chiave e valore.
        // Collectors.groupingBy() -> Raggruppare gli elementi di uno Stream in una mappa
        //                              basata su una funzione di raggruppamento in cui la chiave
        //                              sarà la proprietà sul quale voglio raggruppare e il valore
        //                              sarà una lista di elementi raggruppati.
        // Collectors.summingInt() -> Calcola la somma dei valori interi contenuti in uno Stream
        // Collectors.summingLong() -> Calcola la somma dei valori long contenuti in uno Stream
        // Collectors.summingDouble() -> Calcola la somma dei valori double contenuti in uno Stream
        // Collectors.averageInt() -> Calcola la media dei valori interi contenuti in uno Stream
        // Collectors.averageLong() -> Calcola la media dei valori long contenuti in uno Stream
        // Collectors.averageDouble() -> Calcola la media dei valori double contenuti in uno Stream

        // Comparators
        // Comparator è un metodo per la gestione avanzata di ordinamenti in uno Stream
        // .sorted(Comparator.comparing(Oggetto::proprieta))
        // .sorted(Comparator.comparingInt(Oggetto::IntProprieta))
        // .sorted(Comparator.comparingLong(Oggetto::LongProprieta))
        // .sorted(Comparator.comparingDouble(Oggetto::DoubleProprieta))

        // Mapping
        // .mapToInt(Oggetto::IntProprieta) -> Trasforma uno Stream di oggetti in uno Stream
        //                                  di interi con i valori della proprietà letta
        // .mapToLong(Oggetto::LongProprieta) -> Trasforma uno Stream di oggetti in uno Stream
        //                                  di Long con i valori della proprietà letta
        // .mapToDouble(Oggetto::DoubleProprieta) -> Trasforma uno Stream di oggetti in uno Stream
        //                                  di double con i valori della proprietà letta

        // .flatMap(obj -> obj.propList.stream()) ->  Trasforma uno Stream di oggetti in uno Stream
        //                                          di valori letti da una lista contenuta in una
        //                                          proprietà di ogni sigolo oggetto


    }
}
