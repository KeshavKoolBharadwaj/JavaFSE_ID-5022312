import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
public class RealImage implements Image
{
    private String url;
    private BufferedImage image;
    public RealImage(String url)
    {
        this.url = url;
        loadImage();
    }
    private void loadImage()
    {
        try
        {
            image = ImageIO.read(new URL(url));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            loadPlaceholderImage();
        }
    }
    private void loadPlaceholderImage()
    {
        try
        {
            image = ImageIO.read(getClass().getResource("/placeholder.jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void display()
    {
        if (image == null)
        {
            System.out.println("No image to display.");
            return;
        }
        JFrame frame = new JFrame();
        frame.setTitle("Image Viewer");
        frame.setSize(image.getWidth(), image.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        });
        frame.setVisible(true);
    }
}