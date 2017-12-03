package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import entities.Ball;
import entities.Striker;
import com.futuris.strike.FuturisStrikeGame;

public class GameScreen implements Screen {
	private FuturisStrikeGame game;
	
	private Striker player;
	private Striker pc;
	private Ball ball;
	
	public GameScreen(FuturisStrikeGame game) {
		this.game = game;
		
		player = new Striker(false);
		pc = new Striker(true);
		ball = new Ball(game);
	}
	
	@Override 
	public void show() {
		
	}
	
	@Override
	public void render(float delta) {
		player.update(delta);
		ball.update(delta, player, pc);
		
		pc.setY(ball.getY() - pc.getHeight() / 2);
		pc.getRect().y = pc.getY();
		
		Gdx.gl.glClearColor(0,  0,  0,  0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		// Render the sprites for use in the game
		
		player.render(game.batch);
		pc.render(game.batch);
		ball.render(game.batch);
		
		// Render score 
		// game.mediumFont.draw(game.batch, Integer.toString(game.userPoints), 150, Gdx.graphics.getHeight() - 25);
		// game.mediumFont.draw(game.batch, Integer.toString(game.pcPoints), Gdx.graphics.getWidth() - 150, Gdx.graphics.getHeight() - 25); 
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
