package com.example.myapp.ui.ledger

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.ui.main.Model
import com.example.myapp.ui.main.MyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class LedgerFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    var list = mutableListOf<Model>()
    private lateinit var listView: ListView
    private lateinit var root: View
    private lateinit var thisFragment:LedgerFragment

    init{
        list.add(Model("Yelahanka", "Satellite bus station", R.drawable.helpwe))
        list.add(Model("SVIT", "Canteen", R.drawable.btn_rounded))
        list.add(Model("SVIT", "Boys Hostel"))
        Log.d("LedgerFragment", "Init")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_ledger, container, false)
        listView = root.findViewById<ListView>(R.id.listView)
        //  list.add(Model("BadBOi3", "Hello!!!", R.drawable.btn_rounded))

        listView.adapter = MyAdapter(root.context, R.layout.row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id:Long ->
            Toast.makeText(root.context, "Clicked on" + list[position].description, Toast.LENGTH_LONG).show()
        }
        val add = root.findViewById<FloatingActionButton>(R.id.add)
        add.setOnClickListener{
            val intent = Intent(root.context, TakeInput::class.java)
            intent.putExtra("key", "value")
            startActivityForResult(intent, 6969)
        }

        return root

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 6969){
            if(resultCode == 7070){
                val location = data!!.getStringExtra("Location")
                val landmark = data!!.getStringExtra("Landmark")

                list.add(Model(location, landmark, R.drawable.btn_rounded))
                listView.adapter = MyAdapter(root.context, R.layout.row, list)
            }
        }
    }


}