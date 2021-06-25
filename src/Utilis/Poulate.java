package Utilis;

import com.app.core.Book;
import static Validation.Validation.*;
import static com.app.core.Categories.JAVA;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Poulate {
    public static ArrayList<Book> populate(){
        ArrayList<Book> list = new ArrayList<>();

        try {
            list.add(new Book("java", JAVA, 100, validateDate("18-07-1998"), "harshit", 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static HashMap<String,Book> populateMap(ArrayList<Book> book){
        HashMap<String,Book> map = new HashMap<>();
        for (Book b : book){
            map.put(b.getTitle(),b);
        }
        return  map;
    }
}
