package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import bookshopsystemapp.domain.entities.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction agerestriction);

    List<Book> findAllByEditionTypeAndCopiesBefore(EditionType edtype,Integer copies);

    List<Book> findAllByPriceLessThanOrPriceAfter(BigDecimal startBetween,BigDecimal endBetween );

    @Query(value="SELECT b from bookshopsystemapp.domain.entities.Book as b WHERE function('YEAR', b.releaseDate) <> :year")
    List<Book> findBooksNotINYear(@Param(value="year")int year);

    List<Book> findAllByTitleContaining(String words);

    @Query(value="SELECT b FROM bookshopsystemapp.domain.entities.Book as b join b.author as a WHERE a.lastName LIKE CONCAT(:words,'%')")
    List<Book> findAllByAuthorLastNameContaining(@Param(value="words") String words);

    @Query(value="SELECT b FROM bookshopsystemapp.domain.entities.Book as b WHERE length(b.title) >:number")
    List<Book> findAllByTitleWhenGreaterThen(@Param(value="number") Integer number);

    @Query(value="SELECT concat(a.firstName,' ',a.lastName), SUM(b.copies)  FROM  bookshopsystemapp.domain.entities.Book as b " +
            "JOIN  b.author as a GROUP BY b.author  ORDER BY SUM(b.copies) DESC")
    List<Object[]> findAllCopiesByAuthor();

    List<ReducedBook> findAllByTitle(String title);
}
