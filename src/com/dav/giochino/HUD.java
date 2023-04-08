package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH=100;
	
	private int value = 255;
	private int score = 0;
	private int level=1;
	
	public void tick() {
			
		HEALTH = Game.clamp(HEALTH, 0, 100);
		value = Game.clamp(value, 0, 255);
		value = HEALTH*2;
		score++;
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 15);
		g.setColor(new Color(255-value, value, 0));
		g.fillRect(15, 15, HEALTH*2, 15);
		
		g.setColor(Color.white);
		g.drawString("Score: " + score, 15, 45);
		g.drawString("Level: " + level, 15, 60);
	
	}
	public void setScore(int score) {
		this.score=score;
	}
	public int getScore() {
		return score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
