package gameEngine;

public enum cardtype {

	COPPER("Treasure", "Copper", "Coin with Value 1", 1, 0, 0, "http://i.imgur.com/3qBu0jv.jpg?1"), 
	SILVER("Treasure", "Silver", "", 2, 3, 0, "http://i.imgur.com/dxSJ4M1.jpg?1 "), 
	GOLD("Treasure", "Gold", "",3, 6, 0, "http://i.imgur.com/CidYwq3.png?1"),
	/*
	 * VICTORY
	 */
	ESTATE("Victory", "Estate", "", 0, 2, 1, "http://i.imgur.com/gHNS5dO.jpg?1 "), 
	DUTCHY("Victory", "Dutchy", "",0, 5, 3, "http://i.imgur.com/qLMQ0Pk.jpg?1"), 
	PROVINCE("Victory", "Province", "", 0, 8, 6,"http://i.imgur.com/A8WzRRu.jpg?1"),
	/*
	 * ACTION
	 */

	MARKET("Action", "Market", "", 1, 5, 0, "http://i.imgur.com/imzWC25.png?1"),

	WORKSHOP("Action", "Workshop", "Gain a card costing up to 4", 0, 3, 0, "http://i.imgur.com/Z7B1inP.png?1"),

	BUREAUCRAT("Action", "Bureaucrat",
			"Gain a Silver card; " + "put it on top of your deck. "
					+ "Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).",
			0, 4, 0, "http://i.imgur.com/MbpD8rS.png?1"),

	ADVENTURER("Action", "Adventurer",
			"Reveals cards from your deck until you reveal 2 Treasure cards. "
					+ "Put those Treasure cards into your hand and discard the other revealing cards.",
			0, 6, 0, "http://i.imgur.com/Q3vVy0f.png?1"),

	CELLAR("Action", "Cellar", "Discards any number of cards. +1 Card per card discared", 0, 2, 0,
			"http://i.imgur.com/odphdVa.png?1"),

	CHANCELLOR("Action", "Chancellor", "You may immediately put your deck into your discard pile", 2, 3, 0,
			"http://i.imgur.com/RqGibgp.png?1"),

	CHAPEL("Action", "Chapel", "Thrash up to 4 cards from your hand", 0, 2, 0,
			"http://i.imgur.com/SLOzbk2.png?1"),

	COUNCIL_ROOM("Action", "Council room", "Each other player draws a card.", 0, 5, 0,
			"http://i.imgur.com/Zu7H3Sx.png?1"),

	FEAST("Action", "Feast", "Trash this card. Gain a card costing up to 5", 0, 4, 0,
			"http://i.imgur.com/lTufRWM.png?1"),

	FESTIVAL("Action", "Festival", "", 2, 5, 0, "http://i.imgur.com/0wWvRFN.png"),

	GARDENS("Action", "Gardens", "Worth 1 victory point for every 10 cards in you deck (rounded down).", 0, 4, 0,
			"http://i.imgur.com/tLcpJv8.png"),

	LABORATORY("Action", "Laboratory", "+2 Cards", 0, 5, 0, "http://i.imgur.com/NhThp5P.png?1"),

	LIBRARY("Action", "Library",
			"Draw until you have 7 cards in hand. You may set aside any Action cards drawn this way, as you draw them; discard the set aside cards after you finish drawing.",
			0, 5, 0, "http://i.imgur.com/Ty3mxe2.png?1"),

	MILITIA("Actions", "Militia", "Each other player discards down to 3 cards in his hand", 2, 4, 0,
			"http://i.imgur.com/DRGLKzo.png?1"),

	MINE("Action", "Mine",
			"Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 more; put it into your hand.",
			0, 5, 0, "http://i.imgur.com/AoTpgg5.png?1"),

	MOAT("Action", "Moat",
			"+2 Cards | When another player plays an Attack card, you may reveal this from your hand. If you do, you are unaffcted by that Attack.",
			0, 2, 0, "http://i.imgur.com/PZQiy5r.png?1"),

	MONEYLENDER("Action", "Moneylender", "Trash a Copper card from your hand. If you do, +3", 0, 4, 0,
			"http://i.imgur.com/PZQiy5r.png?1"),

	REMODEL("Action", "Remodel", "Trash a card from your hand. Gain a card costing up to 2 more than the trashed card.",
			0, 4, 0, "http://i.imgur.com/M0pyARe.png?1"),

	SMITHY("Action", "Smithy", "", 0, 4, 0, "http://i.imgur.com/BxlgtrD.png?1");

	/*
	 * String type, String name, String description, int value, int cost, int
	 * points, int actions, int buys, String url
	 */
	/*
	 * copper: http://i.imgur.com/3qBu0jv.jpg?1
	 * 
	 * silver:http://i.imgur.com/dxSJ4M1.jpg?1
	 * 
	 * gold: http://i.imgur.com/CidYwq3.png?1
	 * 
	 * 
	 * 
	 * estate: http://i.imgur.com/gHNS5dO.jpg?1
	 * 
	 * dutchy: http://i.imgur.com/qLMQ0Pk.jpg?1
	 * 
	 * province: http://i.imgur.com/A8WzRRu.jpg?1
	 * 
	 * 
	 * back: http://i.imgur.com/pm2MNnN.jpg?1
	 */

	private String type;
	private String name;
	private String description;
	private int value;
	private int cost;
	private int points;
	private String url;

	cardtype(String type, String name, String description, int value, int cost, int points,String url) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.value = value;
		this.cost = cost;
		this.points = points;
		this.url = url;

	}

	public card add() {

		return new card(type, name, description, value, cost, points, url);

	}

	public int getPoints() {
		return points;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getValue() {
		return value;
	}

	public int getCost() {
		return cost;
	}

}