package personal;

/**
 * Created by dank on 10/28/15.
 */
public class Student extends Person{
    /***
     * Constructor
     * -----------
     *  Default Constructor
     **/
    public Student() {
        super();
    }
    /**
     * Constructor
     * -----------
     * Takes a string argument to represent the private
     *  data member name of the student and person class. The
     *  constructor will take the string and pass it to the super constructor
     *  which will assign the value of name the data member name.
     *
     * @param name
     *         the name
     ***/
    public Student(String name) {
        super(name);
    }

    /**
     * This overrides the super class' isAsleep method
     * -----------
     * A student is awake at odd hours in comparison to a normal
     *  person, in turn this changes the constraints in wwhich the
     *  isAsleep method follows.
     **/
    public boolean isAsleep(int hr) {
        return 2 < hr && 8 > hr;
    }

    public void method1() {
        System.out.print("Student 1");
        super.method1();
        method2();
    }

    public void method2() {
        System.out.print("Student 1");
    }
    /**
     * main: For testing the Student Class
     *
     * @param args
     *         the input arguments
     **/
    public static void main(String[] args) {

        /**
         * Test 1
         * -------
         * At runtime the compiler will calls the status method it
         *  will look in the student class first Then it will go
         *  through the super class to see if the there is a status
         *  method. Since it was determined that p was a student
         *  class, when this is called it will still refer the
         *  student object. So when isAsleep method is called it will
         *  call the student class method rather than the person
         *  class isAsleep method.
         */

        // p refers to a Student object
        Person p;
        p = new Student("Sally");
        p.status(1);
    }
}
