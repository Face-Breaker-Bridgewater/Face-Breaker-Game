/*Seth Trumbo
 * Credits:
 * Yaverclap - The Sky
 * SoundCloud - https://soundcloud.com/yaverclap
 * Facebook - https://goo.gl/986pNb
 * YouTube - https://goo.gl/NZ4gZE
 * Free Background Music No Copyright Music – YAVERCLAP – The Sky
 * Free Background Music
 * Website - http://www.freebackgroundmusic.co.uk
 * YouTube - http://goo.gl/fFI0z8
 * SoundCloud - https://soundcloud.com/freebmusic
 * Facebook - http://goo.gl/2otgOU
 * Twitter - https://twitter.com/FreeBMusic
 * Google+ - http://goo.gl/TybZuK
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
