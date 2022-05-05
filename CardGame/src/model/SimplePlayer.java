package model;

import model.interfaces.Player;

public class SimplePlayer implements  Player{

	private String playerName;
	private String id;
	private int points;
	private int bet;
	private int result;
	
	public SimplePlayer(String id, String playerName, int initialPoints) {
		this.id = id;
		this.playerName = playerName;
		this.points = initialPoints;
		this.bet = 0;
	}


	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return this.id;
	}

	@Override
	public boolean setBet(int bet) {
		if (0 < bet && bet <= this.points ) {
			this.bet = bet;
			return true;
		} 
		return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
	}

	@Override
	public int getResult() {
		return this.result;
	}

	@Override
	public void setResult(int result) {
		this.result = result;
		
	}

	@Override
	public boolean equals(Player player) {
		return this.getPlayerId().equals(player.getPlayerId());
	}
	
	@Override
	public boolean equals (java.lang.Object player) {
		return equals(player);
	}

	@Override
	public int compareTo(Player player) {
		return this.getPlayerId().compareTo(player.getPlayerId());
	}
	
	@Override
	public int hashCode() {
		return this.getPlayerId().hashCode();																						
	}
	
	@Override 
	public String toString() {
		return String.format("Player:\n  ID: %s \n  Name: %s \n"
				+ "  Bet: %d \n  Points:  %d \n  Result:  %d", 
				this.getPlayerId(), this.getPlayerName(), this.getBet(),
				this.getPoints(), this.getResult());
	}
	

}






