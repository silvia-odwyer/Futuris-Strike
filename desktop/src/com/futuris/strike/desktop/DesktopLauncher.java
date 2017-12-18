package com.futuris.strike.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.futuris.strike.FuturisStrikeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Futuris Strike";
		config.resizable = false;
		new LwjglApplication(new FuturisStrikeGame(), config);
	}
}