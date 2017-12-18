package com.futuris.strike;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;
import screens.HomeScreen;


public class FuturisStrikeGame extends Game {
	public SpriteBatch batch;
	public BitmapFont homeFont;
	public int userPoints;
	public int pcPoints;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		homeFont = new BitmapFont(Gdx.files.internal("../assets/ProFontWindows.fnt"));
		userPoints = 0;
		pcPoints = 0;
		this.setScreen(new HomeScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
