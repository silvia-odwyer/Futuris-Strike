package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.futuris.strike.FuturisStrikeGame;
import com.badlogic.gdx.Screen;

public class PauseScreen implements Screen {
	private FuturisStrikeGame game;
	private SpriteBatch batch;
	private Texture texture;
	
	public PauseScreen(FuturisStrikeGame game) {
		this.game = game;
		
	}
	
	@Override 
	public void show() {
		
	}
	
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			game.setScreen(new GameScreen(game));
		}
	}
	
	public void create() {

	}
	
	@Override 
	public void render(float delta) {
		handleInput();
		Gdx.gl.glClearColor(0,  0,  0,  0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.batch.begin();
		game.homeFont.draw(game.batch, "PAUSED GAME", Gdx.graphics.getWidth() / 2 - 40, Gdx.graphics.getHeight() - 40);
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
		texture.dispose();
	}	
}

