package io.github.zachtib.coloutodo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import io.github.zachtib.coloutodo.R
import io.github.zachtib.coloutodo.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.transaction {
                replace(R.id.container, MainFragment.newInstance())
            }
        }
    }

    fun navigateToScreen(screen: Screen) {
        supportFragmentManager.transaction {
            replace(R.id.container, screen.getFragment())
        }
    }

}
