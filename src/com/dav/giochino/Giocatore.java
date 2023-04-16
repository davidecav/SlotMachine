package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;

public class Giocatore extends GameObject{

	private float lato =32;
	private Handler handler;
	
    public Giocatore(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
         
        
    }
    public float getLato() {
		return lato;
	}
	public void setLato(float lato) {
		this.lato = lato;
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
    		if(tempObj.getId()==ID.Enemy) {
    			if(getBounds().intersects(tempObj.getBounds())) {
    				HUD.HEALTH--;
    			
    			}
    		}
    	}
    }
    
    public void render(Graphics g) {  
    	Graphics2D g2d =(Graphics2D) g;
        g.setColor(Color.green);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);
	}

}