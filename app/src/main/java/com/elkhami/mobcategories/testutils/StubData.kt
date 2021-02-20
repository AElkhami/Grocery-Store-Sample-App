package com.elkhami.mobcategories.testutils

import com.elkhami.productcatalogue.data.model.Category
import com.elkhami.productcatalogue.data.model.Product
import com.elkhami.productcatalogue.data.model.SalePrice

/**
 * Created by A.Elkhami on 20,February,2021
 */

 fun recyclerViewTestingStubData(): MutableList<Category> {
    val productList: MutableList<Product> = ArrayList()
    val categoryList: MutableList<Category> = ArrayList()

    val salePrice = SalePrice(
        "0.81",
        "EUR")
    val productModel = Product(
        "36802",
        "",
        "1",
        "Bread", salePrice,
        "/Bread.jpg")

    val categoryModel = Category("", "", "Food", productList)

    productList.add(productModel)
    categoryList.add(categoryModel)

    return categoryList
}