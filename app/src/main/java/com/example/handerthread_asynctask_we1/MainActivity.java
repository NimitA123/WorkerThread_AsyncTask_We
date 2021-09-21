package com.example.handerthread_asynctask_we1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import android.os.Handler;
import android.os.Message;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private CircularProgressIndicator progressBar;
    private Handler mainThreadHandler=new Handler(Looper .getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    int progress=(int) msg.obj;
                    progressBar.setProgress(progress);
                    break;
            }
        }


    };
    //private final Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
    //  hander
    // };




    /*AsyncTask Method
     * 1.onPreExecute if u want to show toast message before downloading   a file in background than
     * use onPreExecute method it is use in main Thread
     * doInBackground
     * if We rotate the Screen the App will Destroy but task is running
     *
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        WorkerThread workerThread =  new WorkerThread("async", mainThreadHandler);
        workerThread.start();
    }
}