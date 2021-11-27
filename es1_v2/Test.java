public class Test {
    public static void main(String[] args) {

        Person p1 = new Person("Person", "Alpha", 0);
        Person p2 = new Person("Person", "Beta", 0);

        assert p1.getName().matches("[A-Z][a-z]+( [A-Z][a-z]+)*") && p2.getName().matches("[A-Z][a-z]+( [A-Z][a-z]+)*")
                && p1.getSurname().matches("[A-Z][a-z]+( [A-Z][a-z]+)*")
                && p2.getSurname().matches("[A-Z][a-z]+( [A-Z][a-z]+)*") && p1.getsocialSN() >= 0
                && p2.getsocialSN() >= 0;

        Person.join(p1, p2);
        assert !p1.isSingle() && !p2.isSingle();

        Person.divorce(p1, p2);
        assert p1.isSingle() && p2.isSingle();
        
        System.out.println("passed all Integrity tests");

    }

}