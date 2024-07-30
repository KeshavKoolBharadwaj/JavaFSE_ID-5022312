import java.util.Scanner;
public class CommandPatternTest
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Light livingRoomLight = new Light();
        System.out.print("Press enter to turn on light: ");
        String s=sc.nextLine();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();
        System.out.print("Press enter to turn off light: ");
        s=sc.nextLine();
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
