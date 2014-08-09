package de.tu_darmstadt.gdi1.pacman.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import de.tu_darmstadt.gdi1.pacman.view.Pacman;

public class Main
{
	
	
    public static void main(String[] args) throws SlickException
	{	 
		// standardpfade initialisieren
		setPaths();

		// engine starten
		Pacman game = new Pacman();
		AppGameContainer app = new AppGameContainer(game);

		// konfiguration festlegen, falls Vollbild benötigt -> app.setDisplayMode(int1,int2,true) ändern
		app.setDisplayMode(800, 600, false);
		app.setShowFPS(false);// FPS anzeigen ;)
		app.setTargetFrameRate(60);
		app.start();
	}

	private static void setPaths()
	{
		String osName = System.getProperty("os.name").toLowerCase();
    	// Setze den library Pfad abhaengig vom Betriebssystem
    	if (osName.contains("windows")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.9.0/native/windows");
    	} else if (osName.equals("mac os x")) {
    		System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/lib/lwjgl-2.9.0/native/macosx");
    	} else {
    		System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/lib/lwjgl-2.9.0/native/" +System.getProperty("os.name").toLowerCase() +'"');
    	}
		
		System.err.println(System.getProperty("org.lwjgl.librarypath"));
        System.err.println(System.getProperty("java.library.path"));
	}
}