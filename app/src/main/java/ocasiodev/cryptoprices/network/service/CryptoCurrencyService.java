package ocasiodev.cryptoprices.network.service;

import javax.inject.Inject;

import ocasiodev.cryptoprices.model.PriceData;
import ocasiodev.cryptoprices.network.api.CryptoCurrencyApi;
import retrofit2.Call;

public class CryptoCurrencyService {

    @Inject
    CryptoCurrencyApi mCurrencyApi;

    @Inject
    public CryptoCurrencyService(){

    }

    public Call<PriceData> fetchCurrencyPriceData(String currency){
        return mCurrencyApi.fetchPriceData(currency);
    }
}
