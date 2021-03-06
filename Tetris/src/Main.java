import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;


/*
 * Tetris Fusion
 * 
 * Made by Rafi Long
 * Based on a Tetris Worlds game
 * 
 */


public class Main {
	//dimension variables
	public static int squareSize = 16; //size of the square
	public static int gridWidth = 10; //width of the grid
	public static int gridHeight = 22; //height of the grid
	
	//display variables
	public static Display d = new Display(); //display constructor
	
	//game variables
	public static boolean game = false; //signifies the game is on
	public static int level = 1;
	
	public static void main(String args[]) {
		//console print
		consolePrint("Making frame");
		
		//makes the frame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(0, 0);
		f.setLocation(0, 0);
		f.setVisible(true);
		
		f.add(d);
	}
	
	public static void consolePrint(String message) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		System.out.println("[System @ " + formattedDate +"] " + message);
	}
}
