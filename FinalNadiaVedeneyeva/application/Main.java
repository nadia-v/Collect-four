package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    @Override
    public void start(final Stage primaryStage) {
    	
    	String unicornURL = "https://cdn.shopify.com/s/files/1/1782/5295/files/giphy-2-1_large.gif?v=1532492231";
    	Image unicorn = new Image(unicornURL, 200, 200, true, true);
    	ImageView unicornView = new ImageView(unicorn);
 
        Button button = new Button();
        button.setGraphic(unicornView);
 
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
                Label secondLabel = new Label("I'm a Label on new Window");
 
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 230, 100);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
                //newWindow.setX(primaryStage.getX() + 200);
                //newWindow.setY(primaryStage.getY() + 100);
 
                newWindow.show();
            } //end handle
        }); //end button
 
        StackPane root = new StackPane();
        root.getChildren().add(button);
 
        Scene scene = new Scene(root, 450, 250);
 
        primaryStage.setTitle("JavaFX Open a new Window (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    } //end void start
 
    public static void main(String[] args) {
        launch(args);
    } //end void main
 
} //end main
