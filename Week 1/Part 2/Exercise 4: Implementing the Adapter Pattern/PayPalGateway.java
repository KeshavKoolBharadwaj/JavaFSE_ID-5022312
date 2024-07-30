public class PayPalGateway
{
    public void makePayment(double amount)
    {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
class StripeGateway
{
    public void pay(double amount)
    {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
class SquareGateway
{
    public void process(double amount)
    {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}