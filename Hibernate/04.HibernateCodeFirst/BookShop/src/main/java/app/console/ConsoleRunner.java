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
//        this.seedDatabase();


    }

    private void seedDatabase() throws IOException, ParseException {
        this.seedAuthors();

        this.seedCategories();

        Random random = new Random();
        List<Author> authors = (List<Author>)  this.authorService.findAll();
        BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
        String line = booksReader.readLine();
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
