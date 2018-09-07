package ocasiodev.cryptoprices.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ocasiodev.cryptoprices.R;
import ocasiodev.cryptoprices.model.CryptoCurrency;
import ocasiodev.cryptoprices.model.PriceData;
import ocasiodev.cryptoprices.ui.viewholder.CryptoViewHolder;

public class CryptoCurrencyAdapter extends RecyclerView.Adapter<CryptoViewHolder> {

    private ArrayList<CryptoCurrency> mCryptoCurrencies;

    public CryptoCurrencyAdapter(ArrayList<CryptoCurrency> cryptoCurrencies) {
        mCryptoCurrencies = cryptoCurrencies;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CryptoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutRes(), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder cryptoViewHolder, int i) {
        CryptoCurrency cryptoCurrency = mCryptoCurrencies.get(i);
        cryptoViewHolder.bind(cryptoCurrency);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if (!payloads.isEmpty()){
            for (Object o:payloads) {
                if (o instanceof PriceData){
                    PriceData priceData = (PriceData)o;
                    holder.bind(priceData);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mCryptoCurrencies.size();
    }

    private int getLayoutRes() {
        return R.layout.view_crypto_currency_item;
    }

    public ArrayList<CryptoCurrency> getCryptoCurrencies() {
        return mCryptoCurrencies;
    }
}
