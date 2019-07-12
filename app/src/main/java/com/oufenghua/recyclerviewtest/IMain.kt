package com.oufenghua.recyclerviewtest

/**
 * 主页面相关的 View 与 Presenter 的接口
 */
interface IMain {

    /**
     * Main 视图
     */
    interface View : IBase.View<Presenter> {

        /**
         * 展示 RecyclerView
         * @param items Item 列表
         */
        fun showRv(items:MutableList<Item>)

        /**
         * 展示添加 Item
         * @param position 添加的位置
         */
        fun showAddItemToRv(position: Int)

        /**
         * 展示删除 Item
         * @param position 删除的位置
         */
        fun showRemoveItemToRv(position: Int)

        /**
         * 展示提示
         * @param content 提示内容
         */
        fun showToast(content:String)
    }

    /**
     * Main 逻辑
     */
    interface Presenter : IBase.Presenter {

        /**
         * 添加 Item 到数据中
         * @param position 插入位置
         */
        fun addItem(position: Int)

        /**
         * 移除数据中的特定位置 Item
         * @param position 移除特定 Item 的位置
         */
        fun removeItem(position: Int)

        /**
         * 将 fromPosition 的 Item 移动至 toPosition
         * @param fromPosition Item 的原位置
         * @param toPosition Item 将要去的位置
         */
        fun swapItem(fromPosition: Int, toPosition: Int)
    }

}