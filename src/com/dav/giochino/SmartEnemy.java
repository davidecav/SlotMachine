package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

public class SmartEnemy extends GameObject{
    
	int lato =16;
	private Handler handler;
	private GameObject player;
	
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        for (int i = 0; i < handler.object.size();i++ ) {
			
        	if(handler.object.get(i).getID() == ID.Player ) player=handler.object.get(i) ;
        	
		}
        velX=2;
        velY=2;
    }
    public void tick(){
    	 x+=velX;
         y+=velY;
         
         float diffX = x - player.getX()-8;
         float diffY = y - player.getY()-8;
         float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX())*(y-player.getY())*y-player.getY());
         
         velX=(int)((-1.0 /distance )*diffX);
         velY=(int)((-1.0 /distance )*diffY);

         
//         if(x<0||x>Game.WIDTH - lato ) velX *= -1;
//         if(y<0||y>Game.HEIGHT - lato -36) velY *= -1;
         handler.addObject(new Trail(x, y, ID.Trail, Color.blue, lato, 0.1f, handler));
    }
  
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);    
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);    
	}
}