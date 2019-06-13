package com.biao.jnatoso1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = CLibrary.INSTANCE.get_sum(11, 2);
        Log.i("MainActivity", "结果:" + i);
    }

    interface CLibrary extends Library {

        //        String path = Thread.currentThread().getContextClassLoader().getResource("system/RAIO/lib_android_gcc2.so").getPath();
        CLibrary INSTANCE = (CLibrary) Native.load("/system/RAIO/lib_android_gcc2.so", CLibrary.class);

        int get_sum(int plus1, int plus2);
    }
}
