package com.wj.mydemo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import butterknife.BindView
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


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
        EventBus.getDefault().register(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun setEvent() {
        button!!.setOnClickListener {
            if(isIgnoringBatteryOptimizations){
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show()
                requestIgnoreBatteryOptimizations()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetMessage(message: MessageWrap) {
        Log.i("====", "onGetMessage")

    }

    /*
    * 判断我们的应用是否在白名单中
    * */
    private val isIgnoringBatteryOptimizations: Boolean
        @RequiresApi(api = Build.VERSION_CODES.M)
        get() {
            var isIgnoring = false
            val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
            if (powerManager != null) {
                isIgnoring = powerManager.isIgnoringBatteryOptimizations(packageName)
            }
            return isIgnoring
        }


    @RequiresApi(api = Build.VERSION_CODES.M)
    fun requestIgnoreBatteryOptimizations() {
        try {
            val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
            intent.data = Uri.parse("package:$packageName")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}
