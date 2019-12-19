package com.wj.mydemo

/**
 * author wangjing
 * Date 2019/12/19
 * Description
 */
class MessageWrap(var type: Int, var message: String?) {

    override fun toString(): String {

        return "type=$type--message= $message"
    }

    companion object {
        val TYPE_UNLOGIN = 0x1001
        val TYPE_BAGCLICK = 0x1002
    }

}
