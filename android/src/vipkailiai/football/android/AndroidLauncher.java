package vipkailiai.football.android;

import VIPKailiai.Configuration.FootballConfiguration;
import VIPKailiai.Football.Game.Football;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        FootballConfiguration.setGetAssetsPath("");
        initialize(new Football(), config);
	}
}
