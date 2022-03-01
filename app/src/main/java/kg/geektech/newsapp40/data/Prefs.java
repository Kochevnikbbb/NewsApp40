package kg.geektech.newsapp40.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", context.MODE_PRIVATE);
    }

    public void saveBoardState() {
        preferences.edit().putBoolean("board_state", true).apply(); //сохраняет видел ли человек boardFragmen
    }

    public boolean isBoardShown() {
        return preferences.getBoolean("board_state", false);
    }

    public void saveETName(String nameEt) {
        preferences.edit().putString("saveedittext",nameEt).apply();
    }
    public String getETName(){
        return preferences.getString("saveedittext","");
    }
    public void saveAvatar(String image){
        preferences.edit().putString("sfdhhbd",image.toString()).apply();
    }
    public String getAvatar(){
        return preferences.getString("sfdhhbd","");
    }

    public void cleanPrefs(){
        preferences.edit().clear().apply();
    }

}
