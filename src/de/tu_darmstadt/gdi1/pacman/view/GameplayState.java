package de.tu_darmstadt.gdi1.pacman.view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.action.basicactions.ChangeStateAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.event.basicevents.KeyPressedEvent;

import de.tu_darmstadt.gdi1.pacman.eea.*;

/**
 * @author
 * 
 *         Diese Klasse repraesentiert das Spielfenster eines pacmans
 * 
 */
public class GameplayState extends BasicGameState {

	public static Input in; // variable für die key events
	public Geist1 g; // geistobjekt
	public Pacman1 p; // pacmanobjekt
	protected int stateID; // stellt ein state da
	protected StateBasedEntityManager entityManager; // nimmt die entitäten auf

	// spielemodus state
	GameplayState(int sid) {
		stateID = sid;
		entityManager = StateBasedEntityManager.getInstance();
	}

	/**
	 * Wird vor dem (erstmaligen) Starten dieses States ausgefuehrt
	 */
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

		// Entities erzeugen

		p = new Pacman1("/res/pictures/menu/Pacman.jpg", 10, 10);
		g = new Geist1("/res/pictures/theme1/entities/G1.png",
				(int) ((Math.random()) * 801 + 0),
				(int) ((Math.random()) * 601 + 0));

		// Hintergrund laden

		Entity background = new Entity("background"); // Entitaet fuer
														// Hintergrund

		background.setPosition(new Vector2f(400, 300)); // Startposition des
														// Hintergrunds

		background.addComponent(new ImageRenderComponent(new Image(
				"/res/pictures/menu/blackscreen.JPG"))); // Bildkomponente

		// Hintergrund-Entitaet an StateBasedEntityManager uebergeben
		StateBasedEntityManager.getInstance().addEntity(stateID, background);

		// Bei Drücken der ESC-Taste zurueck ins Hauptmenue wechseln
		Entity esc_Listener = new Entity("ESC_Listener");

		KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
		esc_pressed.addAction(new ChangeStateAction(Pacman.MAINMENU_STATE));

		esc_Listener.addComponent(esc_pressed);
		entityManager.addEntity(stateID, esc_Listener);

		// nötig für die Keyevents
		in = container.getInput();

	}

	/**
	 * Wird vor dem Frame ausgefuehrt/ updatet die ganze zeit
	 */
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		entityManager.updateEntities(container, game, delta);

		p.pacmanInput(p, in); // Keyevents des Pacmans

		p.pacmanKiste(p); // die weltabgrenzung für das pacman ding
		g.geistKiste(g); // die weltabgrenzung für die feinde
	}

	// }

	/**
	 * Wird mit dem Frame ausgefuehrt
	 */

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		// StatedBasedEntityManager soll alle Entities rendern
		entityManager.renderEntities(container, game, g);

		// pacman wird an den X und Y koordianten gespawnt und gezeichnet
		g.drawImage(p.getPlayerImg(), p.getX(), p.getY());
		g.drawImage(g.getPlayerImg(), g.getX(), g.getY());
	}

	@Override
	public int getID() {
		return stateID;
	}
}
