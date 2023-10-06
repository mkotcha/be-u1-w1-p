package Multimedia;

public class Image extends MultimediaItem implements NotPlayable, Dimmerable {
    private int dim;

    public Image(String title) {
        super(title);
        this.dim = 8;
    }

    @Override
    public String getMediaType() {
        return "image";
    }

    @Override
    public void dimUp() {
        if (this.dim < 10) this.dim++;
    }

    @Override
    public void dimDown() {
        if (this.dim > 0) this.dim--;
    }

    @Override
    public void show() {
        System.out.println(this.getTitle() + " - " + this.getDimStr());
    }

    @Override
    public String getDimStr() {
        return "*".repeat(Math.max(0, this.dim));
    }

}
