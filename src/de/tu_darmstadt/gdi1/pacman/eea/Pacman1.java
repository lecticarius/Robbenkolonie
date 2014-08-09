package de.tu_darmstadt.gdi1.pacman.eea;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Pacman1 extends Entity {

	public Pacman1(String entityImg, int x, int y) {
		super(entityImg, x, y);
	}


	public static void pacmanInput(Pacman1 p, Input in) {

		if (in.isKeyDown(Input.KEY_UP)) {
			p.setY(p.getY() - 3);
			p.setEntityImg("/res/pictures/menu/Pacman2.jpg");

		} else {

			if (in.isKeyDown(Input.KEY_DOWN)) {
				p.setY(p.getY() + 3);
				p.setEntityImg("/res/pictures/menu/Pacman1.jpg");
			} else {
				if (in.isKeyDown(Input.KEY_LEFT)) {
					p.setX(p.getX() - 3);
					p.setEntityImg("/res/pictures/menu/Pacman3.jpg");
					;
				} else {
					if (in.isKeyDown(Input.KEY_RIGHT)) {
						p.setX(p.getX() + 3);
						p.setEntityImg("/res/pictures/menu/Pacman.jpg");
					}
				}
			}
		}
	}
}
