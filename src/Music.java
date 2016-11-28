/*Seth Trumbo
 */
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.scene.media.AudioClip;

public class Music 
{
	public static Clip playYaverclap()
	{
		try
		{
			File Yaverclap = new File("Yaverclap - The Sky.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Yaverclap));
			return clip;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
}
