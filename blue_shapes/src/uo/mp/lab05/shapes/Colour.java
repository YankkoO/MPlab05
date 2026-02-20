package uo.mp.lab05.shapes;

public enum Colour {
	RED("red"), GREEN("green"), BLUE("blue"), WHITE("white"), BLACK("black"), YELLOW("yellow");

	private String name;

	private Colour(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
}
