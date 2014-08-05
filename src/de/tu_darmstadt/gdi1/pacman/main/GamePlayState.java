package de.tu_darmstadt.gdi1.pacman.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.entity.StateBasedEntityManager;

public class GamePlayState extends BasicGameState{
	
	//ID for the BasicGameState
	private int stateID;
	// the entety Manager
	private StateBasedEntityManager entityManager;

	// Constroctor
  public GamePlayState(int sid){
		stateID = sid;
		entityManager = StateBasedEntityManager.getInstance();
		}
	
	
	/**
	 * Runs when the states will be executed for the first time
	 */
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Executet meanwhile the Frame
	 */
	

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		entityManager.renderEntities(container, game, g);
		
	}

	/**
	 *  will be executed before Frame
	 */

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// all entities has to be updated
		entityManager.updateEntities(container, game, delta);
	}


	@Override
	public int getID() {
		
		return stateID;
	}
	
	
}
