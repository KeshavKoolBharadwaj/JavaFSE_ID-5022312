import java.util.Scanner;
public class TaskManagementSystem
{
    private Node head;
    public TaskManagementSystem()
    {
        this.head = null;
    }
    public void addTask(Task task)
    {
        Node newNode = new Node(task);
        if (head == null)
            head = newNode;
        else
        {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }
    public Task searchTask(int taskId)
    {
        Node current = head;
        while (current != null)
        {
            if (current.task.getTaskId() == taskId)
                return current.task;
            current = current.next;
        }
        return null;
    }
    public boolean deleteTask(int taskId)
    {
        if (head == null)
            return false;
        if (head.task.getTaskId() == taskId)
        {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null)
        {
            if (current.next.task.getTaskId() == taskId)
            {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void traverseTasks()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.task);
            current = current.next;
        }
    }
    class Node
    {
        Task task;
        Node next;
        Node(Task task)
        {
            this.task = task;
            this.next = null;
        }
    }
   public static void main(String[] args)
   {
       TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
       int ch=0,i,tid=0;
       Scanner sc=new Scanner(System.in);
       while(ch!=5)
       {
           System.out.println("Enter 1 for add data");
           System.out.println("Enter 2 for delete data");
           System.out.println("Enter 3 for search data");
           System.out.println("Enter 4 for traversal");
           System.out.println("Enter 5 for exit");
           ch=sc.nextInt();
           switch (ch)
           {
               case 1:
                   tid++;
                   System.out.print("Enter task name: ");
                   String tname=sc.next();
                   System.out.print("Enter task status");
                   String stat=sc.next();
                   taskManagementSystem.addTask(new Task(tid, tname, stat));
                   break;
               case 2:
                   System.out.println("Enter ID of task to delete: ");
                   int t=sc.nextInt();
                   boolean isDeleted = taskManagementSystem.deleteTask(t);
                   if (isDeleted)
                       System.out.println("Task deleted successfully");
                   else
                       System.out.println("Task not found");
                   break;
               case 3:
                   System.out.println("Enter task ID : ");
                   t= sc.nextInt();;
                   Task task = taskManagementSystem.searchTask(t);
                   if (task != null)
                       System.out.println(task);
                   else
                       System.out.println("Task not found");
                   break;
               case 4:
                   taskManagementSystem.traverseTasks();
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
