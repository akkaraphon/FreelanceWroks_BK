package com.example.pmakkaraphon.freelancewroks.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmakkaraphon.freelancewroks.EditProActivity;
import com.example.pmakkaraphon.freelancewroks.LoginActivity;
import com.example.pmakkaraphon.freelancewroks.MainActivity;
import com.example.pmakkaraphon.freelancewroks.R;
import com.example.pmakkaraphon.freelancewroks.Utils.StaticClass;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tvFullname, tvStatus, tvEmail, tvTel, tvAddress;
    private Button btEditPro;
    private View view;
    StaticClass sc = new StaticClass();


    public HomeFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        tvFullname = (TextView) view.findViewById(R.id.tvFullname);
        tvStatus = (TextView) view.findViewById(R.id.tvStatus);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvTel = (TextView) view.findViewById(R.id.tvTel);
        tvAddress = (TextView) view.findViewById(R.id.tvAddress);

        tvFullname.setText(sc.loginModel.getProfile().getName_mem() + " " + sc.loginModel.getProfile().getLname_mem());
        if (sc.loginModel.getProfile().getStatus_mem().equals("green")) {
            tvStatus.setText("สถานะ : ปกติ");
            tvStatus.setTextColor(R.color.stGreen);
        } else if (sc.loginModel.getProfile().getStatus_mem().equals("orange")) {
            tvStatus.setText("สถานะ : รอยืนยัน");
            tvStatus.setTextColor(R.color.stOrange);
        } else if (sc.loginModel.getProfile().getStatus_mem().equals("yellow")) {
            tvStatus.setText("สถานะ : หลักฐานผิด");
            tvStatus.setTextColor(R.color.stYellow);
        } else {
            tvStatus.setText("สถานะ : ระงับบัญชี");
            tvStatus.setTextColor(R.color.stRed);
        }
        tvEmail.setText(sc.loginModel.getProfile().getEmail_mem());
        tvTel.setText(sc.loginModel.getProfile().getTel_mem());
        tvAddress.setText(sc.loginModel.getProfile().getAddress_mem()
                + " " + sc.loginModel.getProfile().getDISTRICT_NAME()
                + " " + sc.loginModel.getProfile().getAMPHUR_NAME()
                + " " + sc.loginModel.getProfile().getPROVINCE_NAME()
                + " " + sc.loginModel.getProfile().getZipcode());

        tvFullname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"");
                String TAG = "EditProActivity";
                Intent intent = new Intent(getActivity(), EditProActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("หน้าหลัก");
    }

}
