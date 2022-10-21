import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int choice = 0;

        while (choice != 9) {
            choice = BookService.fetchUserChoice();

            switch (choice) {
                case 1:
                    BookService.saveBookToJSON();
                    break;
                case 2:
                    BookService.printAllBooksInJSON();
                    break;
            }
        }
    }
}
