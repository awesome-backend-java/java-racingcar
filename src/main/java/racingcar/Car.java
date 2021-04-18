package racingcar;

public class Car {
	private String name;
	private int position;
	
	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}
	
	public void addPosition() {
		this.position += 1;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return this.position;
	}
}
