package com.oufenghua.recyclerviewtest

interface Main {

    interface View : IBase.View<Presenter> {
        fun showRv(items:MutableList<Item>)
        fun showAddItemToRv(position: Int)
        fun showRemoveItemToRv(position: Int)
        fun showToast(content:String)
    }

    interface Presenter : IBase.Presenter {
        fun addItem(position: Int)
        fun removeItem(position: Int)
        fun swapItem(fromPosition: Int, toPosition: Int)
    }

}