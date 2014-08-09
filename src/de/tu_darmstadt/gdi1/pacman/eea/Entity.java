package de.tu_darmstadt.gdi1.pacman.eea;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Entity {

	private int x;
	private int y;
	private String entityImg;
	private Image playerImg;

	public Entity(String entityImg, int x, int y) {
		this.entityImg = entityImg;
		this.x = x;
		this.y = y;
		try {
			playerImg = new Image(entityImg);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void weltabgrenzung(Entity e){
		if (e.getX() < 0)
			e.setX(0);
		if (e.getY() < 0)
			e.setY(0);
		if (e.getX() >= 770)
			e.setX(770); // sehr unsaubere lösung
		if (e.getY() >= 570)
			e.setY(570); // sehr unsaubere lösung
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getEntityImg() {
		return entityImg;
	}

	public void setEntityImg(String entityImg) {
		this.entityImg = entityImg;
	}

	public Image getPlayerImg() {
		return playerImg;
	}

	public void setPlayerImg(Image playerImg) {
		this.playerImg = playerImg;
	}

}
