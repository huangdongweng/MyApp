package eud.zhuoxin.feicui.myapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eud.zhuoxin.feicui.myapp.R;

/**
 * Created by Administrator on 2017/3/23.
 */

public class EnterActivity extends AppCompatActivity {
    @BindView(R.id.enter_username)
    EditText enterUsername;
    @BindView(R.id.enter_pwd)
    EditText enterPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.enter_enroll, R.id.enter_enter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enter_enroll:
                startActivity(new Intent(this,EnrollActivity.class));
                break;
            case R.id.enter_enter:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
