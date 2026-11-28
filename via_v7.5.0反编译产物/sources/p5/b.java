package p5;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f11582b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11583a = new HashMap();

    /* JADX INFO: renamed from: p5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0110b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f11585b;

        public void a() {
            if (this.f11585b.isEmpty()) {
                b.d().b(this.f11584a);
            } else {
                b.d().e(this.f11584a, this.f11585b);
            }
        }

        public C0110b b(String str, int i10) {
            this.f11585b.putInt(str, i10);
            return this;
        }

        public C0110b c(String str, long j10) {
            this.f11585b.putLong(str, j10);
            return this;
        }

        public C0110b d(String str, String str2) {
            this.f11585b.putString(str, str2);
            return this;
        }

        public C0110b e(String str) {
            this.f11584a = str;
            return this;
        }

        public C0110b f(int i10) {
            c("expired_time", (SystemClock.elapsedRealtime() / 1000) + ((long) i10));
            return this;
        }

        public C0110b() {
            this.f11585b = new Bundle();
        }
    }

    public static C0110b a() {
        return new C0110b();
    }

    public static b d() {
        if (f11582b == null) {
            f11582b = new b();
        }
        return f11582b;
    }

    public void b(String str) {
        this.f11583a.remove(str);
    }

    public Bundle c(String str) {
        Bundle bundle = (Bundle) this.f11583a.get(str);
        if (bundle == null) {
            return null;
        }
        boolean z10 = bundle.getBoolean("throwaway", false);
        if (bundle.containsKey("expired_time") && bundle.getLong("expired_time") < SystemClock.elapsedRealtime() / 1000) {
            b(str);
            return null;
        }
        if (z10) {
            b(str);
        }
        return bundle;
    }

    public void e(String str, Bundle bundle) {
        this.f11583a.put(str, bundle);
    }
}
