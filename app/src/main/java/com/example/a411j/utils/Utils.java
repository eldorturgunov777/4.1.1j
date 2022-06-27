package com.example.a411j.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Eldor Turgunov on 27.06.2022.
 * 4.1.1j
 * eldorturgunov777@gmail.com
 */
public class Utils {
    public static void fireToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
