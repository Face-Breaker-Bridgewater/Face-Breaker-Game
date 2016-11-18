import java.net.URL;

import javafx.scene.media.AudioClip;

public class Music 
{
	public AudioClip playBitQuest()
	{
		URL bitQuest = getClass().getResource("BitQuest.wav");
		final AudioClip clip = new AudioClip(bitQuest.toString());
		return clip;

	}
}
