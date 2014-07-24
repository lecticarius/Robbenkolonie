package de.tu_darmstadt.gdi1.pacman.tests;

import java.awt.Point;

import de.tu_darmstadt.gdi1.pacman.exceptions.InvalidLevelCharacterException;
import de.tu_darmstadt.gdi1.pacman.exceptions.InvalidLevelFormatException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoGhostSpawnPointException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoItemsException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoPacmanSpawnPointException;
import de.tu_darmstadt.gdi1.pacman.exceptions.ReachabilityException;

public class PacmanTestAdapterExtended1 implements PacmanTestInterfaceExtended1 {

	@Override
	public boolean levelIsValid(String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void levelIsValidWithException(String content)
			throws InvalidLevelCharacterException, InvalidLevelFormatException,
			NoPacmanSpawnPointException, ReachabilityException,
			NoGhostSpawnPointException, NoItemsException {
		// TODO Auto-generated method stub

	}

	@Override
	public int levelGetPacmanSpawnCount(String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int levelGetGhostSpawnCount(String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startGame(String level) {
		// TODO Auto-generated method stub

	}

	@Override
	public char getLevelCharAt(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLevelChar(int x, int y, char c) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLevelString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGhosts() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean moveUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void movePacman(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point getPacmanPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveGhost(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point getGhostPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getKills() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasPowerUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPowerUp(boolean enable) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getViewDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

}
