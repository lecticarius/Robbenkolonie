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

	// initialisieren einer Kartenvariable für die weitere Verarbeitung
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

	/**
	 * Übergebener String wird an Methode create_map_fromString übergeben um aus
	 * String ein charArray[][] zu erzeugen. char[][] wird mit Variablennamen
	 * "karte" gekennzeichnet und über alle Elemente iteriert. Akkumulator zählt
	 * bei Iteration hoch und gibt Anzahl an P characters zurück.
	 * 
	 * @param String
	 *            content, ist ein String, der eine Karte representiert
	 * @return Integer result, ist die Anzahl an P character aus dem übergebenen
	 *         String
	 */
	@Override
	public int levelGetPacmanSpawnCount(String content) {

		int result = 0;
		char[][] karte = create_map_fromString(content);

		for (int i = 0; i < karte.length; i++) {
			for (int j = 0; j < karte[i].length; j++) {

				if (karte[i][j] == 'P') {
					result++;
				}
			}
		}

		System.out.println("PacmanSpawnPunkte: " + result);
		return result;
	}

	/**
	 * Übergebener String wird an Methode create_map_fromString übergeben um aus
	 * String ein charArray[][] zu erzeugen. char[][] wird mit Variablennamen
	 * "karte" gekennzeichnet und über alle Elemente iteriert. Akkumulator zählt
	 * bei Iteration hoch und gibt Anzahl an G characters zurück.
	 * 
	 * @param String
	 *            content, ist ein String, der eine Karte representiert
	 * @return Integer result, ist die Anzahl an P character aus dem übergebenen
	 *         String
	 */
	@Override
	public int levelGetGhostSpawnCount(String content) {

		int result = 0;
		char[][] karte = create_map_fromString(content);

		for (int i = 0; i < karte.length; i++) {
			for (int j = 0; j < karte[i].length; j++) {

				if (karte[i][j] == 'G') {
					result++;
				}
			}
		}

		System.out.println("GhostSpawnPunkte: " + result);
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

	private char[][] create_map_fromString(String eingabekarte) {

		// Eingabe eingabekarte umgewandelt in ein char array
		char[] tmpcont = eingabekarte.toCharArray();

		// temporäre Zeile, ArrayList<Character> ist ein Objekt welches alle
		// Character einer Zeile(bis \n)
		// seperat speichert.wird später in akku eingespeist

		ArrayList<Character> tmp_zeile = new ArrayList<Character>();

		char[] tmpcont2;

		// Arraylist mit einzelnen Zeilen
		ArrayList<char[]> zeilenAkku = new ArrayList<char[]>();

		// iteriert über einzelne Zeichen des Eingabestrings,der in char[]
		// tmpcont gespeichert ist
		for (int i = 0; i < tmpcont.length; i++) {

			// fügt so lange kein \n gefunden wird alle chars in einen
			// Zwischenspeicher, hier tmp_zeile, ein
			if (tmpcont[i] != '\n')
				tmp_zeile.add(tmpcont[i]);

			// fügt sobald der Zeilenumbruch ( \n) gefunden wird das bestehende
			// Array(Zeile) , hier tmp_zeile, in einen anderen dynamischen
			// Array, hier
			if (tmpcont[i] == '\n' || i == tmpcont.length - 1) {
				tmpcont2 = new char[tmp_zeile.size()];

				for (int j = 0; j < tmp_zeile.size(); j++) {
					tmpcont2[j] = tmp_zeile.get(j);
				}

				// akkumulator mit einzelnen Zeilen als Elemente drin
				zeilenAkku.add(tmpcont2);
				// tmpstring resetten
				tmp_zeile.clear();
			}
		}

		char[][] tmpresult = new char[zeilenAkku.size()][zeilenAkku.get(0).length];

		for (int i = 0; i < zeilenAkku.size(); i++) {
			tmpresult[i] = zeilenAkku.get(i);
		}

		// Matrix spiegeln an der Achse
		char[][] result = new char[tmpresult[0].length][tmpresult.length];

		for (int x = 0; x < tmpresult[0].length; x++) {
			for (int y = 0; y < tmpresult.length; y++) {
				result[x][y] = tmpresult[y][x];
			}
		}

		return result;

	}

}
