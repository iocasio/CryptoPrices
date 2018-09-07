package ocasiodev.cryptoprices.dagger;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ocasiodev.cryptoprices.Config;
import ocasiodev.cryptoprices.network.api.CryptoCurrencyApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create(new GsonBuilder().create());
    }

    @Provides
    @Singleton
    CryptoCurrencyApi provideCryptoCurrencyApi(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.CryptoBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient).build();
        return retrofit.create(CryptoCurrencyApi.class);
    }
}
