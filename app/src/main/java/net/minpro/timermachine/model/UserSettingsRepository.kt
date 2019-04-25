package net.minpro.timermachine.model

import android.content.Context
import net.minpro.timermachine.MyApplication
import net.minpro.timermachine.R
import net.minpro.timermachine.util.ThemeId

class UserSettingsRepository {

    private val context = MyApplication.appContext
    private val pref = context.getSharedPreferences(
        UserSettings.PREF_USERSETTINGS_NAME, Context.MODE_PRIVATE
    )
    private val editor = pref.edit()

    fun loadUserSettings(): UserSettings {
        return UserSettings(
            themeId = pref.getInt(UserSettingsPrefKey.THEME_ID.name, ThemeId.KITAGAWA),
            themeName = context.getString(
                pref.getInt(
                    UserSettingsPrefKey.THEME_NAME_STR_ID.name,
                    R.string.theme_kitagawa
                )
            )
        )
    }

    fun setTheme(selectedItemId: Int): String {
        editor.putInt(UserSettingsPrefKey.THEME_ID.name, selectedItemId).commit()
        val themeNameStrId = when (selectedItemId) {
            0 -> R.string.theme_kitagawa
            1 -> R.string.theme_nagano
            2 -> R.string.theme_ishihara
            3 -> R.string.theme_arimura
            else -> {0}
        }
        editor.putInt(UserSettingsPrefKey.THEME_NAME_STR_ID.name, themeNameStrId).commit()
        return loadUserSettings().themeName
    }
}