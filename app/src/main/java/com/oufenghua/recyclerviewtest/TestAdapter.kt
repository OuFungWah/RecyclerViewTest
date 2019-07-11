package com.oufenghua.recyclerviewtest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TestAdapter(items: MutableList<Item>) : RecyclerView.Adapter<TestAdapter.TestViewHolder>() {

    private var items: MutableList<Item>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.setView(items?.get(position))
    }

    class TestViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)) {

        var contentView: View? = null
        var contentTv: TextView? = null

        init {
            contentView = itemView.findViewById(R.id.v_item_content)
            contentTv = itemView.findViewById(R.id.tv_item_content)
        }

        fun setView(item: Item?) {
            contentTv?.text = item?.content
            contentView?.setBackgroundColor(item?.color ?: Color.BLACK)
        }
    }

}