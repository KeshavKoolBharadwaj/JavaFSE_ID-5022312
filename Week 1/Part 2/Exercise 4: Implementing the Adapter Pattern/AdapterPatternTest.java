import java.util.Scanner;
public class AdapterPatternTest
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter amount: ");
        Double amt= sc.nextDouble();
        System.out.println("+----------------------+");
        System.out.println("|Select Payment Gateway|");
        System.out.println("+----------------------+");
        System.out.println("| 1 | PayPal           |");
        System.out.println("| 2 | Stripe           |");
        System.out.println("| 3 | Square           |");
        System.out.println("+----------------------+");
        System.out.print("Enter choice: ");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
                payPalProcessor.processPayment(amt);
                System.out.println("Payment Succcessful");
                break;
            case 2:
                PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
                stripeProcessor.processPayment(amt);
                System.out.println("Payment Succcessful");
                break;
            case 3:
                PaymentProcessor squareProcessor = new SquareAdapter(new SquareGateway());
                squareProcessor.processPayment(amt);
                System.out.println("Payment Succcessful");
                break;
            default:
                System.out.println("No payment gateway found!");
        }
    }
}
