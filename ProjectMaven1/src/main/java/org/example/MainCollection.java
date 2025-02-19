package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MainCollection {

    static Logger log = LoggerFactory.getLogger(MainCollection.class);

    public static void main(String[] args) {


        // Collections
        // Contenitori dinamici di elementi. A differenza degli array che hanno una dimensione fissa
        // Una Collection può essere ordinata o no, puòl ammettere dei duplicato o no.
        // L'interfaccia Collection non specifica nullad i questo.
        // Collection
        //               -> Non memorizza l'ordine in cui sono stati inseriti i dati
        //                  Non definisce se ci possono essere valori duplicati
        //                  Non può contenere valori primitivi ma solo classi Wrapper (Integer - Char - Boolean - Double)
        //      -> Set   -> La classe che implementa SET è HashSet
        //                  Non ammette duplicati e gli elementi non sono indicizzati
        //                  I valori inseriti nel SET non sono memorizzati in base all'oridne di inserimento
        //          -> SortedSet -> La classe che implementa SORTEDSET è TreeSet
        //                  Non ammette duplicati a differenza del SET SONO indicizzati
        //                  I valori inseriti SONO memorizzati in base all'oridne di inserimento
        //      -> List  -> La classe che implementa LIST è ArrayList
        //                  Gli elementi sono indicizzati e può contenere duplicati
        //                  I valori inseriti SONO memorizzati in base all'oridne di inserimento
        //                  Consente di aggiungere, rimuovere e modificare elementi in base ad un indice
        //                  Consente di leggere elementi specificando un indice
        //      -> Queue -> La classe che implementa QUEUE è LinkedLIst
        //                  Crea una coda che ha dei metodi per leggere inserire ed eliminare
        //                  elementi ad inizio e fine della lista
        // Map
        //               -> Definisce una funzione composta da chiave-valore. Non può contenere valori primitivi
        //                  Una chiave sarà un valore univoco che servirà per accedere al dato associato
        //                  Gli oggetti verranno memorizzati in base all'ordine di inserimento
        //  -> SortedMap -> Fornisce un ordine sulle chiavi

        // Collection c;
        // Set s = new HashSet();
        // SortedSet ss = new TreeSet();
        // List l = new ArrayList();
        // Queue q = new LinkedList();
        // Map m = new HashMap();
        // SortedMap sm = new TreeMap();

        //testCollection();
        //testList();
        //testSet();
        //testQueue();
        //testMap();
    }

    public static void testCollection() {
        Collection<String> c = new ArrayList<String>();
        c.add("Primo Elemento");
        c.add("Secondo Elemento");
        c.add("Terzo Elemento");

        boolean cont = c.contains("Secondo Elemento");
        log.info("Contains 'Secondo Elemento' " + cont);

        boolean isEmp = c.isEmpty();
        log.info("Contains isEmpty " + isEmp);

        int size = c.size();
        log.info("Contains size " + size);

        c.remove("Secondo Elemento");

        for (String s : c) {
            System.out.println(s);
        }

        c.clear();
        isEmp = c.isEmpty();
        log.info("Contains isEmpty " + isEmp);

    }

    public static void testList() {
        List<String> l = new ArrayList<String>();
        l.add("Primo Elemento");
        l.add("Secondo Elemento");
        l.add("Terzo Elemento");

        boolean cont = l.contains("Secondo Elemento");
        log.info("Contains 'Secondo Elemento' " + cont);

        boolean isEmp = l.isEmpty();
        log.info("Contains isEmpty " + isEmp);

        int size = l.size();
        log.info("Contains size " + size);

        l.remove("Secondo Elemento");

        //l.clear();
        //isEmp = l.isEmpty();
        //log.info("Contains isEmpty " + isEmp);

        String ele = l.get(0);
        log.info("Contains index 0 " + ele);

        l.set(1,"Nuovo Elemento");

        for (String s : l) {
            System.out.println(s);
        }

        int index = l.indexOf("Secondo Elemento"); // Restituisce l'indice dell'elemento o -1 se noon lo trova
        log.info("Index 'Primo Elemento' " + index);

        Object[] arr = l.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void testSet() {
        //Set<String> s = new HashSet<String>();
        SortedSet<String> s = new TreeSet<String>();

        s.add("Primo Elemento");
        s.add("Secondo Elemento");
        s.add("Terzo Elemento");
        s.add("Secondo Elemento"); // Valore duplicato | Non è stato inserito

        // .add(valore) -> restituisce true se il valore è sstato inserito correttamente nel set
        // restiruisce false se il valore è duplicato e quindi non è stato inserito nel set
        if(s.add("Quinto Elemento")) {
            System.out.println("Valore inserito nel SET");
        } else {
            System.out.println("Valore duplicato");
        }

        boolean cont = s.contains("Secondo Elemento");
        log.info("Contains 'Secondo Elemento' " + cont);

        boolean isEmp = s.isEmpty();
        log.info("Contains isEmpty " + isEmp);

        int size = s.size();
        log.info("Contains size " + size);

        s.remove("Secondo Elemento");

        for (String ele : s) {
            System.out.println(ele);
        }

        //s.clear();

        // Metodi si SortedSet

        String s1 = s.first();
        log.info("First element " + s1);
        String l1 = s.last();
        log.info("Last element " + l1);
    }

    public static void testQueue() {
        Queue<String> q = new LinkedList<String>();
        q.add("Primo Elemento");
        q.add("Secondo Elemento");
        q.add("Terzo Elemento");
        q.add("Quarto Elemento");
        q.add("Quinto Elemento");

        boolean cont = q.contains("Secondo Elemento");
        log.info("Contains 'Secondo Elemento' " + cont);

        boolean isEmp = q.isEmpty();
        log.info("Contains isEmpty " + isEmp);

        int size = q.size();
        log.info("Contains size " + size);

        q.remove("Secondo Elemento");

        //q.clear();

        String elePeek = q.peek(); // Legge il primo elemento della coda
        log.info("Queue peek " + elePeek);

        String elePool = q.poll(); // Legge e rimuove il primo elemento della coda
        log.info("Queue pool " + elePool);

        for (String s : q) {
            System.out.println(s);
        }

    }

    public static void testMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("A", "Primo Elemento");
        m.put("B", "Secondo Elemento");
        m.put("C", "Terzo Elemento");

        boolean contKey = m.containsKey("B");
        log.info("Contains 'B' " + contKey);

        boolean contValue = m.containsValue("Secondo Elemento");
        log.info("Contains 'Secondo Elemento' " + contValue);

        String ele = m.get("C");
        log.info("Value key 'C' " + ele);

        boolean isEmp = m.isEmpty();
        log.info("Map isEmpty " + isEmp);

        int size = m.size();
        log.info("Map size " + size);

        //m.clear();

        // Creo un set di chiavi da una mappa
        Set<String> keys =  m.keySet();

        for (String k : keys) {
            System.out.println(k);
        }

        Collection<String> values = m.values();
        for (String v : values) {
            System.out.println(v);
        }

    }

}
