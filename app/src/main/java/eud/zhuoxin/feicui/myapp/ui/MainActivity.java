package eud.zhuoxin.feicui.myapp.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import eud.zhuoxin.feicui.myapp.R;
import eud.zhuoxin.feicui.myapp.fragment.ExchangeFragment;
import eud.zhuoxin.feicui.myapp.fragment.FriendFragment;
import eud.zhuoxin.feicui.myapp.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    @BindView(R.id.main_bottom_bar)
    BottomBar mainBottomBar;

    private FriendFragment friendFragment;
    private ExchangeFragment exchangeFragment;
    private MineFragment mineFragment;



    // 当前正在显示的Fragment
    private Fragment showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        retrieveFragments();
        mainBottomBar.setOnTabSelectListener(this);
    }


    /**底部导航的监听事件*/
    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId){
            case R.id.tab_friend:
                //判断是否为空，为空就创建对象
                if (friendFragment == null) friendFragment = FriendFragment.newInstance();
                switchFragment(friendFragment);
                break;
            case R.id.tab_exchange:
                //判断是否为空，为空就创建对象
                if (exchangeFragment == null) exchangeFragment = ExchangeFragment.newInstance();
                switchFragment(exchangeFragment);

                break;
            case R.id.tab_mine:
                //判断是否为空，为空就创建对象
                if (mineFragment == null) mineFragment = MineFragment.newInstance();
                switchFragment(mineFragment);
                break;
        }
    }
    /**
     * 首页4个Fragment切换, 使用hide和show, 而不是replace.
     * @param target 要显示的目标Fragment.
     */
    private void switchFragment(Fragment target) {
        if (showFragment == target) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (showFragment != null) {
            // 隐藏当前正在显示的Fragment
            transaction.hide(showFragment);
        }

        if (target.isAdded()) {
            // 如果目标Fragment已经添加过, 就显示它
            transaction.show(target);
        } else {
            // 否则直接添加该Fragment
            transaction.add(R.id.main_fragment, target, target.getClass().getName());
        }
        //
        transaction.commit();
        //
        showFragment = target;
    }

//    // 找回FragmentManager中存储的Fragment
//    private void retrieveFragments() {
//        FragmentManager manager = getSupportFragmentManager();
//       friendFragment =  manager.findFragmentByTag(friendFragment);
//        friendFragment = (friendFragment) manager.findFragmentByTag(friendFragment.class.getName());
//    }

}
