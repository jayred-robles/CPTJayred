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
		
		String strChoice = "";
		
		Font fntSquare = con.loadFont("square.ttf", 125);
		
		
		con.setDrawColor(new Color (252, 200, 20));
		con.setDrawFont(fntSquare);
		con.repaint();
		con.drawString("CONNECT 4", 300, 10);
		
		Font fntSquare2 = con.loadFont("square.ttf", 50);
		con.setDrawFont(fntSquare2);
		
		//Home Screen
		
		while(strChoice.equals("")){
		intMouseX = con.currentMouseX();
		intMouseY = con.currentMouseY();
		intCurrentMouseButton = con.currentMouseButton();
		con.repaint();
			if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 546) && (intMouseY <= 582))){
				//Help Button
				con.setDrawColor(new Color (252, 200, 20));
				con.drawRect(530,544,200,38);
				con.setDrawColor(new Color (52, 232, 248));
				con.drawString("HELP", 572, 534);
				if(intCurrentMouseButton == 1){
					strChoice = "h";
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
					strChoice = "s";
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
				con.drawString("HELP", 572, 534);
			}
		}
		
		con.clear();
		
		if(strChoice.equals("p")){
			//Game Screen
			
			con.println("Game");
			
		}else if(strChoice.equals("s")){
			//High Score Screen
			
			con.println("high scores");
			
		}else if(strChoice.equals("w")){
			//Replay Screen
			
			con.println("replay");
			
		}else{
			//Help Screen
			
			con.println("HELP");
			
		}
	}
}
