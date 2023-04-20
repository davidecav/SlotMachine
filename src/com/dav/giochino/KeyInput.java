package com.dav.giochino;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.dav.giochino.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
    private int velstandard=5;
    private boolean [] keydown=new boolean[4];
    private Game game;
    
    //costruttore
    public KeyInput(Handler handler,Game game){
    	this.game= game;
    	
        this.handler=handler;
        for(int i= 0;i<4;i++) {
        	keydown[i]=false;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId()==ID.Player){
            	
                if(key==KeyEvent.VK_UP) {tempObject.setVelY(-velstandard); keydown[0]=true;  };
                if(key==KeyEvent.VK_DOWN) {tempObject.setVelY(velstandard); keydown[1]=true;  };
                if(key==KeyEvent.VK_LEFT) {tempObject.setVelX(-velstandard); keydown[2]=true;  };
                if(key==KeyEvent.VK_RIGHT) {tempObject.setVelX(velstandard); keydown[3]=true;  };
                
            }
        }
        
        if(key==KeyEvent.VK_P) {
        	if(game.gameState==STATE.Game) {
        		Game.pause=!Game.pause;
        	}
        	
        }
        if(key==KeyEvent.VK_ESCAPE)System.exit(1);

        
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();


        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId()==ID.Player){
            	
                if(key==KeyEvent.VK_UP) keydown[0]=false;  ;
                if(key==KeyEvent.VK_DOWN) keydown[1]=false;  ;
                if(key==KeyEvent.VK_LEFT) keydown[2]=false;  ;
                if(key==KeyEvent.VK_RIGHT) keydown[3]=false;  ;
              
                if(!keydown[0]&&!keydown[1]) tempObject.setVelY(0);
                if(!keydown[2]&&!keydown[3]) tempObject.setVelX(0);
            }
        }
    }
}
