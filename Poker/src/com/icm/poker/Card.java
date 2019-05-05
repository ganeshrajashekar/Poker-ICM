package com.icm.poker;

import com.icm.poker.Constants;
/**
 * A playing card.
 * 
 * @author Ganesh Rajashekar
 * @version (0.1.0)
 */

public class Card implements Comparable<Card> {
	private int value;
	private char suit;
	
	/**
	 * Constructor for Card. 
	 * The cards are valued in the order:
	 * 		2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace*. 
	 * Diamonds (D), Hearts (H), Spades (S), Clubs (C)
	 */
	public Card(String v) {
		if (v.charAt(0)==Constants.TWO || v.charAt(0)==Constants.THREE || v.charAt(0)==Constants.FOUR || v.charAt(0)==Constants.FIVE || v.charAt(0)==Constants.SIX || v.charAt(0)==Constants.SEVEN || v.charAt(0)==Constants.EIGHT || v.charAt(0)==Constants.NINE ) {
			value = Integer.parseInt(v.substring(0,1));
		} else {
			if (v.charAt(0)==Constants.TEN) {
				value = 10;
			}if (v.charAt(0)==Constants.JACK) {
				value = 11;
			} else if (v.charAt(0)==Constants.QUEEN) {
				value = 12;
			} else if (v.charAt(0)==Constants.KING) {
				value = 13;
			} else if (v.charAt(0)==Constants.ACE) {
				value = 14;
			}
		}
		
		suit = v.charAt(1);
	}
	
	/**
	 * To fetch the value of the card
	 * 
	 * @return   The value.
	 */
	public String value() {
		String result = "";
		
		// If a number card.
		if (value >= 2 && value <= 10) {
			result = Integer.toString(value);
		}
		
		// If a face card.
		else if (value >= 11 && value <= 14) {
			if (value == 11) {
				result = Constants.JACKSTRING;
			} else if (value == 12) {
				result = Constants.QUEENSTRING;
			} else if (value == 13) {
				result = Constants.KINGSTRING;
			} else if (value == 14) {
				result = Constants.ACESTRING;
			} else {
				result = "";
			}
		}
		
		return result;
	}
	
	/**
	 * Get the raw numerical value of the value.
	 * 
	 * @return   The value in numerical form (2-10, jack is 11, queen is 12, king is 13, ace is 14).
	 */
	public int intValue() {
		return value;
	}
	
	/**
	 * Get the suit (hearts, spades, clubs, diamonds).
	 * 
	 * @return   The suit (hearts, spades, clubs, diamonds).
	 */
	public char suit() {
		return suit;
	}
	
	/**
	 * Check if two cards are equal.
	 * 
	 * @param   c   Another card.
	 * @return      A boolean value.
	 */
	public boolean equals(Card c) {
		boolean result = false;
		
		if (this.intValue() == c.intValue()) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Compare two cards.
	 * 
	 * @param   c   Another card.
	 * @return      An integer. If 0, then they are equal, -1 if the current card (the one calling the method) is weaker than the other, and 1 if the card calling the method is better.
	 */
	public int compareTo(Card c) {
		int result = 0;
		
		if (this.intValue() > c.intValue()) {
			result = 1;
		} else if (c.intValue() > this.intValue()) {
			result = -1;
		} 
		
		return result;
	}
	
	public String toString() {
		return value() + " of " + suit();
	}
}
