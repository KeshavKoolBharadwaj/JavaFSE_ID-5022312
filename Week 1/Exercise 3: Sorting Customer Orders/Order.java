import java.util.Scanner;
public class Order
{
    private static void quickSort(Double totalPrice[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(totalPrice, low, high);
            quickSort(totalPrice, low, pi - 1);
            quickSort(totalPrice, pi + 1, high);
        }
    }
    private static int partition(Double totalPrice[], int low, int high)
    {
        double pivot = totalPrice[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++)
        {
            if (totalPrice[j] <= pivot)
            {
                i++;
                Double temp = totalPrice[i];
                totalPrice[i] = totalPrice[j];
                totalPrice[j] = temp;
            }
        }
        Double temp = totalPrice[i + 1];
        totalPrice[i + 1] = totalPrice[high];
        totalPrice[high] = temp;
        return i + 1;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int c=sc.nextInt();
        String orderId[]=new String[c], customerName[]=new String[c];
        Double totalPrice[]=new Double[c];
        int i,ch,j;
        for(i=0;i<c;i++)
        {
            /*System.out.print("Enter order id of customer number "+i+1+": ");
            orderId[i]=sc.next();
            System.out.print("Enter Name of customer number "+i+1+": ");
            customerName[i]= sc.next();*/
            System.out.print("Enter Total price for customer number "+i+1+": ");
            totalPrice[i]= sc.nextDouble();
        }

        System.out.println("Select for sort:");
        System.out.println("1 for Bubble sort");
        System.out.println("2 for Quick sort");
        System.out.print("Enter choice: ");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                for (i=0;i<c-1;i++)
                {
                    for (j = 0; j < c - i - 1; j++)
                    {
                        if (totalPrice[j] > totalPrice[j + 1])
                        {
                            Double temp = totalPrice[j];
                            totalPrice[j] = totalPrice[j + 1];
                            totalPrice[j + 1] = temp;
                        }
                    }
                }
                break;
            case 2:
                quickSort(totalPrice, 0, c - 1);
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("Sorted list of Total prices: ");
        for(i=0;i<c;i++)
        {
            System.out.println(totalPrice[i]);
        }
    }
}
