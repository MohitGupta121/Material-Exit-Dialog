package com.example.materialexitdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onBackPressed() {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View viewDialog = inflater.inflate(R.layout.exit_dialog,null);
        Dialog exitDialog = new Dialog(MainActivity.this, R.style.CustomAlertDialog);
        exitDialog.setContentView(viewDialog);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(exitDialog.getWindow().getAttributes());
        layoutParams.width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        layoutParams.height = (int)(getResources().getDisplayMetrics().heightPixels*0.20);

        LinearLayout rate = viewDialog.findViewById(R.id.rate);
        LinearLayout more = viewDialog.findViewById(R.id.more);
        LinearLayout exit = viewDialog.findViewById(R.id.exit);

        TextView msg = viewDialog.findViewById(R.id.exitMsg);
        msg.setText("Thanks for using our App, Visit Again");

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName())));

                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https:play.google.com/store/apps/details?id=" + getPackageName())));
                }

            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        exitDialog.setCancelable(true);
        exitDialog.setCanceledOnTouchOutside(false);
        exitDialog.getWindow().setAttributes(layoutParams);
        exitDialog.show();



    }
}
