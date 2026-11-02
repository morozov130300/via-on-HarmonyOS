package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class SafeParcelReader {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle a(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iS);
        return bundle;
    }

    public static int[] b(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iS);
        return iArrCreateIntArray;
    }

    public static Parcelable c(Parcel parcel, int i10, Parcelable.Creator creator) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iS);
        return parcelable;
    }

    public static String d(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iS);
        return string;
    }

    public static ArrayList e(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iS);
        return arrayListCreateStringArrayList;
    }

    public static Object[] f(Parcel parcel, int i10, Parcelable.Creator creator) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iS);
        return objArrCreateTypedArray;
    }

    public static void g(Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i10, parcel);
    }

    public static int h(int i10) {
        return (char) i10;
    }

    public static boolean i(Parcel parcel, int i10) {
        w(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean j(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        if (iS == 0) {
            return null;
        }
        v(parcel, i10, iS, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static Double k(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        if (iS == 0) {
            return null;
        }
        v(parcel, i10, iS, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float l(Parcel parcel, int i10) {
        w(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static Float m(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        if (iS == 0) {
            return null;
        }
        v(parcel, i10, iS, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int n(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder o(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iS == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iS);
        return strongBinder;
    }

    public static int p(Parcel parcel, int i10) {
        w(parcel, i10, 4);
        return parcel.readInt();
    }

    public static long q(Parcel parcel, int i10) {
        w(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long r(Parcel parcel, int i10) {
        int iS = s(parcel, i10);
        if (iS == 0) {
            return null;
        }
        v(parcel, i10, iS, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int s(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void t(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + s(parcel, i10));
    }

    public static int u(Parcel parcel) {
        int iN = n(parcel);
        int iS = s(parcel, iN);
        int iDataPosition = parcel.dataPosition();
        if (h(iN) != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iN))), parcel);
        }
        int i10 = iS + iDataPosition;
        if (i10 >= iDataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i10, parcel);
    }

    public static void v(Parcel parcel, int i10, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        throw new ParseException("Expected size " + i12 + " got " + i11 + " (0x" + Integer.toHexString(i11) + ")", parcel);
    }

    public static void w(Parcel parcel, int i10, int i11) {
        int iS = s(parcel, i10);
        if (iS == i11) {
            return;
        }
        throw new ParseException("Expected size " + i11 + " got " + iS + " (0x" + Integer.toHexString(iS) + ")", parcel);
    }
}
