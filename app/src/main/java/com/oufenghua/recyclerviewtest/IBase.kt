package com.oufenghua.recyclerviewtest

interface IBase{

    interface View<P>{
        var presenter:P?
    }

    interface Presenter{
        fun start()
    }

}