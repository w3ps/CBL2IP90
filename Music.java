import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

/**
 * Music is responsible for the audio for Gravity Shift.
 */
public class Music {
    private static final String LOCATION = "other\\Sweden.wav";
    private File musicFile;
    private int volume;
    private Clip clip;
    private Settings settings;

    /**
     * Constructor for the Music class.
     */
    public Music(Settings settings) {
        this.settings = settings;
        volume = this.settings.getVolume();

        try {
            musicFile = new File(LOCATION);
        } catch (Exception e) {
            e.printStackTrace();
        }

        play();
    }

    /**
     * Plays the music.
     */
    public void play() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            setVolume(volume);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (javax.sound.sampled.UnsupportedAudioFileException | java.io.IOException
                | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the music's volume.
     */
    public void setVolume(int volume) {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * volume / 100f) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }

    public static void main(String[] args) {
        new Music(new Settings(new Controller(new Main())));
    }
}
