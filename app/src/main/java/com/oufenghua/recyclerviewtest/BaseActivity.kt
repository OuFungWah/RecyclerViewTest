package com.oufenghua.recyclerviewtest

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        createPresenter()
        initData()
        initView()
        initObserver()
    }

    abstract fun createPresenter()

    abstract fun getLayout(): Int

    abstract fun initData()

    abstract fun initView()

    abstract fun initObserver()

    abstract fun release()

    override fun onDestroy() {
        super.onDestroy()
        release()
    }

}