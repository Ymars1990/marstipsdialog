package marsplanet.mars.com.marstipsdialog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mars on 2017/9/15.
 */

public class MyUtils {
    /**
     * 获取系统时间
     * Context mCtxt:上下文
     * int getIndex：返回字符串的索引 0、年月日 1、年 2、月 3、日  4、时 5、分 6、秒 7、时分秒 8、格式化日期时间
     * String fmt;
     */
    public static Object getSysTime(Context mCtxt, int getIndex, String fmt){
        try {
            long time=System.currentTimeMillis();
            Calendar mCalendar= Calendar.getInstance();
            mCalendar.setTimeInMillis(time);
            int mYear=mCalendar.get(Calendar.YEAR);
            int mMonth=mCalendar.get(Calendar.MONTH);
            int mDay=mCalendar.get(Calendar.DATE);
            int mHour=mCalendar.get(Calendar.HOUR);
            int mMinuts=mCalendar.get(Calendar.MINUTE);
            int mSecond=mCalendar.get(Calendar.SECOND);
            DateFormat df = null;
            String dateTime = null;
            try {
                df = new SimpleDateFormat(fmt);
                 dateTime = df.format(new Date());
            } catch (Exception e) {
                df = new SimpleDateFormat("yyMMdd HH:mm:ss");
                dateTime = df.format(new Date());
                e.printStackTrace();
            }


            switch (getIndex){
                case 0:
                    df = new SimpleDateFormat("YYMMDD");
                    return df.format(new Date());
                case 1:
                    return mYear;
                case 2:
                    return mMonth;
                case 3:
                    return mDay;
                case 4:
                    return mHour;
                case 5:
                    return mMinuts;
                case 6:
                    return mSecond;
                case 7:
                    df = new SimpleDateFormat("HH:mm:ss");
                    return df.format(new Date());
                case 8:
                    return dateTime;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断对象是否为空或者String 为""
     */
    public static boolean objIsNotEmpty(Object obj){
        if(obj instanceof  String){
            if(obj!=null&&!"".equals((String)obj)){
                return true;
            }else{
                return false;
            }
        }else{
            if(obj!=null){
                return true;
            }else{
                return false;
            }
        }
    }
    /**
     * 判断String 只有一种字符"
     */
    public static  boolean isOnlyOneChar(String src){
        if(src!=null) {
            for (int i = 0; i < src.length()-1;i++){
                if(src.charAt(i)!=src.charAt(i+1)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }


    public static String StringToDate(String dateStr, String dateFormatStr) {
        if(objIsNotEmpty(dateStr)&&objIsNotEmpty(dateFormatStr)) {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormatStr);
            Date curDate = new Date(Long.parseLong(dateStr));
            return formatter.format(curDate);
        }else{
            return "";
        }
    }

    /**
     * Handler 处理
     *
     */
    public static void HandlerMessage(Message msg, int what, Object obj, Handler handler,long delayMillis){
        msg = null;
        msg = new Message();
        msg.what = what;
        if (obj != null) {
            msg.obj = obj;
        }
        handler.sendMessageDelayed(msg, delayMillis);
    }

    public static  int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

    public static Object getBeanParams(Object src,Object def){
            if(objIsNotEmpty(src)){
                return src;
            }else{
                return def;
            }
    }
}
