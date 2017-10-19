package marsplanet.mars.com.marstipsdialog;

import android.util.Log;

/**
 * Created by mars on 2017/9/15.
 */

public class LogUtills {
    // log打印
    public static void LogShow(String tag, Object obj) {
        try {

            if (obj != null) {
                if (obj instanceof String) {
                    if (MyUtils.objIsNotEmpty((String) obj))
                        Log.i(tag, (String) obj);
                    else
                        Log.i(tag, "空值");
                } else if (obj instanceof Integer) {
                    Log.i(tag, "" + ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    Log.i(tag, "" + (Long) obj);
                } else if (obj instanceof Boolean) {
                    Log.i(tag, "" + (Boolean) obj);
                }
            } else {
                Log.i(tag, "空值");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
