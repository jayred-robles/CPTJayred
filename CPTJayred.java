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
		
		while(strChoice.equals("")){
		intMouseX = con.currentMouseX();
		intMouseY = con.currentMouseY();
		intCurrentMouseButton = con.currentMouseButton();
		con.repaint();
			if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 546) && (intMouseY <= 582))){
				con.setDrawColor(new Color (252, 200, 20));
				con.drawRect(530,544,200,38);
				if(intCurrentMouseButton == 1){
					strChoice = "click";
				}
			}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 446) && (intMouseY <= 482))){
				con.setDrawColor(new Color (252, 200, 20));
				con.drawRect(530,444,200,38);
				if(intCurrentMouseButton == 1){
					strChoice = "click";
				}
			}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 346) && (intMouseY <= 382))){
				con.setDrawColor(new Color (252, 200, 20));
				con.drawRect(530,344,200,38);
				if(intCurrentMouseButton == 1){
					strChoice = "click";
				}
			}else if(((intMouseX >= 512) && (intMouseX <= 710)) && ((intMouseY >= 246) && (intMouseY <= 282))){
				con.setDrawColor(new Color (252, 200, 20));
				con.drawRect(530,244,200,38);
				if(intCurrentMouseButton == 1){
					strChoice = "click";
				}
			}else{
				con.setDrawColor(Color.WHITE);
				con.drawRect(530,544,200,38);

				con.drawRect(530,444,200,38);

				con.drawRect(530,344,200,38);

				con.drawRect(530,244,200,38);
			}
		}
	}
}
