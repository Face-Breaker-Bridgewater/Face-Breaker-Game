/*Laura Gretz
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Help {
	Stage mainStage;
	public Help(Stage mainStage) {
		runHelp();
		this.mainStage = mainStage;
	}
	
	public void runHelp() {
		
		Stage stage = new Stage();
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 800, 500);
		Label helpTitle = new Label("FACE BREAKER GAME HELP");
		stage.setTitle("HELP!");
		helpTitle.getStyleClass().add("helpTitle");

		StringBuilder text = addText();
		Text help = new Text();
		help.setText(text.toString());
		help.getStyleClass().add("helpText");
		
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainStage.show();
				stage.close();
			}
		});
		
		StackPane.setAlignment(helpTitle, Pos.TOP_CENTER);
		StackPane.setAlignment(help, Pos.CENTER);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		
		pane.getChildren().addAll(back,helpTitle, help);
		
		scene.getStylesheets().add(this.getClass()
        		.getResource("stylesheet.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
	}
	
	public StringBuilder addText() {
        StringBuilder contents = new StringBuilder();
        
        try {
            BufferedReader input =  new BufferedReader(new FileReader("instructions.txt"));
            try {
                String line = null;
                while (( line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            }
            finally {
                input.close();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
     //   System.out.println(contents.toString());
        return contents;
	}
    
}
