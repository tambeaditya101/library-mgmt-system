package strategies;
import models.Book;
import java.util.ArrayList;
import java.util.List;

public class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }

        }

        return result;
    }
}
