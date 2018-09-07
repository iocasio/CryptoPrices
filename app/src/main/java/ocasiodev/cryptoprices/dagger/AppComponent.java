package ocasiodev.cryptoprices.dagger;

import javax.inject.Singleton;

import dagger.Component;
import ocasiodev.cryptoprices.ui.CryptoPriceFragment;

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {
    void inject(CryptoPriceFragment fragment);
}
