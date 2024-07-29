import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
public class inventory
{
    private static Map<String, product> products;
    private static int productId=0;
    public inventory()
    {
        products = new HashMap<>();
    }
    public void addProduct(product product)
    {
        products.put(product.getProductId(), product);
    }
    public void updateProduct(product product)
    {
        if (products.containsKey(product.getProductId()))
            products.put(product.getProductId(), product);
        else
            System.out.println("Product not found.");
    }
    public void deleteProduct(String productId)
    {
        if (products.containsKey(productId))
        {
            products.remove(productId);
            System.out.println("Product deleted");
        }
        else
            System.out.println("Product not found.");
    }
    public void linearSearch(int  pid)
    {
        for (product product : products.values())
        {
            if(pid==Integer.parseInt(product.getProductId()))
            {
                System.out.println("Found");
            return;
            }
        }
        System.out.println("Not Found");
    }
    public void binarySearch(int pid)
    {
        int l=products.size();
        int []arr=new int[l];
        int left=0,right=l-1;
        for(product product: products.values())
        {
            arr[left++]=Integer.parseInt(product.getProductId());
        }
        left=0;
        Arrays.sort(arr);
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == pid)
            {
                System.out.println("Found");
                return;
            }
            else if (arr[mid] < pid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println("Product not found");
    }
    public String toString()
    {
        return "Inventory{" + "products=" + products + '}';
    }
    public static void main(String[] args)
    {
        inventory inventory = new inventory();
        System.out.println("Welcome to Inventory Management System!\n");
        int ch=0;
        Scanner sc=new Scanner(System.in);
        while(ch!=6)
        {
            System.out.println("+------------------------------+");
            System.out.println("|             Menu             |");
            System.out.println("+--+---------------------------|");
            System.out.println("|1 | Add product               |");
            System.out.println("|2 | Display all products      |");
            System.out.println("|3 | Delete a product          |");
            System.out.println("|4 | Update product description|");
            System.out.println("|5 | Search                    |");
            System.out.println("|6 | Exit                      |");
            System.out.println("+--+---------------------------|\n");
            System.out.print("Enter your choice [1-6]: ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    productId++;
                    System.out.print("\nEnter product name: ");
                    String name=sc.next();
                    System.out.print("Enter product quantity: ");
                    int quantity=sc.nextInt();
                    System.out.print("Enter product price: ");
                    double price=sc.nextDouble();
                    product p = new product(String.valueOf(productId), name, quantity, price);
                    inventory.addProduct(p);
                    break;
                case 2:
                    System.out.println("+-----------+-------------+-----------------+--------------+");
                    System.out.println("|Product ID |Product name |Product quantity |Product price |");
                    System.out.println("+-----------+-------------+-----------------+--------------+");
                    for (product product : products.values())
                    {
                        System.out.println("|"+product.getProductId()+"          |"+product.getProductName()+"        |"+product.getQuantity()+"               |"+product.getPrice()+"         |");
                    }
                    System.out.println("+-----------+-------------+-----------------+--------------+");
                    break;
                case 3:
                    System.out.println("Enter product ID to be deleted: ");
                    int pid=sc.nextInt();
                    inventory.deleteProduct(String.valueOf(pid));
                    break;
                case 4:System.out.println("Enter product ID to update: ");
                    String productid=sc.next();
                    for (product product : products.values())
                    {
                        if(productid.equalsIgnoreCase(product.getProductId()))
                        {
                            System.out.println("+---------------+");
                            System.out.println("| What to edit? |");
                            System.out.println("+---------------+");
                            System.out.println("|1 | Name       |");
                            System.out.println("|2 | Quantity   |");
                            System.out.println("|3 | Price      |");
                            System.out.println("+---------------+");
                            int c=sc.nextInt();
                            switch (c)
                            {
                                case 1:
                                    System.out.print("Enter new name: ");
                                    String newName = sc.next();
                                    product.setProductName(newName);
                                    inventory.updateProduct(product);
                                    break;
                                case 2:
                                    System.out.print("Enter new quantity: ");
                                    int newQuantity = sc.nextInt();
                                    product.setQuantity(newQuantity);
                                    inventory.updateProduct(product);
                                    break;
                                case 3:
                                    System.out.print("Enter new price: ");
                                    double newPrice = sc.nextDouble();
                                    product.setPrice(newPrice);
                                    inventory.updateProduct(product);
                                    break;
                                default:
                                    System.out.println("Wrong choice!");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter Product ID to search: ");
                    int id=sc.nextInt();
                    System.out.println("Select search: ");
                    System.out.println("1) Linear search");
                    System.out.println("2) Binary search");
                    int c=sc.nextInt();
                    if(c==1)
                        inventory.linearSearch(id);
                    else if (c==2)
                        inventory.binarySearch(id);
                    else
                        System.out.println("Wrong selection");
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }
}