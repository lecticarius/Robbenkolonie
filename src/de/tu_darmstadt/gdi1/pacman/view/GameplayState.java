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
	public static int px; // repräsentiert die position auf der x achse
	public static int py; // repräsentiert die position auf der y achse
	public static int ex1; // repräsentiert die position auf der x achse
	public static int ey1; // repräsentiert die position auf der y achse
	public Image playerImg; // stellt das pacman ding da
	public Image enemyImg;
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
		px = 10;
		py = 10;

		ex1 = (int)((Math.random()) * 801 + 0); 
		ey1 = (int)((Math.random()) * 601 + 0); 
		// bild des pacmans
		playerImg = new Image("/res/pictures/menu/Pacman.jpg");
		lab = new Image("/res/pictures/menu/X0.png");
		enemyImg = new Image("/res/pictures/theme1/entities/G0.png");
		
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
			py -= 3;
		}
		if (in.isKeyDown(Input.KEY_DOWN) || in.isKeyDown(Input.KEY_S)) {
			playerImg = new Image("/res/pictures/menu/Pacman1.jpg");
			py += 3;
		}
		if (in.isKeyDown(Input.KEY_LEFT) || in.isKeyDown(Input.KEY_A)) {
			playerImg = new Image("/res/pictures/menu/Pacman3.jpg");
			px -= 3;
		}
		if (in.isKeyDown(Input.KEY_RIGHT) || in.isKeyDown(Input.KEY_D)) {
			playerImg = new Image("/res/pictures/menu/Pacman.jpg");
			px += 3;
		}
		
		


		// die weltabgrenzung
		if (px < 0)
			px = 0;
		if (py < 0)
			py = 0;
		if (px >= 770)
			px = 770;// sehr unsaubere lösung
		if (py >= 570)
			py = 570;// sehr unsaubere lösung
		
		if (ex1 < 0)
			ex1 = 0;
		if (ey1 < 0)
			ey1 = 0;
		if (ex1 >= 770)
			ex1 = 770;// sehr unsaubere lösung
		if (ey1 >= 570)
			ey1 = 570;// sehr unsaubere lösung

	}

	/**
	 * Wird mit dem Frame ausgefuehrt
	 */

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		Reader reader = null;
		int x1 = 100;
		int y1 = 100;
		try {
			reader = new FileReader("res/levels/Minimal.txt");
			for (int c; (c = reader.read()) != (1 * -1);) {
				x1 = x1 + 10;
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
		g.drawImage(playerImg, px, py);
		g.drawImage(enemyImg, ex1, ey1);
	}

	@Override
	public int getID() {
		return stateID;
	}
}
