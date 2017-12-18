package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.futuris.strike.FuturisStrikeGame;
import com.badlogic.gdx.Screen;

public class HomeScreen implements Screen {
	private FuturisStrikeGame game;
	private Texture texture;
	private SpriteBatch batch;
	private Sprite sprite;
	
	public HomeScreen(FuturisStrikeGame game) {
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
//		batch = new SpriteBatch();
//		Texture texture = new Texture(Gdx.files.internal("../assets/blue_button.png"));
//		sprite = new Sprite(texture);
	}
	
	@Override 
	public void render(float delta) {
		handleInput();
		Gdx.gl.glClearColor(0,  0,  0,  0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.batch.begin();
		game.homeFont.draw(game.batch, "FUTURIS STRIKE", Gdx.graphics.getWidth() / 2 - 40, Gdx.graphics.getHeight() - 40);
		game.homeFont.draw(game.batch, "Hi There", 200, 200);
//		sprite.draw(batch);	
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
