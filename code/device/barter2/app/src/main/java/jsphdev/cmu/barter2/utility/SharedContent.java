package jsphdev.cmu.barter2.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import jsphdev.cmu.barter2.entities.User;

/**
 * Created by Nan on 12/10/2015.
 */
public class SharedContent {
    static public User getCurrentUser(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String userJson = preferences.getString("CurrentUser", "");
        if (userJson.isEmpty() || userJson.equals("")) {
            return null;
        }

        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);
        return user;
    }

    static public void clearCurrentUser(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String userJson = preferences.getString("CurrentUser", "");
        preferences.edit().clear().commit();
    }

    static public void updateCurrentUser(Context context, User user) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        editor.putString("CurrentUser", userJson);
        editor.commit();
    }
}
