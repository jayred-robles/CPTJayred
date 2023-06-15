/*
 * 
 * Name: Connect 4 
 * File Name: CPTJayred.java
 * By: Jayred Robles
 * Date Created: May 29, 2023
 * Purpose: 2-Player Connect 4 Game With Other Features
 * Version: 2.1
 * 
 */



import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class CPTJayred{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		
		//Variables for general use
		int intMouseX;
		int intMouseY;
		int intCurrentMouseButton;
		int intLines = 0;
		
		
		double dblP2Wins;
		double dblP1Wins;
		
		String strName1;
		String strName2;
		
	
		
		
		//Choice Variable
		char chrChoice = ' ';
		
		//Title Font
		Font fntSquare = con.loadFont("square.ttf", 125);
		
		
		
		//Home Screen
		while(chrChoice != 'q'){
			
			//Will determine what the players will do
			chrChoice = ' ';
			
			//Title Background
			MainMenu(con);
			
			//Will ask for what the play wants to do until they put a valid option
			while((chrChoice != 'q') &&(chrChoice != 'p') &&(chrChoice != 'w') && (chrChoice != 'm') &&(chrChoice != 's') &&(chrChoice != 'h')){
				chrChoice = con.getChar();
				
			}
			
			 
			con.repaint();
			con.clear();
			
			if(chrChoice == 'p'){
				//Game Background
				Game(con);
				
				//Help option
				char chrHelp;
				
				
				con.drawString("Press 'h' if you want help before you begin", 57, 334);
				con.drawString("Press any other button to continue: ", 57, 434);
				chrHelp = con.getChar();
				
				//If the players want help
				if(chrHelp == 'h'){
					con.repaint();
					//Instructions
					Help(con);
					
					//Back Button
					while(chrChoice != 'b'){
						int intMouseXw = con.currentMouseX();
						int intMouseYw = con.currentMouseY();
						int intCurrentMouseButtonw = con.currentMouseButton();
						if(((intMouseXw >= 512) && (intMouseXw <= 710)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
								con.setDrawColor(new Color (252, 200, 20));
								con.drawRect(530,544,200,38);
								con.setDrawColor(new Color (52, 232, 248));
								con.drawString("PLAY", 572, 534);
								if(intCurrentMouseButtonw == 1){
									chrChoice = 'b';
									con.sleep(300);
								}
						
						}else{
							con.setDrawColor(new Color (252, 200, 20));
							con.setDrawColor(Color.WHITE);
							con.drawString("PLAY", 572, 534);	
							con.setDrawColor(Color.WHITE);
							con.drawRect(530,544,200,38);
						}
						con.repaint();
					}
				}
				
				chrChoice = 'p';
				//Amount of wins
				double dblWins1 = 0.00;
				double dblWins2 = 0.00;
				//Number of games played
				double dblGames = 0.00;
				
				//Name choice
				char chrNameChoice = ' ';
				
				//Names of players
				strName1 = "";
				strName2 = "";
				
				//Asking for names
				//Will keep asking for names until the players are good with their decision 
				while(chrNameChoice != 'y'){
					//Game background
					Game(con);
					
					//Asks for Player 1's Name
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("Enter Player 1's Name", 57, 334);
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.print("		");
					strName1 = con.readLine();
					
					con.clear();
					con.repaint();
					con.sleep(500);
					Game(con);
					
					//Asks for Player 2's Name
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("Enter Player 2's Name", 607, 334);
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.print("								");
					strName2 = con.readLine();
					Game(con);
					con.clear();
					
					
					//Shows the chosen names and asks if they are ok
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("Player 2: "+strName2, 807, 40);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("Player 1: "+strName1, 57, 40);
					con.setDrawColor(Color.WHITE);
					con.drawString("Are These Names Good?", 332, 484);
					con.drawString("Press 'y' To Continue:", 332, 534);
					chrNameChoice = con.getChar();
					
					con.clear();
					con.repaint();
					
				}
				
				
				//Game setup
				while(chrChoice == 'p'){
					//Game backgound
					Game(con);
					
					//For recording
					char chrRecord = ' ';
					con.clear();
					con.repaint();
					
					//Asks if the players want to record their game
					con.setDrawColor(Color.WHITE);
					con.drawString("Would you like to record this game? 'y' / 'n'", 57, 334);
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.print("		");
					
					//Keeps looping until a valid answer is given
					while((chrRecord != 'y') && (chrRecord != 'n')){
						chrRecord = con.getChar();
					}
					
					//If they want to record their game
					if(chrRecord == 'y'){
						
						//Clears old recorded game
						TextOutputFile txtClear = new TextOutputFile("Replay.txt");
						txtClear.close();
						
						//Records player's names
						TextOutputFile txtReplay = new TextOutputFile("Replay.txt", true);
						txtReplay.println(strName1);
						txtReplay.println(strName2);
						txtReplay.close();
						
					//Nothing happens if they do not want to record the game	
					}else{
						
						
						
					}
				
					
					con.clear();
					con.repaint();
					
					//Game Background
					Game(con);
					
					//Drawing Board
					Board(con);
					con.setDrawColor(Color.WHITE);
					con.drawString("1",320,640);
					con.drawString("2",420,640);
					con.drawString("3",520,640);
					con.drawString("4",620,640);
					con.drawString("5",720,640);
					con.drawString("6",820,640);
					con.drawString("7",920,640);
					//
					dblGames = dblGames + 1;

					
					//Array for board
					int intRows = 6;
					int intColumns = 7;
					int intBoard[][] = new int[intRows][intColumns];
					
					
					//Drawing Names
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString(strName2, 1107, 40);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString(strName1, 57, 40);
					
					char chrWin = ' ';
					int intTurn = 1;
					int intMove = 0;
					
					//Main game function
					//Will keep looping until there is a winner or board is full
					while(chrWin == ' '){
						
						//Shows the number of games played
						con.println("						Game "+dblGames);
						
						//Display on who's turn it is
						if(intTurn % 2 == 1){
							con.setDrawColor(new Color (252, 200, 20));
							con.fillOval(55,130,140,140);
							con.drawString("Your Turn:",20,300);
							
							con.setDrawColor(Color.black);
							con.drawString("Your Turn:",1020,300);
						}else{
							con.setDrawColor(new Color (52, 232, 248));
							con.fillOval(1085,130,140,140);
							con.drawString("Your Turn:",1020,300);
							
							con.setDrawColor(Color.black);
							con.drawString("Your Turn:",20,300);
						}
						//Asks for players move
						intMove = con.readInt();
						
						//If the move is not valid it will ask again
						if((intMove <= 0) || (intMove >= 8)){
							while((intMove <= 0) || (intMove >= 8)){
								con.clear();
								con.println("						Game "+dblGames);
								con.println("Not Valid");
								intMove = con.readInt();
							
							
							}
						}
						//Make sure it lines up with the array
						intMove = intMove - 1;
						
						//Checks to see if there are pieces in the column already
						int intStack = 0;
						while(intBoard[intStack][intMove]>0){
							//If there is a piece, the spot above will be chosen
							intStack = intStack+1;
							
							//If the column is full, players will be asked to choose another column
							if(intStack > 5){
								intStack = 0;
								con.clear();
								con.println("						Game "+dblGames);
								con.println("Invalid: choose another collumn");
								intMove = con.readInt();
							}
						}
						//If the players are recording their game, their moves will be recorded
						if(chrRecord == 'y'){
						
							TextOutputFile txtReplayS = new TextOutputFile("Replay.txt", true);
							txtReplayS.println(intMove);
							txtReplayS.close();
						
						
						}else{
						
						
						
						}
						
						//Determines who's turn it is by looking at the amount of turns played
						intBoard[intStack][intMove] = (intTurn % 2)+1;
						
						//Picks the corresponding colour
						if(intTurn % 2 == 1){
							con.setDrawColor(new Color (252, 200, 20));
						}else{
							con.setDrawColor(new Color (52, 232, 248));
						}
						//Draws piece on board
						con.fillOval(290+((intMove)*100),550-((intStack)*100),80,80);
						
						//Checks for win
						chrWin = chrCheck(intBoard, intStack, intMove, intTurn);
						
						//If the the board is full, game will end
						if(intTurn == 42){
							chrWin = 't';
						}else{
						
							intTurn = intTurn + 1;
						}
						
						//Additional visuals
						con.setDrawColor(Color.BLACK);
						con.fillOval(55,130,140,140);
						con.fillOval(1085,130,140,140);
						con.drawString("Your Turn:",20,300);
						con.drawString("Your Turn:",1020,300);
						con.clear();
						con.repaint();
						
					}
					
					con.clear();
					con.repaint();
					
					//Will determine if they want to play again
					char chrDone = ' ';
					
					
					//If board is full, it will be a tie
					if(chrWin == 't'){
					
						con.setDrawColor(Color.WHITE);
						con.drawString("TIE",20,300);	
					//If the amount of turns is even when a player wins, player 1 wins
					}else if(intTurn % 2 == 0){
						con.setDrawColor(new Color (252, 200, 20));
						dblWins1 = dblWins1 +1;
						con.drawString("YOU WIN",20,300);
					//If the amount of turns is odd when a player wins, player 2 wins	
					}else{
						dblWins2 = dblWins2 +1;
						con.setDrawColor(new Color (52, 232, 248));
						con.drawString("YOU WIN",1020,300);
					}
					//Win percentage calculations
					dblP1Wins = Math.round((dblWins1/dblGames)*100.00);
					dblP2Wins = Math.round((dblWins2/dblGames)*100.00);
					
					
					//Statistics and visuals
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("WINS",1020,350);
					con.drawString("WIN %",1020,450);
					con.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.println("	"+dblWins1+"										"+dblWins2);
					con.print("\n\n\n");
					con.println("	"+dblP1Wins+"%										"+dblP2Wins+"%");
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("WINS",20,350);
					con.drawString("WIN %",20,450);
					
					
					//Asks for rematch
					con.setDrawColor(Color.WHITE);
					con.drawString("REMATCH?",1000,520);
					con.drawString("'Y' / 'N'",1000,570);
					
					//Will keep looping until valid answer
					while(chrDone != 'y' && chrDone != 'n'){
						chrDone = con.getChar();
					}
					//Game goes again
					if(chrDone == 'y'){
					
					//Scores and names are sent to Highscores.txt	
					}else{
					
						TextOutputFile txtRecordScore = new TextOutputFile("Highscores.txt",true );
						txtRecordScore.println(strName1);
						txtRecordScore.println(dblWins1);
						txtRecordScore.println(strName2);
						txtRecordScore.println(dblWins2);
						txtRecordScore.close();
						
						//Back Button	
						while(chrChoice != 'b'){
							
							
							int intMouseXw = con.currentMouseX();
							int intMouseYw = con.currentMouseY();
							int intCurrentMouseButtonw = con.currentMouseButton();
							if(((intMouseXw >= 12) && (intMouseXw <= 210)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
								con.setDrawColor(new Color (252, 200, 20));
								con.drawRect(30,544,200,38);
								con.setDrawColor(new Color (52, 232, 248));
								con.drawString("BACK", 72, 534);
								if(intCurrentMouseButtonw == 1){
									chrChoice = 'b';
									con.sleep(300);
								}
							}else{
								con.setDrawColor(new Color (252, 200, 20));
								con.setDrawColor(Color.WHITE);
								con.drawString("BACK", 72, 534);	
								con.setDrawColor(Color.WHITE);
								con.drawRect(30,544,200,38);
							}
							con.repaint();
						}
					}
				}
				
			}else if(chrChoice == 's'){
				//Highscore File
				TextInputFile txtBoardLines = new TextInputFile("Highscores.txt");
				
				//High Score Screen
				HighScores(con);
				
				//Variables for highscore screen
				String strHighName;
				
				int intScore; 
				int intScoreY = 150;
				
				double dblRead;
				String strRead;
				
				intLines = 0;
				//Reads number of players in highscore file
				if(intLines == 0){
					while(txtBoardLines.eof() == false){
						strRead = txtBoardLines.readLine();
						dblRead = txtBoardLines.readDouble();
						intLines = intLines + 1;
						
					}
				}
				txtBoardLines.close();
				
				//Opens Highscore file again
				TextInputFile txtScoreBoard = new TextInputFile("Highscores.txt");
				//Array for Highscores
				String strLeaderboard[][] = new String[intLines][2];
				con.setDrawColor(new Color (252, 200, 20));
				
				//Reads information from highscores file and puts it into the array
				for(int intCount = 0; intCount < intLines; intCount++){
					strLeaderboard[intCount][0] = txtScoreBoard.readLine();
					strLeaderboard[intCount][1] = txtScoreBoard.readLine();
				}
				txtScoreBoard.close();
				
				//Sorts information from greatest to least
				strLeaderboard = Sort(strLeaderboard, intLines);
				
				int intRow;
				int intCounter = 1;
				
				//Will ony show the top ten to avoid crowded visuals
				if(intLines > 10){
					intLines = 10;
				}
				//Draws Highscore board
				for(intRow = 0; intRow < intLines; intRow++){
					con.drawString((intCounter+". "+strLeaderboard[intRow][0]+"                     ").substring(0,10), 450, intScoreY);
					con.drawString((strLeaderboard[intRow][1]+"                     ").substring(0,10), 700, intScoreY);
					intScoreY = intScoreY + 40;
					intCounter = intCounter + 1;
				}
				
				
				
				
				//Back Button
				while(chrChoice != 'b'){
					int intMouseXw = con.currentMouseX();
					int intMouseYw = con.currentMouseY();
					int intCurrentMouseButtonw = con.currentMouseButton();
					if(((intMouseXw >= 532) && (intMouseXw <= 730)) && ((intMouseYw >= 580) && (intMouseYw <= 618))){
							con.setDrawColor(new Color (252, 200, 20));
							con.drawRect(530,580,200,38);
							con.setDrawColor(new Color (52, 232, 248));
							con.drawString("BACK", 572, 570);
							if(intCurrentMouseButtonw == 1){
								chrChoice = 'b';
								con.sleep(300);
							}
					}else{
						con.setDrawColor(new Color (252, 200, 20));
						con.setDrawColor(Color.WHITE);
						con.drawString("BACK", 572, 570);	
						con.setDrawColor(Color.WHITE);
						con.drawRect(530,580,200,38);
					}
					con.repaint();
				}
				
					
			}else if(chrChoice == 'w'){
				//Replay Screen
				
				//Replay file
				TextInputFile txtWatch = new TextInputFile("Replay.txt");
				
				
				//Draws board 
				Game(con);
				Board(con);

				con.setDrawColor(Color.WHITE);
				con.drawString("1",320,640);
				con.drawString("2",420,640);
				con.drawString("3",520,640);
				con.drawString("4",620,640);
				con.drawString("5",720,640);
				con.drawString("6",820,640);
				con.drawString("7",920,640);
				
				//Reads file to get names
				strName1 = txtWatch.readLine();
				strName2 = txtWatch.readLine();
				
				//Array for board
				int intRows = 6;
				int intColumns = 7;
				int intBoard[][] = new int[intRows][intColumns];
				
				//Draws Names
				con.setDrawColor(new Color (52, 232, 248));
				con.drawString(strName2, 1107, 40);
				con.setDrawColor(new Color (252, 200, 20));
				con.drawString(strName1, 57, 40);
				
				//Variables for replay
				char chrWin = ' ';
				int intTurn = 1;
				int intMove = 0;
				
				//Loops until winner
				while(chrWin == ' '){
					
					con.println("						Replay ");
					//Draws circle to show whos turn it is
					if(intTurn % 2 == 1){
						con.setDrawColor(new Color (52, 232, 248));
						con.fillOval(1085,130,140,140);
						
						
					}else{
						
						con.setDrawColor(new Color (252, 200, 20));
						con.fillOval(55,130,140,140);
						
					}
					//Reads move from file
					intMove = txtWatch.readInt();
					
					//Puts chosen piece on top of existing ones
					int intStack = 0;
					while(intBoard[intStack][intMove]>0){
						intStack = intStack+1;
						if(intStack > 5){
							intStack = 0;
						}
					}
					
					//Piece in the array will be from Player 1 or 2 depending on who's turn it is
					intBoard[intStack][intMove] = (intTurn % 2)+1;
					
					//Changes colour depending on who's turn it is
					if(intTurn % 2 == 1){
						con.setDrawColor(new Color (252, 200, 20));
					}else{
						con.setDrawColor(new Color (52, 232, 248));
					}
					//Draws piece on the board
					con.fillOval(290+((intMove)*100),550-((intStack)*100),80,80);
					
					//Check for win
					chrWin = chrCheck(intBoard, intStack, intMove, intTurn);
					
					//If board is full without win, it is a tie
					if(intTurn == 42){
						chrWin = 't';
					}else{
					
						intTurn = intTurn + 1;
					}
					
					con.sleep(750);
					
					con.setDrawColor(Color.BLACK);
					con.fillOval(55,130,140,140);
					con.fillOval(1085,130,140,140);
					con.clear();
					con.repaint();
					
				}
					
				//Tie	
				if(chrWin == 't'){
				
					con.setDrawColor(Color.WHITE);
					con.drawString("TIE",80,300);	
				//Player 1 Wins
				}else if(intTurn % 2 == 0){
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("WIN",80,300);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("LOSS",1080,300);
					
				//Player 2 Wins
				}else{
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("WIN",1080,300);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("LOSS",80,300);
				}
				txtWatch.close();
				
				//Back Button
				while(chrChoice != 'b'){
							
					int intMouseXw = con.currentMouseX();
					int intMouseYw = con.currentMouseY();
					int intCurrentMouseButtonw = con.currentMouseButton();
					if(((intMouseXw >= 12) && (intMouseXw <= 210)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
						con.setDrawColor(new Color (252, 200, 20));
						con.drawRect(30,544,200,38);
						con.setDrawColor(new Color (52, 232, 248));
						con.drawString("BACK", 72, 534);
						if(intCurrentMouseButtonw == 1){
							chrChoice = 'b';
							con.sleep(300);
						}
					}else{
						con.setDrawColor(new Color (252, 200, 20));
						con.setDrawColor(Color.WHITE);
						con.drawString("BACK", 72, 534);	
						con.setDrawColor(Color.WHITE);
						con.drawRect(30,544,200,38);
					}
					con.repaint();
				}
			
			}else if(chrChoice == 'h'){
				//Help screen
				
				//Intructions
				Help(con);
				
				//Back Button
				while(chrChoice != 'b'){
					int intMouseXw = con.currentMouseX();
					int intMouseYw = con.currentMouseY();
					int intCurrentMouseButtonw = con.currentMouseButton();
					if(((intMouseXw >= 532) && (intMouseXw <= 730)) && ((intMouseYw >= 580) && (intMouseYw <= 618))){
						con.setDrawColor(new Color (252, 200, 20));
						con.drawRect(530,580,200,38);
						con.setDrawColor(new Color (52, 232, 248));
						con.drawString("BACK", 572, 570);
						if(intCurrentMouseButtonw == 1){
							chrChoice = 'b';
							con.sleep(300);
						}
					}else{
						con.setDrawColor(new Color (252, 200, 20));
						con.setDrawColor(Color.WHITE);
						con.drawString("BACK", 572, 570);	
						con.setDrawColor(Color.WHITE);
						con.drawRect(530,580,200,38);
					}
					con.repaint();
				}
				
				
			
			}else if(chrChoice == 'm'){
				//Secret menu
				
				//Joke
				Joke(con);
				
				//Back Button
				while(chrChoice != 'b'){
					int intMouseXw = con.currentMouseX();
					int intMouseYw = con.currentMouseY();
					int intCurrentMouseButtonw = con.currentMouseButton();
					if(((intMouseXw >= 532) && (intMouseXw <= 730)) && ((intMouseYw >= 580) && (intMouseYw <= 618))){
						con.setDrawColor(new Color (252, 200, 20));
						con.drawRect(530,580,200,38);
						con.setDrawColor(new Color (52, 232, 248));
						con.drawString("BACK", 572, 570);
						if(intCurrentMouseButtonw == 1){
							chrChoice = 'b';
							con.sleep(300);
						}
					}else{
						con.setDrawColor(new Color (252, 200, 20));
						con.setDrawColor(Color.WHITE);
						con.drawString("BACK", 572, 570);	
						con.setDrawColor(Color.WHITE);
						con.drawRect(530,580,200,38);
					}
					con.repaint();
				}
				
				
			
			}else{
				//Quit Screen
				End(con);
				con.clear();
				con.repaint();
				
			}
		}
	}
	 public static void MainMenu(Console con){
		//Main menu Visuals
		BufferedImage imgMain = con.loadImage("MainMenu.jpg");
		con.drawImage(imgMain, 0, 0);
		
		//Title Font
		Font fntSquare = con.loadFont("square.ttf", 125);
		//Title
			con.setDrawColor(new Color (252, 200, 20));
			con.setDrawFont(fntSquare);
			con.repaint();
			con.drawString("CONNECT 4", 300, 10);
			con.clear();
			//Button font
			Font fntSquare2 = con.loadFont("square.ttf", 50);
			con.setDrawFont(fntSquare2);
		
			//Options in Game
			con.setDrawColor(Color.GRAY);
			con.fillRect(530,614,200,42);
			
			con.fillRect(530,514,200,42);

			con.fillRect(530,414,200,42);

			con.fillRect(530,314,200,42);

			con.fillRect(530,214,200,42);
			
			con.setDrawColor(new Color (52, 232, 248));
			con.drawString("(P)LAY", 555, 204);
			con.drawString("(S)CORE", 537, 304);
			con.drawString("(W)ATCH", 542, 404);
			con.drawString("(H)ELP", 557, 504);
			con.drawString("(Q)UIT", 557, 604);
		con.repaint();
	}
	public static void HighScores(Console con){
		//Highscore Background
		BufferedImage imgScore = con.loadImage("HighScores.jpg");
		con.drawImage(imgScore, 0, 0);
		con.repaint();
	}
	public static void Game(Console con){
		//Game Background
		BufferedImage imgGame = con.loadImage("Game.jpg");
		con.drawImage(imgGame, 0, 0);
		con.repaint();
	}
	public static void Help(Console con){
		//Help and Intructions
		BufferedImage imgHelp = con.loadImage("Help.jpg");
		con.drawImage(imgHelp, 0, 0);
		
	}
	public static void End(Console con){
		//End visuals
		BufferedImage imgEnd = con.loadImage("End.jpg");
		con.drawImage(imgEnd, 0, 0);
		con.println("");
		con.sleep(2000);
		con.closeConsole();
		
	}
	
    public static String[][] Sort(String strArray[][], int intCount){
		//Variables
		double dblBelow;
		double dblCurrent;
		int intCounter;
		int intCounter2;
		String strOrder;
		
		//Will keep going until it is organized from greatest to least
		for(intCounter2 = 0; intCounter2 < intCount-1; intCounter2++){
			for(intCounter = 0; intCounter < intCount-intCounter2-1; intCounter++){
				//Reads 2 scores in array
				dblBelow = Double.parseDouble(strArray[intCounter+1][1]);
				dblCurrent = Double.parseDouble(strArray[intCounter][1]);
				//If the value for dblBelow is greater than dblCurrent, the values will switch using strOrder to pass it along
				if(dblBelow > dblCurrent){
					strOrder = strArray[intCounter+1][0];
					strArray[intCounter+1][0] = strArray[intCounter][0];
					strArray[intCounter][0] = strOrder;

					strOrder = strArray[intCounter+1][1];
					strArray[intCounter+1][1] = strArray[intCounter][1];
					strArray[intCounter][1] = strOrder;
				}
			}
		}
		return strArray;
	}
	public static void Board(Console con){
		//Board Visuals
		con.setDrawColor(Color.WHITE);
		con.fillRect(270,30,720,620);
		
		
		//Empty Spaces For Pieces
		con.setDrawColor(Color.BLACK);
		
		int intRow = 290;
		int intCollumn = 50;
		//Row 1
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		//Row 2
		intRow = 290;
		intCollumn = 150;
		
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		
		//Row 3
		intRow = 290;
		intCollumn = 250;
		
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		
		//Row 4
		intRow = 290;
		intCollumn = 350;
		
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		
		//Row 5
		intRow = 290;
		intCollumn = 450;
		
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		
		//Row 6
		intRow = 290;
		intCollumn = 550;
		
		while(intRow != 990){
			con.fillOval(intRow,intCollumn,80,80);
			intRow = intRow+100;
		}
		
	}
	public static char chrCheck(int intBoard[][], int intStack, int intMove, int intTurn){
		//Checking for wins function
		
		//Check variable
		double dblWin = 0;
		
		//Vertical Check
		//Scans whole column
		for(int intCheckY = 0; intCheckY < 6; intCheckY++){
			if(intBoard[intCheckY][intMove] == (intTurn % 2)+1){
				//Adds 1 to variable if it finds a piece that has the same value as the one placed
				dblWin = dblWin + 1;	
			}else{
				//Resets to 0 if it scans anything else
				dblWin = 0;
					
			}
			//If there are 4 pieces in a row the player that placed a piece wins
			if(dblWin == 4){
			return 'y';
			}
			
		}	
		
		//Horizontal Check
		dblWin = 0;
		//Scans the whole row
		for(int intCheckX = 0; intCheckX < 7; intCheckX++){
			if(intBoard[intStack][intCheckX] == (intTurn % 2)+1){
				//Adds 1 to variable if it finds a piece that has the same value as the one placed
				dblWin = dblWin + 1;
			}else{
				//Resets to 0 if it scans anything else
				dblWin = 0;
			}
			if(dblWin == 4){
				//If there are 4 pieces in a row the player that placed a piece wins
				return 'y';
			}
		}	
		
		//Diagonal Check 1 (Positive Slope)
		dblWin = 0;
		//Scans 4 peices below and 4 peices above the placed piece in diagonal
		for(int intCheckD = -4; intCheckD <= 4; intCheckD++) {
			//Will not scan if dimentions are out of array
			if((intCheckD + intStack >= 0) && (intCheckD + intStack < 6) && (intCheckD + intMove >= 0) && (intCheckD + intMove < 7)) {
				if(intBoard[intStack + intCheckD][intMove + intCheckD] == (intTurn % 2) + 1) {
					//Adds 1 to variable if it finds a piece that has the same value as the one placed
					dblWin = dblWin + 1;
					System.out.println("test: "+dblWin);
					if(dblWin == 4){
						//If there are 4 pieces in a row the player that placed a piece wins
						return 'y';
					}
				}else{
					//Resets to 0 if it scans anything else
					dblWin = 0;
				}
			}
		}
		
		//Diagonal Check 2 (Negative Slope)
		dblWin = 0;
		for (int intCheckD2 = -4; intCheckD2 <= 4; intCheckD2++) {
			if((intStack - intCheckD2 >= 0) && (intStack - intCheckD2 < 6) && (intMove + intCheckD2 >= 0) && (intMove + intCheckD2 < 7)) {
				if(intBoard[intStack - intCheckD2][intMove + intCheckD2] == (intTurn % 2) + 1) {
					//Adds 1 to variable if it finds a piece that has the same value as the one placed
					dblWin = dblWin + 1;
					if(dblWin == 4) {
						//If there are 4 pieces in a row the player that placed a piece wins
						return 'y';
					}
				}else{
					//Resets to 0 if it scans anything else
					dblWin = 0;
				}
			}
		}
		return ' ';		
	}
	public static void Joke(Console con){
		//Joke visuals
		
		//Variables 
		int intJoke = 600;
		int intJoker = 600;
		int intHAHA = -12;
		int intFun = 1;
		int intCount = 0;
		
		//Joke image
		BufferedImage imgJoke = con.loadImage("Joke.png");
		con.setDrawColor(Color.BLACK);
		
		//Animation will keep going until certain time
		while(intFun == 1){
			//Drawing background and images
			con.fillRect(0,0,1280,720);
			con.repaint();
			con.drawImage(imgJoke, intJoke, 350);
			con.drawImage(imgJoke, intJoker, 50);
			
			//Images will go back and forth
			if(intJoke <=0){
				intHAHA = +12;
			}
			if (intJoke >= 1100){
				intHAHA = -12;
			}
			if(intJoker <=0){
				intHAHA = -12;
			}
			if (intJoker >= 1100){
				intHAHA = +12;
			}
			//For testing
			System.out.println("Test: "+intJoke);
			
			//For changing the position
			intJoke = intJoke + intHAHA;
			intJoker = intJoker - intHAHA;
			
			con.sleep(30);
			
			//After looping 200 times the animation will end
			intCount = intCount+ 1;
			if(intCount == 200){
				intFun = 0;
			}
		}
	}
}
