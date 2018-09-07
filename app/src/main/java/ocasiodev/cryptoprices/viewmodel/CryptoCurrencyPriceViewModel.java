package ocasiodev.cryptoprices.viewmodel;

import java.util.ArrayList;

import javax.inject.Inject;

import ocasiodev.cryptoprices.model.CryptoCurrency;
import ocasiodev.cryptoprices.model.PriceData;
import ocasiodev.cryptoprices.network.service.CryptoCurrencyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoCurrencyPriceViewModel {

    @Inject
    CryptoCurrencyService mCryptoCurrencyService;

    @Inject
    public CryptoCurrencyPriceViewModel() {
        mSupportedCurrencies = CryptoCurrency.getSupportedCurrencies();
    }

    private ArrayList<CryptoCurrency> mSupportedCurrencies;
    private CurrencyDataListener      mCurrencyDataListener;

    public void fetchAllCryptoCurrencyData() {
        for (final CryptoCurrency currency : mSupportedCurrencies) {
            fetchCryptoCurrencyPriceData(currency);
        }
    }

    private void fetchCryptoCurrencyPriceData(final CryptoCurrency cryptoCurrency) {
        final Call<PriceData> priceDataCall = mCryptoCurrencyService.fetchCurrencyPriceData(cryptoCurrency.getCode());
        priceDataCall.enqueue(new Callback<PriceData>() {
            @Override
            public void onResponse(Call<PriceData> call, Response<PriceData> response) {
                if (response.isSuccessful()) {
                    cryptoCurrency.setPriceData(response.body());
                    if (mCurrencyDataListener != null) {
                        mCurrencyDataListener.onCurrencyDataChanged(cryptoCurrency);
                    }
                }
            }

            @Override
            public void onFailure(Call<PriceData> call, Throwable t) {
                //Todo Add error handling
            }
        });
    }

    public void setCurrencyDataListener(CurrencyDataListener currencyDataListener) {
        mCurrencyDataListener = currencyDataListener;
    }

    public ArrayList<CryptoCurrency> getSupportedCurrencies() {
        return mSupportedCurrencies;
    }

    public interface CurrencyDataListener {
        void onCurrencyDataChanged(CryptoCurrency cryptoCurrency);
    }
}