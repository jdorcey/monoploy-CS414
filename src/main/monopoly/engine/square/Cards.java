package monopoly.engine.square;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import monopoly.engine.game.GUI;
import monopoly.engine.game.Monopoly;
import monopoly.engine.game.Turn;
import monopoly.engine.player.Player;

public class Cards {
	public enum Type {COMM_CHEST, CHANCE};
	
	private Type type;
	private Random rand;
	private ArrayList<Card> cards;
	
	public Cards(Type type) throws FileNotFoundException {
		cards = new ArrayList<Card>();
		this.type = type;
		rand = new Random();
		Scanner scan;
		if (type == Type.CHANCE) {
			File chancefile = new File("chance.txt");
			scan = new Scanner(chancefile);
		}else {
			scan = new Scanner(new File("commchest.txt"));
		}
		while(scan.hasNextLine()) {
			parseLine(scan.nextLine());
		}
		scan.close();
	}
	
	public void useCard(Card card, Player player) {
		card.performAction(player);
	}
	
	public Card getCard() {
		int index = rand.nextInt(cards.size());
		return cards.get(index);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	private void parseLine(String line) {
		int moveTo = -1;
		int moveWith = 0;
		boolean getJail = false;
		String[] tokens = line.split(",");
		if (tokens[2].charAt(0) == '+') {
			moveWith = Integer.parseInt(tokens[2].substring(1));
		}else if (tokens[2].charAt(0) == '-') {
			moveWith = Integer.parseInt(tokens[2].substring(1));
		}else {
			moveTo = Integer.parseInt(tokens[2]);
		}
		getJail = Integer.parseInt(tokens[3]) == 1; 
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
		public void performAction(Player player) {
			Turn turn = Monopoly.getInstance().getTurn();
			String out = player.getToken() + " drew a card! \n" + "- Card Text: " + text + "\n";
			GUI.getInstance().printToDialogBox(out);
			if (money != 0) {
				player.deposit(money);
			}else if(moveWith != 0) {
				if(moveWith == 10) { player.setJailed(true); }
				turn.movePlayer(moveWith, true);
			}else if(moveTo != -1) {
				turn.movePlayer(moveTo, false);
			}else if (getOutOfJail) {
				int jailfree = turn.getPlayer().getNumGetOutOfJailFreeCards();
				turn.getPlayer().setNumGetOutOfJailFreeCards(jailfree + 1);
			}
		}
	}
}
