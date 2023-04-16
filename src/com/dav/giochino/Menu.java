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
	HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game=game;
		this.handler =handler;
		this.hud=hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx =e.getX();
		int my =e.getY();
		r = new Random();
		
		if(game.gameState==STATE.Menu) {
			
			if(mouseOver(mx, my, Game.WIDTH/2-150, 150, 300, 40)) {
				hud.setLevel(1);
				hud.setScore(0);
				hud.HEALTH=100;
				game.gameState = STATE.Game;
				handler.addObject( new Giocatore(game.WIDTH/2,game.HEIGHT/2,ID.Player, handler));
				handler.clearEnemies();
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
		if(game.gameState ==STATE.End) {
			
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
		Font fontHelp = new Font("arial", 1, 20);

		
		Color coloreTitolo = Color.white;
		Color coloreFont=Color.green;
		Color coloreBottone=Color.red;
		
		if(game.gameState==STATE.Menu) {

		g.setFont(fontTitolo);
		g.setColor(coloreTitolo);
		g.drawString("MENU", Game.WIDTH/2-80, 50);
		
		g.setFont(fontMenu);
		g.setColor(coloreBottone);
		g.fillRect(Game.WIDTH/2-150, 150, 300, 40);
		g.setColor(coloreFont);
		g.drawString("New Game", Game.WIDTH/2-90, 180);
		g.setColor(coloreBottone);
		g.fillRect(Game.WIDTH/2-150, 250, 300, 40);
		g.setColor(coloreFont);
		g.drawString("Help", Game.WIDTH/2-35, 280);
		g.setColor(coloreBottone);
		g.fillRect(Game.WIDTH/2-150, 350, 300, 40);
		g.setColor(coloreFont);
		g.drawString("Exit", Game.WIDTH/2-30, 380);
		
		}
		if(game.gameState==STATE.Help) {
			g.setFont(fontMenu);
			g.setColor(coloreTitolo);
			g.drawString("Help", Game.WIDTH/2-35, 50);
			g.setFont(fontHelp);
			g.setColor(coloreBottone);
			g.drawString("Usa le freccette per scappare dai nemici!!", 80, 220);
			g.setFont(fontMenu);
			g.setColor(coloreBottone);
			g.fillRect(Game.WIDTH/2-150, 350, 300, 40);
			g.setColor(coloreFont);
			g.drawString("Back", Game.WIDTH/2-40, 380);
			
			
		}
		if(game.gameState==STATE.End) {
			g.setFont(fontMenu);
			g.setColor(coloreTitolo);
			g.drawString("Game Over", Game.WIDTH/2-35, 50);
			g.setFont(fontHelp);
			g.drawString("punteggio raggiunto:", 100, 180);
			g.setColor(coloreBottone);
			g.drawString(""+hud.getScore(), 100, 220);
			g.setFont(fontMenu);
			g.setColor(coloreBottone);
			g.fillRect(Game.WIDTH/2-150, 350, 300, 40);
			g.setColor(coloreFont);
			g.drawString("Riprova", Game.WIDTH/2-80, 380);
			
			
		}

	}
}
