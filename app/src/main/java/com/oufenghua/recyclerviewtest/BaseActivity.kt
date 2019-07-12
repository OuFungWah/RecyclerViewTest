package com.oufenghua.recyclerviewtest

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Activity 的基类
 *
 * 创建 Activity 时方法执行顺序
 * 1、getLayout()
 * 2、createPresenter()
 * 3、initData()
 * 4、initView()
 * 5、initObserver()
 *
 * 销毁 Activity 时方法执行顺序
 * 1、release()
 * */
abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        createPresenter()
        initData()
        initView()
        initObserver()
    }

    /**
     * 创建 Presenter
     * */
    abstract fun createPresenter()

    /**
     * 获取 Layout 的 id
     * @return 返回资源文件的 id
     */
    abstract fun getLayout(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化组件
     */
    abstract fun initView()

    /**
     * 初始化监听器
     */
    abstract fun initObserver()

    /**
     * 释放资源
     */
    abstract fun release()

    override fun onDestroy() {
        super.onDestroy()
        release()
    }

}