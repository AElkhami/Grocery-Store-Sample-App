package com.elkhami.mobcategories.presenter.productlist

import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.network.RetrofitInstance
import com.elkhami.mobcategories.model.request.productlist.ProductListModel
import com.elkhami.mobcategories.model.request.productlist.ProductListModelListener
import com.elkhami.mobcategories.utils.Constants
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

        val categoryListWithImageUrl = appendImageUrlToResponse(categoryList)

        viewListener?.finishLoading()

        provideDataToView(categoryListWithImageUrl)
    }

    override fun provideDataToView(categoryListWithImageUrl: List<Category>) {
        viewListener?.onCategorisedProductsReceived(categoryListWithImageUrl)
    }

    override fun onResponseFailure(t: Throwable) {
        viewListener?.finishLoading()
        viewListener?.showError()
        viewListener?.enableRefresh()
    }


    override fun onDestroy() {
        viewListener = null
    }

    fun appendImageUrlToResponse(categoryList: List<Category>): List<Category> {
        categoryList.forEach { category ->
            category.products.forEach { product ->
                product.url = Constants.BASE_URL
                    .replaceAfter("com", product.url, "//")
            }
        }


        return categoryList
    }
}

