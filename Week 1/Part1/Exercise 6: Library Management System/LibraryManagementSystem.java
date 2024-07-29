import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class LibraryManagementSystem
{
    private Book[] books;
    private int count;
    public LibraryManagementSystem(int capacity)
    {
        books = new Book[capacity];
        count = 0;
    }
    public void addBook(Book book)
    {
        if (count < books.length)
            books[count++] = book;
    }
    public Book linearSearchByTitle(String title)
    {
        for (int i = 0; i < count; i++)
        {
            if (books[i].getTitle().equalsIgnoreCase(title))
                return books[i];
        }
        return null;
    }
    public Book binarySearchByTitle(String title)
    {
        int left = 0;
        int right = count - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0)
                return books[mid];
            else if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return null;
    }
    public void sortBooksByTitle()
    {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
    public static void main(String[] args)
    {
        LibraryManagementSystem library = new LibraryManagementSystem(10);
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(5, "Moby-Dick", "Herman Melville"));
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String title=sc.next();
        System.out.println("Enter 1 for linear search");
        System.out.println("Enter 2 for binary search");
        int ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println("Linear Search:");
            Book foundBook = library.linearSearchByTitle(title);
            if (foundBook != null)
                System.out.println("Found: " + foundBook);
            else
                System.out.println("Book not found");
        }
        else if (ch==2)
        {
            library.sortBooksByTitle();
            System.out.println("\nBinary Search:");
            Book foundBook = library.binarySearchByTitle(title);
            if (foundBook != null)
                System.out.println("Found: " + foundBook);
            else
                System.out.println("Book not found");
        }
    }
}
