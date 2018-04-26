package monopoly.engine.square;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cards {
	public enum Type {COMM_CHEST, CHANCE};
	
	private Type type;
	private Random rand;
	private ArrayList<Card> cards;
	
	public Cards(Type type) throws FileNotFoundException {
		this.type = type;
		rand = new Random();
		Scanner scan;
		if (type == Type.CHANCE) {
			scan = new Scanner(new File("monopoly/engine/game/resources1/chance.txt"));
		}else {
			scan = new Scanner(new File("monopoly/engine/game/resources1/commchest.txt"));
		}
		while(scan.hasNextLine()) {
			parseLine(scan.nextLine());
		}
		scan.close();
	}
	
	public Card getCard() {
		int index = rand.nextInt(cards.size());
		return cards.get(index);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	private void parseLine(String line) {
		System.out.println(line);
		int moveTo = -1;
		int moveWith = 0;
		boolean getJail = false;
		String[] tokens = line.split(",");
		if (tokens[2].charAt(0) == '+') {
			moveWith = Integer.parseInt(tokens[2]);
		}else if (tokens[2].charAt(0) == '-') {
			moveWith = Integer.parseInt(tokens[2]);
		}else {
			moveTo = Integer.parseInt(tokens[2]);
		}
		cards.add(new Card(tokens[0], Integer.parseInt(tokens[1]), moveTo, moveWith, getJail));
	}
	
	public class Card{
		private String text;
		private int money;
		private int moveTo;
		private int moveWith;
		private boolean getOutOfJail;
		public Card(String text, int money, int moveTo, int moveWith, boolean getOutOfJail) {
			this.text = text;
			this.money = money;
			this.moveTo = moveTo;
			this.moveWith = moveWith;
			this.getOutOfJail = getOutOfJail;
		}
		public String getText() {
			return text;
		}
		public int getMoney() {
			return money;
		}
		public int getMoveTo() {
			return moveTo;
		}
		public int getMoveWith() {
			return moveWith;
		}
		public boolean isGetOutOfJail() {
			return getOutOfJail;
		}
	}
}
