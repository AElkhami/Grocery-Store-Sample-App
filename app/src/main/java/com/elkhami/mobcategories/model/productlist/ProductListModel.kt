package com.elkhami.mobcategories.model.productlist

import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by A.Elkhami on 21,February,2021
 */
class ProductListModel(retrofitInstance: RetrofitInstance?): ProductListModelListener {

    private val response = retrofitInstance
        ?.getApiService
        ?.requestProductCatalogue()

    override fun requestApiCallForProductList(onFinishedListener: ProductListModelListener.OnResponseListener) {
        response?.enqueue(object : Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                response.body()?.let {
                    onFinishedListener.onResponseFinished(it)
                }

            }

            override fun onFailure(call: Call<List<Category>>, throwable: Throwable) {
                onFinishedListener.onResponseFailure(throwable)
            }

        })
    }
}