package com.mostafa.fci.recyclerviewdemo

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = WordRecyclerViewAdapter(this)
        recyclerView.adapter = adapter

        // save call ".let"
        val uri:Uri? = intent.data
        var msg:String? = intent.getStringExtra("msg")

        uri?.let {
            contentResolver.query(uri, null, null, null,null)
        }
        msg?.let {
            //do this if msg not null value
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }


    }
}
