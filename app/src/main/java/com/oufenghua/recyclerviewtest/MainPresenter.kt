package com.oufenghua.recyclerviewtest

import android.graphics.Color
import kotlin.math.abs
import kotlin.random.Random

class MainPresenter(val view: IMain.View) : IMain.Presenter {

    companion object {

        val TAG = "MainPresenter"
        private val random = Random(System.currentTimeMillis())
        private var count = 0

        fun randomColor(): Int {
            return Color.parseColor(
                "#${abs(random.nextInt(25, 256)).toString(16)}" +
                        abs(random.nextInt(25,256)).toString(16) +
                        abs(random.nextInt(25, 256)).toString(16)
            )
        }
    }

    lateinit var model :MainModel

    override fun start() {
        // 数据初始化
        model = MainModel(mutableListOf())
        // 通知UI
        view.showRv(model.list)
    }

    init {
        view.presenter = this
    }

    override fun addItem(position: Int) {
        addItem(position, null)
    }

    private fun addItem(position: Int, item: Item?) {
        if (!checkNum(position)) {
            return
        }
        if (model.list.size <= 100) {
            model.list.add(position, item ?: Item("Item ${count++}", randomColor()))
            view.showAddItemToRv(position)
        } else {
            view.showToast("加太多啦！先删掉一些")
        }
    }

    override fun removeItem(position: Int) {
        if (!checkNum(position)) {
            return
        }
        if (model.list.size > 0) {
            model.list.removeAt(position)
            view.showRemoveItemToRv(position)
        } else {
            view.showToast("没什么好删的了")
        }
    }

    override fun swapItem(fromPosition: Int, toPosition: Int) {
        if (model.list.size < 2) {
            view.showToast("没什么好换的了")
            return
        }
        if (fromPosition == toPosition) {
            view.showToast("换的同一个 position = ${fromPosition}")
            return
        }
        var item = model.list.get(fromPosition)
        removeItem(fromPosition)
        addItem(toPosition, item)
    }

    private fun checkNum(num: Int): Boolean {
        if (num > model.list.size || num < 0) {
            view.showToast("非法输入")
            return false
        }
        return true
    }

}