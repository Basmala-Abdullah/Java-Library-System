package taskPkg;

public class Book extends LibraryItem {
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String displayItemDetails() {
        return "Book[ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author + "]";
    }
}