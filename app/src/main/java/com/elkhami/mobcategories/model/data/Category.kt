package com.elkhami.mobcategories.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val description: String,
    val id: String,
    val name: String,
    val products: List<Product>
) : Parcelable