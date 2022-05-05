package model;

import java.util.Objects;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {
	
	private Suit suit;
	private Value value;
	
	public PlayingCardImpl (Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	@Override
	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public int getScore() {
		switch(this.getValue()) {
			
		case EIGHT:
			return 8;
			
		case NINE:
			return 9;
			
		case TEN:
			
		case JACK:
			
		case QUEEN:
			
		case KING:
			return 10;
			
		case ACE:
			return 11;		
		} return 0;
	}

	@Override
	public boolean equals(PlayingCard card) {
		return this.getSuit().equals(card.getSuit()) && this.getValue().equals(card.getValue());
	}
	
	@Override
	public boolean equals(java.lang.Object card) {
		return equals(card);
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(this.getSuit(),this.getValue());
	}

	@Override
	public String toString() {
		return String.format("Playing Card: Suit: %s, Value: %s,"
				+ " Score:  %d", this.getSuit(), this.getValue(), this.getScore());
	}
}