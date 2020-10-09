
public class nimPerfectPlayEngine extends nimGameEngine {

	public nimMove engineMove(GameState s) {
		int i = 0, emptyFields = 0, richFields = 0, richField = 0;
		for(i = 0; i < s.field.length; i++){
			if(s.field[i] == 0) emptyFields++;
			if(s.field[i] > 1){
				richFields++;
				richField = i;
			}
		}
		if(richFields == 1){
			if((s.field.length - emptyFields) % 2 == 0){
				return new nimMove(richField + 1, s.field[richField]);
			} else {
				return new nimMove(richField + 1, s.field[richField] - 1);
			}
		}
		
		int pos, am;
		for (pos = 0; pos < s.field.length; pos++) {

			for (am = 1; am <= s.field[pos]; am++) {
				if (s.makeMove(pos + 1, am).nimNumber() == 0) {
					System.out.println("Winning move found");
					//The position is winning, search for a winning move and make it.
					return new nimMove(pos + 1, am);
				}

			}

		}
		//Move doesn't change the outcome (either Computer is losing or every move wins), so do a random move.
		System.out.println("Random move");
		return s.getRandomMove();
	}
	
}