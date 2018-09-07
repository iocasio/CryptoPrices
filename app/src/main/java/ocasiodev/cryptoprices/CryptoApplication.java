package ocasiodev.cryptoprices;

import android.app.Application;

import ocasiodev.cryptoprices.dagger.AppComponent;
import ocasiodev.cryptoprices.dagger.DaggerAppComponent;

public class CryptoApplication extends Application {

    private static CryptoApplication sInstance;
    protected      AppComponent      mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mAppComponent = DaggerAppComponent.builder().build();
    }

    public static CryptoApplication getInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
