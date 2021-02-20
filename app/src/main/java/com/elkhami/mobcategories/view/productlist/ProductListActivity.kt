package com.elkhami.mobcategories.view.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.testutils.recyclerViewTestingStubData
import com.elkhami.mobcategories.view.productlist.adapter.CategoryRecyclerAdapter
import com.elkhami.productcatalogue.data.model.Category
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)


        initRecyclerView(recyclerViewTestingStubData())

    }

    private fun initRecyclerView(categoryList: List<Category>) {
        categoryRecyclerView.apply {
            adapter = CategoryRecyclerAdapter(categoryList)
            adapter!!.notifyDataSetChanged()
        }
    }


}