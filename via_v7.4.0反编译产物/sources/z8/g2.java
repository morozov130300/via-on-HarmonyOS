package z8;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Process;
import android.util.Rational;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g2 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14703a = false;

    public static boolean a(Context context) {
        int i10;
        Activity activityA;
        if (!f14703a || (i10 = Build.VERSION.SDK_INT) < 24 || (activityA = g6.f.a(context)) == null) {
            return false;
        }
        if (i10 >= 26) {
            return activityA.enterPictureInPictureMode(new PictureInPictureParams.Builder().build());
        }
        activityA.enterPictureInPictureMode();
        return true;
    }

    public static int[] b(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return new int[]{16, 9};
        }
        int[][] iArr = {new int[]{4, 3}, new int[]{3, 4}, new int[]{16, 9}, new int[]{9, 16}, new int[]{1, 1}, new int[]{21, 9}, new int[]{2, 1}};
        int[] iArr2 = new int[2];
        double d10 = i10;
        double d11 = i11;
        Double.isNaN(d10);
        Double.isNaN(d11);
        double d12 = d10 / d11;
        double d13 = Double.MAX_VALUE;
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr3 = iArr[i12];
            double d14 = iArr3[0];
            double d15 = iArr3[1];
            Double.isNaN(d14);
            Double.isNaN(d15);
            double dAbs = Math.abs(d12 - (d14 / d15));
            if (dAbs < d13) {
                iArr2 = iArr3;
                d13 = dAbs;
            }
        }
        return iArr2;
    }

    public static boolean c(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        return (i10 >= 29 ? appOpsManager.unsafeCheckOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName()) : appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName())) == 0;
    }

    public static boolean d(Context context) {
        Activity activityA;
        if (!f14703a || Build.VERSION.SDK_INT < 24 || (activityA = g6.f.a(context)) == null) {
            return false;
        }
        return activityA.isInPictureInPictureMode();
    }

    public static boolean e(Context context) {
        boolean z10 = Build.VERSION.SDK_INT >= 24 && context.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        f14703a = z10;
        return z10;
    }

    public static void f(Context context, int i10) {
        if (!f14703a || Build.VERSION.SDK_INT < 26 || context == null) {
            return;
        }
        if (i10 <= 0) {
            g6.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(Collections.EMPTY_LIST).build());
            return;
        }
        Icon iconCreateWithResource = Icon.createWithResource(context, x7.o.f13716c1);
        Intent intent = new Intent("mark.via.MEDIA_REWIND");
        intent.setPackage(context.getPackageName());
        RemoteAction remoteAction = new RemoteAction(iconCreateWithResource, context.getString(x7.u.f14136qb), context.getString(x7.u.f14136qb), PendingIntent.getBroadcast(context, 0, intent, 201326592));
        Intent intent2 = new Intent("mark.via.MEDIA_PLAY");
        intent2.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 201326592);
        RemoteAction remoteAction2 = i10 == 1 ? new RemoteAction(Icon.createWithResource(context, x7.o.O0), context.getString(x7.u.O3), context.getString(x7.u.O3), broadcast) : new RemoteAction(Icon.createWithResource(context, x7.o.M0), context.getString(x7.u.N3), context.getString(x7.u.N3), broadcast);
        Icon iconCreateWithResource2 = Icon.createWithResource(context, x7.o.Q);
        Intent intent3 = new Intent("mark.via.MEDIA_FASTFORWARD");
        intent3.setPackage(context.getPackageName());
        RemoteAction remoteAction3 = new RemoteAction(iconCreateWithResource2, context.getString(x7.u.f14046k5), context.getString(x7.u.f14046k5), PendingIntent.getBroadcast(context, 0, intent3, 201326592));
        ArrayList arrayList = new ArrayList();
        arrayList.add(remoteAction);
        arrayList.add(remoteAction2);
        arrayList.add(remoteAction3);
        g6.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(arrayList).build());
    }

    public static void g(Context context, int i10, int i11) {
        if (!f14703a || Build.VERSION.SDK_INT < 26) {
            return;
        }
        int[] iArrB = b(i10, i11);
        g6.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setAspectRatio(new Rational(iArrB[0], iArrB[1])).build());
    }
}
