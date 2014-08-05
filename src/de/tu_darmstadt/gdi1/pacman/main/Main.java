package de.tu_darmstadt.gdi1.pacman.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.tu_darmstadt.gdi1.pacman.view.Pacman;
import eea.engine.entity.StateBasedEntityManager;

public class Main extends StateBasedGame
{
	
	public Main(String name) {
		super("Pacman");
		// TODO Auto-generated constructor stub
	}

	// Jeder State wird durch einen Integer-Wert gekennzeichnet
    public static final int MAINMENU_STATE = 0;
    public static final int GAMEPLAY_STATE = 1;
	
    public static void main(String[] args) throws SlickException
	{	 
		
		// standardpfade initialisieren
		setPaths();

		// engine starten
		Pacman game = new Pacman();
		AppGameContainer app = new AppGameContainer(game);

		// konfiguration festlegen
		app.setDisplayMode(700, 435, false);
		app.setShowFPS(false);
		app.setTargetFrameRate(60);
		app.start();
	}

	private static void setPaths()
	{
		if (System.getProperty("os.name").toLowerCase().contains("windows"))
			System.setProperty("org.lwjgl.librarypath",
			System.getProperty("user.dir") + "/native/windows");
		else if (System.getProperty("os.name").toLowerCase().contains("mac"))
			System.setProperty("org.lwjgl.librarypath",
			System.getProperty("user.dir") + "/native/macosx");
		else
			System.setProperty("org.lwjgl.librarypath",
			System.getProperty("user.dir") + "/native/" + System.getProperty("os.name").toLowerCase());
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {

		// Fuege dem StateBasedGame die States hinzu 
		// (der zuerst hinzugefuegte State wird als erster State gestartet)
		addState(new MainMenuStates(MAINMENU_STATE));
        addState(new GamePlayState(GAMEPLAY_STATE));
        
        // Fuege dem StateBasedEntityManager die States hinzu
        StateBasedEntityManager.getInstance().addState(MAINMENU_STATE);
        StateBasedEntityManager.getInstance().addState(GAMEPLAY_STATE);
				
	}
}