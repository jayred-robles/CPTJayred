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
		
		//Importing and exporting other files
		
		//Highscores
		TextInputFile txtScoreBoard = new TextInputFile("Highscores.txt");
		TextOutputFile txtRecordScore = new TextOutputFile("Highscores.txt");
		
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
				Game(con);
				con.setDrawColor(new Color (252, 200, 20));
				con.drawString("Enter Player 1's Name", 57, 334);
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.print("		");
				String strName1 = con.readLine();
				
				con.clear();
				con.sleep(500);
				Game(con);
				con.setDrawColor(new Color (52, 232, 248));
				con.drawString("Enter Player 2's Name", 607, 334);
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.println("");
				con.print("								");
				String strName2 = con.readLine();
				
				while(strChoice.equals("p")){
				con.clear();
				Game(con);
				con.println("Game");
				
				con.println("are you done?");
				String strDone = con.readLine();
					if(strDone.equals("no")){
						
					}else{
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
					}
				}
				
			}else if(strChoice.equals("v")){
			//High Score Screen
			HighScores(con);
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
			con.println("");
			}
		}
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
		
	}
}

