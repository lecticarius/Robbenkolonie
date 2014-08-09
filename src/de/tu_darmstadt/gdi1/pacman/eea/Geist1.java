package de.tu_darmstadt.gdi1.pacman.eea;

public class Geist1 extends Entity {

	public Geist1(String entityImg, int x, int y) {
		super(entityImg, x, y);
	}

	public static void geistKiste(Geist1 g) {
		if (g.getX() < 0)
			g.setX(0);
		if (g.getY() < 0)
			g.setY(0);
		if (g.getX() >= 770)
			g.setX(770); // sehr unsaubere lösung
		if (g.getY() >= 570)
			g.setY(570); // sehr unsaubere lösung
	}

}
