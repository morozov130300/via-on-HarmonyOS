package com.tuyafeng.support.utils;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Object[] a(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2;
        }
        if (objArr2 == null) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static boolean b(int[] iArr, int i10) {
        return c(iArr, i10) >= 0;
    }

    public static int c(int[] iArr, int i10) {
        if (iArr != null && iArr.length != 0) {
            for (int i11 = 0; i11 < iArr.length; i11++) {
                if (iArr[i11] == i10) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public static int[] d(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Integer) list.get(i10)).intValue();
        }
        return iArr;
    }
}
