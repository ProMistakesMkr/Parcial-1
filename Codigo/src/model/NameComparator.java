package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Doggo> {

	// the method compare let compare the two elements of the list using the name to
	// order
	public int compare(Doggo o1, Doggo o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
