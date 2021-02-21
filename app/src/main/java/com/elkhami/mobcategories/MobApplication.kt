package com.elkhami.mobcategories

import android.app.Application
import com.elkhami.mobcategories.di.AppContainer

/**
 * Created by A.Elkhami on 21,February,2021
 */
class MobApplication : Application() {
    val appContainer = AppContainer()
}