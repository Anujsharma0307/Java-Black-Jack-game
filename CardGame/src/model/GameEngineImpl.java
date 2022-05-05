package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	private List<Player> players = new ArrayList<Player>();
	private Deque<PlayingCard> deck=new LinkedList<PlayingCard>();
	private List<GameEngineCallback> gameEngineCallbackList=new ArrayList<>();

	@Override
	public void dealPlayer(Player player, int delay) throws IllegalArgumentException {
		
		
	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyWinLoss(Player player, int houseResult) {
		
		if(player.getResult()<houseResult) {
			player.setPoints(player.getPoints()-player.getBet());
		}
		else if(player.getResult()<houseResult) {
			player.setPoints(player.getPoints()+player.getBet());
		}
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
		
	}

	@Override
	public Player getPlayer(String id) {
	
		for (int i =0; i<players.size(); i++) {
		if(players.get(i).getPlayerId().equals(id)) {
			return players.get(i);
		}
	} return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		for (int i =0; i<players.size(); i++) {
			if (players.get(i).equals(player)) {
				players.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		
		return player.setBet(bet);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallbackList.add(gameEngineCallback);
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for (int i =0; i<gameEngineCallbackList.size(); i++) {
			
			GameEngineCallback ge = gameEngineCallbackList.get(i);
			if (ge.equals(gameEngineCallback)) {
				gameEngineCallbackList.remove(i);
				return true;
			}
		} return false;

	}

	@Override
	public Collection<Player> getAllPlayers() {
		 //players.values();
		 return null;
	}

	@Override
	public Deque<PlayingCard> getShuffledHalfDeck() {
		for(Suit suit:Suit.values()) {
			for(Value value: Value.values()) {
				PlayingCard card=new PlayingCardImpl(suit,value);
				deck.add(card);
			}
		}
		Collections.shuffle((List<PlayingCard>) deck);
		return deck;
	}

}
