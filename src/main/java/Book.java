public class Book {
    private int numberOfPages;
    private String title;
    private String author;
    private String purchaseDate;

    public Book(int numberOfPages, String title, String author, String purchaseDate) {
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.author = author;
        this.purchaseDate = purchaseDate;
    }

    public Book() {
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
