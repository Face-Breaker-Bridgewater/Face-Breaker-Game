/*Juan Padilla
 * 
 * 
 * 
 * */
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

public class FBInfoExtraction {

	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
         
	       @SuppressWarnings("deprecation")
		FacebookClient facebookClient= new DefaultFacebookClient(FBConstants.MY_ACCESS_TOKEN);
	       
	    User user = facebookClient.fetchObject("me", User.class,
	    		   Parameter.with("fields", "picture,id,gender,name,birthday,email"));  
	    
	       //Extracting picture
	       String fbURL = user.getPicture().getUrl();
	       java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(fbURL);
	       
	        try {
	            URL url = new URL(fbURL);
	            image = ImageIO.read(url);
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }

	        //Picture Display
	        JFrame frame = new JFrame();
	        frame.setSize(300, 300);
	        JLabel label = new JLabel(new ImageIcon(image));
	        frame.add(label);
	        frame.setVisible(true);
	        
	        //User Info Displayed
	        /*System.out.println("User="+ user);
		       System.out.println("id= "+ user.getId());
		       System.out.println("Birthday= "+ user.getBirthday());
		       System.out.println("Gender= "+ user.getGender());
		       System.out.println("Name="+ user.getName());
		       System.out.println("Email= "+ user.getEmail());
		       System.out.println("Picture= " +user.getPicture().getUrl()); 
		       */
	    }
}