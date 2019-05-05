package com.icm.poker;

import java.util.Scanner;
/**
 * A Poker Game processor.
 * 
 * @author Ganesh Rajashekar
 * @version (0.1.0)
 */
public class PokerSolution {

	public static void main(String[] args) {
		// reading the data from the system stream
		 Scanner sc=new Scanner(System.in);
		 ProcessCards processCards= new ProcessCards();
		 processCards.process(sc);
	}

}
