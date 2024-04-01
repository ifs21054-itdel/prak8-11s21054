package com.ifs21054.youtube

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ifs21054.youtube.fragment.AccountFragment
import com.ifs21054.youtube.fragment.ExploreFragment
import com.ifs21054.youtube.fragment.HomeFragment
import com.ifs21054.youtube.fragment.LibraryFragment
import com.ifs21054.youtube.fragment.SubscriptionFragment


class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        // Set judul toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Youtube"
        setSupportActionBar(toolbar)

        // Inisialisasi fragment
        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val subscriptionFragment = SubscriptionFragment()
        val libraryFragment = LibraryFragment()
        val accountFragment = AccountFragment()

        // Menampilkan fragment awal
        makeCurrentFragment(homeFragment)

        // Bottom navigation setup
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_explore -> makeCurrentFragment(exploreFragment)
                R.id.menu_subscription -> makeCurrentFragment(subscriptionFragment)
                R.id.menu_library -> makeCurrentFragment(libraryFragment)
                R.id.menu_account -> makeCurrentFragment(accountFragment)
            }
            true
        }
    }

    // Function untuk menampilkan fragment
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }
}
