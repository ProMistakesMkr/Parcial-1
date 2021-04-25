package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {
	private PApplet app;
	private String[] info1;
	private String[] info2;
	private LinkedList<Doggo> ListOfDogs;
	AgeComparator ageComp;
	RaceComparator breedComp;
	NameComparator nameComp;
	String[] saveId, saveName, saveAge, saveBreed;

	public Logic(PApplet app) {
		this.app = app;
		info1 = app.loadStrings("../texts/TXT1.txt");
		info2 = app.loadStrings("../texts/TXT2.txt");
		ListOfDogs = new LinkedList<Doggo>();
		ageComp = new AgeComparator();
		breedComp = new RaceComparator();
		nameComp = new NameComparator();
		saveId = new String[5];
		saveName = new String[5];
		saveAge = new String[5];
		saveBreed = new String[5];
		TextDogs();
	}

	public void TextDogs() {

		for (int i = 0; i < info1.length; i++) {

			String[] dogAttributes1 = info1[i].split(" ");

			int id = Integer.parseInt(dogAttributes1[0]);
			String name = dogAttributes1[1];
			for (int j = 0; j < info2.length; j++) {

				String[] dogAttributes2 = info2[j].split(" ");
				if (id == Integer.parseInt(dogAttributes2[0])) {

					String breed = dogAttributes2[1];
					String birth = dogAttributes2[2];
					String[] birthday = birth.split("-");
					String dogBirthday = birthday[2] + "-" + birthday[1] + "-" + birthday[0];
					LocalDate dogBirth = LocalDate.parse(dogBirthday);
					LocalDate date = LocalDate.now();

					int age = calculateAge(dogBirth, date);
					ListOfDogs.add(new Doggo(id, name, age, breed, app));
				}

			}
		}

	}

	public void prueba() {
		for (int i = 0; i < ListOfDogs.size(); i++) {
			System.out.println(ListOfDogs.get(i).id);
			System.out.println(ListOfDogs.get(i).name);
			System.out.println(ListOfDogs.get(i).age);
			System.out.println(ListOfDogs.get(i).breed);

		}
	}

	public void sortList(char key) {
		switch (key) {
		case 'i':
			Collections.sort(ListOfDogs);
			for (int i = 0; i < ListOfDogs.size(); i++) {
				String id = Integer.toString(ListOfDogs.get(i).getId());
				String name = ListOfDogs.get(i).getName().toLowerCase();
				String age = Integer.toString(ListOfDogs.get(i).getAge());
				String breed = ListOfDogs.get(i).getBreed().toLowerCase();
				String row = id + "," + name + "," + age + "," + breed;
				saveId[i] = row;
				app.saveStrings("texts/byID.txt", saveId);
			}
			break;
		case 'n':
			Collections.sort(ListOfDogs, nameComp);
			for (int i = 0; i < ListOfDogs.size(); i++) {
				String id = Integer.toString(ListOfDogs.get(i).getId());
				String name = ListOfDogs.get(i).getName().toLowerCase();
				String age = Integer.toString(ListOfDogs.get(i).getAge());
				String breed = ListOfDogs.get(i).getBreed().toLowerCase();
				String row = id + "," + name + "," + age + "," + breed;
				saveName[i] = row;
				app.saveStrings("texts/byName.txt", saveName);
			}
			break;
		case 'b':
			Collections.sort(ListOfDogs, breedComp);
			for (int i = 0; i < ListOfDogs.size(); i++) {
				String id = Integer.toString(ListOfDogs.get(i).getId());
				String name = ListOfDogs.get(i).getName().toLowerCase();
				String age = Integer.toString(ListOfDogs.get(i).getAge());
				String breed = ListOfDogs.get(i).getBreed().toLowerCase();
				String row = id + "," + name + "," + age + "," + breed;
				saveBreed[i] = row;
				app.saveStrings("texts/byBreed.txt", saveBreed);
			}
			break;
		case 'a':
			Collections.sort(ListOfDogs, ageComp);
			for (int i = 0; i < ListOfDogs.size(); i++) {
				String id = Integer.toString(ListOfDogs.get(i).getId());
				String name = ListOfDogs.get(i).getName().toLowerCase();
				String age = Integer.toString(ListOfDogs.get(i).getAge());
				String breed = ListOfDogs.get(i).getBreed().toLowerCase();
				String row = id + "," + name + "," + age + "," + breed;
				saveAge[i] = row;
				app.saveStrings("texts/byAge.txt", saveAge);
			}

			break;
		}
	}

	public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public LinkedList<Doggo> getList() {
		return ListOfDogs;
	}
}
