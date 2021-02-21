package com.elkhami.mobcategories.di

import com.elkhami.mobcategories.model.network.RetrofitInstance

/**
 * Created by A.Elkhami on 21,February,2021
 */


/*
 * This class has all the object that will be injected in all the app
 */
open class AppContainer {
    val retrofitInstance = RetrofitInstance()
}