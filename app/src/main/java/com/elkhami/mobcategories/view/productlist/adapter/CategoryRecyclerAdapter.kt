package com.elkhami.mobcategories.view.productlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.model.data.Category
import com.elkhami.mobcategories.model.data.Product

/**
 * Created by A.Elkhami on 20,February,2021
 */
class CategoryRecyclerAdapter(private val categoryList: List<Category>,
                              private val clickListener: CategoryRecyclerAdapterCallback) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>(), ProductRecyclerAdapterCallback {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val categoryRecyclerView: RecyclerView = itemView.findViewById(R.id.productRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryItem = categoryList[position]

        holder.categoryTextView.text = categoryItem.name
        holder.categoryRecyclerView.apply{
            layoutManager = LinearLayoutManager(holder.categoryRecyclerView.context,
                RecyclerView.HORIZONTAL,
                false)

            adapter = ProductRecyclerAdapter(categoryItem.products,
                this@CategoryRecyclerAdapter)

            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onProductClick(productItem: Product) {
        clickListener.onProductClickFromCategory(productItem)
    }
}