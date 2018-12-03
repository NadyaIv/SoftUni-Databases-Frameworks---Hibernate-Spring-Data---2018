package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getAllBooksByAgeRestriction(String ageRestriction);
    List<String> getAllBooksByGoldenEditionTypeandCopiesBefore();
    List<String> getAlBooksByPriceBetween();
    List<String> getAllBooksNotRealesIN(int year);
    List<String> getAllBooksByReleaseDate(String date);
    List<String> getAllBooksByTitleContains(String words);
    List<String> getAllBooksByTitleFromAuthorContaining(String words);
    List<String> getAllBooksByTitleLenghtIsGreaterThen(Integer number);
    List<String> getAllBooksByCopies();
    List<String> gettAllBooksByTitle(String title);
}
