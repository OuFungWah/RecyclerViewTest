package com.oufenghua.recyclerviewtest

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ToastUtil.init(this)
    }

}