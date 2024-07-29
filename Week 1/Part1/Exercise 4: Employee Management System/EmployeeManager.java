import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeManager {
    private static ArrayList<Employee> employees;
    public EmployeeManager()
    {
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    public Employee searchEmployee(int employeeId)
    {
        for (Employee employee : employees)
        {
            if (employee.getEmployeeId() == employeeId)
            {
                return employee;
            }
        }
        return null;
    }
    public static void traverseEmployees()
    {
        System.out.println("+------------+--------------+------------------+------------------+");
        System.out.println("|Employee ID |Employee name |Employee position |Employee salary   |");
        System.out.println("+------------+--------------+------------------+------------------+");
        for (int i=0;i<employees.size(); i++)
        {
            Employee employee = employees.get(i);
            System.out.println("|"+employee.getEmployeeId()+"           |"+employee.getName()+"        |"+employee.getPosition()+"             |"+employee.getSalary()+"             |");
        }
        System.out.println("+------------+--------------+------------------+------------------+");
    }
    public boolean deleteEmployee(int employeeId)
    {
        Employee employee = searchEmployee(employeeId);
        if (employee != null)
        {
            employees.remove(employee);
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int ch=0,eid=0;
        while(ch!=4)
        {
            System.out.println("Enter 1 to add employee");
            System.out.println("Enter 2 to delete employee");
            System.out.println("Enter 3 to traverse all employee");
            System.out.println("Enter 4 to search a employee");
            System.out.println("Enter 5 to exit");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    eid++;
                    System.out.print("Enter name: ");
                    String name=sc.next();
                    System.out.print("Enter position: ");
                    String position=sc.next();
                    System.out.println("Enter salary: ");
                    int salary=sc.nextInt();
                    manager.addEmployee(new Employee(eid, name, position,salary));
                    break;
                case 2:
                    System.out.print("Enter EID: ");
                    int epid=sc.nextInt();
                    boolean isDeleted = manager.deleteEmployee(epid);
                    if (isDeleted)
                        System.out.println("Employee deleted successfully.");
                    else
                        System.out.println("Employee not found.");
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    System.out.println("\nEnter EID: ");
                    epid=sc.nextInt();
                    Employee employee = manager.searchEmployee(epid);
                    if (employee != null)
                        System.out.println("Employee found: " + employee);
                    else
                        System.out.println("Employee not found.");
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
