package gameEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameEngine {
	
	public boolean running;
	
	private ArrayList<player> players = new ArrayList<player>();	// players array
	private ArrayList<card> actionCards = new ArrayList<card>();	// action cards
	private int currentplayer;	// index of array
	private int round = 1;
	private ActionHandler actions;
	public int maxRounds = 10;
	private int winner;
	
	public GameEngine(){
		running = true;
	}
	
	public void init(int players, int rounds){
		
		maxRounds = rounds;
		
		// construct players
		for (int i = 0; i < players; i++) {
			this.players.add(new player("player " + (i + 1)));
		}
		currentplayer = 0;
		
		randomizeActionsCards();
		
		actions = new ActionHandler(this);
		
	}
	
	public void nextTurn(){

		if(currentplayer == players.size() - 1){
			currentplayer = 0;
			round++;
		}else{
			currentplayer++;
		}
		
		if(round > maxRounds){
			running = false;
			calculateScore();
		}
		
		getPlayer().flushHandCards();
		getPlayer().flushPlayedCards();
		
		getPlayer().resetStats();
		getPlayer().fillHand();
		
		
		
	}
	
	public void cardInHandClicked(int index){
		
		if(getPlayer().getHandCards().get(index).getType().equals("Treasure") && running){
			
			// Add coins
			getPlayer().addCoins(getPlayer().getHandCards().get(index).getValue());
			
			// Move to Played cards
			getPlayer().getPlayedCards().add(getPlayer().getHandCards().get(index));
			getPlayer().getHandCards().remove(index);
			
		}else if(getPlayer().getHandCards().get(index).getType().equals("Action") && running){
			
			// send card to actionHandler
			actions.actionCard(getPlayer().getHandCards().get(index));
			
			// Move to Played cards
			getPlayer().getPlayedCards().add(getPlayer().getHandCards().get(index));
			getPlayer().getHandCards().remove(index);
			
		}
		
	}
	
	public void buyCard(card c){
		
		if(getPlayer().getCurrentCoins() >= c.getCost() && getPlayer().getBuys() > 0 && running){
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
	
	private void calculateScore(){
		int winner = 0;
		for (int i = 0; i < players.size(); i++) {
			players.get(i).flushHandCards();
			players.get(i).flushPlayedCards();
			
			for (int j = 0; j < players.get(i).getDeck().getCards().size(); j++) {
				if(players.get(i).getDeck().getCards().get(i).getType().equals("Victory")) players.get(i).victoryPoints += players.get(i).getDeck().getCards().get(i).getPoints();
			}
			if(players.get(i).victoryPoints > players.get(winner).victoryPoints) winner = i;
		}
		this.winner = winner;
		
		drawWinner();
		
	}
	
	public void drawWinner(){
		JOptionPane.showConfirmDialog(null,"The Winner is "+players.get(winner).getName()+" ! ("+players.get(winner).victoryPoints+" points)");
	}
	
	public player getPlayerX(int playerIndex){
		return players.get(playerIndex);
	}
	
	public player getPlayer(){
		return players.get(currentplayer);
	}
	
	public ArrayList<player> getPlayers(){
		return players;
	}
	
	public int getRound(){
		return round;
	}
	
	public ArrayList<card> getActionCards(){
		return actionCards;
	}

}
