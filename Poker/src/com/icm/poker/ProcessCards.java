package com.icm.poker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program logic for to count the total number of hands won by 2 players
 *
 * @author (Ganesh Rajashekar)
 * @version (0.1.0)
 */
public class ProcessCards {

	public void process(Scanner sc) {
		ArrayList<Card> firstPlayerCards = new ArrayList<Card>();
		ArrayList<Card> secondPlayerCards = new ArrayList<Card>();
		;
		int playerOne = 0;
		int playerTwo = 0;
		try (sc) {
			//process each stream
			while (sc.hasNextLine()) {
				String sor = sc.nextLine();
				//Split the input sting considering space as delimiter
				String cards[] = sor.split(" ");
				try {
				//Add first five cards to first player
				for (int i = 0; i < 5; i++) {
					firstPlayerCards.add(new Card(cards[i]));

				}
				
				//Add next five cards to the second player
				for (int i = 5; i < 10; i++) {
					secondPlayerCards.add(new Card(cards[i]));
				}

				Hand firstPair = new Hand(firstPlayerCards);
				Hand secondPair = new Hand(secondPlayerCards);
				
				if (firstPair.compareTo(secondPair) == 1) {
					playerOne++;
				} else
					playerTwo++;
				}
				catch(Exception e)
				{
					System.out.println("There was an issue processing the cards->  " + sor);
				}
				firstPlayerCards.clear();
				secondPlayerCards.clear();
			}
		} catch (Exception e) {
			System.out.println("There was an error processing the stream of data");
		}

		System.out.println("Player1 = " + playerOne);
		System.out.println("Player2 = " + playerTwo);

	}

	
}
