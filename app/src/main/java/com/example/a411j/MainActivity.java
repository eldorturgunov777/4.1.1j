package com.example.a411j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a411j.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    boolean isPersistent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cache = findViewById(R.id.cache);
        Button files = findViewById(R.id.files);
        Button delete = findViewById(R.id.delete);

        cache.setOnClickListener(view -> {
            saveInternalFile("CACHE");
        });
        files.setOnClickListener(view -> {
            saveInternalFiles("FILES");
        });
        delete.setOnClickListener(view -> {
            deleteInternalFile();
        });
    }

    private void saveInternalFiles(String text) {
        String fileName = "internal.txt";
        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));

            Utils.fireToast(this, String.format
                    ("Write to %s successful", fileName));
        } catch (Exception e) {
            e.printStackTrace();
            Utils.fireToast(this, String.format
                    ("Write to file %s failed", fileName));
        }
    }

    private void saveInternalFile(String text) {
        String fileName = "internal.txt";
        try {
            FileOutputStream fileOutputStream;
            File file = new File(getCacheDir(), fileName);
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
            Utils.fireToast(this, String.format
                    ("Write to %s successful", fileName));
        } catch (Exception e) {
            e.printStackTrace();
            Utils.fireToast(this, String.format
                    ("Write to file %s failed", fileName));
        }
    }

    private void deleteInternalFile() {
        String fileName = "internal.txt";
        File cache = new File(getFilesDir(), fileName);
        File file = new File(getCacheDir(), fileName);
        file.delete();
        cache.delete();
        Utils.fireToast(this, String.format
                ("File %s has been deleted", fileName));
    }
}