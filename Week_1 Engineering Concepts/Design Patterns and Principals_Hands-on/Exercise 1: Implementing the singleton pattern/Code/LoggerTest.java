public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("Message from logger1");
        logger2.log("Message from logger2");
        logger3.log("Message from logger3");

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("Test Passed: All logger instances are the same (singleton confirmed).");
        } else {
            System.out.println("Test Failed: Logger instances are different (singleton broken).");
        }

        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());
    }
}