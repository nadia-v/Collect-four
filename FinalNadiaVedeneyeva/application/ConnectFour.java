package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConnectFour extends Application {
	//This program is a customized version of Connect Four game
	//After program is ran, users will be presented with the player selection window
	//There are 15 characters for users to choose from
	//Player one chooses first, then player 2 chooses
	//After both players have chosen, 'play' button is activated and needs to be pressed for the game to begin
	//Until play button is pressed, players have an opportunity to choose different characters 
	//After play button is pressed, players will be presented with new window --> game window
	//In the game window, switching turns, players have to move their avatar above the column they wish to drop it into
	//Once avatar is above the desired column, player has to click on the avatar to complete the move
	//The goal of the game is collecting 4 same characters in a row
	//Characters can be collected in horizontal, vertical or diagonal rows
	//After one of the players wins, his avatar will be displayed enlarged and the program will offer to play again
	//If the game is a tie, no avatars will be displayed, just an option to play again.
	//In case players wish to look at the part of the board blocked by the enlarged avatar,
	//The avatar can be moved around with the mouse
	
	
	// Import avatar images
	
	String louise2URL = "/application/images/louise2.gif";
	Image louise2 = new Image(louise2URL, 100, 100, true, true);
	ImageView louise2View = new ImageView(louise2);
	
	String tina2URL = "/application/images/tina2.gif";
	Image tina2 = new Image(tina2URL, 100, 100, true, true);
	ImageView tina2View = new ImageView(tina2);
	
	String geneURL = "/application/images/gene.gif";
	Image gene = new Image(geneURL, 100, 100, true, true);
	ImageView geneView = new ImageView(gene);
	
	String bob2URL = "/application/images/bob2.gif";
	Image bob2 = new Image(bob2URL, 100, 100, true, true);
	ImageView bob2View = new ImageView(bob2);
	
	String linda2URL = "/application/images/linda2.gif";
	Image linda2 = new Image(linda2URL, 100, 100, true, true);
	ImageView linda2View = new ImageView(linda2);
	
	String rickURL = "/application/images/rick.gif";
	Image rick = new Image(rickURL, 100, 100, true, true);
	ImageView rickView = new ImageView(rick);
	
	String mortieURL = "/application/images/mortie.gif";
	Image mortie = new Image(mortieURL, 100, 100, true, true);
	ImageView mortieView = new ImageView(mortie);
	
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
	
	String helloKittyURL = "/application/images/helloKitty.gif";
	Image helloKitty = new Image(helloKittyURL, 100, 100, true, true);
	ImageView helloKittyView = new ImageView(helloKitty);
		
	String pandaURL = "/application/images/panda.gif";
	Image panda = new Image(pandaURL, 100, 100, true, true);
	ImageView pandaView = new ImageView(panda);
	
	String catURL = "/application/images/cat.gif";
	Image cat = new Image(catURL, 100, 100, true, true);
	ImageView catView = new ImageView(cat);
	
	String minionURL = "/application/images/minion.gif";
	Image minion = new Image(minionURL, 100, 100, true, true);
	ImageView minionView = new ImageView(minion);
	
	ImageView avatar = new ImageView(new Image("/application/images/ninja.png", 100, 100, true, true));
	
	


	boolean winner = false;
	Button play = new Button("PLAY");
	
	
	private Text playerSelectionText  = new Text("Player 1 choose your avatar!");
	private Text bannerText = new Text("Player 1 make your move!");
		
	private String player = "player1";
	private String player1URL = "";
	private String player2URL = "";
	
	private Cell[][] cell = new Cell[7][6];
	
	
	GridPane pane = new GridPane();
	VBox playersMove = new VBox();
	Pane move = new Pane();
	
	Stage stage = new Stage();
	Stage newWindow = new Stage();
	
	
	
//---------------------------------------------------------------//


	public void restart(Stage stage) {
	    startGame(stage);
	}

	@Override
	public void start(Stage primaryStage) {
	    startGame(primaryStage);
	}
		
//---------------------------------------------------------------//	
	
	public void startGame(Stage stage) {
				
		
		//----------------------Player Instructions Pane---------------------------------//
		
		
		StackPane selectPlayerBanner = new StackPane();
		Rectangle playerSelectionRectangle = new Rectangle(0, 0, 700, 100);
		playerSelectionRectangle.setFill(Color.RED);
		playerSelectionRectangle.setStroke(Color.BLACK);
		playerSelectionText.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		
		selectPlayerBanner.getChildren().addAll(playerSelectionRectangle, playerSelectionText);
		
		
		//----------------------Player Selection Pane---------------------------------//
		
		GridPane players = new GridPane();	// All available avatars
		players.setStyle("-fx-background-color: red;");
		players.setPadding(new Insets(10, 10, 10, 100));
		players.setVgap(30);
		players.setHgap(10);
		
		Text player1Text = new Text("Player 1");
		player1Text.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		Text player2Text = new Text("Player 2");
		player2Text.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));
		
		String imageURL = "/application/images/ninja.png";
		Image image = new Image(imageURL, 100, 100, true, true);
		ImageView player1 = new ImageView(image);
		ImageView player2 = new ImageView(image);
		
		play.setDisable(true);
		play.setPrefSize(100, 70);
		
		
		players.add(player1Text, 0, 0);
		players.add(player2Text, 0, 1);
		players.add(player1, 1, 0);
		players.add(player2, 1, 1);
		players.add(play, 5, 1);
		
			
		
		//-------------------Select Avatar Pane------------------------------------//
		
		GridPane playerPane = new GridPane();
		playerPane.setPadding(new Insets(10, 0, 10, 15));
		playerPane.setVgap(30);
		playerPane.setHgap(20);
		
		
		Button louise2Button = new Button();
		louise2Button.setGraphic(louise2View);
		louise2Button.setOnAction(e -> {
			if (player == "player1") {
				player1URL = louise2URL;
				player1.setImage(louise2);
			} //End if statement
			else if (player == "player2") {
				player2URL = louise2URL;
				player2.setImage(louise2);
			} //End else if statement
				handlePlayerSelection();
		}); //End louise2 Button
		
		
		Button tina2Button = new Button();
		tina2Button.setGraphic(tina2View);
		tina2Button.setOnAction(e -> {
			if (player == "player1") {
				player1URL = tina2URL;
				player1.setImage(tina2);
			} //End if statement
			else if (player == "player2") {
				player2URL = tina2URL;
				player2.setImage(tina2);
			} //End else if statement
				handlePlayerSelection();
		}); //End tina2 Button
		
		
		Button geneButton = new Button();
		geneButton.setGraphic(geneView);
		geneButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = geneURL;
				player1.setImage(gene);
			} //End if statement
			else if (player == "player2") {
				player2URL = geneURL;
				player2.setImage(gene);
			} //End else if statement
				handlePlayerSelection();
		}); //End gene Button
		
		
		Button bob2Button = new Button();
		bob2Button.setGraphic(bob2View);
		bob2Button.setOnAction(e -> {
			if (player == "player1") {
				player1URL = bob2URL;
				player1.setImage(bob2);
			} //End if statement
			else if (player == "player2") {
				player2URL = bob2URL;
				player2.setImage(bob2);
			} //End else if statement
				handlePlayerSelection();
		}); //End bob2 Button
		
		
		Button linda2Button = new Button();
		linda2Button.setGraphic(linda2View);
		linda2Button.setOnAction(e -> {
			if (player == "player1") {
				player1URL = linda2URL;
				player1.setImage(linda2);
			} //End if statement
			else if (player == "player2") {
				player2URL = linda2URL;
				player2.setImage(linda2);
			} //End else if statement
				handlePlayerSelection();
		}); //End linda2 Button
		
		
		Button rickButton = new Button();
		rickButton.setGraphic(rickView);
		rickButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = rickURL;
				player1.setImage(rick);
			} //End if statement
			else if (player == "player2") {
				player2URL = rickURL;
				player2.setImage(rick);
			} //End else if statement
				handlePlayerSelection();
		}); //End rick Button
		
		
		Button mortieButton = new Button();
		mortieButton.setGraphic(mortieView);
		mortieButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = mortieURL;
				player1.setImage(mortie);
			} //End if statement
			else if (player == "player2") {
				player2URL = mortieURL;
				player2.setImage(mortie);
			} //End else if statement
				handlePlayerSelection();
		}); //End mortie Button
		
		
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
		
		
		Button pandaButton = new Button();
		pandaButton.setGraphic(pandaView);
		pandaButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = pandaURL;
				player1.setImage(panda);
			} //End if statement
			else if (player == "player2") {
				player2URL = pandaURL;
				player2.setImage(panda);
			} //End else if statement
				handlePlayerSelection();
		}); //End panda Button
		
		
		Button catButton = new Button();
		catButton.setGraphic(catView);
		catButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = catURL;
				player1.setImage(cat);
			} //End if statement
			else if (player == "player2") {
				player2URL = catURL;
				player2.setImage(cat);
			} //End else if statement
				handlePlayerSelection();
		}); //End cat Button
		
		
		Button minionButton = new Button();
		minionButton.setGraphic(minionView);
		minionButton.setOnAction(e -> {
			if (player == "player1") {
				player1URL = minionURL;
				player1.setImage(minion);
			} //End if statement
			else if (player == "player2") {
				player2URL = minionURL;
				player2.setImage(minion);
			} //End else if statement
				handlePlayerSelection();
		}); //End minion Button
		
		
		
		playerPane.add(louise2Button, 0, 0);
		playerPane.add(tina2Button, 1, 0);
		playerPane.setHalignment(tina2Button, HPos.CENTER); 
		playerPane.setValignment(tina2Button, VPos.CENTER);
		playerPane.add(geneButton, 2, 0);
		playerPane.add(bob2Button, 3, 0);
		playerPane.setHalignment(bob2Button, HPos.CENTER); 
		playerPane.setValignment(bob2Button, VPos.CENTER);
		playerPane.add(linda2Button, 4, 0);
		playerPane.add(rickButton, 0, 1);
		playerPane.setHalignment(rickButton, HPos.CENTER); 
		playerPane.setValignment(rickButton, VPos.CENTER);
		playerPane.add(mortieButton, 1, 1);
		playerPane.add(pikaButton, 2, 1);
		playerPane.add(minionButton, 3, 1);
		playerPane.add(unicornButton, 4, 1);
		playerPane.add(helloKittyButton, 0, 2);
		playerPane.add(catButton, 1, 2);
		playerPane.add(pandaButton, 2, 2);
		playerPane.add(dogoButton, 3, 2);
		playerPane.add(raccoonButton, 4, 2);


		
	
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(selectPlayerBanner);
		borderPane.setCenter(playerPane);
		borderPane.setBottom(players);
		
		Scene scene = new Scene(borderPane, 700, 800);
		stage.setTitle("Connect Four");
		stage.setScene(scene);
		stage.show();
	} //End start
	
	
	//----------------------Select Player Turn---------------------------------//
	
	
	
	private void handlePlayerSelection() {
		
    	if (player == "player1") {
    		playerSelectionText.setText("Player 2 choose your avatar!");
    		player = "player2";
    	} //End if statement
    	else if (player == "player2") {
    		playerSelectionText.setText("Player 1 choose your avatar!");
    		player = "player1";
    		enablePlay();
    	} //End else if statement
	} //End handle player selection
	
	public void enablePlay() {

		play.setDisable(false);

		play.setOnAction(new EventHandler<ActionEvent>() {
			

			
		//----------------------Game---------------------------------//
	        @Override
	        public void handle(ActionEvent event) {
  	
	        	Game game = new Game();
	        	game.nextMove();
	        } //End handle event
		}); //End set on action
	
	} //End enable play button

//----------------------Class Game---------------------------------//
		
	public class Game extends Cell {
		
		BorderPane game = new BorderPane();
		StackPane winnerPane = new StackPane();
		
		public Game() {
			
			StackPane banner = new StackPane();
			banner.setAlignment(Pos.CENTER);
			
			Rectangle bannerRectangle = new Rectangle(0, 0, 700, 100);
			bannerRectangle.setFill(Color.RED);
			bannerRectangle.setStroke(Color.BLACK);
			
			
			bannerText.setFont(Font.font("Andale Mono", FontWeight.BOLD, 25));  
			
			banner.getChildren().addAll(bannerRectangle, bannerText);
			
			
			
			avatar.setImage(new Image(player1URL, 100, 100, true, true));
			move.getChildren().add(avatar);
			
			playersMove.getChildren().addAll(banner, move);
    	
			for (int i = 0; i < 7; i++)
				for (int j = 0; j < 6; j++)
					pane.add(cell[i][j] = new Cell(), i, j);
			
			winnerPane.getChildren().add(pane);
			
	        game.setTop(playersMove);
	        game.setCenter(winnerPane);
	
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
				pane.add(avatar1, i, j);
			} //End if statements
			
			else if (player == "player2") {	
				cell[i][j].setToken(2);
				ImageView avatar2 = new ImageView(new Image(player2URL, 100, 100, true, true));
				pane.add(avatar2, i, j); 
			} //End if statements
			//checkResult(winner);
			handlePlayerTurn();
	    } //End setAvatar
	    
	    
	    
	    //Check for winner
	    public boolean checkResult(boolean winner) {
	    	
	    	//StackPane winnerPane = new StackPane();
	    	
	    	//Check horizontal rows for winner
	    	for (int j = 0; j < 6; j++)
	    		for (int i = 0; i < 4; i++) {
	    			if (cell[i][j].getToken() == 1 &&
	    					cell[i + 1][j].getToken() == 1 &&
	    					cell[i + 2][j].getToken() == 1 &&
	    					cell[i + 3][j].getToken() == 1) {
	    						cell[i][j].setTranslateZ(200);
	    						cell[i + 1][j].setTranslateZ(200);
	    						cell[i + 2][j].setTranslateZ(200);
	    						cell[i + 3][j].setTranslateZ(200);
	    						setWinner(1);
	    						return true;
	    			} //End if winner horizontal 1
	    			else if (cell[i][j].getToken() == 2 &&
	    					cell[i + 1][j].getToken() == 2 &&
	    					cell[i + 2][j].getToken() == 2 &&
	    					cell[i + 3][j].getToken() == 2) {
	    						setWinner(2);
	    						return true;
	    			} //End if winner horizontal 2	    			
	    		} //End check vertical
	    		    	
	    	
	    	 //Check vertical
    		for (int i = 0; i < 7; i++) 
	    		for (int j = 0; j < 3; j++) {
	    			if (cell[i][j].getToken() == 1 &&
	    					cell[i][j + 1].getToken() == 1 &&
	    					cell[i][j + 2].getToken() == 1 &&
	    					cell[i][j + 3].getToken() == 1) {
	    						setWinner(1);
	    						return true;
	    			} //End if player 1 wins vertically
	    			else if (cell[i][j].getToken() == 2 &&
	    					cell[i][j + 1].getToken() == 2 &&
	    					cell[i][j + 2].getToken() == 2 &&
	    					cell[i][j + 3].getToken() == 2) {
	    						setWinner(2);
	    						return true;
	    			} //End if player 2 wins vertically
	    		} //End check vertical
	    	
    		
    		//Check  ascending horizontal 
    		for (int i = 0; i < 4; i++) 
    			for (int j = 5; j > 2; j--) {
    				if (cell[i][j].getToken() == 1 &&
    						cell[i + 1][j - 1].getToken() == 1 &&
    						cell[i + 2][j - 2].getToken() == 1 &&
    						cell[i + 3][j - 3].getToken() == 1) {
		    					setWinner(1);
								return true;
    				} //End if player 1 wins ascending horizontal
    				else if (cell[i][j].getToken() == 2 &&
    						cell[i + 1][j - 1].getToken() == 2 &&
    						cell[i + 2][j - 2].getToken() == 2 &&
    						cell[i + 3][j - 3].getToken() == 2) {
		    					setWinner(2);
								return true;
    				} //End if player 2 wins ascending horizontal
    			} //End check ascending horizontal
    		
    		
    		//Check descending horizontal
    		for (int i = 0; i < 4; i++) 
    			for (int j = 0; j < 3; j++) {
    				if (cell[i][j].getToken() == 1 &&
    						cell[i + 1][j + 1].getToken() == 1 &&
    						cell[i + 2][j + 2].getToken() == 1 &&
    						cell[i + 3][j + 3].getToken() == 1) {
		    					setWinner(1);
								return true;
    				} //End if player 1 wins descending horizontal
    				else if (cell[i][j].getToken() == 2 &&
    						cell[i + 1][j + 1].getToken() == 2 &&
    						cell[i + 2][j + 2].getToken() == 2 &&
    						cell[i + 3][j + 3].getToken() == 2) {
		    					setWinner(2);
								return true;
    				} //End if player 2 wins descending horizontal
    			} //End check descending horizontal
	    	return false;		    	
	    } //End check result
	    
	   
	    
	    //Check if game is a tie
	    public boolean isTie(boolean winner) {
	    	for (int i = 0; i < 7; i++) 
	    		for (int j = 0; j < 6; j++) {
	    			if (cell[i][j].getToken() == 0) {
	    				return false;
	    			} //End if statement
	    		} //End for statement
	    	setWinner(3);
	    	return true;
	    } //End check if game is a tie
	    
	    
	    
	    //Set winner
	    public void setWinner(int winner) { 

	    	DropShadow shadow = new DropShadow();
	    	shadow.setRadius(50);
	    	
	    	VBox replay = new VBox();
	    	ImageView winnerAvatar = new ImageView();
	    	winnerAvatar.setEffect(shadow);
	    	
	    	Button newGame = new Button("PLAY AGAIN");
	    	newGame.setPrefSize(100, 70);
	    
	    	replay.getChildren().add(newGame);
	    	replay.setAlignment(Pos.CENTER);
	    	replay.setPadding(new Insets(15, 0, 15, 0));
	    	
	    	playersMove.getChildren().remove(move);
	    	playersMove.getChildren().add(replay);
	    	
	    	
	    	
			if (winner == 3) { //tie game
				bannerText.setText("It's a Tie!!!");
			} //End if game is a tie 
			else if (winner == 1) {
	    		bannerText.setText("Player 1 is the WINNER!!!");
	    		winnerAvatar.setImage(new Image(player1URL, 400, 400, true, true));
	    	} //End if player 1 is the winner
	    	else if (winner == 2) {
	    		bannerText.setText("Player 2 is the WINNER!!!");
	    		winnerAvatar.setImage(new Image(player2URL, 400, 400, true, true));
	    	} //End if player 2 is the winner
			

			winnerPane.getChildren().add(winnerAvatar);
			
			
			//Move winner's avatar
			winnerAvatar.setOnMouseDragged(e -> {
				winnerAvatar.setTranslateX(e.getX());   
				winnerAvatar.setTranslateY(e.getY()); 
			}); //End set on mouse dragged
			
			

			//Play new game
			newGame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					NewConnect restartGame = new NewConnect();
					restartGame.restart(stage);
				
				}//End handle event
			}); //End play new game
	
			
	    } //End set winner
	    
	    
	    
	    
	    //Handle player turn
	    public void handlePlayerTurn() {  
	    	if (!checkResult(winner) && !isTie(winner)) {
		    	player = (player == "player1") ? "player2" : "player1";	    	
		    	if (player == "player1") {
		    		avatar.setImage(new Image(player1URL, 100, 100, true, true));
		    		bannerText.setText("Player 1 make your move!");
		    	} //End if
		    	else if (player == "player2") {
		    		avatar.setImage(new Image(player2URL, 100, 100, true, true));
		    		bannerText.setText("Player 2 make your move!");
		    	} //End else if 	
	    	} //End if not winner
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











