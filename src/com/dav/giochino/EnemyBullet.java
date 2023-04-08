package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBullet extends GameObject{
    
	int lato =16;
	private Handler handler;
	Random r = new Random();
	
    public EnemyBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=r.nextInt(5);
        velY=5;
    }
    public void tick(){
    	 x+=velX;
         y+=velY;
         
         if (y>Game.HEIGHT) {
        	 handler.removeObject(this);
         }
         
         
         handler.addObject(new Trail(x, y, ID.Trail, Color.red, lato, 0.1f, handler));
    }
  
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);    
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);
	}
}