package com.delta.chatscreen

import android.app.Activity
import android.database.DataSetObserver
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.myapp.R
import com.example.myapp.ui.directmessage.ChatMessage

class MainActivity1 : Activity() {
    private var chatArrayAdapter: ChatArrayAdapter? = null
    private var listView: ListView? = null
    private var chatText: EditText? = null
    private var buttonSend: Button? = null
    private var side = false
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSend = findViewById<View>(R.id.send) as Button
        listView = findViewById<View>(R.id.msgview) as ListView
        chatArrayAdapter = ChatArrayAdapter(applicationContext, R.layout.right)
        listView!!.adapter = chatArrayAdapter
        chatText = findViewById<View>(R.id.msg) as EditText
        chatText!!.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                sendChatMessage()
            } else false
        }
        buttonSend!!.setOnClickListener { sendChatMessage() }
        listView!!.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
        listView!!.adapter = chatArrayAdapter
        //to scroll the list view to bottom on data change
        chatArrayAdapter!!.registerDataSetObserver(object : DataSetObserver() {
            override fun onChanged() {
                super.onChanged()
                listView!!.setSelection(chatArrayAdapter!!.count - 1)
            }
        })
    }

    private fun sendChatMessage(): Boolean {
        chatArrayAdapter!!.add(ChatMessage(side, chatText!!.text.toString()))
        chatText!!.setText("")
        side = !side
        return true
    }

    companion object {
        private const val TAG = "ChatActivity"
    }
}