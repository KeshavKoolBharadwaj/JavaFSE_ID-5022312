import java.util.Scanner;
public class BuilderPatternTest
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What type of PC do you wanna build?");
        System.out.println("Enter 1 for gaming PC");
        System.out.println("Enter 2 for office PC");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        if (ch == 1)
        {
            Computer gamingPC = new Computer.Builder()
                    .setCPU("Intel i9")
                    .setRAM("32GB")
                    .setStorage("2TB SSD")
                    .setGraphicsCard("NVIDIA RTX 3080")
                    .setPowerSupply("750W")
                    .setCoolingSystem("Liquid Cooling")
                    .setCaseType("ATX")
                    .build();
            System.out.println("PC build successful with the following configurations:");
            System.out.println("CPU: "+gamingPC.getCPU());
            System.out.println("RAM: "+gamingPC.getRAM());
            System.out.println("Storage: "+gamingPC.getStorage());
            System.out.println("Graphics card: "+gamingPC.getGraphicsCard());
            System.out.println("Power supply: "+gamingPC.getPowerSupply());
            System.out.println("Colling system: "+gamingPC.getCoolingSystem());
            System.out.println("Case type: "+gamingPC.getCaseType());
        }
        else if (ch == 2)
        {
            Computer officePC = new Computer.Builder()
                    .setCPU("Intel i5")
                    .setRAM("16GB")
                    .setStorage("1TB HDD")
                    .setGraphicsCard("Integrated")
                    .setPowerSupply("500W")
                    .setCoolingSystem("Air Cooling")
                    .setCaseType("Micro-ATX")
                    .build();
            System.out.println("PC build successful with the following configurations:");
            System.out.println("CPU: "+officePC.getCPU());
            System.out.println("RAM: "+officePC.getRAM());
            System.out.println("Storage: "+officePC.getStorage());
            System.out.println("Graphics card: "+officePC.getGraphicsCard());
            System.out.println("Power supply: "+officePC.getPowerSupply());
            System.out.println("Colling system: "+officePC.getCoolingSystem());
            System.out.println("Case type: "+officePC.getCaseType());
        }
    }
}