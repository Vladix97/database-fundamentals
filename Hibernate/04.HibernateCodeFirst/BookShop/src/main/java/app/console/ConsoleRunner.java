package app.console;

import app.entities.Author;
import app.entities.Book;
import app.entities.Category;
import app.entities.enums.AgeRestriction;
import app.entities.enums.EditionType;
import app.services.AuthorService;
import app.services.BookService;
import app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorService authorService;

    private final BookService bookService;

    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... strings) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        this.seedDatabase();

//        01
//        AgeRestriction ageRestriction = AgeRestriction.valueOf(in.readLine().toUpperCase());
//        List<Book> byAgeRestriction = this.bookService.findByAgeRestriction(ageRestriction);
//        for (Book book : byAgeRestriction) {
//            System.out.println(book.getTitle());
//        }

//        02
//        List<Book> books = this.bookService.findAllGoldenEditionTypeWithLessThan5000Copies();
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

//        03
//        List<Book> allBelow5AndAfter40Price = this.bookService.findAllBelow5AndAfter40Price();
//        for (Book book : allBelow5AndAfter40Price) {
//            System.out.println(String.format("%s - %s", book.getTitle(), book.getPrice()));
//        }

//        04
//        List<Book> allByReleaseDateNot = this.bookService.findAllByReleaseDateNot(new Date());
//        for (Book book : allByReleaseDateNot) {
//            System.out.println(book.getTitle());
//        }

//        05
//        List<Category> byNameIn = this.categoryService.findByNameIn(in.readLine().split("\\s+"));
//        for (Category category : byNameIn) {
//            System.out.println(category.getName());
//        }
//
//        Category[] categories = new Category[byNameIn.size()];
//        categories = byNameIn.toArray(categories);
//
//        List<Book> byCategoriesIn = this.bookService.findByCategoriesIn(categories);
//        for (Book book : byCategoriesIn) {
//            System.out.println(book.getTitle());
//        }

//        06
//        String dateString = in.readLine();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = simpleDateFormat.parse(dateString);
//        List<Book> byReleaseDateBefore = this.bookService.findByReleaseDateBefore(date);
//        for (Book book : byReleaseDateBefore) {
//            System.out.println(book.getTitle());
//        }

//        07
//        List<Author> byFirstNameEndingWith = this.authorService.findByFirstNameEndingWith(in.readLine());
//        for (Author author : byFirstNameEndingWith) {
//            System.out.println(String.format("%s %s", author.getFirstName(), author.getLastName()));
//        }

//        08
//        List<Book> byTitleIsContaining = this.bookService.findByTitleIsContaining(in.readLine());
//        for (Book book : byTitleIsContaining) {
//            System.out.println(book.getTitle());
//        }

//        09
//        List<Book> byAuthorLastNameStartingWith = this.bookService.findByAuthorLastNameStartingWith(in.readLine());
//        for (Book book : byAuthorLastNameStartingWith) {
//            System.out.println(book.getTitle());
//        }

//        10
//        int i = this.bookService.countByTitleLongerThat(Integer.parseInt(in.readLine()));
//        System.out.println(i);

//        11
//        List<Object[]> allAuthorsBySumOfCopies = this.bookService.findAllAuthorsBySumOfCopies();
//        for (Object[] allAuthorsBySumOfCopy : allAuthorsBySumOfCopies) {
//            Author author = (Author) allAuthorsBySumOfCopy[0];
//            long size = (long) allAuthorsBySumOfCopy[1];
//
//            System.out.println(String.format("%s - %s", author.getFirstName(), size));
//        }

//        12
//        List<Object[]> totalProfitByCategory = this.categoryService.findTotalProfitByCategory();
//        for (Object[] objects : totalProfitByCategory) {
//            System.out.println(objects[0]);
//            System.out.println(objects[1]);
//        }

//        13
//        List<Object[]> countOfBooksByCategory = this.bookService.findCountOfBooksByCategory();
//        for (Object[] objects : countOfBooksByCategory) {
//            Category category = (Category) objects[0];
//            long count = (long) objects[1];
//            System.out.println(category + " " + count);
//
//            List<Book> byCategory = this.bookService.findByCategory(category);
//            for (Book book : byCategory) {
//                System.out.println(book.getTitle());
//            }
//        }

//        15
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
//        Date date = simpleDateFormat.parse(in.readLine());
//        int copies = Integer.parseInt(in.readLine());
//        this.bookService.increaseBookCopiesAfterDate(date, copies);
    }

    private void seedDatabase() throws IOException, ParseException {
        this.seedAuthors();

        this.seedCategories();

        Random random = new Random();
        List<Author> authors = (List<Author>)  this.authorService.findAll();
        BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
        String line;
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            //book.setAuthor(this.authorService.findAuthor(author.getId()));
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            //TODO set random categories for current book

            this.bookService.save(book);
        }
    }

    private void seedCategories() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("categories.txt"));
        String line = null;
        while((line = reader.readLine()) != null){
            Category category = new Category();
            category.setName(line);

            this.categoryService.save(category);
        }
    }

    private void seedAuthors() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("authors.txt"));
        String line;
        while((line = reader.readLine()) != null){
            String[] data = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(data[0]);
            author.setLastName(data[1]);

            this.authorService.save(author);
        }
    }
}
