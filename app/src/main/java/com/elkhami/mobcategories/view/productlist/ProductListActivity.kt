package com.elkhami.mobcategories.view.productlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.testutils.recyclerViewTestingStubData
import com.elkhami.mobcategories.view.productdetail.ProductDetailActivity
import com.elkhami.mobcategories.view.productlist.adapter.CategoryRecyclerAdapter
import com.elkhami.mobcategories.view.productlist.adapter.CategoryRecyclerAdapterCallback
import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.utils.Constants.Companion.productItemExtra
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity(), CategoryRecyclerAdapterCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)


        initRecyclerView(recyclerViewTestingStubData())

    }

    private fun initRecyclerView(categoryList: List<Category>) {
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


}