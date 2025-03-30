package taskPkg;

public class Magazine extends LibraryItem {
    private int releaseNo;

    public Magazine(int id, String title, int releaseNo) {
        super(id, title);
        this.releaseNo = releaseNo;
    }

    public int getReleaseNo() {
        return releaseNo;
    }

    @Override
    public String displayItemDetails() {
        return "Magazine (ID: " + getId() + ", Title: " + getTitle() + ", Release Number: " + releaseNo + ")";
    }
}
