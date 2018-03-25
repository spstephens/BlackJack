/**
 * @author Seth Stephens
 * 
 * @date 3-25-2018
 * 
 *       Class used to hold title of a card, and return the value of the card
 *       title.
 *
 */
public class Card {

	private String cardTitle;
	private String cardSuit;
	private int cardValue;
	private boolean drawn;

	public Card(String title, String suit) {
		this.cardTitle = title;
		this.cardSuit = suit;
		this.cardValue = this.assignValue(this.cardTitle);
		this.drawn = false;
	}

	private int assignValue(String title) {
		switch (title) {
		case "1":
			return 1;
		case "ACE":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		default:
			return 10;
		}
	}

	public int getValue() {
		if (this.cardTitle == "")
			return 0;
		else
			return this.cardValue;
	}

	public String getSuit() {
		if (this.cardSuit == "")
			return "null";
		else
			return this.cardSuit;
	}
	
	public void draw() {
		this.drawn = true;
	}
	
	public boolean isDrawn()
	{
		return this.drawn;
	}

	public String toString() {
		if (this.cardTitle == "")
			return "null";
		else {
			return this.cardTitle + this.cardSuit + " ";
		}
	}

}
