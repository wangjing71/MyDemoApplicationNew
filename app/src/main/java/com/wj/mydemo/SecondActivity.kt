package com.wj.mydemo

import butterknife.BindView
import android.util.Log
import android.widget.Button


class SecondActivity : BaseActivity() {
    @JvmField
    @BindView(R.id.button)
    var button: Button? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_second
    }

    override fun initView() {
        Log.i("====","initView")
    }


    override fun initData() {

    }

    override fun setEvent() {

    }
}
