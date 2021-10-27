package com.example;

public class WeekManager {

	public static String isFriday(String day) {
		String actualAnswer = null;
		if (day.equals("Friday")) {
			actualAnswer = "TGIF";
		} else {
			actualAnswer = "Nope";
		}
		return actualAnswer;
	}

}
