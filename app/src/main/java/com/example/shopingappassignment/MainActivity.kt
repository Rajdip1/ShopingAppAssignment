package com.example.shopingappassignment

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.shopingappassignment.ui.theme.ShopingAppAssignmentTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        //by default home fragment will be appear
        replaceFrameWithFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> replaceFrameWithFragment(SearchFragment())
                R.id.item2 -> replaceFrameWithFragment(CategoriesFragment())
                R.id.item3 -> replaceFrameWithFragment(HomeFragment())
                R.id.item4 -> replaceFrameWithFragment(CartFragment())
                R.id.item5 -> replaceFrameWithFragment(AccountFragment())
                else ->{
                    //something
                }
            }
            true
        }
    }

    private fun replaceFrameWithFragment(frag: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransection = fragmentManager.beginTransaction()
        fragmentTransection.replace(R.id.frameLayout,frag)
        fragmentTransection.commit()
    }
}

