//package MiniGameZelda;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	private final int WIDTH = 480, HEIGHT = 480;
	private final int SCALE = 4;

	public Player player;
	public World world;

	public Game() throws IOException {

		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		new Spritesheet();
		player = new Player(32, 32);
		world = new World();


	}

	public void tick() {
		player.tick();

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		player.render(g);
		world.render(g);

		bs.show();
	}

	public static void main(String[] args) throws IOException {

		Game game = new Game();
		JFrame frame = new JFrame();

		frame.add(game);
		frame.setTitle("Mini Zelda");

		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		new Thread(game).start();
	
	}

	public void run() {

		while(true) {

			tick();
			render();

			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = true;

		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;

		}

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;

		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.rigth = false;

		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;

		}

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;

		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;

		}

	}

}
