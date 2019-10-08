package com.lihang.viewmodelstu.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class ActivityUtils {
    //简单跳转
    public static void transfer(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
