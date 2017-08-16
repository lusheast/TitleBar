package moocollege.cn.titlebar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zsd on 2017/8/16 10:28
 * desc:通用标题栏
 */

public class CommonTitleBar<T extends CommonTitleBar.Builder.CommonTitleBarParams> extends BaseTitleBar<CommonTitleBar.Builder.CommonTitleBarParams> {


    public CommonTitleBar(CommonTitleBar.Builder.CommonTitleBarParams params) {
        super(params);
    }


    @Override
    public int bindLayoutId() {
        return R.layout.title_bar;
    }

    @Override
    public void applyView() {


        // 绑定效果

        setTitleBarColor(R.id.title_bar, getParams().mTitleBarColor);

        setText(R.id.left_tv, getParams().mLeftText);
        setTextColor(R.id.left_tv, getParams().mLeftTextColor);
        setIcon(R.id.left_icon, getParams().mLeftIconRes);

        setText(R.id.title, getParams().mTitle);
        setTextColor(R.id.title, getParams().mTitleColor);
        setIcon(R.id.title_icon, getParams().mTitleIconRes);


        setText(R.id.right_text, getParams().mRightText);
        setTextColor(R.id.right_text, getParams().mRightTextColor);
        setIcon(R.id.right_icon, getParams().mRightIconRes);

        // 左边 要写一个默认的  finishActivity
        setOnClickListener(R.id.left_icon, getParams().mLeftClickListener);
        setOnClickListener(R.id.left_tv, getParams().mLeftClickListener);

        setOnClickListener(R.id.title, getParams().mCenterClickListener);
        setOnClickListener(R.id.title_icon, getParams().mCenterClickListener);

        setOnClickListener(R.id.right_text, getParams().mRightClickListener);
        setOnClickListener(R.id.right_icon, getParams().mRightClickListener);

    }

    public static class Builder extends BaseTitleBar.Builder {

        CommonTitleBarParams P;


        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            P = new CommonTitleBarParams(context, parent);
        }

        public Builder(Context context) {
            super(context, null);
            P = new CommonTitleBarParams(context, null);
        }

        @Override
        public CommonTitleBar builder() {
            CommonTitleBar commonTitleBar = new CommonTitleBar(P);
            return commonTitleBar;
        }

        //设置所有效果

        /**
         * 标题栏颜色设置
         * @param color
         * @return
         */
        public CommonTitleBar.Builder setTitleBarColor(int color) {
            P.mTitleBarColor = color;
            return this;
        }

        /**
         * 设置左边文字
         *
         * @param leftText
         * @return
         */
        public CommonTitleBar.Builder setLeftText(String leftText) {
            P.mLeftText = leftText;
            return this;
        }

        /**
         * 设置左边文字颜色
         *
         * @param color
         * @return
         */
        public CommonTitleBar.Builder setLeftTextColor(int color) {
            P.mLeftTextColor = color;
            return this;
        }

        /**
         * 设置左边的图片
         */
        public CommonTitleBar.Builder setLeftIcon(int leftIconRes) {
            P.mLeftIconRes = leftIconRes;
            return this;
        }

        /**
         * 设置标题
         *
         * @param title
         * @return
         */
        public CommonTitleBar.Builder setTitle(String title) {
            P.mTitle = title;
            return this;
        }

        /**
         * 设置标题颜色
         *
         * @param color
         * @return
         */
        public CommonTitleBar.Builder setTitleColor(int color) {
            P.mTitleColor = color;
            return this;
        }

        /**
         * 设置中间的图标
         *
         * @param titleIconRes
         * @return
         */
        public CommonTitleBar.Builder setTitleIcon(int titleIconRes) {
            P.mTitleIconRes = titleIconRes;
            return this;
        }

        /**
         * 设置右边文字
         *
         * @param rightText
         * @return
         */
        public CommonTitleBar.Builder setRightText(String rightText) {
            P.mRightText = rightText;
            return this;
        }

        /**
         * 设置右边文字颜色
         *
         * @param color
         * @return
         */
        public CommonTitleBar.Builder setRightTextColor(int color) {
            P.mRightTextColor = color;
            return this;
        }

        /**
         * 设置右边的图片
         */
        public CommonTitleBar.Builder setRightIcon(int rightRes) {
            P.mRightIconRes = rightRes;
            return this;
        }

        /**
         * 设置左边的点击事件
         */
        public CommonTitleBar.Builder
        setLeftClickListener(View.OnClickListener leftListener) {
            P.mLeftClickListener = leftListener;
            return this;
        }

        /**
         * 设置中间的点击事件
         */
        public CommonTitleBar.Builder setTitleClickListener(View.OnClickListener titleListener) {
            P.mCenterClickListener = titleListener;
            return this;
        }

        /**
         * 设置右边的点击事件
         */
        public CommonTitleBar.Builder setRightClickListener(View.OnClickListener rightListener) {
            P.mRightClickListener = rightListener;
            return this;
        }



        public static class CommonTitleBarParams extends
                BaseTitleBar.Builder.BaseTitleBarParams {


            // 所有效果放置
            public String mLeftText;//左边文字
            public int mLeftTextColor;//左边文字颜色
            public int mLeftIconRes;//左边图片
            public int mTitleBarColor;//标题栏颜色

            public String mTitle;//标题
            public int mTitleColor;//标题颜色
            public int mTitleIconRes;//标题图片

            public String mRightText;//右边文字
            public int mRightTextColor;//右边文字颜色
            public int mRightIconRes;//右边图片

            
            public View.OnClickListener mRightClickListener;
            public View.OnClickListener mCenterClickListener;

            public View.OnClickListener mLeftClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 关闭当前Activity
                    ((Activity) mContext).finish();
                }
            };

            public CommonTitleBarParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
