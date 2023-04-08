package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;

public class Player extends GameObject{

	int lato =32;
	private Handler handler;
	
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
         
        
    }
    public void tick(){
        x+=velX;
        y+=velY;
        x=Game.clamp(x, 0, Game.WIDTH-lato);
        y=Game.clamp(y, 0, Game.HEIGHT-lato -36);
        
        collision();
    }
    
    public void collision() {
    	for(int i=0;i<handler.object.size();i++) {
    		GameObject tempObj = handler.object.get(i);
    		if(tempObj.getID()==ID.Enemy) {
    			if(getBounds().intersects(tempObj.getBounds())) {
    				HUD.HEALTH--;
    			
    			}
    		}
    	}
    }
    
    public void render(Graphics g) {  
    	Graphics2D g2d =(Graphics2D) g;
        g.setColor(Color.green);
        g.fillRect(x,y,lato,lato);      
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,lato,lato);
	}

}