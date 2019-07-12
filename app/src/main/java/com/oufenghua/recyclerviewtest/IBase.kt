package com.oufenghua.recyclerviewtest

/**
 * MVP 模式的 VP 基类
 */
interface IBase{

    interface View<P>{
        var presenter:P?
    }

    interface Presenter{
        fun start()
    }

}