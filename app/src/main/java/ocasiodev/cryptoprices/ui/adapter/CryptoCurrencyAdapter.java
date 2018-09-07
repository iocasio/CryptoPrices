package ocasiodev.cryptoprices.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ocasiodev.cryptoprices.ui.viewholder.CryptoViewHolder;

public class CryptoCurrencyAdapter extends RecyclerView.Adapter<CryptoViewHolder>{

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
        return 0;
    }

    private int getLayoutRes(){
        return 0;
    }
}
