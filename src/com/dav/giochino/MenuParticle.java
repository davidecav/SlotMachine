package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
    
	float lato =16;
	private Handler handler;
	Random r=new Random();
	private int rosso =r.nextInt(255);
	private int blu =r.nextInt(255);
	private int verde =r.nextInt(255);
	private Color col;
	private int dir=0;
	
	
    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        
        velX=r.nextInt(10);
        velY=r.nextInt(10);
        	
        
        
        col=new Color(rosso,verde,blu);
    }
    public void tick(){
    	 x+=velX;
         y+=velY;
         if(x<0||x>Game.WIDTH) velX *=-1;
         if(y<0||y>Game.HEIGHT - lato-36) velY *= -1;
         handler.addObject(new Trail(x, y, ID.MenuParticle, col, lato, 0.1f, handler));
    }
  
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);
	}
}