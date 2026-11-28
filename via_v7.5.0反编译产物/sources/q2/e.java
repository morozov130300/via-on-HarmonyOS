package q2;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f11724b = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11726b;

        public b() {
            int iR = CommonUtils.r(e.this.f11723a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iR == 0) {
                if (!e.this.c("flutter_assets/NOTICES.Z")) {
                    this.f11725a = null;
                    this.f11726b = null;
                    return;
                } else {
                    this.f11725a = "Flutter";
                    this.f11726b = null;
                    f.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f11725a = "Unity";
            String string = e.this.f11723a.getResources().getString(iR);
            this.f11726b = string;
            f.f().i("Unity Editor version is: " + string);
        }
    }

    public e(Context context) {
        this.f11723a = context;
    }

    public final boolean c(String str) {
        if (this.f11723a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f11723a.getAssets().open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public String d() {
        return f().f11725a;
    }

    public String e() {
        return f().f11726b;
    }

    public final b f() {
        if (this.f11724b == null) {
            this.f11724b = new b();
        }
        return this.f11724b;
    }
}
