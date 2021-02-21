package com.elkhami.mobcategories.view.productdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.utils.Constants.Companion.productItemExtra
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.app_toolbar.*


/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        setSupportActionBar(appToolBar)

        initUi()
    }

    private fun initUi() {
        val product = intent.extras?.getParcelable<Product>(productItemExtra)

        product?.let {

            supportActionBar?.apply {
                title = getString(R.string.details_screen_title, it.name)
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setHomeAsUpIndicator(R.drawable.ic_toolbar_back)
            }

            Glide
                .with(this)
                .load(it.url)
                .placeholder(R.drawable.ic_placeholder)
                .circleCrop()
                .transition(
                    DrawableTransitionOptions()
                        .crossFade()
                )
                .into(productImageView)

            productNameTextView.text = it.name

            productPriceTextView.text = getString(
                R.string.amount_with_currency,
                it.salePrice.amount,
                it.salePrice.currency
            )
        }
    }
}