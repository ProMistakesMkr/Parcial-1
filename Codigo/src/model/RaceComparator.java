package model;

import java.util.Comparator;

public class RaceComparator implements Comparator<Doggo> {
	public int compare(Doggo d1, Doggo d2) {
		return d1.getBreed().compareTo(d2.getBreed());
	}
}
