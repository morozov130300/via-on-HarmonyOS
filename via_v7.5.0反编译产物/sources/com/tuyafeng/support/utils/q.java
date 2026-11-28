package com.tuyafeng.support.utils;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static boolean a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
