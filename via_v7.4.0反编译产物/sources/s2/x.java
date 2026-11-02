package s2;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public String f11807a;

    public static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public synchronized String a(Context context) {
        try {
            if (this.f11807a == null) {
                this.f11807a = b(context);
            }
        } finally {
        }
        return "".equals(this.f11807a) ? null : this.f11807a;
    }
}
