package gameEngine;

public enum cardtype {

	COPPER("Treasure", "Copper", "Coin with Value 1", 1, 0, 0, "cards/copper.png"), SILVER(
			"Treasure", "Silver", "", 2, 3, 0, "cards/silver.png"), GOLD("Treasure", "Gold", "",
					3, 6, 0, "cards/gold.png"),
	/*
	 * VICTORY
	 */
	ESTATE("Victory", "Estate", "", 0, 2, 1, "cards/estate.png"), DUTCHY("Victory", "Dutchy", "",
			0, 5, 3, "cards/dutchy.png"), PROVINCE("Victory", "Province", "", 0, 8, 6,
					"cards/province.png"),
	/*
	 * ACTION
	 */

	MARKET("Action", "Market", "", 1, 5, 0, "cards/market.png"),

	WORKSHOP("Action", "Workshop", "Gain a card costing up to 4", 0, 3, 0, "cards/workshop.png"),

	BUREAUCRAT("Action", "Bureaucrat",
			"Gain a Silver card; " + "put it on top of your deck. "
					+ "Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).",
			0, 4, 0, "cards/bureaucrat.png"),

	ADVENTURER("Action", "Adventurer",
			"Reveals cards from your deck until you reveal 2 Treasure cards. "
					+ "Put those Treasure cards into your hand and discard the other revealing cards.",
			0, 6, 0, "cards/adventurer.png"),

	CELLAR("Action", "Cellar", "Discards any number of cards. +1 Card per card discared", 0, 2, 0,
			"cards/cellar.png"),

	CHANCELLOR("Action", "Chancellor", "You may immediately put your deck into your discard pile", 2, 3, 0,
			"cards/chancellor.png"),

	CHAPEL("Action", "Chapel", "Thrash up to 4 cards from your hand", 0, 2, 0,
			"cards/chapel.png"),

	COUNCIL_ROOM("Action", "Council room", "Each other player draws a card.", 0, 5, 0,
			"cards/council_room.png"),

	FEAST("Action", "Feast", "Trash this card. Gain a card costing up to 5", 0, 4, 0,
			"cards/feast.png"),

	FESTIVAL("Action", "Festival", "", 2, 5, 0, "cards/festival.png"),

	GARDENS("Action", "Gardens", "Worth 1 victory point for every 10 cards in you deck (rounded down).", 0, 4, 0,
			"cards/gardens.png"),

	LABORATORY("Action", "Laboratory", "+2 Cards", 0, 5, 0, "cards/laboratory.png"),

	LIBRARY("Action", "Library",
			"Draw until you have 7 cards in hand. You may set aside any Action cards drawn this way, as you draw them; discard the set aside cards after you finish drawing.",
			0, 5, 0, "cards/library.png"),

	MILITIA("Actions", "Militia", "Each other player discards down to 3 cards in his hand", 2, 4, 0,
			"cards/militia.png"),

	MINE("Action", "Mine",
			"Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 more; put it into your hand.",
			0, 5, 0, "cards/mine.png"),

	MOAT("Action", "Moat",
			"+2 Cards | When another player plays an Attack card, you may reveal this from your hand. If you do, you are unaffcted by that Attack.",
			0, 2, 0, "cards/moat.png"),

	MONEYLENDER("Action", "Moneylender", "Trash a Copper card from your hand. If you do, +3", 0, 4, 0,
			"cards/moneylender.png"),

	REMODEL("Action", "Remodel", "Trash a card from your hand. Gain a card costing up to 2 more than the trashed card.",
			0, 4, 0, "cards/remodel.png"),

	SMITHY("Action", "Smithy", "", 0, 4, 0, "cards/smithy.png");

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