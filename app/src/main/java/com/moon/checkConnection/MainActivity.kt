package com.moon.checkConnection

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.moon.conectivity.ConnectivityReceiver

class MainActivity : AppCompatActivity() , ConnectivityReceiver.ConnectivityReceiverListener {
    lateinit var snackbar:Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }

    private fun showNetworkMessage(isConnected: Boolean) {

    if(!isConnected){
       /* snackbar=Snackbar.make(findViewById(R.id.container),"You are Offline",Snackbar.LENGTH_LONG)
        snackbar?.duration=BaseTransientBottomBar.LENGTH_INDEFINITE
        snackbar?.show()*/
        Toast.makeText(this, "Offline", Toast.LENGTH_SHORT).show()
    }else{
       // snackbar?.dismiss()
        Toast.makeText(this, "OnLine", Toast.LENGTH_SHORT).show()

    }

    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener=this;
    }
}