package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{
    
	int lato =16;
	private Handler handler;
	
    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=5;
        velY=5;
    }
    public void tick(){
    	 x+=velX;
         y+=velY;
         if(x<0||x>Game.WIDTH) velX *=-1;
         if(y<0||y>Game.HEIGHT) velY *= -1;
         handler.addObject(new Trail(x, y, ID.Trail, Color.white, lato, 0.1f, handler));
    }
  
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,lato,lato);    
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,lato,lato);
	}
}