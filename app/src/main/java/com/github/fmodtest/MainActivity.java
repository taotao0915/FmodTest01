package com.github.fmodtest;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory().getPath()+"/drumloop.mp3";
        File file = new File(path);
        if (file.exists()) {
            Log.i("TAG","----------------文件存在--------------");
            playSound(path, 2);
        }else{
            Log.i("TAG","----------------文件不存在--------------");
        }

    }

    public native int playSound(String path, int type);
}
