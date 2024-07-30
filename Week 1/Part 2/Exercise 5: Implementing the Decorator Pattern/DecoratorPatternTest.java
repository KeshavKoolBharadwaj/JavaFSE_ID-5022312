public class DecoratorPatternTest
{
    public static void main(String[] args)
    {
        Notifier notifier = new EmailNotifier();
        notifier.send("Hello!");

        System.out.println();

        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Hello!");

        System.out.println();

        Notifier slackNotifier = new SlackNotifierDecorator(new EmailNotifier());
        slackNotifier.send("Hello!");

        System.out.println();

        Notifier combinedNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        combinedNotifier.send("Hello!");
    }
}
