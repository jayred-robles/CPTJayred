import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class CPTJayred{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		
		//Variables
		int intMouseX;
		int intMouseY;
		int intCurrentMouseButton;
		int intLines = 0;
		
	
		//TextOutputFile txtRecordScore = new TextOutputFile("Highscores.txt",true );
		
		//Uploading font
		String strChoice = "";
		Font fntSquare = con.loadFont("square.ttf", 125);
		
		
		
		//Home Screen
		while(!strChoice.equals("q")){
			
			strChoice = "";
			MainMenu(con);
			//Title
			con.setDrawColor(new Color (252, 200, 20));
			con.setDrawFont(fntSquare);
			con.repaint();
			con.drawString("CONNECT 4", 300, 10);
			con.clear();
			
			while(strChoice.equals("")){
				//Button font
				Font fntSquare2 = con.loadFont("square.ttf", 50);
				con.setDrawFont(fntSquare2);
				
				intMouseX = con.currentMouseX();
				intMouseY = con.currentMouseY();
				intCurrentMouseButton = con.currentMouseButton();
				con.repaint();
				if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 546) && (intMouseY <= 582))){
					//Help Button
					con.setDrawColor(new Color (252, 200, 20));
					con.drawRect(530,544,200,38);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("QUIT", 572, 534);
					if(intCurrentMouseButton == 1){
						strChoice = "q";
					}
				}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 446) && (intMouseY <= 482))){
					//Watch Button
					con.setDrawColor(new Color (252, 200, 20));
					con.drawRect(530,444,200,38);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("WATCH", 557, 434);
					if(intCurrentMouseButton == 1){
						strChoice = "w";
					}
				}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 346) && (intMouseY <= 382))){
					// Score Button
					con.setDrawColor(new Color (252, 200, 20));
					con.drawRect(530,344,200,38);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("SCORES", 537, 334);
					if(intCurrentMouseButton == 1){
						strChoice = "v";
					}
				}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 246) && (intMouseY <= 282))){
					//Play Button
					con.setDrawColor(new Color (252, 200, 20));
					con.drawRect(530,244,200,38);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("PLAY", 572, 234);
					if(intCurrentMouseButton == 1){
						strChoice = "p";
					}
				}else{
					//Display When Buttons Are Not Being Hovered
					con.setDrawColor(Color.WHITE);
					con.drawRect(530,544,200,38);

					con.drawRect(530,444,200,38);

					con.drawRect(530,344,200,38);

					con.drawRect(530,244,200,38);
					
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("PLAY", 572, 234);
					con.drawString("SCORES", 537, 334);
					con.drawString("WATCH", 557, 434);
					con.drawString("QUIT", 572, 534);
				}
			}
			
			con.clear();
			
			if(strChoice.equals("p")){
				//Game Screen
				Game(con);
				char chrMenu;
				
				con.drawString("Press 'h' if you want help before you begin", 57, 334);
				con.drawString("Press any other button to continue: ", 57, 434);
				chrMenu = con.getChar();
				
				if(chrMenu == 'h'){
					con.repaint();
					Help(con);
					while(!strChoice.equals("b")){
						int intMouseXw = con.currentMouseX();
						int intMouseYw = con.currentMouseY();
						int intCurrentMouseButtonw = con.currentMouseButton();
						if(((intMouseXw >= 512) && (intMouseXw <= 710)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
								//Back Button
								con.setDrawColor(new Color (252, 200, 20));
								con.drawRect(530,544,200,38);
								con.setDrawColor(new Color (52, 232, 248));
								con.drawString("PLAY", 572, 534);
								if(intCurrentMouseButtonw == 1){
									strChoice = "b";
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
				strChoice = "p";
				char chrNameChoice = ' ';
				String strName1 = "";
				String strName2 = "";
				while(chrNameChoice != 'y'){
					Game(con);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("Enter Player 1's Name", 57, 334);
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.print("		");
					strName1 = con.readLine();
					
					con.clear();
					con.sleep(500);
					Game(con);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("Enter Player 2's Name", 607, 334);
					con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					con.print("								");
					strName2 = con.readLine();
					Game(con);
					con.clear();
					
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("Player 2: "+strName2, 807, 40);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString("Player 1: "+strName1, 57, 40);
					con.setDrawColor(Color.WHITE);
					con.drawString("Are These Names Good?", 332, 484);
					con.drawString("Press 'y' To Continue:", 332, 534);
					chrNameChoice = con.getChar();
					
				}
				
				
				
				while(strChoice.equals("p")){
					con.clear();
					Game(con);
					Board(con);
					
					int intRows = 6;
					int intColumns = 7;
					int intBoard[][] = new int[intRows][intColumns];
					
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString(strName2, 1107, 40);
					con.setDrawColor(new Color (252, 200, 20));
					con.drawString(strName1, 57, 40);
					
					char chrWin = ' ';
					int intTurn = 1;
					int intMove = 0;
					
					while(chrWin != 'y'){
						if(intTurn % 2 == 1){
							con.setDrawColor(new Color (252, 200, 20));
							con.fillOval(55,130,140,140);
							con.drawString("Your Turn:",20,300);
						}else{
							con.setDrawColor(new Color (52, 232, 248));
							con.fillOval(1085,130,140,140);
							con.drawString("Your Turn:",1020,300);
						}
						intMove = con.readInt();
						if((intMove <= 0) || (intMove >= 8)){
							while((intMove <= 0) || (intMove >= 8)){
								con.clear();
								con.println("Not Valid");
								intMove = con.readInt();
							
							
							}
						}
						int intStack = 0;
						while(intBoard[intStack][intMove]>0){
							intStack = intStack+1;
							if(intStack > 5){
								intStack = 0;
								con.clear();
								con.println("Invalid: choose another collumn");
								intMove = con.readInt();
							}
						}
						
						intBoard[intStack][intMove] = (intTurn % 2)+1;
						if(intTurn % 2 == 1){
							con.setDrawColor(new Color (252, 200, 20));
						}else{
							con.setDrawColor(new Color (52, 232, 248));
						}
						con.fillOval(290+((intMove-1)*100),550-((intStack)*100),80,80);
						
						if(intMove == 7){
							chrWin = 'y';
						}
						
						
						intTurn = intTurn + 1;
						con.setDrawColor(Color.BLACK);
						con.fillOval(55,130,140,140);
						con.fillOval(1085,130,140,140);
						con.clear();
						
					}

					con.println("Play Again?");
					String strDone = con.readLine();
					if(strDone.equals("yes")){
						
					}else{
						while(!strChoice.equals("b")){
							int intMouseXw = con.currentMouseX();
							int intMouseYw = con.currentMouseY();
							int intCurrentMouseButtonw = con.currentMouseButton();
							if(((intMouseXw >= 12) && (intMouseXw <= 210)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
								//Back Button
								con.setDrawColor(new Color (252, 200, 20));
								con.drawRect(30,544,200,38);
								con.setDrawColor(new Color (52, 232, 248));
								con.drawString("BACK", 72, 534);
								if(intCurrentMouseButtonw == 1){
									strChoice = "b";
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
				
			}else if(strChoice.equals("v")){
				//High Score Screen
				TextInputFile txtBoardLines = new TextInputFile("Highscores.txt");
				HighScores(con);
				String strHighName;
				int intScore; 
				intLines = 0;
				
				int intScoreY = 150;
				
				int intRead;
				String strRead;
				if(intLines == 0){
					while(txtBoardLines.eof() == false){
						strRead = txtBoardLines.readLine();
						intRead = txtBoardLines.readInt();
						intLines = intLines + 1;
						
					}
				}
				txtBoardLines.close();
				
				TextInputFile txtScoreBoard = new TextInputFile("Highscores.txt");
				String strLeaderboard[][] = new String[intLines][2];
				con.setDrawColor(new Color (252, 200, 20));
				
				for(int intCount = 0; intCount < intLines; intCount++){
					strLeaderboard[intCount][0] = txtScoreBoard.readLine();
					strLeaderboard[intCount][1] = txtScoreBoard.readLine();
				}
				txtScoreBoard.close();
				strLeaderboard = bubbleSort(strLeaderboard, intLines);
				
				int intRow;
				int intCounter = 1;
				
				if(intLines > 10){
					intLines = 10;
				}
				
				for(intRow = 0; intRow < intLines; intRow++){
					con.drawString((intCounter+". "+strLeaderboard[intRow][0]+"                     ").substring(0,10), 450, intScoreY);
					con.drawString((strLeaderboard[intRow][1]+"                     ").substring(0,10), 700, intScoreY);
					intScoreY = intScoreY + 40;
					intCounter = intCounter + 1;
				}
				
				
				
				
				
				while(!strChoice.equals("b")){
					int intMouseXw = con.currentMouseX();
					int intMouseYw = con.currentMouseY();
					int intCurrentMouseButtonw = con.currentMouseButton();
					if(((intMouseXw >= 532) && (intMouseXw <= 730)) && ((intMouseYw >= 580) && (intMouseYw <= 618))){
							//Back Button
							con.setDrawColor(new Color (252, 200, 20));
							con.drawRect(530,580,200,38);
							con.setDrawColor(new Color (52, 232, 248));
							con.drawString("BACK", 572, 570);
							if(intCurrentMouseButtonw == 1){
								strChoice = "b";
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
				
					
			}else if(strChoice.equals("w")){
			//Replay Screen
			Game(con);
			while(!strChoice.equals("b")){
				int intMouseXw = con.currentMouseX();
				int intMouseYw = con.currentMouseY();
				int intCurrentMouseButtonw = con.currentMouseButton();
				if(((intMouseXw >= 512) && (intMouseXw <= 710)) && ((intMouseYw >= 546) && (intMouseYw <= 582))){
					//Back Button
					con.setDrawColor(new Color (252, 200, 20));
					con.drawRect(530,544,200,38);
					con.setDrawColor(new Color (52, 232, 248));
					con.drawString("BACK", 572, 534);
					if(intCurrentMouseButtonw == 1){
						strChoice = "b";
						con.sleep(300);
					}
					}else{
						con.setDrawColor(new Color (252, 200, 20));
						con.setDrawColor(Color.WHITE);
						con.drawString("BACK", 572, 534);	
						con.setDrawColor(Color.WHITE);
						con.drawRect(530,544,200,38);
					}
					con.repaint();
				}
				
			}else{
				//Quit Screen
				End(con);
				
			}
		}
		System.out.println(strChoice);
	}
	 public static void MainMenu(Console con){
		BufferedImage imgMain = con.loadImage("MainMenu.jpg");
		con.drawImage(imgMain, 0, 0);
		con.repaint();
	}
	public static void HighScores(Console con){
		BufferedImage imgScore = con.loadImage("HighScores.jpg");
		con.drawImage(imgScore, 0, 0);
		con.repaint();
	}
	public static void Game(Console con){
		BufferedImage imgGame = con.loadImage("Game.jpg");
		con.drawImage(imgGame, 0, 0);
		con.repaint();
	}
	public static void Help(Console con){
		BufferedImage imgHelp = con.loadImage("Game.jpg");
		con.drawImage(imgHelp, 0, 0);
		
	}
	public static void End(Console con){
		BufferedImage imgEnd = con.loadImage("End.jpg");
		con.drawImage(imgEnd, 0, 0);
		con.println("");
		con.sleep(2000);
		con.closeConsole();
		
	}
	
    public static String[][] bubbleSort(String strSortedArray[][], int intCount){
	int intBelow;
	int intCurrent;
	int intCounter;
	int intCounter2;
	String strTemp;

	for(intCounter2 = 0; intCounter2 < intCount-1; intCounter2++){
		for(intCounter = 0; intCounter < intCount-intCounter2-1; intCounter++){
			intBelow = Integer.parseInt(strSortedArray[intCounter+1][1]);
			intCurrent = Integer.parseInt(strSortedArray[intCounter][1]);
			if(intBelow > intCurrent){
				strTemp = strSortedArray[intCounter+1][0];
				strSortedArray[intCounter+1][0] = strSortedArray[intCounter][0];
				strSortedArray[intCounter][0] = strTemp;

				strTemp = strSortedArray[intCounter+1][1];
				strSortedArray[intCounter+1][1] = strSortedArray[intCounter][1];
				strSortedArray[intCounter][1] = strTemp;
			}
		}
	}
	return strSortedArray;
	}
	public static void Board(Console con){
		con.setDrawColor(Color.WHITE);
		con.fillRect(270,30,720,620);
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
}


