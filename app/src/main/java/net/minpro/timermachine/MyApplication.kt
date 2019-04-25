package net.minpro.timermachine

import android.app.Application
import android.content.Context
import net.minpro.timermachine.data.ThemeData
import net.minpro.timermachine.util.ThemeId

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        themeList = setThemeData()
    }

    private fun setThemeData(): ArrayList<ThemeData> {
        return arrayListOf(
            ThemeData(
                ThemeId.KITAGAWA,
                R.string.theme_kitagawa
            ),
            ThemeData(
                ThemeId.NAGANO,
                R.string.theme_nagano
            ),
            ThemeData(
                ThemeId.ISHIHARA,
                R.string.theme_ishihara
            ),
            ThemeData(
                ThemeId.ARIMURA,
                R.string.theme_arimura
            )
        )
    }

    companion object {
        lateinit var appContext: Context
        lateinit var themeList: ArrayList<ThemeData>
    }
}