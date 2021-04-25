package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Doggo> {
	public int compare(Doggo d1, Doggo d2) {
		return d1.getName().compareTo(d2.getName());
	}
}