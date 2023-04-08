package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
    
	float lato =16;
	private Handler handler;
	
    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=6;
        velY=6;
    }
    public void tick(){
    	 x+=velX;
         y+=velY;
         if(x<0||x>Game.WIDTH) velX *=-1;
         if(y<0||y>Game.HEIGHT - lato-36) velY *= -1;
         handler.addObject(new Trail(x, y, ID.Trail, Color.orange, lato, 0.1f, handler));
    }
  
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);
	}
}