
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

public class UserName extends Application {

	public ArrayList<Player> users;
	Player thePlayer;

	@Override
	public void start(Stage primaryStage) {

		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		Label username = new Label("Username:");
		username.setTranslateX(-150);
		TextField usertext = new TextField();
		usertext.setMaxWidth(150);
		usertext.setText("");
		Button submit = new Button("Submit");
		submit.setTranslateY(100);
		pane.getChildren().addAll(username, usertext, submit);
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
							String user = users.get(i).getUserName();
							System.out.println("userName: " + user);
							if (user.equals(puname)) {
								System.out.println("User " + puname + " is old username");
								returnIndex = i;
								thePlayer = users.get(i);
							}
						}
					}
					if (returnIndex == -1) {
						//System.out.println(puname);
						Player newPlayer = new Player(puname);
						users.add(0, newPlayer);
						thePlayer = users.get(0);
					}
					
					System.out.println("This is the Player: "+thePlayer);
					MainMenu mainMenu = new MainMenu();
					thePlayer = mainMenu.runMainMenu(thePlayer);
					
					try {
						System.out.println(users.get(0));
						writeObject(users);
					} catch (IOException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}

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

	public void writeObject(ArrayList<Player> list) throws IOException {
		FileOutputStream fout = new FileOutputStream("users");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(list);
		System.out.println("Success");
		out.close();
		fout.close();
	}

	public void readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("users");
			ObjectInputStream in = new ObjectInputStream(fis);
			users = (ArrayList<Player>)in.readObject();
			System.out.println("Success");
			in.close();
			fis.close();
		} catch (FileNotFoundException e) {
			users = new ArrayList<>();
			System.err.println("Created new arraylist for players");
		}

	}
}
