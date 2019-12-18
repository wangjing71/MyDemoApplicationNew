package com.wj.mydemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.gyf.immersionbar.ImmersionBar
import com.tbruyelle.rxpermissions2.RxPermissions


/**
 * Created by Administrator on 2018/1/4.
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var rxPermissions: RxPermissions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        ImmersionBar.with(this).init()
        rxPermissions = RxPermissions(this)
        initView()
        initData()
        setEvent()
    }

    protected abstract fun setLayoutId(): Int

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun setEvent()

}