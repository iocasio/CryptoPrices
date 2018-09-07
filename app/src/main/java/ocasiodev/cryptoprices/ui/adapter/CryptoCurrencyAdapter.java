package ocasiodev.cryptoprices.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import ocasiodev.cryptoprices.model.CryptoCurrency;
import ocasiodev.cryptoprices.ui.viewholder.CryptoViewHolder;

public class CryptoCurrencyAdapter extends RecyclerView.Adapter<CryptoViewHolder>{

    private ArrayList<CryptoCurrency> mCryptoCurrencies;

    public CryptoCurrencyAdapter(ArrayList<CryptoCurrency> cryptoCurrencies){
        mCryptoCurrencies = cryptoCurrencies;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CryptoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutRes(), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder cryptoViewHolder, int i) {
        cryptoViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return mCryptoCurrencies.size();
    }

    private int getLayoutRes(){
        return 0;
    }

    public ArrayList<CryptoCurrency> getCryptoCurrencies() {
        return mCryptoCurrencies;
    }
}
