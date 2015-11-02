package personal;

/**
 * Created by dank on 10/4/15.
 */
public class Quiz2 {
    private int a;
    /**
     * The B.
     */
    public double b;

    /**
     * Instantiates a new Quiz 2.
     *
     * @param first
     *         the first
     * @param second
     *         the second
     */
    public Quiz2(int first, double second) {
        this.a = first;
        this.b = second;
    }

    /**
     * Question 1.
     */
    public void question1() {
        Quiz2 c1 = new Quiz2(10, 20.5);
        Quiz2 c2 = new Quiz2(10, 31.5);
        System.out.println(c1.a + ", " + c1.b);
    }

    /**
     * Question 2.
     */
    public static void question2() {
        Quiz2 c1 = new Quiz2(10, 20.5);
        Quiz2 c2 = new Quiz2(10, 31.5);
        c2 = c1;
        c1.a = 2;
        System.out.println(c2.a);
    }

    /**
     * Increment both.
     *
     * @param c1
     *         the c 1
     */
    public static void incrementBoth(Quiz2 c1) {
        c1.a = c1.a + 1;
        c1.b = c1.b + 1.0;
    }

    /**
     * Question 4.
     */
    public static void question4() {
        Quiz2 c1 = new Quiz2(10, 20.5);
        Quiz2 c2 = new Quiz2(10, 31.5);
        incrementBoth(c2);
        System.out.println(c1.a + ", " + c2.a);
    }
    /**
     * The entry point of application.
     *
     * @param args
     *         the input arguments
     */
    public static void main(String[] args) {
        question4();
    }
}
