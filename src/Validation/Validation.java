package Validation;

import com.app.core.Categories;

import java.text.ParseException;
import java.util.Date;
import Exception.CustomExceptionHandler;
import static com.app.core.Book.*;

public class Validation {
    public static Date validateDate(String date) throws ParseException {
        return sdf.parse(date);
    }
    public static Categories convertCategories(String categories) throws CustomExceptionHandler {
        if(categorieExist(categories))
            return Categories.valueOf(categories.toUpperCase());
        throw new CustomExceptionHandler("Invaild category");
    }

    private static boolean categorieExist(String categories) throws CustomExceptionHandler {
        for(Categories temp : Categories.values()){
            if(temp.name().equals(categories.toUpperCase()))
                return true;
        }
        throw new CustomExceptionHandler("Categorie not avilable");
    }
}
