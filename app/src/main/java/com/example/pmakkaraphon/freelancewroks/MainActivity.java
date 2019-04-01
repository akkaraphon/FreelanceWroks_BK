package com.example.pmakkaraphon.freelancewroks;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.pmakkaraphon.freelancewroks.API.ConnectionManager;
import com.example.pmakkaraphon.freelancewroks.API.LoginCallbackListener;
import com.example.pmakkaraphon.freelancewroks.API.LogoutCallbackListener;
import com.example.pmakkaraphon.freelancewroks.Fragment.HomeFragment;
import com.example.pmakkaraphon.freelancewroks.Fragment.NotificationFragment;
import com.example.pmakkaraphon.freelancewroks.Fragment.OrtherFragment;
import com.example.pmakkaraphon.freelancewroks.Fragment.SearchFragment;
import com.example.pmakkaraphon.freelancewroks.Model.LoginModel;
import com.example.pmakkaraphon.freelancewroks.Model.LogoutModel;
import com.example.pmakkaraphon.freelancewroks.Utils.StaticClass;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    ConnectionManager connect = new ConnectionManager();
    LogoutCallbackListener logoutCallbackListener;
    String TAG = "MainActivityLog";
    StaticClass sc = new StaticClass();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        logoutCallbackListener = new LogoutCallbackListener() {

            @Override
            public void onResponse(LogoutModel logoutModel, Retrofit retrofit) {
                if (logoutModel.getCode() == 1) {
                    mEditor = mPrefs.edit();
                    mEditor.clear();
                    mEditor.commit();
                    finish();
                } else {
                    Log.d(TAG, String.valueOf(logoutModel.getMessage()));
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onBodyError(ResponseBody responseBody) {

            }

            @Override
            public void onBodyErrorIsNull() {

            }
        };

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            onLogoutPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new SearchFragment();
                case 2:
                    return new NotificationFragment();
                default:
                    return new OrtherFragment();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "หน้าหลัก";
                case 1:
                    return "ค้นหา";
                case 2:
                    return "แจ้งเตื่อน ";
                case 3:
                    return "อื่น ๆ ";
            }
            return null;
        }

        public void setActionBarTitle(String title) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onLogoutPressed() {
        mPrefs = getSharedPreferences("prefs_user", Context.MODE_PRIVATE);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("ออกจากระบบ");
        dialog.setCancelable(true);
        dialog.setMessage("คุณต้องการออกจากระบบใช่หรือไม่");
        dialog.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, sc.loginModel.getProfile().getId_mem());
                connect.logout(logoutCallbackListener, sc.loginModel.getProfile().getId_mem());
            }
        });

        dialog.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
