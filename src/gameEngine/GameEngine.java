package gameEngine;

import java.util.*;

public class GameEngine {
	
	private ArrayList<player> players = new ArrayList<player>();	// players array
	private ArrayList<card> actionCards = new ArrayList<card>();	// action cards
	private int currentplayer;	// index of array
	private int round = 1;
	
	public GameEngine(){
		
	}
	
	public void init(int players){
		
		// construct players
		for (int i = 0; i < players; i++) {
			this.players.add(new player("player " + (i + 1)));
		}
		currentplayer = 0;
		
		randomizeActionsCards();		
	}
	
	public void nextTurn(){
		
		if(currentplayer == players.size() - 1){
			currentplayer = 0;
			round++;
		}else{
			currentplayer++;
		}
		
		getPlayer().resetStats();
		
		getPlayer().getDeck().shuffleDeck();
		getPlayer().getPlayedCards().clear();
		getPlayer().fillHand();
		
	}
	
	public void cardInHandClicked(int index){
		
		if(getPlayer().getHandCards().get(index).getType().equals("Treasure")){
			
			// Add coins
			getPlayer().addCoins(getPlayer().getHandCards().get(index).getValue());
			
			// Move to Played cards
			getPlayer().getPlayedCards().add(getPlayer().getHandCards().get(index));
			getPlayer().getHandCards().remove(index);
			
		}else if(getPlayer().getHandCards().get(index).getType().equals("Action")){
			
			//actions TODO
			System.out.println("action card: "+getPlayer().getHandCards().get(index).getName());
			
		}
		
	}
	
	public void buyCard(card c){
		
		if(getPlayer().getCurrentCoins() >= c.getCost() && getPlayer().getBuys() > 0){
			getPlayer().getDeck().getCards().add(c);
			getPlayer().addBuys(-1);
			getPlayer().addCoins(-(c.getCost()));
		}else{
			System.out.println("Insufficient Resources to perform this purchase");
		}
		
	}
	
	private void randomizeActionsCards(){
		
		//Add all cards
		actionCards.add(cardtype.MARKET.add());
		actionCards.add(cardtype.WORKSHOP.add());
		actionCards.add(cardtype.BUREAUCRAT.add());
		actionCards.add(cardtype.ADVENTURER.add());
		actionCards.add(cardtype.CELLAR.add());
		actionCards.add(cardtype.CHANCELLOR.add());
		actionCards.add(cardtype.CHAPEL.add());
		actionCards.add(cardtype.COUNCIL_ROOM.add());
		actionCards.add(cardtype.FEAST.add());
		actionCards.add(cardtype.FESTIVAL.add());
		actionCards.add(cardtype.GARDENS.add());
		actionCards.add(cardtype.LABORATORY.add());
		actionCards.add(cardtype.LIBRARY.add());
		actionCards.add(cardtype.MILITIA.add());
		actionCards.add(cardtype.MINE.add());
		actionCards.add(cardtype.MOAT.add());
		actionCards.add(cardtype.MONEYLENDER.add());
		actionCards.add(cardtype.REMODEL.add());
		actionCards.add(cardtype.SMITHY.add());
		
		long seed = System.nanoTime();
		Collections.shuffle(actionCards, new Random(seed));
		
		while (actionCards.size() > 10) {
			actionCards.remove(0);
		}
		
	}
	
	public player getPlayerX(int i){
		return players.get(i);
	}
	
	public player getPlayer(){
		return players.get(currentplayer);
	}
	
	public int getRound(){
		return round;
	}
	
	public ArrayList<card> getActionCards(){
		return actionCards;
	}

}
