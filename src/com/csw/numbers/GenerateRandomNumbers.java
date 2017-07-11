package com.csw.numbers;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumbers {

	//storage for the number of balls to draw
	private int howMany;
	
	//storage for the highest number possible in the draw
	private int maxNumber;
	
	//the current number of balls in the uk lotto draw
	private static final int DEFAULT_HOW_MANY = 6;
	//the current uk max lotto number
	private static final int DEFAULT_MAX = 59;

	//use a set so no duplicates are added 
	//and a treeset to store numbers for auto sorting when retrieving
	private Set<Integer> numbers;
	
	public GenerateRandomNumbers() {
		this(DEFAULT_HOW_MANY);
	}

	public GenerateRandomNumbers(int howMany) {
		this(howMany, DEFAULT_MAX);
	}

	public GenerateRandomNumbers(int howMany, int maxMumber) {
		setHowMany(howMany);
		setMaxNumber(maxMumber);
	}

	/**
	 * generate a list of new numbers
	 */
	public void generateNumbers() {
		
		if (numbers == null) {
			numbers = new TreeSet<>();
		} else {
			numbers.clear();
		}
		
		for (;;) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 59+1);
			numbers.add(randomNum);
			if (numbers.size() == getHowMany()) {
				break;
			}
		}
	}
	
	/**
	 * return the numbers in string format separated by a space
	 * @return
	 */
	public String getNumbers() {
		String returnNumbers = "";
		for (Integer i: numbers) {
			if (returnNumbers.length()>0) {
				returnNumbers += ", ";			
			}
			returnNumbers += i;
		}
		return returnNumbers;
	}
	
	public int getHowMany() {
		return howMany;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	public static void main(String[] args) {
		GenerateRandomNumbers g = new GenerateRandomNumbers();
		g.generateNumbers();
		System.out.println(g.getNumbers());
	}
}