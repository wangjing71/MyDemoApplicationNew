package com.wj.mydemo

import android.content.Intent
import butterknife.BindView
import android.util.Log
import android.widget.Button
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity() {

    @BindView(R.id.button)
    lateinit var button: Button

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        Log.i("====", "initView")
    }

    override fun initData() {
        EventBus.getDefault().register(this)
    }

    override fun setEvent() {
        button!!.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetMessage(message: MessageWrap) {
        Log.i("====","onGetMessage")

    }
}
