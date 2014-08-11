package de.tu_darmstadt.gdi1.pacman.view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.entity.StateBasedEntityManager;

/**
 * Grundgerüst eines FSMs
 */
public class Pacman extends StateBasedGame
{
	// Jeder State wird durch einen Integer-Wert gekennzeichnet
    public static final int MAINMENU_STATE = 0;
    public static final int GAMEPLAY_STATE = 1;
    public static final int HIGHSCORE_STATE = 2;
	
	public Pacman() throws SlickException
	{
		super("GDI1 Praktikum: Pacman");
	}

	/*
	 * von StateBasedGame geerbt und einmal beim Start ausgeführt
	 */
	public void initStatesList(GameContainer gc) throws SlickException
	{
		// Fuege dem StateBasedGame die States hinzu 
		// (der zuerst hinzugefuegte State wird als erster State gestartet)
		addState(new MainMenuState(MAINMENU_STATE));
        addState(new GameplayState(GAMEPLAY_STATE));
        addState(new HighscoreState(HIGHSCORE_STATE));
        
        // Fuege dem StateBasedEntityManager die States hinzu
        StateBasedEntityManager.getInstance().addState(MAINMENU_STATE);
        StateBasedEntityManager.getInstance().addState(GAMEPLAY_STATE);
        StateBasedEntityManager.getInstance().addState(HIGHSCORE_STATE);
		
	}
}