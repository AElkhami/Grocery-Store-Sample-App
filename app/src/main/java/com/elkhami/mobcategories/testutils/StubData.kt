package com.elkhami.mobcategories.testutils

import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.model.data.SalePrice

/**
 * Created by A.Elkhami on 20,February,2021
 */

fun recyclerViewTestingStubData(): List<Category> {
    val productList: MutableList<Product> = ArrayList()
    val categoryList: MutableList<Category> = ArrayList()

    val salePrice = SalePrice(
        "0.81",
        "EUR"
    )
    val productModel = Product(
        "36802",
        "",
        "1",
        "Bread", salePrice,
        "/Bread.jpg"
    )

    val categoryModel = Category("", "36802", "Food", productList)

    productList.add(productModel)
    categoryList.add(categoryModel)

    return categoryList
}