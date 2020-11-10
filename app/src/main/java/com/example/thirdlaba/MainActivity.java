package com.example.thirdlaba;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    TextView firstLine,secondLine,thirdLine,fouthLine,fifthLine;
    public void GetAllTextViewId(){
        firstLine = (TextView) findViewById(R.id.text_absolute);
        secondLine = (TextView) findViewById(R.id.text_name);
        thirdLine = (TextView) findViewById(R.id.text_path);
        fouthLine = (TextView) findViewById(R.id.text_read_write);
        fifthLine = (TextView) findViewById(R.id.text_external);
    }
    public void SetAllNewTextViewValues(File file){

        firstLine.setText(firstLine.getHint() + file.getAbsolutePath());
        secondLine.setText(secondLine.getHint() + file.getName());
        thirdLine.setText(thirdLine.getHint() + file.getPath());
        fouthLine.setText(fouthLine.getHint() + String.valueOf(file.canRead())+ "/" + String.valueOf(file.canWrite()));
        fifthLine.setText(fifthLine.getHint() + Environment.getExternalStorageState());
    }


    public void GetFilesDir(View view) {
        File file = super.getFilesDir();
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }


    public void GetCacheDir(View view) {
        File file = super.getCacheDir();
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }


    public void GetExternalFilesDir(View view) {
        File file = super.getExternalFilesDir(super.getFilesDir().getAbsolutePath());
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }


    public void GetExternalCacheDir(View view) {
        File file = super.getExternalCacheDir();
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }


    public void GetExternalStorageDirectory(View view) {
        File file = Environment.getExternalStorageDirectory();
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void GetExternalStoragePublicDirectory(View view) {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        GetAllTextViewId();
        SetAllNewTextViewValues(file);
    }
}