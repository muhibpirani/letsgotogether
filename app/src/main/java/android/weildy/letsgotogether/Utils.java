package android.weildy.letsgotogether;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

/**
 * Created by muhib on 10/25/2017.
 */
public class Utils {

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static boolean isValidEmail(String email) {
        if (email != null)
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        else
            return false;
    }

}
