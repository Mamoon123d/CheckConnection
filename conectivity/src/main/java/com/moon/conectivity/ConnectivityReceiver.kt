package com.moon.conectivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

public class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
    connectivityReceiverListener?.onNetworkConnectionChanged(isConnectedOrConnecting(p0!!))
    }

    private fun isConnectedOrConnecting(context: Context):Boolean{
       val conMgr=context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager

        val networkInfo=conMgr.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnectedOrConnecting
    }

   public interface ConnectivityReceiverListener{
        fun onNetworkConnectionChanged(isConnected :Boolean)
    }
    companion object{
        var connectivityReceiverListener:ConnectivityReceiverListener?=null
    }
}