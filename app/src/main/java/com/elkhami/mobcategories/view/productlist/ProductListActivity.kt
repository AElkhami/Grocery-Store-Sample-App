package com.elkhami.mobcategories.view.productlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.elkhami.mobcategories.MobApplication
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.di.AppContainer
import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.presenter.productlist.ProductListPresenter
import com.elkhami.mobcategories.utils.Constants.Companion.productItemExtra
import com.elkhami.mobcategories.view.productdetail.ProductDetailActivity
import com.elkhami.mobcategories.view.productlist.adapter.CategoryRecyclerAdapter
import com.elkhami.mobcategories.view.productlist.adapter.CategoryRecyclerAdapterCallback
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_product_list.*
import kotlinx.android.synthetic.main.app_toolbar.*

class ProductListActivity : AppCompatActivity(), CategoryRecyclerAdapterCallback,
    ProductListActivityListener {

    private lateinit var presenter: ProductListPresenter
    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        screenTitle.text = getString(R.string.products)

        appContainer = (application as MobApplication).appContainer

        setUpPresenter()

        setUpClickListener()

        presenter.getCategorisedProducts()

    }

    private fun setUpPresenter() {
        presenter = ProductListPresenter(this, appContainer.retrofitInstance)
    }

    private fun setUpClickListener() {
        refreshButton.setOnClickListener {
            presenter.refreshCategorisedProducts()
        }
    }

    private fun setUpRecyclerView(categoryList: List<Category>) {
        categoryRecyclerView.apply {
            adapter = CategoryRecyclerAdapter(categoryList, this@ProductListActivity)
            adapter!!.notifyDataSetChanged()
        }
    }

    override fun onProductClickFromCategory(productItem: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(productItemExtra, productItem)
        startActivity(intent)
    }

    override fun onCategorisedProductsReceived(categoryList: List<Category>) {
        setUpRecyclerView(categoryList)
    }

    override fun showError() {
        Snackbar.make(
            categoryListContainer,
            getString(R.string.something_went_wrong),
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun startLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun finishLoading() {
        progressBar.visibility = View.GONE
    }

    override fun enableRefresh() {
        refreshButton.visibility = View.VISIBLE
    }

    override fun disableRefresh() {
        refreshButton.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}