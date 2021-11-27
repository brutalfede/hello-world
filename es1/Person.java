package Lab3.es1;

public class Person {
    private final String name; // valore obbligatorio e non modificabile;
    private final String surname; // valore obbligatorio e non modificabile;
    private final long socialSN; // valore obbligatorio e non modificabile,
    // non può essere negativo e deve
    // identificare ogni oggetto della classe: due oggetti di Person hanno lo stesso
    // codice fiscale se e solo se sono lo stesso oggetto.
    private Person spouse; // coniuge di tipo Person, valore opzionale e modificabile.

    public Person(String name, String surname, long socialSN) {
        String pattern = "[A-Z][a-z]+( [A-Z][a-z]+)*";
        if (!name.matches(pattern) || !surname.matches(pattern) || socialSN < 0)
            throw new NullPointerException();
        this.name = name;
        this.surname = surname;
        this.socialSN = socialSN;
    }

    public Person(String name, String surname, long socialSN, Person spouse) {
        this(name, surname, socialSN);
        this.spouse = spouse;
    }

    public String getName() {
        ;
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public long getsocialSN() {
        return this.socialSN;
    }

    // metodo di query restituisce true se e solo se la persona non ha coniuge;
    public boolean isSingle() {
        return this.spouse == null;
    }

    // class method for argument validation
    private static void checkforjoin(Person p1, Person p2) {
        if (p1 == p2 || !p1.isSingle() || !p2.isSingle())
            throw new IllegalArgumentException();
    }

    // class method for argument validation
    private static void checkfordivorce(Person p1, Person p2) {
        if (p1.spouse != p2 && p2.spouse != p1)
            throw new IllegalArgumentException();
    }

    // metodo che permette di sposare due persone p1 e p2, con la pre-condizione
    // che non siano la stessa persona e siano entrambe senza coniuge;
    public static void join(Person p1, Person p2) {
        Person.checkforjoin(p1, p2);
        p1.spouse = p2;
        p2.spouse = p1;
    }

    // metodo che permette di far divorziare due persone p1 e p2, con la
    // pre-condizione che
    // siano coniugi l'uno dell'altro;
    public static void divorce(Person p1, Person p2) {
        Person.checkfordivorce(p1, p2);
        p1.spouse = null;
        p2.spouse = null;
    }
}
