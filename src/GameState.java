import java.util.Random;

public class GameState {
	protected Integer[] field;
	protected Boolean turn;

	public GameState() {
		// Standard-Nim Game-state
		this.field = new Integer[] { 1, 2, 3, 4, 5 };
		this.turn = true;
	}

	public GameState(int n) {
		// Initialize a gamestate with n fields
		this.field = new Integer[n];
		for (int i = 0; i < n; i++) {
			this.field[i] = (i + 1);
		}
	}

	public GameState(Integer[] f, Boolean t) {
		this.field = f;
		this.turn = t;
	}

	public Boolean isFinished(){
		
		for(int i = 0; i < this.field.length; i++){
			if(this.field[i] != 0) return false;
		}
		
		return true;
	}
	
	public GameState makeMove(int position, int amount) throws IllegalMoveException {
		if (position - 1 > this.field.length) {
			StringBuffer s = new StringBuffer();
			s.append("Tried to remove from field ");
			s.append(position);
			s.append(", game is of size ");
			s.append(this.field.length);
			s.append(".");
			throw new IllegalMoveException(s.toString());
		}
		if (amount > this.field[position - 1]) {
			StringBuffer s = new StringBuffer();
			s.append("Tried to take away ");
			s.append(amount);
			s.append(" from field of size ");
			s.append(this.field[position - 1]);
			s.append(".");
			throw new IllegalMoveException(s.toString());
		}

		Integer[] i = this.field.clone();
		i[position - 1] = this.field[position - 1] - amount;
		return new GameState(i, !this.turn);
	}

	public GameState makeMove(nimMove nm) {
		return this.makeMove(nm.position, nm.amount);
	}

	public int nimNumber() {
		int result = 0;
		for (int k : this.field) {
			if(k != 0) result = result ^ k;
		}

		return result;
	}

	public nimMove getRandomMove() throws IllegalMoveException {
		if(this.isFinished()) throw new IllegalMoveException("Game is finished.");
		Random rn = new Random();
		int pos = 0, am = 0;
		for(int i = 0; i < this.field.length; i++){
			if(this.field[i] != 0) pos = i;
		}
		
		am = rn.nextInt(this.field[pos]) + 1;

		return new nimMove(pos + 1, am);
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("(");
		for(int i : this.field){
			s.append(i + " : ");
		}
		s.append(")");
		
		return s.toString();
	}
}
