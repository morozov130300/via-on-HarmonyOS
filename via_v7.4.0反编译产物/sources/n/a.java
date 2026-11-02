package n;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends o.a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: n.a$a, reason: collision with other inner class name */
    public class RunnableC0098a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f10036e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Activity f10037j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f10038k;

        public RunnableC0098a(String[] strArr, Activity activity, int i10) {
            this.f10036e = strArr;
            this.f10037j = activity;
            this.f10038k = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f10036e.length];
            PackageManager packageManager = this.f10037j.getPackageManager();
            String packageName = this.f10037j.getPackageName();
            int length = this.f10036e.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f10036e[i10], packageName);
            }
            ((d) this.f10037j).onRequestPermissionsResult(this.f10038k, this.f10036e, iArr);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {
        public static void a(Activity activity) {
            activity.finishAffinity();
        }

        public static void b(Activity activity, Intent intent, int i10, Bundle bundle) {
            activity.startActivityForResult(intent, i10, bundle);
        }

        public static void c(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface e {
        void a(int i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(Activity activity, String[] strArr, int i10) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof e) {
                ((e) activity).a(i10);
            }
            c.b(activity, strArr, i10);
        } else if (activity instanceof d) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0098a(strArr, activity, i10));
        }
    }

    public static void n(Activity activity, Intent intent, int i10, Bundle bundle) {
        b.b(activity, intent, i10, bundle);
    }

    public static void o(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        b.c(activity, intentSender, i10, intent, i11, i12, i13, bundle);
    }
}
