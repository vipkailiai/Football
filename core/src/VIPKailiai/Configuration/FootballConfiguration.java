package VIPKailiai.Configuration;

/**
 * Created by Paulius on 10/10/2014.
 */
public final class FootballConfiguration {

    private static String assetsPath;
    public static String getGetAssetsPath() {
        return assetsPath;
    }
    public static void setGetAssetsPath(String getAssetsPath) {
        assetsPath = getAssetsPath;
    }

    private FootballConfiguration() {
        assetsPath = "";
    }

}

