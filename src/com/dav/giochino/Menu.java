package com.dav.giochino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.dav.giochino.Game.STATE;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private Random r ;
	
	public Menu(Game game, Handler handler) {
		this.game=game;
		this.handler =handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx =e.getX();
		int my =e.getY();
		r = new Random();
		
		if(game.gameState==STATE.Menu) {
			
			if(mouseOver(mx, my, Game.WIDTH/2-150, 150, 300, 40)) {
				game.gameState = STATE.Game;
				handler.addObject( new Player(game.WIDTH/2,game.HEIGHT/2,ID.Player, handler));
				handler.addObject(new Enemy(r.nextFloat(game.WIDTH),r.nextFloat(game.HEIGHT),ID.Enemy, handler));
			}
			if(mouseOver(mx, my, Game.WIDTH/2-150, 250, 300, 40)) {
				game.gameState = STATE.Help; 
				return;	//bisogna aggiungere il return altrimenti non cambia stato
			}
			if(mouseOver(mx, my, Game.WIDTH/2-150, 350, 300, 40)) {
				System.exit(1);
			}
		}
		if(game.gameState ==STATE.Help) {
			
			if (mouseOver(mx, my, Game.WIDTH/2-150, 350, 300, 40)) {
				game.gameState=STATE.Menu;
			}
			
			
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public boolean mouseOver(int mx, int my,int x, int y, int width, int height) {
		if((mx > x)&&(mx<x+width)) {
			if((my > y)&&(my<y+height)) {
				return true;
			}
			return false;
		}
		return false;
		
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		Font fontTitolo = new Font("arial", 1,50);
		Font fontMenu = new Font("arial", 1, 30);
		Font fontHelp = new Font("arial", 1, 10);

		if(game.gameState==STATE.Menu) {

		g.setFont(fontTitolo);
		g.setColor(Color.white);
		g.drawString("MENU", Game.WIDTH/2-80, 50);
		
		g.setFont(fontMenu);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH/2-150, 150, 300, 40);
		g.setColor(Color.green);
		g.drawString("New Game", Game.WIDTH/2-90, 180);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH/2-150, 250, 300, 40);
		g.setColor(Color.green);
		g.drawString("Help", Game.WIDTH/2-35, 280);
		g.setColor(Color.red);
		g.fillRect(Game.WIDTH/2-150, 350, 300, 40);
		g.setColor(Color.green);
		g.drawString("Exit", Game.WIDTH/2-30, 380);
		
		}
		if(game.gameState==STATE.Help) {
			g.setFont(fontMenu);
			g.setColor(Color.white);
			g.drawString("Help", Game.WIDTH/2-35, 50);
			g.setFont(fontHelp);
			g.setColor(Color.white);
			g.drawString("Usa le freccette per scappare dai nemici", Game.WIDTH/2-100, 250);
			g.setFont(fontMenu);
			g.setColor(Color.red);
			g.fillRect(Game.WIDTH/2-150, 350, 300, 40);
			g.setColor(Color.green);
			g.drawString("Back", Game.WIDTH/2-40, 380);
			
			
		}

	}
}
