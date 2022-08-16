package com.example.delicorrientazos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.delicorrientazos.ui.favorites.FavoritesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val favoritesFragment = FavoritesFragment()

        val loginButton = findViewById<android.widget.Button>(R.id.login_button)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorite -> {
                    setCurrentFragment(favoritesFragment)
                }
                else -> {
                    setCurrentFragment(favoritesFragment)
                }
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }
}