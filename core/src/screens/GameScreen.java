package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import entities.Ball;
import entities.Striker;
import com.futuris.strike.FuturisStrikeGame;

public class GameScreen implements Screen {
	private FuturisStrikeGame game;
	
	private Striker player;
	private Striker pc;
	private Ball ball;
	private ShapeRenderer shapeRenderer;
	private float constant = 0f;
	
	public GameScreen(FuturisStrikeGame game) {
		this.game = game;
		
		player = new Striker(false);
		pc = new Striker(true);
		ball = new Ball(game);
		shapeRenderer = new ShapeRenderer();
	}
	
	@Override 
	public void show() {
		
	}
	
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.P)) {
			System.out.println("Setting to pause screen");
			game.setScreen(new PauseScreen(game));
		}
	}
	
	
	@Override
	public void render(float delta) {
		handleInput();
		
		player.update(delta);
		ball.update(delta, player, pc);
		
		pc.setY(ball.getY() - pc.getHeight() / 2);
		pc.getRect().y = pc.getY();
		
		Gdx.gl.glClearColor(10f / 256f,  18f / 256f,  20f / 256f,  0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.valueOf("0fffff"));
		
		
//		shapeRenderer.line(new Vector2(0, Gdx.graphics.getHeight() - 50), new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		
		for(int i = 20; i <= Gdx.graphics.getWidth(); i += 20) {
			shapeRenderer.line(new Vector2(i, 0), new Vector2(i - constant, Gdx.graphics.getHeight() + constant));
		}
		
		for(int i = 20; i <= Gdx.graphics.getHeight(); i += 20) {
			shapeRenderer.line(new Vector2(0, i), new Vector2(Gdx.graphics.getWidth() + constant, i - constant));
		}
		
		shapeRenderer.end();
		
		game.batch.begin();
		
		// Render the sprites for use in the game
		
		player.render(game.batch);
		pc.render(game.batch);
		ball.render(game.batch);
		
		// Render score 
		game.homeFont.draw(game.batch, Integer.toString(game.userPoints), 150, Gdx.graphics.getHeight() - 25);
		game.homeFont.draw(game.batch, Integer.toString(game.pcPoints), Gdx.graphics.getWidth() - 150, Gdx.graphics.getHeight() - 25); 
		
		
		game.batch.end();
	
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
	

}
