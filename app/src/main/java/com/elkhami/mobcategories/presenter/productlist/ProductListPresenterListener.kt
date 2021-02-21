package com.elkhami.mobcategories.presenter.productlist

import com.elkhami.mobcategories.model.data.Category

/**
 * Created by A.Elkhami on 21,February,2021
 */
interface ProductListPresenterListener {

    fun provideDataToView(categoryListWithImageUrl: List<Category>)
    fun getCategorisedProducts()
    fun refreshCategorisedProducts()
    fun onDestroy()
}