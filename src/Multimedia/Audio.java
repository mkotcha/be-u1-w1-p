package Multimedia;

public class Audio extends MultimediaItem implements Playable {

    private final int duration;
    private int volume;

    public Audio(String title, int duration) {
        super(title);
        this.duration = duration;
        this.volume = 8;
    }

    @Override
    public void volUp() {
        if (this.volume < 10) this.volume++;
    }

    @Override
    public void volDown() {
        if (this.volume > 0) this.volume--;
    }

    @Override
    public void play() {
        for (int i = 0; i < this.duration; i++) System.out.println(this.getTitle() + " - " + this.getVolumeStr());
    }

    @Override
    public String getVolumeStr() {
        return "!".repeat(Math.max(0, this.volume));
    }

    @Override
    public String getMediaType() {
        return "audio";
    }
}
