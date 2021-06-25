import com.app.core.Book;
import static Utilis.Poulate.*;
import java.util.HashMap;
import java.util.HashSet;
import Exception.CustomExceptionHandler;
import java.util.Map;
import java.util.Scanner;
import static Validation.Validation.*;
public class Tester {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HashSet<Book> books = new HashSet<>();
            Map<String,Book> hashMapBook = populateMap(populate());
            boolean exit = false;
            while(!exit){
                try {
                    System.out.println("1.Add a book\n100.Exit");
                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println("Enter the title,categories,price,publishedDate,authorName,quantity");
                            Book e = new Book(scanner.next(),convertCategories(scanner.next()),scanner.nextDouble(),validateDate(scanner.next()),scanner.next(),scanner.nextInt());
                            books.add(e);
                            hashMapBook.put(e.getTitle(),e);
                            break;
                        case 2:
                            for(Book temp : hashMapBook.values()){
                                System.out.println(temp);
                            }
                            break;
                        case 3:
                            System.out.println("Enter the book name to be issued");
                            Book issue = hashMapBook.get(scanner.next());
                            if(issue==null)
                                throw new CustomExceptionHandler("Invalid book name");
                            issue.issueBook();
                            break;
                        case 4:
                            System.out.println("Enter the book name to be return");
                            Book returnBook = hashMapBook.get(scanner.next());
                            if(returnBook==null)
                                throw new CustomExceptionHandler("Invalid book name");
                            returnBook.returnBook();
                            break;
                        case 5:
                            System.out.println("Enter the book to be removed");
                            String removeBook = scanner.next();
                            if(hashMapBook.containsKey(removeBook)){
                                hashMapBook.remove(removeBook);
                            }
                            else{
                                throw new CustomExceptionHandler("Book not available");
                            }
                            break;



                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                scanner.nextLine();

            }

        }

    }
}
