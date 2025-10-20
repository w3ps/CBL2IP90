import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Music is responsible for the audio for Gravity Shift.
 */
public class Music {
    private static final String LOCATION = "other\\Sweden.wav";
    private File musicFile;
    private int volume;
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
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (javax.sound.sampled.UnsupportedAudioFileException | java.io.IOException
                | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void updateVol() {
    }
}
