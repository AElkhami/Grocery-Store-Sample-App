package com.elkhami.mobcategories.view.productdetail

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.utils.Constants
import com.elkhami.mobcategories.utils.Constants.Companion.productItemExtra
import kotlinx.android.synthetic.main.activity_product_detail.*

/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.extras?.getParcelable<Product>(productItemExtra)

        product?.let {
            productNameTextView.text = it.name
            title = getString(R.string.details_screen_title, it.name)
        }


    }
}