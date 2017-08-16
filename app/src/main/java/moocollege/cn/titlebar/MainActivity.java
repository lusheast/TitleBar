package moocollege.cn.titlebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * CommonTitleBar使用，分别有左图标，左边文字
 *                          中间标题 中间图标
 *                          右边图标 右边文字
 *                          不设置文字或者不设置图片资源 图表或者文字为gone
 *                          左边图标默认设置了点击事件为关闭当前页面 根据需要进行处理
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommonTitleBar titleBar = new CommonTitleBar.Builder(this)
                 .setTitleBarColor(R.color.blue)
                .setLeftText("左边标题")
                .setLeftTextColor(R.color.red)
                .setLeftIcon(R.drawable.iv_back_arrow_white)
                .setLeftClickListener(this)
                .setTitle("投稿")
                .setTitleColor(R.color.white)
                .setTitleIcon(R.drawable.iv_mine_on)
                .setTitleClickListener(this)
                .setRightText("分享")
                .setRightTextColor(R.color.colorAccent)
                .setRightIcon(R.drawable.iv_more_blue)
                .setRightClickListener(this)
                .builder();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.left_icon:
                Toast.makeText(this,"左图标",Toast.LENGTH_LONG).show();
                break;
            case R.id.left_tv:
                Toast.makeText(this,"左文字",Toast.LENGTH_LONG).show();
                break;
            case R.id.title_icon:
                Toast.makeText(this,"中间图标",Toast.LENGTH_LONG).show();
                break;
            case R.id.title:
                Toast.makeText(this,"中间文字",Toast.LENGTH_LONG).show();
                break;
            case R.id.right_text:
                Toast.makeText(this,"右边文字",Toast.LENGTH_LONG).show();
                break;
            case R.id.right_icon:
                Toast.makeText(this,"右边图标",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
