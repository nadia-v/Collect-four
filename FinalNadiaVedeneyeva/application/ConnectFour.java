package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConnectFour extends Application {	
	
	String unicornURL = "/application/images/unicorn.gif";
	Image unicorn = new Image(unicornURL, 100, 100, true, true);
	ImageView unicornView = new ImageView(unicorn);
	
	String pikaURL = "/application/images/pika.gif";
	Image pika = new Image(pikaURL, 100, 100, true, true);
	ImageView pikaView = new ImageView(pika);
	
	String dogoURL = "/application/images/dogo.gif";
	Image dogo = new Image(dogoURL, 100, 100, true, true);
	ImageView dogoView = new ImageView(dogo);
	
	String raccoonURL = "/application/images/raccoon.gif";
	Image raccoon = new Image(raccoonURL, 100, 100, true, true);
	ImageView raccoonView = new ImageView(raccoon);
	
	String helloKittyURL = "https://cdn.clipart.email/2e54ac74b25cf5d04fdb106c1be52c71_glitter-graphics-cute-" +
			"graphics-free-graphics-free-clipart-png-_386-500.gif";
	Image helloKitty = new Image(helloKittyURL, 100, 100, true, true);
	ImageView helloKittyView = new ImageView(helloKitty);
		
	
	private Text playerSelectionText  = new Text("Player 1 choose your avatar!");
	private Text bannerText = new Text("Player 1 make your move!");
		
	private String player = "player1";
	private String player1URL = "";
	private String player2URL = "";
	
	private Cell[][] cell = new Cell[7][6];
	
	ImageView avatar = new ImageView(new Image("/application/images/ninja.png", 100, 100, true, true));
	
	GridPane pane = new GridPane();

	@Override
	public void start(Stage primaryStage) {
				
		
		//----------------------Player Instructions Pane---------------------------------//
		
		StackPane selectPlayer = new StackPane();
		
		Rectangle playerSelectionRectangle = new Rectangle(0, 0, 700, 100);
		playerSelectionRectangle.setFill(Color.RED);
		playerSelectionRectangle.setStroke(Color.BLACK);
		playerSelectionText.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		
		selectPlayer.getChildren().addAll(playerSelectionRectangle, playerSelectionText);
		
		
		//----------------------Player Selection Pane---------------------------------//
		
		GridPane players = new GridPane();
		players.setStyle("-fx-background-color: red;");
		players.setPadding(new Insets(10, 10, 10, 10));
		players.setVgap(10);
		players.setHgap(10);
		
		Text player1Text = new Text("Player 1");
		player1Text.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		Text player2Text = new Text("Player 2");
		player2Text.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		
		String imageURL = "/application/images/ninja.png";
		Image image = new Image(imageURL, 100, 100, true, true);
		ImageView player1 = new ImageView(image);
		ImageView player2 = new ImageView(image);
		
		
		
		Button play = new Button("PLAY");
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			
//--------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------------//
			
			
		//----------------------Game---------------------------------//
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
            	
            	Game game = new Game();
            	game.nextMove();
            }
		});
		
//--------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------------//
		
		players.add(player1Text, 0, 0);
		players.add(player2Text, 0, 1);
		players.add(player1, 1, 0);
		players.add(player2, 1, 1);
		players.add(play, 2, 1);
			
		
		//-------------------Select Avatar Pane------------------------------------//
		
		GridPane playerPane = new GridPane();
		playerPane.setPadding(new Insets(10, 10, 10, 10));
		playerPane.setVgap(10);
		playerPane.setHgap(10);
		
		Button unicornButton = new Button();
		unicornButton.setGraphic(unicornView);
		unicornButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = unicornURL;
				player1.setImage(unicorn);
			} //End if statement
			else if (player == "player2") {
				player2URL = unicornURL;
				player2.setImage(unicorn);
			} //End else if statement
				handlePlayerSelection();
		}); //End unicorn Button
		
		
		Button pikaButton = new Button();
		pikaButton.setGraphic(pikaView);
		pikaButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = pikaURL;
				player1.setImage(pika);
			} //End if statement
			else if (player == "player2") {
				player2URL = pikaURL;
				player2.setImage(pika);
			} //End else if statement
				handlePlayerSelection();
		}); //End pika Button
		
		
		Button dogoButton = new Button();
		dogoButton.setGraphic(dogoView);
		dogoButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = dogoURL;
				player1.setImage(dogo);
			} //End if statement
			else if (player == "player2") {
				player2URL = dogoURL;
				player2.setImage(dogo);
			} //End else if statement
				handlePlayerSelection();
		}); //End dogo Button
		
		
		Button raccoonButton = new Button();
		raccoonButton.setGraphic(raccoonView);
		raccoonButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = raccoonURL;
				player1.setImage(raccoon);
			} //End if statement
			else if (player == "player2") {
				player2URL = raccoonURL;
				player2.setImage(raccoon);
			} //End else if statement
				handlePlayerSelection();
		}); //End raccoon Button
		
		
		Button helloKittyButton = new Button();
		helloKittyButton.setGraphic(helloKittyView);
		helloKittyButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = helloKittyURL;
				player1.setImage(helloKitty);
			} //End if statement
			else if (player == "player2") {
				player2URL = helloKittyURL;
				player2.setImage(helloKitty);
			} //End else if statement
				handlePlayerSelection();
		}); //End hello Kitty Button
		
		
		playerPane.add(unicornButton, 0, 0);
		playerPane.add(pikaButton, 1, 0);
		playerPane.add(dogoButton, 0, 1);
		playerPane.add(raccoonButton, 1, 1);
		playerPane.add(helloKittyButton, 0, 2);


		
	
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(selectPlayer);
		borderPane.setCenter(playerPane);
		borderPane.setBottom(players);
		
		Scene scene = new Scene(borderPane, 700, 800);
		primaryStage.setTitle("Connect Four");
		primaryStage.setScene(scene);
		primaryStage.show();
	} //End start
	
	
	//----------------------Select Player Turn---------------------------------//
	
	
	
	private void handlePlayerSelection() {
		
    	if (player == "player1") {
    		playerSelectionText.setText("Player 2 choose your avatar!");
    		player = "player2";
    	}
    	else if (player == "player2") {
    		playerSelectionText.setText("Player 1 choose your avatar!");
    		player = "player1";
    	}
	} //End handle player selection
	
	

//----------------------Class Game---------------------------------//
		
	public class Game extends Cell {
		
		
		public Game() {
			VBox playersMove = new VBox();
			StackPane banner = new StackPane();
			banner.setAlignment(Pos.CENTER);
			
			Rectangle bannerRectangle = new Rectangle(0, 0, 700, 100);
			bannerRectangle.setFill(Color.RED);
			bannerRectangle.setStroke(Color.BLACK);
			
			
			bannerText.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));  
			
			banner.getChildren().addAll(bannerRectangle, bannerText);
			
			Pane move = new Pane();
			
			avatar.setImage(new Image(player1URL, 100, 100, true, true));
			avatar.setCache(true);
			avatar.setCacheHint(CacheHint.SPEED);
			move.getChildren().add(avatar);
			
			playersMove.getChildren().addAll(banner, move);
    	
			for (int i = 0; i < 7; i++)
				for (int j = 0; j < 6; j++)
					pane.add(cell[i][j] = new Cell(), i, j);
			
			
	        BorderPane game = new BorderPane();
	        game.setTop(playersMove);
	        game.setCenter(pane);
	
	        Scene gameScene = new Scene(game, 700, 800);
	        Stage newWindow = new Stage();
	        newWindow.setTitle("Connect Four");
	        newWindow.setScene(gameScene);
	        newWindow.show();
	        
    	} //End Game
    	
		
		
    	public void nextMove() {
					
			avatar.setOnMouseDragged(e -> {
				avatar.setX(e.getX());       			        	          
			}); //End set on mouse dragged
			
			avatar.setOnMouseClicked(e -> {
				
		
	//-----------------------------------Avatar on Mouse Clicked-----------------------------------------------------//			
			
	
			if (avatar.getX() >= 0 && avatar.getX() <= 50) {
				int i = 0;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[0][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	    							
	    			} //End if token = 0
	    		} //End for statement
			} //End if column 0
			
			//-------------------------------//
			
			if (avatar.getX() > 50 && avatar.getX() <= 150) {
				int i = 1;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[1][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	
	    			} //End if token = 0			
	    		} //End for statement
			} //End if column 1
			
			//-------------------------------//
			
			if (avatar.getX() > 150 && avatar.getX() <= 250) {
				int i = 2;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[2][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	    							
	    			} //End if token = 0
	    		} //End for statement
			} //End if column 2
			
			//-------------------------------//
			
			if (avatar.getX() > 250 && avatar.getX() <= 350) {
				int i = 3;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[3][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	
	    			} //End if token = 0			
	    		} //End for statement
			} //End if column 3
			
			//-------------------------------//
			
			if (avatar.getX() > 350 && avatar.getX() <= 450) {
				int i = 4;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[4][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	    							
	    			} //End if token = 0
	    		} //End for statement
			} //End if column 4
			
			//-------------------------------//
			
			if (avatar.getX() > 450 && avatar.getX() <= 550) {
				int i = 5;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[5][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	
	    			} //End if token = 0			
	    		} //End for statement
			} //End if column 5
			
			//-------------------------------//
			
			if (avatar.getX() > 550 && avatar.getX() <= 650) {
				int i = 6;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[6][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	    							
	    			} //End if token = 0
	    		} //End for statement
			} //End if column 6
			
			//-------------------------------//
			
			if (avatar.getX() > 650 && avatar.getX() <= 750) {
				int i = 7;
	    		for(int j = 5; j >= 0; j--) {
	    			if (cell[7][j].getToken() == 0) {
	    				setAvatar(i, j);
	    				break;	
	    			} //End if token = 0			
	    		} //End for statement
			} //End if column 7					
				
		});	//End on mouse clicked		
	    } //End next move
    	
    	
	    public void setAvatar(int i, int j) {
	    	
			if (player == "player1") {		
				cell[i][j].setToken(1);
				ImageView avatar1 = new ImageView(new Image(player1URL, 100, 100, true, true));
				avatar1.setCache(true);
				avatar1.setCacheHint(CacheHint.SPEED);
				pane.add(avatar1, i, j);
			} //End if statements
			
			else if (player == "player2") {	
				cell[i][j].setToken(2);
				ImageView avatar2 = new ImageView(new Image(player2URL, 100, 100, true, true));
				avatar2.setCache(true);
				avatar2.setCacheHint(CacheHint.SPEED);
				pane.add(avatar2, i, j); 
			} //End if statements
			checkResult();		
	    } //End setAvatar
	    
	    
	    
	    //Check for winner
	    public void checkResult() {
	    	
	    	//StackPane winnerPane = new StackPane();
	    	
	    	//Check vertical rows for winner
	    	for (int j = 0; j < 6; j++)
	    		for (int i = 0; i < 4; i++) {
	    			if (cell[i][j].getToken() == 1 &&
	    					cell[i + 1][j].getToken() == 1 &&
	    					cell[i + 2][j].getToken() == 1 &&
	    					cell[i + 3][j].getToken() == 1) {
	    				avatar.setFitHeight(500);
    					avatar.setPreserveRatio(true);
    					avatar.setSmooth(true);
    					avatar.setCache(true); 
    					//winnerPane.getChildren().addAll(pane, avatar);
	    			}
	    			} //End check vertical
	    			
	    	 //Check horizontal
    		for (int i = 0; i < 7; i++) 
	    		for (int j = 0; j < 3; j++) {
	    			if (cell[i][j].getToken() == 1 &&
	    					cell[j + 1][j].getToken() == 1 &&
	    					cell[j + 2][j].getToken() == 1 &&
	    					cell[j + 3][j].getToken() == 1) {
	    				avatar.setFitHeight(500);
    					avatar.setPreserveRatio(true);
    					avatar.setSmooth(true);
    					avatar.setCache(true); 
    					//winnerPane.getChildren().addAll(pane, avatar);
	    			}
	    			} //End check horizontal
	    		
	    	handlePlayerTurn();	
	    } //End check result
	    
	    
	    public void handlePlayerTurn() {           	
	    	player = (player == "player1") ? "player2" : "player1";
	    	
	    	if (player == "player1") {
	    		avatar.setImage(new Image(player1URL, 100, 100, true, true));
	    		bannerText.setText("Player 1 make your move!");
	    	} //End if
	    	else if (player == "player2") {
	    		avatar.setImage(new Image(player2URL, 100, 100, true, true));
	    		bannerText.setText("Player 2 make your move!");
	    	} //End else if
	    } //End handle player turn
	
	} //End class Game
	
//----------------------End Game---------------------------------//

	
	
//----------------------Class Cell---------------------------------//
	
	
	public class Cell extends Pane {		
    	
		public int token = 0;	
		
		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(100, 100);						
		} //End cell 
		
		public int getToken() {
			return token;
		} //End get token
		
		public void setToken(int one) {
			token = one;
		} //End set token			
			
	} //End class Cell

	
	public static void main(String[] args) {
		launch(args);
	} //End main
	
	
} //End Connect Four











