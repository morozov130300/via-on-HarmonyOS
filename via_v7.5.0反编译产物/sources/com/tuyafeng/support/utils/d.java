package com.tuyafeng.support.utils;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static Object a(Bundle bundle, String str, Class cls) {
        if (bundle == null || str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelable(str);
        }
        if (cls == null) {
            return null;
        }
        return bundle.getParcelable(str, cls);
    }

    public static ArrayList b(Bundle bundle, String str, Class cls) {
        if (bundle == null || str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelableArrayList(str);
        }
        if (cls == null) {
            return null;
        }
        return bundle.getParcelableArrayList(str, cls);
    }
}
