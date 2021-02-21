package com.elkhami.mobcategories.view.productlist

import com.elkhami.mobcategories.model.data.Category

/**
 * Created by A.Elkhami on 20,February,2021
 */
interface ProductListActivityListener {

    fun onCategorisedProductsReceived(categoryList: List<Category>)
    fun showError()

    fun startLoading()
    fun finishLoading()

    fun enableRefresh()
    fun disableRefresh()
}