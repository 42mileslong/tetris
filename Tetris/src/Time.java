//Documentation of the methods are in the method

public class Time implements Runnable {
	//each level time is decreased as such:
	//0, 50, 75, 100, 125, 150, 175, 200, 225, 250
	
	//how much time the game should wait between levels
	private static int[] levWait = {1700, 1450, 1375, 1275, 1150, 1000, 825, 625, 325, 125, 1, 0}; 
	
	//thread time repaints and calls methods after periods of time
	Thread time;
	
	static long printTime = 0;
	static long startTime = 0;
	static long currentTime = 0;
	
	//starts the thread time
	public static void threadTimeStart() {
		Thread time = new Thread(new Time());
		time.start();
	}
	
	//calls timeKeeping when the thread time starts
	public void run() {
		timeKeeping();
	}
	
	//keeps track of time, and calls methods that need to be called every drop
	public static void timeKeeping() {
		//random place stuff
		int rantime = 0;
		//the startTime helps keep track of how much time has passed since the loop started, which keeps the computer's performance from effecting game speed
		startTime = System.currentTimeMillis();
		Main.d.repaint();
		sleep();
		
		//a loop that calls methods after every drop
		while (Main.game) {
			startTime = System.currentTimeMillis();
			
			/* Stuff that goes before repaint */
			
			Main.d.repaint();
			
			/* Stuff that goes after repaint but before sleep */
			
			sleep();
		}
	}
	
	private static void sleep() {
		currentTime = System.currentTimeMillis();
		
		//sleeps for the amount of time alloted, removing how much time has passed since the beginning of the loop
		if ((levWait[Main.level -1]-(currentTime-startTime)) >= 0) {
			try {
				Thread.sleep(levWait[Main.level -1]-(currentTime-startTime));
			} catch (InterruptedException e) {
				System.out.println("Time thread died");
				e.printStackTrace();
			}
		}
	
		printStatus();
	}
	
	private static void printStatus() {
		if ((currentTime - printTime) > 1000) {
			if ((levWait[Main.level -1]-(currentTime-startTime)) >= 0) {
				Main.consolePrint("Normal: Game is on time");
			} else {
				Main.consolePrint("Warning: Did the time change, or is the game falling behind?");
			}
			printTime = currentTime;
		}
	}
}