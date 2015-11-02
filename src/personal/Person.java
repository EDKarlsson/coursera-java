package personal;

/**
 * Created by dank on 10/28/15.
 */
public class Person {
    private String name;

    /**
     * Instantiates a new Person.
     *
     * @param name
     *         The name of the student.
     */
    public Person(String name) {
        this.name = name;
    }
    /**
     * Instantiates a new Person.
     */
    public Person() {
        this.name = "Person";
    }
    public String toString() {
        return name;
    }
    /**
     * Method 1.
     */
    public void method1() {

        System.out.print("Person 1 ");
    }
    /**
     * Method 2.
     */
    public void method2() {

        System.out.print("Person 2 ");
    }
    /**
     * Status.
     *
     * @param hr
     *         the hr
     */
    public void status(int hr) {
        if (this.isAsleep(hr)) {
            System.out.println("Now offline: " + this);
        }
        else {
            System.out.println("Now online: " + this);
        }
    }
    /**
     * Is asleep boolean.
     *
     * @param hr
     *         the hr
     *
     * @return the boolean
     */
    public boolean isAsleep(int hr) {
        return 22 < hr || 7 > hr;
    }
}
