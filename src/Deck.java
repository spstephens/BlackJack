import java.util.Random;

/**
 * @author Seth Stephens
 * 
 * @date 3/25/2018
 * 
 * Class used to construct, store, and access a list of Card objects
 *
 */
public class Deck {
	
	private Card[] deck;
	private int drawPointer;
	
	public Deck()
	{
		this.deck = new Card[52];
		this.drawPointer = 0;
		this.constructNewDeck();
	}
	
	private void shuffleDeck() {
		int n = this.deck.length;
		Random random = new Random();
		random.nextInt();
		for(int i = 0; i < n; i++)
		{
			int change = i + random.nextInt(n-i);
			swap(i, change);
		}
		
	}

	private void swap(int i, int change) {
		Card ptr = this.deck[i];
		this.deck[i] = this.deck[change];
		this.deck[change] = ptr;
	}

	private void constructNewDeck(){
		for(int i = 0; i < 4; i++)
		{
			String suit = "";
			String title = "";
			
			if(i == 0)
				suit = "SPADE";
			else if(i == 1)
				suit = "DIMOND";
			else if(i == 2)
				suit = "CLUB";
			else
				suit = "HEART";
			
			for(int j = 1; j < 14; j++)
			{
				if(j < 11)
				{
					title = Integer.toString(j);
				}
				
				else {
					switch (j){
					case 10: title = "JACK";
					break;
					case 11: title = "QUEEN";
					break;
					case 12: title = "KING";
					break;
					case 13: title = "ACE";
					break;
					}
				}
				int index = ((j)+(i*13))-1;
				this.deck[index] = new Card(title, suit);
			}
		}
		this.shuffleDeck();
	}
	
	public Card draw()
	{
		if(this.drawPointer < 52){
			Card c = this.deck[drawPointer];
			this.deck[drawPointer].draw();
			this.drawPointer++;
			return c;
		}
		
		else
		{
			this.constructNewDeck();
			
			this.drawPointer = 0;
			return this.draw();
		}
	}
	
	public String toString()
	{
		String str = "";
		int i = 0;
		for(Card c : this.deck)
		{
			str += c.toString();
			i++;
		}
		
		return str + "length = " + i + '\n';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.print(deck.toString());
		for(int i = 0; i < 100; i++) {
			Card c = deck.draw();
			System.out.println(c.toString());
		}
	}

}
