package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
	private Texture pcCircle;
	private Texture playerCircle;
	private Texture futurisBall;
	private Texture blurBackground;
	
	public GameScreen(FuturisStrikeGame game) {
		this.game = game;
		
		player = new Striker(false);
		pc = new Striker(true);
		ball = new Ball(game);
		shapeRenderer = new ShapeRenderer();
		
		pcCircle = new Texture(Gdx.files.internal("pcCircle.png"));
		playerCircle = new Texture(Gdx.files.internal("playerCircle.png"));
		//futurisBall = new Texture(Gdx.files.internal("futuristic_ball.png"));
		blurBackground = new Texture(Gdx.files.internal("BlurBackground.png"));
	}
	
	@Override 
	public void show() {
		
	}
	
	
	@Override
	public void render(float delta) {

		
		player.update(delta);
		ball.update(delta, player, pc);
		
		pc.setY(ball.getY() - pc.getHeight() / 2);
		
		pc.update(delta);

		
		Gdx.gl.glClearColor(10f / 256f,  18f / 256f,  20f / 256f,  0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.valueOf("ffffff"));
		shapeRenderer.line(new Vector2(320, 0), new Vector2(320 - constant, Gdx.graphics.getHeight() + constant));
		
//		shapeRenderer.line(new Vector2(0, Gdx.graphics.getHeight() - 50), new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		
//		for(int i = 20; i <= Gdx.graphics.getWidth(); i += 60) {
//			shapeRenderer.line(new Vector2(i, 0), new Vector2(i - constant, Gdx.graphics.getHeight() + constant));
//		}
		
//		for(int i = 20; i <= Gdx.graphics.getHeight(); i += 60) {
//			shapeRenderer.line(new Vector2(0, i), new Vector2(Gdx.graphics.getWidth() + constant, i - constant));
//		}
		
		shapeRenderer.end();


		game.batch.begin();
		
		
		//game.batch.draw(blurBackground,  70,  0);
		// Render the sprites for use in the game
		
		player.render(game.batch);
		pc.render(game.batch);
		ball.render(game.batch);
		
		// Render score 
		game.homeFont.draw(game.batch, Integer.toString(game.userPoints), 150, Gdx.graphics.getHeight() - 25);
		game.homeFont.draw(game.batch, Integer.toString(game.pcPoints), Gdx.graphics.getWidth() - 150, Gdx.graphics.getHeight() - 25); 

		game.batch.draw(playerCircle, 115, 375);
		game.batch.draw(pcCircle, 455, 375);
		//game.batch.draw(futurisBall, 89, 78);
		
		
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
