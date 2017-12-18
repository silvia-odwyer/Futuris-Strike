package entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.futuris.strike.FuturisStrikeGame;
import screens.GameScreen;

public class Ball extends Sprite {
	private float x;
	private float y;
	
	private float ballWidth;
	private float ballHeight;
	
	private Rectangle rectangle;
	
	private float rectX;
	private float rectY;
	
	private float xSpeed;
	private float ySpeed;
	
	private Texture image;
	
	private FuturisStrikeGame game;
	
	public Ball(FuturisStrikeGame game) {
		this.game = game; 		
		image = new Texture("ball.png");
		
		ballWidth = image.getWidth();
		ballHeight = image.getHeight();
	
		x = Gdx.graphics.getWidth() / 2 - ballWidth / 2;
		y = Gdx.graphics.getHeight() / 2 - ballHeight / 2;
		
		xSpeed = -4f;
		ySpeed = 1.5f;
		
		rectangle = new Rectangle(x, y, ballWidth, ballHeight);
	}
	
	public void update(float deltaTime, Striker player, Striker pc) {
		x += xSpeed;
		y += ySpeed;
		
		// Window Boundaries 
		
		if (y < 0) {
			ySpeed = -ySpeed;
			game.bounceSound.play();
		}
				
		if(y + ballHeight > Gdx.graphics.getHeight()) {
			ySpeed = -ySpeed;
			game.bounceSound.play();
		}
				
		// Win or Lose Point
				
		if (x < 0) {
			xSpeed = 0;
			ySpeed = 0;
					
				game.pcPoints++;
				game.userLossSound.play();
				game.setScreen(new GameScreen(game));
					
		}
				
		if (x + ballWidth > Gdx.graphics.getWidth()) {
			xSpeed = 0;
			ySpeed = 0;
					
			game.userPoints++;
			game.userPointIncrementSound.play();
			game.setScreen(new GameScreen(game));
		}
				
		rectangle.x = x;
		rectangle.y = y;
				
		if(Intersector.overlaps(player.getRect(), rectangle)) {
				
			xSpeed = -xSpeed;
			game.rallySound.play();
					
		}
				
		if(Intersector.overlaps(pc.getRect(), rectangle)) {
			xSpeed = -xSpeed;
			game.rallySound.play();
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(image,  x,  y);
	}
		
	public float getY() {
		return y;
		
	}
	
	public Rectangle getRect( ) {
		return rectangle;
	}	
	
}
