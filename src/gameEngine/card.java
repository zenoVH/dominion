package gameEngine;

public class card {
	
	private String type;
	private String name;
	private String description;
	private int value;
	private int cost;
	private int points;
	private String url;
	
	public card(String type, String name, String description, int value, int cost, int points, String url){
		
		this.type = type;
		this.name = name;
		this.description = description;
		this.value = value;
		this.cost = cost;
		this.points = points;
		this.url = url;
		
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
