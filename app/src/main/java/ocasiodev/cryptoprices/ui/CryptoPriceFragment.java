package ocasiodev.cryptoprices.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ocasiodev.cryptoprices.CryptoApplication;
import ocasiodev.cryptoprices.R;
import ocasiodev.cryptoprices.model.CryptoCurrency;
import ocasiodev.cryptoprices.model.PriceData;
import ocasiodev.cryptoprices.ui.adapter.CryptoCurrencyAdapter;
import ocasiodev.cryptoprices.viewmodel.CryptoCurrencyPriceViewModel;

import static ocasiodev.cryptoprices.viewmodel.CryptoCurrencyPriceViewModel.CurrencyDataListener;

public class CryptoPriceFragment extends Fragment implements CurrencyDataListener {

    public static final String LOG_TAG = "CryptoPriceFragment";

    public static CryptoPriceFragment newInstance(Bundle bundle) {
        CryptoPriceFragment fragment = new CryptoPriceFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    CryptoCurrencyPriceViewModel mCryptoCurrencyPriceViewModel;

    @BindView(R.id.crypto_list)
    RecyclerView mCryptoList;

    private Unbinder              mUnbinder;
    private CryptoCurrencyAdapter mCryptoCurrencyAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CryptoApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crypto_price, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        mCryptoCurrencyAdapter = new CryptoCurrencyAdapter(mCryptoCurrencyPriceViewModel.getSupportedCurrencies());
        mCryptoList.setAdapter(mCryptoCurrencyAdapter);
        mCryptoList.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        mCryptoCurrencyPriceViewModel.fetchAllCryptoCurrencyData();
    }

    @Override
    public void onResume() {
        super.onResume();
        mCryptoCurrencyPriceViewModel.setCurrencyDataListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mCryptoCurrencyPriceViewModel.setCurrencyDataListener(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onCurrencyDataChanged(CryptoCurrency cryptoCurrency) {
        PriceData priceData = cryptoCurrency.getPriceData();
        if (priceData != null) {
            int itemPosition = mCryptoCurrencyAdapter.getCryptoCurrencies().indexOf(cryptoCurrency);
            if (itemPosition != -1) {
                mCryptoCurrencyAdapter.getCryptoCurrencies().get(itemPosition).setPriceData(cryptoCurrency.getPriceData());
                mCryptoCurrencyAdapter.notifyItemChanged(itemPosition, cryptoCurrency.getPriceData());
            }
            Log.d(LOG_TAG, cryptoCurrency.getName() + " " + String.valueOf(priceData.getMidPrice()));
        }
    }
}
