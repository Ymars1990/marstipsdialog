package marsplanet.mars.com.marstipsdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mars on 2017/9/18.
 */

public class TipsDialog {
    private LinearLayout td_layout;
    private LinearLayout td_title_layout;
    private LinearLayout td_ct_layout;
    private TextView td_title_left_tv;
    private TextView td_title_mid_tv;
    private TextView td_title_right_tv;
    private TextView td_ct_tv;
    private TextView td_left_bt;
    private TextView td_right_bt;
    private ImageView td_ct_iv;
    private View tipsBtdivideline;


    private Context context;
    private Dialog dialog = null;
    private Display display = null;

    public TipsDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public TipsDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.tipdialog_layout,
                null);
        td_layout = (LinearLayout) view.findViewById(R.id.td_layout);
        td_title_layout = (LinearLayout) view.findViewById(R.id.td_title_layout);
        td_ct_layout = (LinearLayout) view.findViewById(R.id.td_ct_layout);
        td_title_left_tv = (TextView) view.findViewById(R.id.td_title_left_tv);
        td_title_mid_tv = (TextView) view.findViewById(R.id.td_title_mid_tv);
        td_title_right_tv = (TextView) view.findViewById(R.id.td_title_right_tv);
        td_ct_tv = (TextView) view.findViewById(R.id.td_ct_tv);
        td_left_bt = (TextView) view.findViewById(R.id.td_left_bt);
        td_right_bt = (TextView) view.findViewById(R.id.td_right_bt);
        td_ct_iv = (ImageView) view.findViewById(R.id.td_ct_iv);
        tipsBtdivideline = (View) view.findViewById(R.id.tipsBtdivideline);
        dialog = new Dialog(context, R.style.RoundDialogStyle);
        Window dialogWin = dialog.getWindow();
        dialogWin.setWindowAnimations(R.style.scaleWindowAnim); // 设置窗口弹出、关闭动画

        dialog.setContentView(view);
        // 调整dialog背景大小
        td_layout.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.8), LinearLayout.LayoutParams.MATCH_PARENT));
        return this;
    }


    // 设置返回键是否关闭dialog
    public void setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
    }

    public void show() {
        try {
            if (MyUtils.objIsNotEmpty(dialog) && !dialog.isShowing()) {
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        try {
            if (MyUtils.objIsNotEmpty(dialog) && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            td_title_left_tv.setOnClickListener(onClickListener);
            td_title_right_tv.setOnClickListener(onClickListener);
            td_left_bt.setOnClickListener(onClickListener);
            td_right_bt.setOnClickListener(onClickListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTdctIv(int rid) {
        try {
            td_ct_iv.setImageResource(rid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(String title, String ctx, String titleLeft, String titleRight, String leftBt, String rightBt) {
        try {
            TextViewUtils.setText(title, td_title_mid_tv, FinaTextString.TD_Tips);
            TextViewUtils.setText(ctx, td_ct_tv, FinaTextString.TD_CONTENT);
            if (MyUtils.objIsNotEmpty(titleLeft)) {
                td_title_left_tv.setVisibility(View.VISIBLE);
            } else {
                td_title_left_tv.setVisibility(View.GONE);
            }
            TextViewUtils.setText(titleRight, td_title_left_tv, FinaTextString.CONFIRM);
            if (MyUtils.objIsNotEmpty(titleRight)) {
                LogUtills.LogShow("titleRight", titleRight);
                td_title_right_tv.setVisibility(View.VISIBLE);
            } else {
                td_title_right_tv.setVisibility(View.GONE);
            }
            TextViewUtils.setText(titleRight, td_title_right_tv, FinaTextString.CONFIRM);
            TextViewUtils.setText(leftBt, td_left_bt, FinaTextString.CANCEL);
            TextViewUtils.setText(rightBt, td_right_bt, FinaTextString.CONFIRM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBtVisiable(int btVisiableCount) {
        try {
            if (btVisiableCount == 1) {
                td_left_bt.setVisibility(View.GONE);
                tipsBtdivideline.setVisibility(View.GONE);
                td_right_bt.setBackgroundResource(R.drawable.td_bt_single_selector);
            } else {
                td_left_bt.setVisibility(View.VISIBLE);
                tipsBtdivideline.setVisibility(View.VISIBLE);
                td_right_bt.setBackgroundResource(R.drawable.td_bt_right_selector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
