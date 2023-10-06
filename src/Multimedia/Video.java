package Multimedia;

public class Video extends MultimediaItem implements Playable, Dimmerable {

    private final int duration;
    private int volume;
    private int dim;

    public Video(String title, int duration) {
        super(title);
        this.duration = duration;
        this.volume = 8;
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
    public void volUp() {
        if (this.volume < 10) this.volume++;
        else System.out.println("vol at MAX");
    }

    @Override
    public void volDown() {
        if (this.volume > 0) this.volume--;
        else System.out.println("vol at MIN");
    }

    @Override
    public void play() {
        for (int i = 0; i < this.duration; i++)
            System.out.println(this.getTitle() + " - " + this.getVolumeStr() + " - " + this.getDimStr());
    }

    @Override
    public String getVolumeStr() {
        return "!".repeat(Math.max(0, this.volume));
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
