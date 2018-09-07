package ocasiodev.cryptoprices

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ocasiodev.cryptoprices.ui.CryptoPriceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, CryptoPriceFragment.newInstance(null)).commit();
    }
}
