package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Striker extends Sprite{
	
	private float x;
	private float y;
	private float strikerHeight;
	private float strikerWidth;
	private Rectangle rectangle;
	private boolean ai;
	
	private float rectangleX;
	private float rectangleY;
	
	private float ySpeed;
	
	private Texture image;
	
	public Striker(boolean ai) {
		image = new Texture("dark-blue-paddle.png");
		
		strikerWidth = image.getWidth();
		strikerHeight = image.getHeight();
		
		if(ai) {
			x = Gdx.graphics.getWidth() - 20 - strikerWidth;
			y = Gdx.graphics.getHeight() / 2 - strikerHeight / 2;
		} else {
			x = 20;
			y = Gdx.graphics.getHeight() / 2 - strikerHeight / 2 ;
		}
		
		this.ai = ai;
		ySpeed = 5;
		strikerWidth = image.getWidth();
		strikerHeight = image.getHeight();
		
		rectangle = new Rectangle(x, y, strikerWidth, strikerHeight);
		
	}
	public void update(float deltaTime) {
		// Handle input
		if(!ai) {
		
			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				y += ySpeed;
			}
			
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				y -= ySpeed;
			}
			
			// Window Boundaries 
			
			if(y < 0) {
				y = 0;
			}
			
			if(y + strikerHeight > Gdx.graphics.getHeight()) {
				y = Gdx.graphics.getHeight() - strikerHeight;
				
			}
			
			// Update rectangles 
			rectangle.x = x;
			rectangle.y = y;
		}
		
		if (ai) {
			
			if(y < 0) {
				y = 0;
			}
			
			if(y + strikerHeight > Gdx.graphics.getHeight()) {
				y = Gdx.graphics.getHeight() - strikerHeight;
				
			}
			
			// Update rectangles 
			rectangle.x = x;
			rectangle.y = y;
			
		}
		
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(image, x, y);
		
	}
	
	public float getY( ) {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
		
	}
	
	public float getHeight() {
		return strikerHeight;
	}
	
	public Rectangle getRect() {
		return rectangle;
	}

}
