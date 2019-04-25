package net.minpro.timermachine.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.minpro.timermachine.R
import net.minpro.timermachine.view.dialog.SexSelectDialog
import net.minpro.timermachine.view.dialog.ThemeSelectDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.screen_container,
                    MainFragment()
                )
                .commit()
        }

        btmNavi.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_select_a -> {
                    SexSelectDialog().show(supportFragmentManager, "sex")
                    true
                }
                R.id.item_select_b -> {
                    ThemeSelectDialog().show(supportFragmentManager, "theme")
                    true
                }
                R.id.item_select_c -> {
                    true
                }
                else -> { false }
            }
        }

    }
}
