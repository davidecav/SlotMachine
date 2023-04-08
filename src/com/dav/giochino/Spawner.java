package com.dav.giochino;

import java.awt.Graphics;
import java.util.Random;

public class Spawner {

	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	Spawner(Handler handler,HUD hud){
		this.handler=handler;
		this.hud=hud;
		
	}
	public void tick(){
		handler.tick();
		hud.tick();
		scoreKeep++;
		if (scoreKeep%500==0) {
			hud.setLevel(hud.getLevel()+1);
			if (hud.getLevel()>2) {
				
				
				if(hud.getLevel()%4==0) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Enemy,handler));
				}else if(hud.getLevel()%7==0) {
					handler.addObject(new SmartEnemy(Game.WIDTH/2, 30 ,ID.Enemy,handler));
				}else {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Enemy,handler));
				}
			}
		}
		
	}
	public void render(Graphics g) {
		handler.render(g);
		hud.render(g);
	}
}
