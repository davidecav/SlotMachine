package com.dav.giochino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{
    
	private Handler handler;
	Random r =new Random();

	float lato = 70;
	int timer = 20;
	int timer2 = 100;
	
	public EnemyBoss(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;
        
        velX = 0;
        velY = 1;
    }
    public void tick(){
    	
    	 x += velX;
         y += velY;
         if(x<0||x>Game.WIDTH- lato) velX *=-1;

         //facciamolo fermare sotto dopo un po'
         if (timer<=0) {
        	 velY=0;
        	 timer2--;
         }else {
        	 timer--;
         }
         if (timer2<=0) {
        	 if(velX==0)velX=2;
        	 
        	 if(velX>0) {
        		 velX+=0.005;}
        	 else {
        		 velX-=0.005;
        	 }
        	 
        	 //limitiamo lo speed up
        	 velX=Game.clamp(velX, -8, 8);
        	 
        	 int spawn = r.nextInt(10);
        	 if (spawn ==0) {
        		 handler.addObject(new EnemyBullet(x +(lato/2),y +(lato/2),ID.Enemy,handler));
        	 }
         }
         
         
    }
  
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,(int)lato,(int)lato);   
        
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)lato,(int)lato);
	}
}
