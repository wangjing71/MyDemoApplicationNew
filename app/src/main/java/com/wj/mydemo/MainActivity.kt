package com.wj.mydemo

import android.content.Intent
import butterknife.BindView
import android.util.Log
import android.widget.Button


class MainActivity : BaseActivity() {

    @JvmField
    @BindView(R.id.button)
    var button: Button? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        Log.i("====", "initView")
    }


    override fun initData() {

    }

    override fun setEvent() {
        button!!.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
