import java.util.Scanner;
//import javax.swing.*;

public class Box {

	public static void main(String[] args) {
		/*
		 * Config.
		 */
		Boolean PLAYER_BEGINS = true;
		Integer[] STARTING_FIELD = new Integer[]
				
				{1,2,3,4,5};
		
		/*
		 * End of config.
		 * TODO: Window sizes, buttons and graphical overlay 
		 */
		
		GameState s;
		Scanner scan = new Scanner(System.in);
		int pos, am;
		nimGameEngine eng = new nimPerfectPlayEngine();
		s = new GameState(STARTING_FIELD, PLAYER_BEGINS);
		System.out.println(s);
		while(!s.isFinished()){
			if(s.turn){
				try {
					System.out.print("Enter a move: ");
					pos = scan.nextInt();
					am = scan.nextInt();
					s = s.makeMove(pos, am);
					System.out.println(s);
				} catch(IllegalMoveException e) {
					System.out.println("Illegal move, try again.");
				}
			} else{
				s = s.makeMove(eng.engineMove(s));
				System.out.println("Computer made a move.");
				System.out.println(s);
			}
		}
		
		if(!s.turn){
			System.out.println("Player lost, Computer won!");
		} else{
			System.out.println("Player won, Computer lost!");
		}
		scan.close();
	}

}
