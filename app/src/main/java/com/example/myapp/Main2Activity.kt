package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapp.ui.directmessage.DirectMessageFragment
import com.example.myapp.ui.globalmessage.GlobalMessageFragment
import com.example.myapp.ui.ledger.LedgerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main2Activity : AppCompatActivity() {

    var directMessageFragment : DirectMessageFragment = DirectMessageFragment()
    var globalMessageFragment : GlobalMessageFragment = GlobalMessageFragment()
    var ledgerFragment : LedgerFragment = LedgerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, directMessageFragment, "putDirectMessageFragment")
                .commit()
        }

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            menuItem ->
        when (menuItem.itemId) {
            R.id.navigation_directmessage -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, directMessageFragment, "putDirectMessageFragment")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_globalmessage -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, globalMessageFragment, "putGlobalMessageFragment")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ledger -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, ledgerFragment, "putLedgerFragment")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

}
