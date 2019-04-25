package net.minpro.timermachine.model

data class UserSettings (
    var themeId: Int,
    var themeName: String) {

    companion object {
        const val PREF_USERSETTINGS_NAME = "net.minpro.timermachine.user_settings"
    }
}

enum class UserSettingsPrefKey {
    THEME_ID,
    THEME_NAME_STR_ID,
}