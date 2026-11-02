package p2;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10945a;

    /* renamed from: b, reason: collision with root package name */
    public b f10946b = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f10947a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10948b;

        public b() throws Resources.NotFoundException {
            int iR = CommonUtils.r(e.this.f10945a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iR == 0) {
                if (!e.this.c("flutter_assets/NOTICES.Z")) {
                    this.f10947a = null;
                    this.f10948b = null;
                    return;
                } else {
                    this.f10947a = "Flutter";
                    this.f10948b = null;
                    f.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f10947a = "Unity";
            String string = e.this.f10945a.getResources().getString(iR);
            this.f10948b = string;
            f.f().i("Unity Editor version is: " + string);
        }
    }

    public e(Context context) {
        this.f10945a = context;
    }

    public final boolean c(String str) throws IOException {
        if (this.f10945a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f10945a.getAssets().open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public String d() {
        return f().f10947a;
    }

    public String e() {
        return f().f10948b;
    }

    public final b f() {
        if (this.f10946b == null) {
            this.f10946b = new b();
        }
        return this.f10946b;
    }
}
