package com.elkhami.mobcategories.model.request.productlist

import com.elkhami.mobcategories.model.data.Category


/**
 * Created by A.Elkhami on 21,February,2021
 */
interface ProductListModelListener {

    interface OnResponseListener {
        fun onResponseFinished(categoryList: List<Category>)
        fun onResponseFailure(t: Throwable)
    }

    fun requestApiCallForProductList(onFinishedListener: OnResponseListener)
}