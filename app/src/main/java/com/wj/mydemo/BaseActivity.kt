package com.wj.mydemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife

import com.gyf.immersionbar.ImmersionBar
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * Created by Administrator on 2018/1/4.
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var rxPermissions: RxPermissions? = null
    protected var barView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        ButterKnife.bind(this)
        ImmersionBar
            .with(this)
            .navigationBarColorTransform(R.color.blue_primary)
            //                .navigationBarDarkIcon(true) //导航栏图标是深色，不写默认为亮色
            //                .fullScreen(true)
            .navigationBarAlpha(1.0f)  //导航栏透明度，不写默认0.0F
            .init()
        rxPermissions = RxPermissions(this)
        barView = findViewById(R.id.barView)
        ImmersionBar.setStatusBarView(this, barView)
        initView()
        initData()
        setEvent()
    }

    protected abstract fun setLayoutId(): Int

    protected open fun initView() {}

    protected abstract fun initData()

    protected abstract fun setEvent()

}