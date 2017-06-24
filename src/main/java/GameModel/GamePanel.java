package GameModel;

import GameController.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private  final int SIZE = 20;
	//Render
	private Graphics2D g2d;
	private BufferedImage image;
	
	//GameLoop
	private Thread thread;
	private boolean running;
	private long targetTime;
	//GameStuff
	private Entity head,apple,amko;
	private ArrayList<Entity> snake;
	private int score;
	private int level;
	private boolean gameover;
	//Movement
	private int dx,dy;
	//key input
	private boolean up,right,down,left,start;
	
	
	
	

	public GamePanel(){
		
		setPreferredSize(new Dimension (WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		
	} 
	
	@Override
	public void addNotify(){
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
	
	private void setFPS(int fps){
		targetTime = 1000 / fps;
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_W) up = true;
		if(k == KeyEvent.VK_A) left = true;
		if(k == KeyEvent.VK_S) down = true;
		if(k == KeyEvent.VK_D) right = true;
		if(k == KeyEvent.VK_ENTER) start = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_W) up = false;
		if(k == KeyEvent.VK_A) left = false;
		if(k == KeyEvent.VK_S) down = false;
		if(k == KeyEvent.VK_D) right = false;
		if(k == KeyEvent.VK_ENTER) start = false;

		/*
		//ADMIN DEBUUGER TRIBE TEST
		if(k == KeyEvent.VK_X) gameover = true;
		if(k == KeyEvent.VK_U) {
			level = 1;
			setFPS(level * 5);
		}
		if(k == KeyEvent.VK_I) {
			level = 2;
			setFPS(level/2 * 7);
		}
		if(k == KeyEvent.VK_O) {
			level = 3;
			setFPS(level/3 * 10);
		}
	
		if(k == KeyEvent.VK_P) {
			level = 4;
			setFPS(level/4 * 15);
		}
		*/

		
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void run() {
		if (running) return;
		init();
		long startTime;
		long elapsed;
		long wait;
		
		while (running){
			startTime=System.nanoTime();
			
			update();
			requestRender();
			
			
			elapsed = System.nanoTime() - startTime;
			wait = targetTime - elapsed / 100000;
			
			if(wait>0){
				try {
					Thread.sleep(wait);
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
						
		}
	}

	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		running = true;
		setUplevel();
	
	}


	private void setUplevel(){
		snake = new ArrayList<Entity>();
		head = new Entity(SIZE);
		head.setPosition(WIDTH/2, HEIGHT/2);
		snake.add(head);
		for(int i=1;i<1;i++)
		{
			//e = tail, 2 on begin
			Entity e = new Entity(SIZE);
			e.setPosition(head.getX() + (i*SIZE),head.getY());
			snake.add(e);
			
		}
		
		apple = new Entity(SIZE);
		setApple();
		score = 0;
		gameover = false;
		dx = dy = 0;
		level = 1;
		setFPS(level * 10);
		
		
		
	}
	
	public void setApple(){
		
		int x = (int)(Math.random() * (WIDTH - SIZE));
		int y = (int)(Math.random() * (HEIGHT - SIZE));
		//apple position corection
		x = x - (x % SIZE);
		y = y - (y % SIZE); 
		
		apple.setPosition(x, y);
		
		
	}
	private void requestRender() {
		
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image,0,0,null);
		g.dispose();
	}

	private void update() {
		
		if(gameover){
			if(start){
				setUplevel();
			}
			
			return;
		}
		
		
		if(up && dy == 0){
			dy = -SIZE;
			dx = 0;
		}
		
		if(down && dy == 0){
			dy = SIZE;
			dx = 0;
		}
		if(left && dx ==0){
			dy = 0;
			dx = -SIZE;
		}
		if(right && dx ==0 && dy!=0){
			dy = 0;
			dx = SIZE;
		}
		if(dx != 0 || dy != 0){
		for (int i = snake.size() -1; i>0; i--){
			snake.get(i).setPosition(snake.get(i-1).getX(), snake.get(i-1).getY());
		}
		head.move(dx, dy);	
		}
		
		for (Entity e : snake){
			if(e.isCollision(head)){
				gameover = true;
				break;
			}
		}		
		
		
		if(apple.isCollision(head)){
			score++;
			setApple();
			
			
			//adding tail to the snake
			Entity e = new Entity(SIZE);
			e.setPosition(-100,-100);
			snake.add(e);
			
			if (score % 10 == 0){
				level++;
				if(level > 4) level = 4;
				if (level == 2){
				setFPS(level/2 * 5 + 5);
				}
				if (level == 3){
					setFPS(level/3 * 5 + 7);
				}
				if (level == 4){
					setFPS(level/4 * 10 + 10);
				}
			}
				
		}
		
		if(head.getX() < 0 ) head.setX(WIDTH);
		if(head.getY() < 0 ) head.setY(HEIGHT);
		if(head.getX() > WIDTH ) head.setX(0);
		if(head.getY() > HEIGHT ) head.setY(0);
		
		
		
	}
	
	public void render(Graphics2D g2d){
		g2d.clearRect(0,0,WIDTH,HEIGHT);
		
		if(level == 1){
		g2d.setColor(Color.GREEN);
		for(Entity e : snake){
			e.render(g2d);
		}
		}
		if(level == 2){
			g2d.setColor(Color.BLUE);
			for(Entity e : snake){
				e.render(g2d);
			}
			}
		if(level == 3){
			g2d.setColor(Color.ORANGE);
			for(Entity e : snake){
				e.render(g2d);
			}
			}
		if(level > 3){
			g2d.setColor(Color.RED);
			for(Entity e : snake){
				e.render(g2d);
			}
			}
	
		if(level == 1){
		g2d.setColor(Color.RED);
		apple.render(g2d);
		}
		
		if(level == 2){
			g2d.setColor(Color.ORANGE);
			apple.render(g2d);
			}
		
		if(level == 3){
			g2d.setColor(Color.GREEN);
			apple.render(g2d);
			}
		
		if(level > 3){
			g2d.setColor(Color.WHITE);
			apple.render(g2d);
			}
		
		if(gameover){
		
			g2d.setColor(Color.WHITE);
			g2d.drawString("GameOver!", 270, 300);
			g2d.drawString("Press ENTER to play again", 225, 320);
			
		}
		g2d.setColor(Color.WHITE);
		g2d.drawString("SCORE:  " + score*10 + "       Level : " + level, 10, 10);
		if(dx ==0 && dy == 0){
			g2d.drawString("Ready!", 270, 300);
		}
		
	}

}