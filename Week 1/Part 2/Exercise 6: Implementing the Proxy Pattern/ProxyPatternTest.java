public class ProxyPatternTest
{
    public static void main(String[] args)
    {
        Image image1 = new ProxyImage("https://keshavkoolbharadwaj.github.io/personalwebpage/images/profile.jpg");
        Image image2 = new ProxyImage("https://keshavkoolbharadwaj.github.io/KeshavBharadwaj/images/about-me.png");
        image1.display();
        image2.display();
    }
}
