package monopoly.engine.player;

public class Token {
	public enum Name{DOG, BATTLESHIP, CAR, HAT, IRON, THIMBLE, WHEELBARROW, MONEY_BAG, SHOE, COWBOY};
	
	private Name name;
	
	// IS THIS CLASS NECESSARY 
	
	public Token(Name name) {
		this.name = name;
	}

}
