package com.wj.mydemo

import android.content.Intent
import butterknife.BindView
import android.util.Log
import android.widget.Button
import org.greenrobot.eventbus.EventBus


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
        button!!.setOnClickListener {
            EventBus.getDefault().post(MessageWrap(MessageWrap.TYPE_BAGCLICK, null))
        }
    }
}
