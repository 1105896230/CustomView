package custom.fmt.com.mycustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import custom.fmt.com.mycustomview.zhujie.ContentView;
import custom.fmt.com.mycustomview.zhujie.OnClick;
import custom.fmt.com.mycustomview.zhujie.ViewInject;
import custom.fmt.com.mycustomview.zhujie.ViewInjectUtils;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.iv)
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.inject(this);
    }

    @OnClick({R.id.iv})
    public void OnBindCLick(View view) {
        switch (view.getId()) {
            case R.id.iv:
                Toast.makeText(MainActivity.this, "注解成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
