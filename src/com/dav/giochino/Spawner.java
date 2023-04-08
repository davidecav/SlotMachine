package com.dav.giochino;

import java.awt.Graphics;
import java.util.Random;

public class Spawner {

	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	Random r = new Random();
	
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
			
			if (hud.getLevel()>0) {
				if(hud.getLevel()%10!=0) {


					if((hud.getLevel())%3==0) {
						handler.addObject(new FastEnemy(r.nextFloat(Game.WIDTH),r.nextFloat(Game.HEIGHT),ID.Enemy,handler));
					}else if(hud.getLevel()%5==0) {
						handler.addObject(new SmartEnemy(Game.WIDTH/2, 30 ,ID.Enemy,handler));
					}else {
						handler.addObject(new Enemy(r.nextFloat(Game.WIDTH),r.nextFloat(Game.HEIGHT),ID.Enemy,handler));
					}
				
				}else {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(Game.WIDTH/2, 30 ,ID.Enemy,handler));
				
				}
			}
		}
		
	}
	public void render(Graphics g) {
		handler.render(g);
		hud.render(g);
	}
}
