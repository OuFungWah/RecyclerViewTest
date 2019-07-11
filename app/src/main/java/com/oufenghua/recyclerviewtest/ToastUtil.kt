package com.oufenghua.recyclerviewtest

import android.app.Application
import android.content.Context
import android.widget.Toast

class ToastUtil {
    companion object {
        private var toast: Toast? = null
        private lateinit var context: Context

        fun init(context: Application) {
            ToastUtil.context = context
        }

        fun showShort(content: String = "无内容") {
            toast?.cancel()
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
            toast?.show()
        }

        fun showLong(content: String = "无内容") {
            toast?.cancel()
            toast = Toast.makeText(context, content, Toast.LENGTH_LONG)
            toast?.show()
        }
    }

}