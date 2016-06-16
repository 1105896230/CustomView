package custom.fmt.com.mycustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import custom.fmt.com.mycustomview.views.ExplosionField.ExplosionField;

public class MainActivity extends AppCompatActivity {

    //爆炸区域
    private ExplosionField mExplosionField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExplosionField = ExplosionField.attach2Window(this);
        addListener(findViewById(R.id.root));
    }

    //给需要爆炸的视图添加到爆炸区域中
    private void addListener(View root) {

        //如果是view group 类型 就把它的子视图添加到区域中
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                addListener(parent.getChildAt(i));
            }
        }

        //这里是View 类型的视图
        else {

            //设置它为可点击的
            root.setClickable(true);

            //添加监听器
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //爆炸该视图
                    mExplosionField.explode(v);
                    //取消注册其点击事件
                    v.setOnClickListener(null);
                }
            });
        }
    }
}
