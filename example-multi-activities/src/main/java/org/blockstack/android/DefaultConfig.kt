package org.blockstack.android

import android.content.Context
import androidx.preference.PreferenceManager
import org.blockstack.android.sdk.Scope
import org.blockstack.android.sdk.SessionStore
import org.blockstack.android.sdk.model.toBlockstackConfig

val defaultConfig = "https://flamboyant-darwin-d11c17.netlify.com".toBlockstackConfig(
        kotlin.arrayOf(Scope.StoreWrite, Scope.Email))


class SessionStoreProvider {
    companion object {
        private var instance: SessionStore? = null
        fun getInstance(context: Context): SessionStore {
            var sessionStore = instance
            if (sessionStore == null) {
                sessionStore = SessionStore(PreferenceManager.getDefaultSharedPreferences(context))
                instance = sessionStore
            }
            return sessionStore
        }
    }
}
