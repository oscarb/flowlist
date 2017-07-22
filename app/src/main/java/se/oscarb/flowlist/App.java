package se.oscarb.flowlist;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .server(BuildConfig.PARSE_SERVER_URL)
                .applicationId(BuildConfig.PARSE_APPLICATION_ID)
                .clientKey(BuildConfig.PARSE_CLIENT_KEY)
                .build());
    }
}
