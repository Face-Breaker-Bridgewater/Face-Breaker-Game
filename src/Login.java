/*
 * Jarret Horton
 * Hunter Layman
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Login extends Application {

	public ArrayList<Player> users;
	public Player thePlayer;
	public Login loginScreen;

	@Override
	public void start(Stage primaryStage) {
		loginScreen = this;
		
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		Label username = new Label("Username:");
		username.setTranslateX(-150);
		username.setTranslateY(-50);
		TextField usertext = new TextField();
		usertext.setMaxWidth(150);
		usertext.setTranslateY(-50);
		usertext.setTranslateX(50);
		usertext.setText("");
		Label password = new Label ("Facebook Password:");
		password.setTranslateX(-130);
		TextField userPassword = new TextField();
		userPassword.setMaxWidth(150);
		userPassword.setText("");
		userPassword.setTranslateX(50);
		Button submit = new Button("Submit");
		submit.setTranslateY(100);
		pane.getChildren().addAll(username, usertext,password,userPassword, submit);
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (usertext.getText().equals("") == false) {
					String puname = usertext.getText();
					try {
						readObject();
					} catch (ClassNotFoundException | IOException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
					int returnIndex = -1;
					if (users.isEmpty() == false) {
						//System.out.println("Size: " + users.size());
						for (int i = 0; i < users.size(); i++) { 
							System.out.println(users.get(i));
							if (users.get(i).getUserName().equals(puname)) {
								System.out.println("User " + puname + " is old username");
								returnIndex = i;
								thePlayer = users.get(i);
							}
						}
					}
					if (returnIndex == -1) {
						//System.out.println(puname);
						Player newPlayer = new Player(puname,userPassword.getText());
						users.add(0, newPlayer);
						thePlayer = users.get(0);
					}
					
					System.out.println("This is the Player: "+thePlayer);
					MainMenu mainMenu = new MainMenu();
					mainMenu.runMainMenu(loginScreen);
					
					/*try {
						System.out.println(users.get(0));
						writeObject(users);
					} catch (IOException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}*/

					primaryStage.close();
				} else {
					System.out.println("Invalid");
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void writeObject() throws IOException {
		FileOutputStream fout = new FileOutputStream("users");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(users);
		System.out.println("Success");
		out.close();
		fout.close();
	}

	@SuppressWarnings("unchecked")
	public void readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("users");
			ObjectInputStream in = new ObjectInputStream(fis);
			users = (ArrayList<Player>) in.readObject();
			System.out.println("Success");
			in.close();
			fis.close();
		} catch (FileNotFoundException e) {
			users = new ArrayList<>();
			System.err.println("Created new arraylist for players");
		}

	}
}
