package ocasiodev.cryptoprices.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ocasiodev.cryptoprices.CryptoApplication;
import ocasiodev.cryptoprices.R;
import ocasiodev.cryptoprices.network.service.CryptoCurrencyService;

public class CryptoPriceFragment extends Fragment {

    public static final String LOG_TAG = "CryptoPriceFragment";

    public static CryptoPriceFragment newInstance(Bundle bundle) {
        CryptoPriceFragment fragment = new CryptoPriceFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    CryptoCurrencyService mCryptoCurrencyService;

    private Unbinder mUnbinder;

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
