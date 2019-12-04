package com.niuyi.androiddemo;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.List;

public class FragmentActivity extends AppCompatActivity implements NumberFragment.OnFragmentInteractionListener {

    private static final String TAG = FragmentActivity.class.getCanonicalName() + "_LOG";
    private String mCurrentFragment;
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        onNext(false);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.i(TAG, "onBackStackChanged");
            }
        });

    }

    private void switchFragment(Fragment fragment){

        mCurrentFragment = fragment.getClass().getCanonicalName();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().setCustomAnimations(0, 0);
        ft.replace(R.id.root_container, fragment);

//        ft.addToBackStack(((NumberFragment)fragment).getArgParam1());

        String arg = ((NumberFragment) fragment).getArgParam1();
        if(!arg.equalsIgnoreCase("0")){
            ft.addToBackStack(null);
        }else{
            Log.i(TAG, "not add 0");
        }

        int result = ft.commitAllowingStateLoss();
    }


    @Override
    public void onNext(boolean remove) {
//        if(remove){
//            Fragment currentFragment = getCurrentFragment();
//            Log.i(TAG, "remove current: " + ((NumberFragment)currentFragment).getArgParam1());
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.remove(currentFragment);
//            fragmentTransaction.commit();
//        }

        switchFragment(NumberFragment.newInstance(String.valueOf(mIndex++), null));
    }

    protected NumberFragment getCurrentFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return (NumberFragment)fragment;
        }
        return null;
    }

    @Override
    public void onBackPressed() {

        Log.i(TAG, "onBackPressed");
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        Log.i(TAG, "backStackEntryCount: " + backStackEntryCount);

        if(backStackEntryCount == 1){
            finish();
        }else{
            NumberFragment fragment = getCurrentFragment();
            String index = fragment.getArgParam1();

            if(index.equalsIgnoreCase("3")){
                getSupportFragmentManager().popBackStack("2", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }else{
                super.onBackPressed();
            }
        }
    }
}
