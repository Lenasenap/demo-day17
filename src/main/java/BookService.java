import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Path path = Paths.get("src/main/resources/books.json");
    private static List<Book> booksFromJSON;
    private static final Scanner scanner = new Scanner(System.in);

    static {
        try {
            booksFromJSON = List.of(mapper.readValue(path.toFile(), Book[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAllBooksInJSON() throws IOException {
        List<Book> booksFromJSONUpdated = List.of(mapper.readValue(path.toFile(), Book[].class));
        for (Book book : booksFromJSONUpdated) {
            printInfoAboutBook(book);
        }
    }

    private static void printInfoAboutBook(Book book) {
        System.out.println("----------");
        System.out.println("Författare: " + book.getAuthor());
        System.out.println("Titel: " + book.getTitle());
        System.out.println("Antal sidor: " + book.getNumberOfPages());
        System.out.println("Inhandlades: " + book.getPurchaseDate());
        System.out.println("----------");
    }

    public static void saveBookToJSON() throws IOException {
        booksFromJSON = List.of(mapper.readValue(path.toFile(), Book[].class));
        List<Book> books = new ArrayList<>(booksFromJSON);
        books.add(createNewBook());
        mapper.writeValue(path.toFile(), books);
    }

    private static Book createNewBook() {
        System.out.println("Skriv in titel:");
        String title = scanner.nextLine();
        System.out.println("Skriv in författare:");
        String author = scanner.nextLine();
        System.out.println("Skriv in antalet sidor:");
        int noOfPages = Integer.parseInt(scanner.nextLine());
        String purchaseDate = LocalDate.now().toString();
        return new Book(noOfPages, title, author, purchaseDate);
    }

    public static int fetchUserChoice() {
        printChoices();
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printChoices() {
        System.out.println("""
                Hej, vad vill du göra?
                1. Skapa en ny bok
                2. Visa alla böcker som finns
                9. Avsluta programmet
                """);
    }
}
