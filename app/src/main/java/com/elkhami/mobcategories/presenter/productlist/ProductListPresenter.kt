package com.elkhami.mobcategories.presenter.productlist

import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.network.RetrofitInstance
import com.elkhami.mobcategories.model.productlist.ProductListModel
import com.elkhami.mobcategories.model.productlist.ProductListModelListener
import com.elkhami.mobcategories.view.productlist.ProductListActivityListener

/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductListPresenter(
    private var viewListener: ProductListActivityListener?,
    retrofitInstance: RetrofitInstance?
) : ProductListPresenterListener,
    ProductListModelListener.OnResponseListener {

    private var dataListener: ProductListModel = ProductListModel(retrofitInstance)

    override fun getCategorisedProducts() {
        viewListener?.startLoading()
        dataListener.requestApiCallForProductList(this)
    }

    override fun refreshCategorisedProducts() {
        getCategorisedProducts()
        viewListener?.disableRefresh()
    }

    override fun onResponseFinished(categoryList: List<Category>) {
        viewListener?.finishLoading()
        viewListener?.onCategorisedProductsReceived(categoryList)
    }

    override fun onResponseFailure(t: Throwable) {
        viewListener?.finishLoading()
        viewListener?.showError(t.message.toString())
        viewListener?.enableRefresh()
    }

    override fun onDestroy() {
        viewListener = null
    }
}

