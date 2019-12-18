package com.wj.mydemo

import android.widget.EditText
import android.R.id
import butterknife.BindView
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.Button


class MainActivity : BaseActivity() {
    @BindView(R.id.button)
    var button: Button? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        Log.i("====","initView")
    }


    override fun initData() {

    }

    override fun setEvent() {

    }
}
