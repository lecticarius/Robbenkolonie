package de.tu_darmstadt.gdi1.pacman.eea;

public class Event {

	public Event() {

	}

	public boolean kollision(Pacman1 p, Geist1 geist) {

		if (p.getX() == geist.getX() + 10 || p.getY() == p.getX() + 10
				|| p.getX() == geist.getX() - 10 || p.getY() == p.getX() - 10) {
			p.setX(10);
			p.setY(10);
			return true;
		} else {
			return false;
		}
	}
}
