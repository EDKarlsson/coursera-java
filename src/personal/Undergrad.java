package personal;

/**
 * Created by dank on 10/28/15.
 */
public class Undergrad extends Student{
    /**
     * Instantiates a new Undergrad.
     */
    public Undergrad() {
        super();
    }
    /**
     * Undergad.
     */
    public void Undergad() {
    }
    public void method2() {
        System.out.println("Undergrad 2 ");
    }
    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {

        Person u = new Undergrad();
        // Even though there is not a method1() in undergrad
        //  it will call the method1 of its super class
        u.method1();
    }
}
