public class SingletonPatternExample
{
    public static void main(String[] args)
    {
        Logger logger1 = Logger.getInstance();
        logger1.log("Code running");
        Logger logger2 = Logger.getInstance();
        logger2.log("All good");
        if (logger1 == logger2)
            System.out.println("Logger has only one instance.");
        else
            System.out.println("Logger instances are different.");
    }
}
