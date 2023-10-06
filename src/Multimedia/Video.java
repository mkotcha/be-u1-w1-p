package Multimedia;

public class Video extends Audio implements Playable, Dimmerable {
    
    private int dim;

    public Video(String title, int duration) {
        super(title, duration);
        this.dim = 8;
    }

    @Override
    public void dimUp() {
        if (this.dim < 10) this.dim++;
        else System.out.println("dim at MAX");
    }

    @Override
    public void dimDown() {
        if (this.dim > 0) this.dim--;
        else System.out.println("dim at MIN");
    }

    @Override
    public void play() {
        for (int i = 0; i < this.duration; i++)
            System.out.println(this.getTitle() + " - " + this.getVolumeStr() + " - " + this.getDimStr());
    }

    @Override
    public String getDimStr() {
        return "*".repeat(Math.max(0, this.dim));
    }

    @Override
    public String getMediaType() {
        return "video";
    }
}
