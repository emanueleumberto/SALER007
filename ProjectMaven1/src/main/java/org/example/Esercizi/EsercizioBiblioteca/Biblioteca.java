package org.example.Esercizi.EsercizioBiblioteca;

import java.util.*;

public class Biblioteca {

    private List<Libro> listaLibriDisponibili;
    private Set<Lettore> lettoriRegistrati;
    private Map<Lettore, Set<Libro>> prestiti;

    public Biblioteca() {
        this.listaLibriDisponibili = new ArrayList<Libro>();
        this.lettoriRegistrati = new HashSet<Lettore>();
        this.prestiti = new HashMap<Lettore, Set<Libro>>();
    }

    public List<Libro> getListaLibriDisponibili() {
        return listaLibriDisponibili;
    }

    public Set<Lettore> getLettoriRegistrati() {
        return lettoriRegistrati;
    }

    public Map<Lettore, Set<Libro>> getPrestiti() {
        return prestiti;
    }

    public void aggiungiLibro(Libro libro) throws LibroException {
        // aggiunge un nuovo libro alla biblioteca
        if(libro != null) {
            this.listaLibriDisponibili.add(libro);
        } else {
            //Gestire eccezione!!!
            //System.out.println("Libro null!!");
            throw new LibroException("Libro null!!");
        }
    }

    public void registraLettore(Lettore lettore) throws LettoreException {
        // registra un nuovo lettore.
        if(lettore != null) {
            if(!this.lettoriRegistrati.add(lettore)) {
                //Gestire eccezione!!!
                //System.out.println("Lettore presente!");
                throw new LettoreException("Lettore già presente!!");
            }
        } else {
            //Gestire eccezione!!!
            //System.out.println("Lettore null!!");
            throw new LettoreException("Lettore null!!");
        }
    }

    public boolean prestaLibro(Lettore lettore, String isbn) throws PrestitoException {
        // assegna un libro a un lettore se disponibile,
        // restituendo true se il prestito è andato a buon fine, altrimenti false.

        Libro lib = trovaLibroDaISBN(isbn);
        if(this.lettoriRegistrati.contains(lettore) && lib != null) {
            // Effettuo prestito
            Set<Libro> libri = new HashSet<Libro>();
            libri.add(lib);
            this.prestiti.put(lettore, libri);
            this.listaLibriDisponibili.remove(lib);
            System.out.println("Libro " + lib.getTitolo() + " preso in prestito da " + lettore.getNome());
            return true;
        } else {
            //Gestire eccezione!!!
            //System.out.println("Prestito NON effettuato!!");
            throw new PrestitoException("Prestito NON effettuato!!");
        }

    }

    public boolean restituisciLibro(Lettore lettore, String isbn) throws PrestitoException {
        // permette al lettore di restituire un libro.

        if(this.lettoriRegistrati.contains(lettore)) {
            Set<Libro> prestitiLettore = getLibriInPrestito(lettore);
            for(Libro lib: prestitiLettore){
                if(lib.getIsbn().equals(isbn)) {
                    prestitiLettore.remove(lib);
                    this.listaLibriDisponibili.add(lib);
                    System.out.println("Libro " + lib.getTitolo() + " è stato restituito da " + lettore.getNome());
                    return true;
                }
            }
            throw new PrestitoException("Libro è stato preso in prestito da altri lettori!!");
        } else {
            //Gestire eccezione!!!
            //System.out.println("Restituzione NON effettuata!!");
            throw new PrestitoException("Restituzione NON effettuata!!");
        }
    }

    public Set<Libro> getLibriInPrestito(Lettore lettore) throws PrestitoException {
        if(this.prestiti.containsKey(lettore)) {
            return this.prestiti.get(lettore);
        } else {
            //Gestire eccezione!!!
            //System.out.println("Nessun prestito efettuato!");
            throw new PrestitoException("Nessun prestito efettuato!");
        }
    }

    public void stampaPrestiti() {
        Set<Lettore> listaChiavi =  this.prestiti.keySet();
        for(Lettore let : listaChiavi) {
            System.out.println("Lettore: " + let.getNome());
            for(Libro lib : this.prestiti.get(let)) {
                System.out.println("     - " + lib.getTitolo());
            }
        }
    }

    public Libro trovaLibroDaISBN(String isbn) {
        for(Libro lib : this.listaLibriDisponibili) {
            if(lib.getIsbn().equals(isbn)) {
                return lib;
            }
        }
        return null;
    }

    public Lettore trovaLettoreDaID(int id) {
        for(Lettore let : this.lettoriRegistrati) {
            if(let.getId() == id) {
                return let;
            }
        }
        return null;
    }
}
