package com.elkhami.mobcategories.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SalePrice(
    val amount: String,
    val currency: String
) : Parcelable