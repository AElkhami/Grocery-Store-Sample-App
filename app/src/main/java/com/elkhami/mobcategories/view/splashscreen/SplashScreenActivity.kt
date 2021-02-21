package com.elkhami.mobcategories.view.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.elkhami.mobcategories.BuildConfig
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.view.productlist.ProductListActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        appVersionTextView.text = getString(R.string.app_version, BuildConfig.VERSION_NAME)

        waitThenStartMainActivity()
    }

    private fun waitThenStartMainActivity(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}