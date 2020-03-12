package com.example.myapp.ui.directmessage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.ui.main.Model
import com.example.myapp.ui.main.MyAdapter
import kotlinx.android.synthetic.main.fragment_ledger.view.*
import org.w3c.dom.Text


class DirectMessageFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_directmessage, container, false)
        val button = root.findViewById<ImageView>(R.id.sendButton)
        val sendText= root.findViewById<TextView>(R.id.editText).getText()
        val bubble = root.findViewById<TextView>(R.id.message_body)
        val listView = root.findViewById<ListView>(R.id.messages_view)
        val al = ArrayList<TextView>()

        button.setOnClickListener{
            //bubble.setText(sendText)
            Toast.makeText(root.context, sendText, Toast.LENGTH_LONG).show()
        }

        return root
    }
}
