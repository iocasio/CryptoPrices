package ocasiodev.cryptoprices.model

import android.text.TextUtils

data class CryptoCurrency(val name: String, val code: String, var priceData: PriceData?) {

    companion object {
        @JvmStatic
        fun getSupportedCurrencies(): ArrayList<CryptoCurrency> {
            val supportedCurrencies = ArrayList<CryptoCurrency>()

            supportedCurrencies.add(CryptoCurrency("Bitcoin", "BTCUSD", null))
            supportedCurrencies.add(CryptoCurrency("Bitcoin Classic", "BCCUSD", null))
            supportedCurrencies.add(CryptoCurrency("Ethereum", "ETHUSD", null))
            supportedCurrencies.add(CryptoCurrency("Litecoin", " LTCUSD", null))
            supportedCurrencies.add(CryptoCurrency("Neo", "NEOUSD", null))

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