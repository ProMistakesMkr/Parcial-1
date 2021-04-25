package model;

import java.util.Comparator;

public class AgeComparator implements Comparator<Doggo> {
	public int compare(Doggo d1, Doggo d2) {
		return d1.getAge() - d2.getAge();
	}
}
