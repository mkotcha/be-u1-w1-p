package Multimedia;

public abstract class MultimediaItem {
    private final String title;

    public MultimediaItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
