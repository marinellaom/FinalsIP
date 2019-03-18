import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Image;


public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

	// circle's position
	public int x = 250;
	public int y = 250;
	public int height = 0;
	public int width = 0;


	public int state = 0; 

	// randomizer
	public Random randomizer;

	// enemy
	public int enemyCount;
	Monster[] monsters = new Monster[10];


	public Draw(){
		randomizer = new Random();
		spawnEnemy();
		
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bg4.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	
		height = image.getHeight();
		width = image.getWidth();

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		if(enemyCount < 10){
			monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500), this);
			enemyCount++;
		}
	}


	public void reloadImage(){
		state++;

		if (state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if (state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if (state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if (state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if (state == 4){
			resource = getClass().getResource("run4.png");
		}
		
		else if (state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}
		
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
		e.printStackTrace();
		}
	}


	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr < 7; ctr++){
					try{
						if(ctr==6){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource  = getClass().getResource("kick"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 3;
						}
					}
				}
			}
		}
	});
	thread1.start();
	}


	public void attackAnimation2(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource  = getClass().getResource("jump"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(160);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}

			for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 1;
						}
					}
				}
			}
		}
	});
	thread2.start();
	}


	
	public void attackAnimation3(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr < 10; ctr++){
					try{
						if(ctr==9){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource  = getClass().getResource("b"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(125);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 3;
						}
					}
				}
			}
		}
	});
	thread3.start();
	}



	public void attackAnimation4(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource  = getClass().getResource("attack"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 5;
						}
					}
				}
			}
		}
	});
	thread4.start();
	}


	public void attackAnimation5(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr < 7; ctr++){
					try{
						if(ctr==6){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource  = getClass().getResource("a"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(125);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 5;
						}
					}
				}
			}
		}
	});
	thread5.start();
	}


	public void attack(){
		attackAnimation();
		repaint();
		checkCollision();
	}

	public void attack2(){
		attackAnimation2();
		repaint();
		checkCollision();
	}

	public void attack3(){
		attackAnimation3();
		repaint();
		checkCollision();
	}

	public void attack4(){
		attackAnimation4();
		repaint();
		checkCollision();
	}

	public void attack5(){
		attackAnimation5();
		repaint();
		checkCollision();
	}

	public void moveUp(){
		y = y - 5;
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		repaint();
	}

	public void moveRight(){
		x = x + 5;
		repaint();
	}

	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<monsters.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monsters[x]!=null){
				monsters[x].contact = false;

				if(yChecker > monsters[x].yPos){
					if(yChecker-monsters[x].yPos < monsters[x].height){
						collideY = true;
					}
				}
				else{
					if(monsters[x].yPos - yChecker < monsters[x].height){
						collideY = true;
					}
				}

				if(xChecker > monsters[x].xPos){
					if(xChecker-monsters[x].xPos < monsters[x].width){
						collideX = true;
					}
				}
				else{
					if(monsters[x].xPos - xChecker < 2){
						collideX = true;
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				monsters[x].contact = true;
			}
		}
	}




	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 380, 750, 50);
		g.setColor(Color.WHITE);
		g.drawString("Press P to Play Sound", 15, 20 );

		Image image = Toolkit.getDefaultToolkit().getImage("brick.jpg");
		    g.drawImage(image, 0, 400, this);

		
	for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				// character grid for monsters
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.RED);
				g.fillRect(monsters[c].xPos+15, monsters[c].yPos, monsters[c].life, 3);


	
		
	
	


			}	
		}
	}
}
