package de.tu_darmstadt.gdi1.pacman.view;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.newdawn.slick.Color;
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

/**
 * @author
 * 
 *         Diese Klasse repraesentiert das Spielfenster eines pacmans
 * 
 */
public class GameplayState extends BasicGameState {

	public static Input in; // variable für die key events
	public static int x; // repräsentiert die position auf der x achse
	public static int y; // repräsentiert die position auf der y achse
	public static int x1;
	public static int y1;
	public Image playerImg; // stellt das pacman ding da
	public Image lab;
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
		// startpunkte des Pacmans
		x = 10;
		y = 10;
		x1 = 0;
		y1 = 0;
		// bild des pacmans
		playerImg = new Image("/res/pictures/menu/Pacman.jpg");
		lab = new Image("/res/pictures/menu/X0.png");
	}

	/**
	 * Wird vor dem Frame ausgefuehrt/ updatet die ganze zeit
	 */
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		// Keyevents werden hier aufgeführt

		entityManager.updateEntities(container, game, delta);

		if (in.isKeyDown(Input.KEY_UP) || in.isKeyDown(Input.KEY_W)) {
			playerImg = new Image("/res/pictures/menu/Pacman2.jpg");
			y -= 3;
		}
		if (in.isKeyDown(Input.KEY_DOWN) || in.isKeyDown(Input.KEY_S)) {
			playerImg = new Image("/res/pictures/menu/Pacman1.jpg");
			y += 3;
		}
		if (in.isKeyDown(Input.KEY_LEFT) || in.isKeyDown(Input.KEY_A)) {
			playerImg = new Image("/res/pictures/menu/Pacman3.jpg");
			x -= 3;
		}
		if (in.isKeyDown(Input.KEY_RIGHT) || in.isKeyDown(Input.KEY_D)) {
			playerImg = new Image("/res/pictures/menu/Pacman.jpg");
			x += 3;
		}
		
		// die weltabgrenzung
		if (x < 0)   x = 0;
		if (y < 0)   y = 0;
		if (x >= 770) x = 770;//sehr unsaubere lösung
		if (y >= 570) y = 570;// sehr unsaubere lösung
		

	}

	/**
	 * Wird mit dem Frame ausgefuehrt
	 */

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		Reader reader = null;
		try {
			reader = new FileReader("res/levels/Minimal.txt");
			for (int c; (c = reader.read()) != (1 * -1);) {
				x1 = x1 + 30;
				y1 = y1 + 30;
				if (c == 'X')
					g.drawImage(lab, x1, y1);
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Datei!");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// StatedBasedEntityManager soll alle Entities rendern
		entityManager.renderEntities(container, game, g);

		// pacman wird an den X und Y koordianten gespawnt und gezeichnet
		g.drawImage(playerImg, x, y);
	}

	@Override
	public int getID() {
		return stateID;
	}
}
