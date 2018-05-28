package com.example.weiliu.nfn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.weiliu.nfn.fragment.MineFragment;
import com.example.weiliu.nfn.fragment.RewardsFragment;
import com.example.weiliu.nfn.fragment.TaskFragment;
import com.example.weiliu.nfn.utils.SharePreferenceUtil;

public class MainActivity extends AppCompatActivity {

    Fragment currentFragment;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragments = new Fragment[3];
        fragments[0] = new TaskFragment();
        fragments[1] = new RewardsFragment();
        fragments[2] = new MineFragment();

        switchFragment(SharePreferenceUtil.getNavigationId(this));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(R.id.navigation_home);
                    return true;
                case R.id.navigation_rewards:
                    switchFragment(R.id.navigation_rewards);
                    return true;
                case R.id.navigation_mine:
                    switchFragment(R.id.navigation_mine);
                    return true;
            }
            return false;
        }
    };

    private void switchFragment(int id) {
        SharePreferenceUtil.putNavigationId(MainActivity.this, id);
        Fragment fragment = getFragmentById(id);
        if (currentFragment == null || !currentFragment.getClass().getSimpleName().equals(fragment.getClass().getSimpleName())) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
    }

    private Fragment getFragmentById(int id) {
        Fragment fragment;
        switch (id) {
            case R.id.navigation_home:
                fragment = fragments[0];
                break;
            case R.id.navigation_rewards:
                fragment = fragments[1];
                break;
            case R.id.navigation_mine:
                fragment = fragments[2];
                break;
            default:
                fragment = fragments[0];
                break;
        }
        return fragment;
    }
}
