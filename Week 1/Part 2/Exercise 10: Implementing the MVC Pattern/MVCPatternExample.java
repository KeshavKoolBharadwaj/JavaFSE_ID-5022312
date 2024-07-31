import java.util.Scanner;
public class MVCPatternExample
{
    public static void main(String[] args)
    {
        int id=0;
        Scanner sc=new Scanner(System.in);
        // Create a student model
        System.out.print("Enter student name: ");
        String name=sc.next();
        System.out.print("Enter Grade: ");
        String ch=sc.next();
        id++;
        Student student = new Student(String.valueOf(id), name, ch);

        // Create a student view
        StudentView view = new StudentView();

        // Create a student controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}