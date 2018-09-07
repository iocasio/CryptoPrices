package ocasiodev.cryptoprices.network.api;

import ocasiodev.cryptoprices.model.PriceData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptoCurrencyApi {

    @GET("v1/pubticker/{crypto_currency}")
    Call<PriceData> fetchPriceData(@Path("crypto_currency") String currency);
}
