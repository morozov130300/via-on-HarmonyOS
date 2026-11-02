package v5;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f13035b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f13036a = new HashMap();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: v5.b$b, reason: collision with other inner class name */
    public static class C0148b {

        /* renamed from: a, reason: collision with root package name */
        public String f13037a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f13038b;

        public C0148b() {
            this.f13038b = new Bundle();
        }

        public void a() {
            if (this.f13038b.isEmpty()) {
                b.d().b(this.f13037a);
            } else {
                b.d().e(this.f13037a, this.f13038b);
            }
        }

        public C0148b b(String str, int i10) {
            this.f13038b.putInt(str, i10);
            return this;
        }

        public C0148b c(String str, long j10) {
            this.f13038b.putLong(str, j10);
            return this;
        }

        public C0148b d(String str, String str2) {
            this.f13038b.putString(str, str2);
            return this;
        }

        public C0148b e(String str) {
            this.f13037a = str;
            return this;
        }

        public C0148b f(int i10) {
            c("expired_time", (SystemClock.elapsedRealtime() / 1000) + i10);
            return this;
        }
    }

    public static C0148b a() {
        return new C0148b();
    }

    public static b d() {
        if (f13035b == null) {
            f13035b = new b();
        }
        return f13035b;
    }

    public void b(String str) {
        this.f13036a.remove(str);
    }

    public Bundle c(String str) {
        Bundle bundle = (Bundle) this.f13036a.get(str);
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
        this.f13036a.put(str, bundle);
    }
}
