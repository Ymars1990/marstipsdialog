package marsplanet.mars.com.marstipsdialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mars on 2017/9/15.
 */

public class TextViewUtils {
    public static void setText(Object content, View v,String defaultCt){
        if(v instanceof TextView){
            if(MyUtils.objIsNotEmpty(content)) {
                ((TextView) v).setText((String) content);
            }else{
                if(MyUtils.objIsNotEmpty(defaultCt))
                    ((TextView) v).setText(defaultCt);
                else
                    ((TextView) v).setText(defaultCt);
            }
        }else if(v instanceof EditText){
            ((EditText)v).setText((String)content);
            if(MyUtils.objIsNotEmpty(content)) {
                ((EditText) v).setText((String) content);
            }else{
                if(MyUtils.objIsNotEmpty(defaultCt))
                    ((EditText) v).setText(defaultCt);
                else
                    ((EditText) v).setText(defaultCt);
            }
        }
    }
}
