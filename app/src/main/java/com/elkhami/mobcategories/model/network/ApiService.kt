package com.elkhami.mobcategories.model.network

import com.elkhami.mobcategories.model.data.Category
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by A.Elkhami on 20,February,2021
 */
interface ApiService {
    @GET(".")
    fun requestProductCatalogue(): Call<List<Category>>
}