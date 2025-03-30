package taskPkg;

public abstract class LibraryItem {
    private int id;
    private String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String displayItemDetails();
}
