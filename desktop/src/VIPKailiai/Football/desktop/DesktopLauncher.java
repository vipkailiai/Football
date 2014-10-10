package VIPKailiai.Football.desktop;

import VIPKailiai.Configuration.FootballConfiguration;
import VIPKailiai.Football.Game.Football;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1920;
        config.height = 1080;
        FootballConfiguration.setGetAssetsPath("data/");
		new LwjglApplication(new Football(),config);
	}
}
