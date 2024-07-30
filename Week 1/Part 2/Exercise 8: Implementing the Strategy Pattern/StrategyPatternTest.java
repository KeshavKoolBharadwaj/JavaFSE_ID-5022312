import java.util.Scanner;
public class StrategyPatternTest
{
    public static void main(String[] args)
    {
        PaymentContext paymentContext = new PaymentContext();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to pay with credit card");
        System.out.println("Enter 2 tp pay with paypal");
        System.out.print("Your choice: ");
        int ch=sc.nextInt();
        if(ch==1)
        {
            PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "Keshav Bharadwaj", "123", "12/24");
            paymentContext.setPaymentStrategy(creditCardPayment);
            paymentContext.pay(150.00);
        }
        else if (ch==2)
        {
            PaymentStrategy payPalPayment = new PayPalPayment("kbharadwaj022@gmail.com", "password");
            paymentContext.setPaymentStrategy(payPalPayment);
            paymentContext.pay(200.00);
        }
        else
            System.out.println("Invalid payment type!");
    }
}
