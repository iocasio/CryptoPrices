package ocasiodev.cryptoprices.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ocasiodev.cryptoprices.R;
import ocasiodev.cryptoprices.model.CryptoCurrency;
import ocasiodev.cryptoprices.model.PriceData;

public class CryptoViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.currency_code)
    TextView currencyCode;
    @BindView(R.id.currency_info)
    TextView currencyInfo;
    @BindView(R.id.currency_background)
    View backgroundColor;

    public CryptoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(CryptoCurrency cryptoCurrency) {
        itemView.setTag(cryptoCurrency);
        currencyCode.setText(cryptoCurrency.getCode());
        currencyCode.setTextColor(ContextCompat.getColor(itemView.getContext(), cryptoCurrency.getSecondaryColorRes()));
        if (cryptoCurrency.getPriceData() != null){
            currencyInfo.setText(itemView.getContext().getString(R.string.crypto_info_format, cryptoCurrency.getName(), String.valueOf(cryptoCurrency.getPriceData().getMidPrice())));
        }else{
            currencyInfo.setText(cryptoCurrency.getName());
        }
        backgroundColor.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), cryptoCurrency.getPrimaryColorRes()));
    }

    public void bind(PriceData priceData) {
        CryptoCurrency cryptoCurrency = (CryptoCurrency) itemView.getTag();
        currencyInfo.setText(itemView.getContext().getString(R.string.crypto_info_format, cryptoCurrency.getName(), String.valueOf(priceData.getMidPrice())));
    }
}