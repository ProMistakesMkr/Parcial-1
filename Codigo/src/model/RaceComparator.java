package model;

import java.util.Comparator;

public class RaceComparator implements Comparator<Doggo> {

	//the method compare let compare the two elements of the list using the race to order
	public int compare(Doggo o1, Doggo o2) {
		return o1.getRace().compareTo(o2.getRace()) ;
	}
}
