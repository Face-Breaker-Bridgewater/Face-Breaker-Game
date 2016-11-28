/*Seth Trumbo
 */
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SFX
{
	public static Clip playBoop()
	{
		try
		{
			File Boop = new File("Boop.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Boop));
			return clip;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static Clip playBounce()
	{
		try
		{
			File Bounce = new File("Bounce.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Bounce));
			return clip;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Clip playBreak() {
		try
		{
			File Break = new File("Break.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Break));
			return clip;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	

}