package strategies;

import models.Book;
import java.util.ArrayList;
import java.util.List;

public class IsbnSearchStrategy implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String query) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getIsbn().equals(query)) {
                result.add(book);
            }

        }

        return result;
    }
}
