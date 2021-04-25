package model;

import java.util.Comparator;

//BirthDateComparator class implementing Comparator interface
public class BirthDateComparator implements Comparator<Doggo> {

	//the method compare let compare the two elements of the list using the birth date to order
	public int compare(Doggo o1, Doggo o2) {
		return o1.getDate().compareTo(o2.getDate()) ;
	}
}
