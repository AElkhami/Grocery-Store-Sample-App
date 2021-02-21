package com.elkhami.mobcategories.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val categoryId: String,
    val description: String,
    val id: String,
    val name: String,
    val salePrice: SalePrice,
    var url: String
) : Parcelable