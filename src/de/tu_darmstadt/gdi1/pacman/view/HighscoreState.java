package de.tu_darmstadt.gdi1.pacman.view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.action.Action;
import eea.engine.action.basicactions.ChangeStateInitAction;
import eea.engine.action.basicactions.QuitAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.event.ANDEvent;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;

/**
 * @author GDI gruppe
 * 
 *         Diese Klasse repraesentiert das Highscorefenster, es ist vom
 *         Hauptmenü erreichbar und nach dem Beenden eines Spieldurchlaufes.
 */

public class HighscoreState extends BasicGameState {

	private int stateID; // Identifier von diesem State(Highscore)
	private StateBasedEntityManager entityManager; // zugehoeriger Entitymanager

	private final int zwischenAbstand = 70; // Abstand zwischen den
											// Highscoreeinträgen
	private final int anfangsPunkt = 385; // Anfang von den Highscoreeinträgen

	HighscoreState(int sid) {
		stateID = sid;
		entityManager = StateBasedEntityManager.getInstance();
	}

	/**
	 * Wird vor dem (erstmaligen) Starten dieses State's ausgefuehrt
	 */
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

		//Entität für Hintergrund
		Entity background = new Entity("highscore");//Entität für den Hintergrund
		
		//Startposition des Hintergrunds
		background.setPosition(new Vector2f(400,300));
		
		//Bildkomponente zur Entität hinzufügen  
		background.addComponent(new ImageRenderComponent(new Image("/res/pictures/menu/Highscore.png")));
		
		//Hintergrund-Entität an StateBasedEntityManager übergeben
		entityManager.addEntity(stateID, background);
		
		
	}

	/**
	 * Wird vor dem Frame ausgefuehrt
	 */
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		// StateBasedEntityManager soll alle Entities aktualisieren
		entityManager.updateEntities(container, game, delta);
	}

	/**
	 * Wird mit dem Frame ausgefuehrt
	 */
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// StateBasedEntityManager soll alle Entities rendern.
		entityManager.renderEntities(container, game, g);

	}

	public int getID() {
		return stateID;
	}

}
