package ocasiodev.cryptoprices.model

import android.text.TextUtils
import ocasiodev.cryptoprices.R

data class CryptoCurrency(val name: String, val code: String, var priceData: PriceData?, val primaryColorRes: Int, val secondaryColorRes: Int) {

    companion object {
        @JvmStatic
        fun getSupportedCurrencies(): ArrayList<CryptoCurrency> {
            val supportedCurrencies = ArrayList<CryptoCurrency>()

            supportedCurrencies.add(CryptoCurrency("Bitcoin", "BTCUSD", null, R.color.bitcoin_primary, R.color.bitcoin_secondary))
            supportedCurrencies.add(CryptoCurrency("Bitcoin Classic", "BCCUSD", null, R.color.bitcoin_classic_primary, R.color.bitcoin_classic_secondary))
            supportedCurrencies.add(CryptoCurrency("Ethereum", "ETHUSD", null, R.color.ethereum_primary, R.color.ethereum_secondary))
            supportedCurrencies.add(CryptoCurrency("Litecoin", " LTCUSD", null, R.color.litecoin_primary, R.color.litecoin_secondary))
            supportedCurrencies.add(CryptoCurrency("Neo", "NEOUSD", null, R.color.neo_primary, R.color.neo_secondary))

            return supportedCurrencies
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is CryptoCurrency) {
            return TextUtils.equals(name, other.name)
        } else {
            return false
        }
    }
}