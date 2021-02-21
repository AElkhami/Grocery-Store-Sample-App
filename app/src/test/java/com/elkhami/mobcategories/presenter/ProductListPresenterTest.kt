package com.elkhami.mobcategories.presenter

import com.elkhami.mobcategories.di.AppContainer
import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.presenter.productlist.ProductListPresenter
import com.elkhami.mobcategories.view.productlist.ProductListActivityListener
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductListPresenterTest {

    @JvmField @Rule
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock private var viewListenerMock: ProductListActivityListener? = null
    @Mock private lateinit var appContainer: AppContainer
    @Mock private lateinit var categoryList: List<Category>
    @Mock private lateinit var throwable: Throwable

    private lateinit var presenter: ProductListPresenter

    @Before
    fun setUp() {
        presenter = ProductListPresenter(viewListenerMock, appContainer.retrofitInstance)
    }

    @Test
    fun test_getCategorisedProducts() {
        presenter.getCategorisedProducts()
        then(viewListenerMock).should()?.startLoading()
    }

    @Test
    fun test_refreshCategorisedProducts() {
        presenter.refreshCategorisedProducts()
        then(viewListenerMock).should()?.disableRefresh()
    }

    @Test
    fun test_onResponseFinished() {
        presenter.onResponseFinished(categoryList)
        then(viewListenerMock).should()?.finishLoading()
        then(viewListenerMock).should()?.onCategorisedProductsReceived(categoryList)
    }

    @Test
    fun test_onResponseFailure() {
        presenter.onResponseFailure(throwable)
        then(viewListenerMock).should()?.showError(throwable.message.toString())
    }

    @Test
    fun test_onDestroy() {
        presenter.onDestroy()
        viewListenerMock = null
        assertNull(viewListenerMock)
    }
}