package controller;

import java.util.LinkedList;

import model.Doggo;
import model.Logic;
import processing.core.PApplet;

public class Controller {
	private PApplet app;
	private Logic logic;
	
	public Controller(PApplet app) {
		this.app = app;
		logic = new Logic(app);
	}
public void sortList(char key) {
		
		logic.sortList(key);
	}
public void prueba() {
	logic.prueba();
}
public LinkedList <Doggo> dog(){
	
	return logic.getList();
}
}
