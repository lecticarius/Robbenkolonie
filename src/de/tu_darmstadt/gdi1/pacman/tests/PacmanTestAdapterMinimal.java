package de.tu_darmstadt.gdi1.pacman.tests;

import java.awt.Point;
import java.util.ArrayList;

import de.tu_darmstadt.gdi1.pacman.exceptions.InvalidLevelCharacterException;
import de.tu_darmstadt.gdi1.pacman.exceptions.InvalidLevelFormatException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoGhostSpawnPointException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoItemsException;
import de.tu_darmstadt.gdi1.pacman.exceptions.NoPacmanSpawnPointException;
import de.tu_darmstadt.gdi1.pacman.exceptions.ReachabilityException;
import de.tu_darmstadt.gdi1.pacman.minimal.LibraryFileReader;

public class PacmanTestAdapterMinimal implements PacmanTestInterfaceMinimal {
	
	private char[][] unserekarte; 

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
		
		int result = 0;
		char[][] karte = create_map_fromString(content);
		
		for(int i = 0; i < karte.length ; i++){
			for(int j = 0; j< karte[i].length ;j++){
				
				if(karte[i][j] == 'P'){
					result++;
				}
			}
		}
					
		System.out.println(result);
		return result;
	}

	@Override
	public int levelGetGhostSpawnCount(String content) {
		
		int result = 0;
		char[][] karte = create_map_fromString(content);
		
		for(int i = 0; i < karte.length ; i++){
			for(int j = 0; j< karte[i].length ;j++){
				
				if(karte[i][j] == 'G'){
					result++;
				}
			}
		}
					
		System.out.println(result);
		return result;
	}

	@Override
	public void startGame(String level) {
		unserekarte = create_map_fromString(level);
	}

	@Override
	public char getLevelCharAt(int x, int y) {
		
		System.out.println("getLevelCharAt " + unserekarte[x][y]);
		return unserekarte[x][y];
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
	
	private char[][] create_map_fromString (String eingabekarte){
		
		//temporäre Zeile
		ArrayList<Character> tmpstring = new ArrayList<Character>();
		char[] tmpstring2;
		//Arraylist mit einzelnen Zeilen
		ArrayList<char[]> akkumulator = new ArrayList<char[]>();
		//Eingabe umgewandelt in ein char array
		char[] tmpcont = eingabekarte.toCharArray();
			
		for(int i = 0 ; i < tmpcont.length ; i++){

			if(tmpcont[i] != '\n')
				tmpstring.add(tmpcont[i]);
					
			if(tmpcont[i] == '\n' || i == tmpcont.length-1){
				tmpstring2 = new char[tmpstring.size()];
				
				for(int j = 0 ; j < tmpstring.size() ; j++){
					tmpstring2[j] = tmpstring.get(j);
				}

				//akkumulator mit einzelnen Zeilen als Elemente drin
				akkumulator.add(tmpstring2);
				//tmpstring resetten
				tmpstring.clear();
			}
		}
		
		
		char[][] tmpresult = new char[akkumulator.size()][akkumulator.get(0).length];
		
		for(int i = 0 ; i < akkumulator.size() ; i++){
			tmpresult[i] = akkumulator.get(i);
		}
		
		//Matrix spiegeln an der Achse
		char[][] result = new char[tmpresult[0].length][tmpresult.length];
		
		for(int x = 0; x < tmpresult[0].length; x++){
			for(int y = 0; y < tmpresult.length ;y++){
				result [x][y] = tmpresult[y][x];			
			}
		}
		
		return result;
		
	}

}
