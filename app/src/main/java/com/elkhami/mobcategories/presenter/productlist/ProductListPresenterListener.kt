package com.elkhami.mobcategories.presenter.productlist

/**
 * Created by A.Elkhami on 21,February,2021
 */
interface ProductListPresenterListener {

    fun getCategorisedProducts()
    fun refreshCategorisedProducts()
    fun onDestroy()
}