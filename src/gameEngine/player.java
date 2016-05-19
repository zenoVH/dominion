package gameEngine;
import java.util.ArrayList;

public class player {
	
	private String name;
	private	deck deck;
	private ArrayList<card> handCards = new ArrayList<card>();
	private ArrayList<card> playedCards = new ArrayList<card>();
	
	private int currentCoins = 0;
	private int buys = 1;
	private int actions = 1;
	
	public player(String name){
		this.name = name;
		deck = new deck();
		fillHand();
	}
	
	public void fillHand(){
		
		int amount = 5 - handCards.size();
		for (int i = 0; i < amount; i++) {
			handCards.add(deck.getCards().get(0));
			deck.getCards().remove(0);
		}
		
	}
	
	//Getters
	
	public deck getDeck(){
		return deck;
	}
	
	public ArrayList<card> getHandCards(){
		return handCards;
	}
	
	public ArrayList<card> getPlayedCards(){
		return playedCards;
	}
	
	public int getCurrentCoins(){
		return currentCoins;
	}
	
	public int getBuys(){
		return buys;
	}
	
	public int getActions(){
		return actions;
	}
	
	public String getName(){
		return name;
	}
	
	//Setters
	public void addHandCard(card card){
		handCards.add(card);
		System.out.println(name+" received "+card.getName()+" in hand");
	}
	
	public void addPlayedCard(card card){
		playedCards.add(card);
		System.out.println(name+" played "+card.getName());
	}
	
	public void addCoins(int c){
		currentCoins += c; 
	}
	
	public void addActions(int c){
		actions += c; 
	}
	
	public void addBuys(int c){
		buys += c; 
	}
	
	public void resetStats(){
		currentCoins = 0;
		buys = 1;
		actions = 1;
	}
	

}
