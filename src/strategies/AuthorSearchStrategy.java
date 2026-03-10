package strategies;
import models.Book;
import java.util.ArrayList;
import java.util.List;

public class AuthorSearchStrategy implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String query) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }

        }

        return result;
    }
}