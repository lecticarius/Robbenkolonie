package de.tud.gdi1.dropofwater.ui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.entity.StateBasedEntityManager;

/**
 * @author Timo Bähr
 *
 * Diese Klasse startet das Spiel "Drop of Water". Es enthaelt
 * zwei State's für das Menue und das eigentliche Spiel.
 */
public class Launch extends StateBasedGame {
	
	// Jeder State wird durch einen Integer-Wert gekennzeichnet
    public static final int MAINMENU_STATE = 0;
    public static final int GAMEPLAY_STATE = 1;
    
    public Launch()
    {
        super("Drop of Water");
    }
 
    public static void main(String[] args) throws SlickException
    {
//      String osName = System.getProperty("os.name").toLowerCase();
//    	// Setze den library Pfad abhaengig vom Betriebssystem
//    	if (osName.contains("windows")) {
//    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/windows");
//    	} else if (osName.equals("mac os x")) {
//    		System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/macosx");
//    	} else {
//        System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/" +System.getProperty("os.name").toLowerCase() +'"');
//    	}
////    	System.err.println(System.getProperty("org.lwjgl.librarypath"));
//      System.err.println(System.getProperty("java.library.path"));
    	// Setze dieses StateBasedGame in einen App Container (oder Fenster)
        AppGameContainer app = new AppGameContainer(new Launch());
 
        // Lege die Einstellungen des Fensters fest und starte das Fenster
        // (nicht aber im Vollbildmodus)
        app.setDisplayMode(800, 600, false);
        app.start();
    }

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		// Fuege dem StateBasedGame die States hinzu 
		// (der zuerst hinzugefuegte State wird als erster State gestartet)
		addState(new MainMenuState(MAINMENU_STATE));
        addState(new GameplayState(GAMEPLAY_STATE));
        
        // Fuege dem StateBasedEntityManager die States hinzu
        StateBasedEntityManager.getInstance().addState(MAINMENU_STATE);
        StateBasedEntityManager.getInstance().addState(GAMEPLAY_STATE);
		
	}
}