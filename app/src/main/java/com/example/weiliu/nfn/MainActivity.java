package com.example.weiliu.nfn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.weiliu.nfn.fragment.MineFragment;
import com.example.weiliu.nfn.fragment.RewardsFragment;
import com.example.weiliu.nfn.fragment.TaskFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Fragment currentFragment;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
        fragments = new ArrayList<Fragment>(3);
        fragments.add(new TaskFragment());
        fragments.add(new RewardsFragment());
        fragments.add(new MineFragment());
        switchFragment(0);
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
        Fragment fragment = getFragmentById(id);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (currentFragment == null) {
            transaction.add(R.id.fragment_container, fragment).commit();
            currentFragment = fragment;
        } else if (!currentFragment.getClass().getSimpleName().equals(fragment.getClass().getSimpleName())) {
            transaction.hide(currentFragment);
            if (!fragment.isAdded()) {
                transaction.add(R.id.fragment_container, fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
            currentFragment = fragment;
        } else
            return;
    }

    private Fragment getFragmentById(int id) {
        Fragment fragment;
        switch (id) {
            case R.id.navigation_home:
                fragment = fragments.get(0);
                break;
            case R.id.navigation_rewards:
                fragment = fragments.get(1);
                break;
            case R.id.navigation_mine:
                fragment = fragments.get(2);
                break;
            default:
                fragment = fragments.get(0);
                break;
        }
        return fragment;
    }
}
