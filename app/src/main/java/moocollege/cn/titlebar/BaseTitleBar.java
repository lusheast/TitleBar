package moocollege.cn.titlebar;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zsd on 2017/8/16 10:15
 * desc:头部的导航栏的基类
 */

public abstract class BaseTitleBar<P extends BaseTitleBar.Builder.BaseTitleBarParams> implements ITitleBar {


    private P mParams;

    private View mTitleBarView;

    public BaseTitleBar(P params) {
        this.mParams = params;
        createAndBindView();
    }

    /**
     * 设置文本
     * @param viewId
     * @param text
     */
    protected void setText(int viewId, String text) {
        TextView tv = findViewById(viewId);
        if(!TextUtils.isEmpty(text)){
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);
        }
    }

    /**
     * 标题栏颜色设置
     * @param viewId
     * @param titleBarColor
     */
    protected void setTitleBarColor(int viewId, int titleBarColor) {
        RelativeLayout relativeLayout = findViewById(viewId);
        if(titleBarColor!=0){
            relativeLayout.setBackgroundColor(mParams.mContext.getResources().getColor(titleBarColor));
        }
    }

    /**
     * 设置文字颜色
     * @param viewId
     * @param textColor
     */
    protected void setTextColor(int viewId, int textColor) {
        TextView tv = findViewById(viewId);
        if(textColor!=0){
            tv.setTextColor(mParams.mContext.getResources().getColor(textColor));
        }
    }

    /**
     * 设置icon
     * @param viewId
     * @param res
     */
    protected void setIcon(int viewId,int res){
        ImageView iv = findViewById(viewId);
        if (res!=0){
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(res);
        }
    }

    /**
     * 设置点击
     * @param viewId
     * @param listener
     */
    protected void setOnClickListener(int viewId,View.OnClickListener listener){
        findViewById(viewId).setOnClickListener(listener);
    }


    /**
     * 绑定和创建View
     */
    private void createAndBindView() {
        //创建View
        if(mParams.mParent == null){
            // 获取activity的根布局
            ViewGroup activityRoot = (ViewGroup) ((Activity)(mParams.mContext))
                    .findViewById(android.R.id.content);
            mParams.mParent = (ViewGroup) activityRoot.getChildAt(0);
        }
        if(mParams.mParent == null){
            return;
        }

        mTitleBarView = LayoutInflater.from(mParams.mContext).
                inflate(bindLayoutId(), mParams.mParent, false);
        //添加
        mParams.mParent.addView(mTitleBarView, 0);

        applyView();
    }

    public <T extends View> T findViewById(int viewId){
        return (T)mTitleBarView.findViewById(viewId);
    }



    public P getParams() {
        return mParams;
    }

    // Builder仿照系统写的dialo就是这样，参数Params
    public abstract static class Builder {

        public Builder(Context context, ViewGroup parent) {

        }

        public abstract BaseTitleBar builder();

        public static class BaseTitleBarParams {
            public Context mContext;
            public ViewGroup mParent;

            public BaseTitleBarParams(Context context, ViewGroup parent) {
                this.mContext = context;
                this.mParent = parent;
            }
        }
    }
}
