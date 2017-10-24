package android.weildy.letsgotogether;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by muhib on 9/30/2017.
 */
public class AppPreference {

    private static AppPreference appPreference;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    private AppPreference(Context context) {
        mPref = context.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public static AppPreference getInstance(Context context) {
        if (appPreference == null) {
            appPreference = new AppPreference(context.getApplicationContext());
        }
        return appPreference;
    }


    // GET SET
    public void setisLogin(boolean isLogin) {
        mEditor.putBoolean(Constants.IS_LOGGED_IN, isLogin);
        mEditor.commit();
    }

    private boolean getIsLogin() {
        return mPref.getBoolean(Constants.IS_LOGGED_IN, false);
    }
}
