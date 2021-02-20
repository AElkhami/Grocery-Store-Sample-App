package com.elkhami.mobcategories.view.productlist.adapter

import com.elkhami.mobcategories.model.data.Product

/**
 * Created by A.Elkhami on 20,February,2021
 */
interface CategoryRecyclerAdapterCallback {
    fun onProductClickFromCategory(productItem: Product)
}