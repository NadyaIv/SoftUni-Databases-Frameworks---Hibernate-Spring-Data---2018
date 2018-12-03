package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();
        // problem 01.Books Titles by Age Restriction
        //this.gettitles();
        // problem 03.Books by Price
        //this.getBooksByPriceLessThenOrAfter();
        // problem 04.Not Released Books
        //this.getBooksNotRealeseIn();
        //problem 05.Books Released Before Date
        //this.getBooksByReleaseDateBefore();
        //problem 06.Authors Search
       // this.getAithorsByFirstNameEndsWith();
        //problem 07.Books Search
         //this.getBooksByTitleContains();
        //problem 08.	Book Titles Search
        //this.getBooksByTitleWithAuthorLatNameContains();
        //problem 09.Count Books
        //this.getBooksByTitleWithLenghtGreaterThen();
        //problem 10.Total Book Copies
        //this.getBooksByCopies();
        //problem 11.Reduced Book
        this.getBooksByTitle();




    }

    private void getBooksByTitle() {
        Scanner scanner=new Scanner(System.in);
        String title=scanner.nextLine();
        List<String> books=this.bookService.gettAllBooksByTitle(title);
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void getBooksByCopies() {
        List<String> books=this.bookService.getAllBooksByCopies();
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void getBooksByTitleWithLenghtGreaterThen() {
        Scanner scanner=new Scanner(System.in);
        Integer number=scanner.nextInt();
        List<String> books=this.bookService.getAllBooksByTitleLenghtIsGreaterThen(number);
        System.out.println(books.size());
    }

    private void getBooksByTitleWithAuthorLatNameContains() {
        Scanner scanner=new Scanner(System.in);
        String words=scanner.nextLine();
        List<String> books=this.bookService.getAllBooksByTitleFromAuthorContaining(words);
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void getBooksByTitleContains() {
        Scanner scanner=new Scanner(System.in);
        String words=scanner.nextLine();
        List<String> books=this.bookService.getAllBooksByTitleContains(words);
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void getAithorsByFirstNameEndsWith() {
        Scanner scanner=new Scanner(System.in);
        String endsWith=scanner.nextLine();
        List<String> authors=this.authorService.findAllByFirstNameEndsWith(endsWith);
        System.out.println(String.join(System.lineSeparator(),authors));

    }

    private void getBooksByReleaseDateBefore() {
        Scanner scanner=new Scanner(System.in);
        String date=scanner.nextLine();
        List<String> books=this.bookService.getAllBooksByReleaseDate(date);
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void getBooksNotRealeseIn() {
        Scanner scanner=new Scanner(System.in);
       int year=Integer.parseInt(scanner.nextLine());
        List<String> books=this.bookService.getAllBooksNotRealesIN(year);
        System.out.println(String.join(System.lineSeparator(),books));

    }

    private void getBooksByPriceLessThenOrAfter() {
        List<String> books=this.bookService.getAlBooksByPriceBetween();
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void gettitlesByCopies() {
        List<String> books=this.bookService.getAllBooksByGoldenEditionTypeandCopiesBefore();
        System.out.println(String.join(System.lineSeparator(),books));
    }

    private void gettitles() {
        Scanner scanner=new Scanner(System.in);
        String ageRestriction=scanner.nextLine();
        List<String> titles=this.bookService.getAllBooksByAgeRestriction(ageRestriction);
        System.out.println(String.join(System.lineSeparator(),titles));
    }
}
