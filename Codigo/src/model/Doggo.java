package model;



import processing.core.PApplet;

public class Doggo implements Comparable<Doggo> {
	private PApplet app;
	String name,breed;
	int age,id;
	public Doggo(int id, String name, int age, String breed,PApplet app) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.breed=breed;
		this.app=app;
	}
	public void drawAttributes(int x, int y) {
		app.fill(0);
		app.text(this.id, x, y);
		y+=30;
		app.text(this.name, x, y);
		y+=30;
		app.text(this.age + " a�os", x, y);
		y+=30;
		app.text(this.breed, x, y);
		y+=30;
	}
	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}
	@Override
	public int compareTo(Doggo nextDog) {
		// TODO Auto-generated method stub
		return this.id - nextDog.getId();
	}
}
