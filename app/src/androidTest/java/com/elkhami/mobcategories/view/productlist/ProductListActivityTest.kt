package com.elkhami.mobcategories.view.productlist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.testutils.recyclerViewTestingStubData
import com.elkhami.mobcategories.testutils.TestUtils.withRecyclerView
import com.elkhami.mobcategories.view.productlist.adapter.ProductRecyclerAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by A.Elkhami on 20,February,2021
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ProductListActivityTest{

    @get: Rule
    val activityRule = ActivityScenarioRule(ProductListActivity::class.java)



    /**
     * Parent RecyclerView come to the view on screen launch
     */
    @Test
    fun test_parentRecyclerView_is_displayed(){
        onView(withId(R.id.categoryRecyclerView))
            .check(matches(isDisplayed()))
    }

    /**
     * Child RecyclerView come to the view on screen launch
     */
    @Test
    fun test_childRecyclerView_is_displayed(){
        onView(withRecyclerView(R.id.categoryRecyclerView).atPositionOnView(0, R.id.productRecyclerView))
            .check(matches(isDisplayed()))
    }


    /**
     * Check that category name matches the data given
     */
    @Test
    fun test_categoryName_isDisplayed_and_matchData(){
        onView(withRecyclerView(R.id.categoryRecyclerView).atPositionOnView(0, R.id.categoryTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(recyclerViewTestingStubData()[0].name)))
    }

    /**
     * Check that product name matches the data given
     */
    @Test
    fun test_productName_isDisplayed_and_matchData(){
        onView(withRecyclerView(R.id.productRecyclerView).atPositionOnView(0, R.id.productItemNameTextView))
            .check(matches(isDisplayed()))
            .check(matches(withText(recyclerViewTestingStubData()[0].products[0].name)))
    }

    /**
     * Clicking on child RecyclerView item
     */
    @Test
    fun test_selectItemOnChildRecyclerView_openDetailsScreen(){

        onView(withId(R.id.productRecyclerView))
            .perform(actionOnItemAtPosition<ProductRecyclerAdapter.ProductViewHolder>(0,
                click()
            ))

        onView(withId(R.id.productNameTextView))
            .check(matches(withText(recyclerViewTestingStubData()[0].name)))
    }

}