package s0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements s0.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f12131c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12133b;

    /* JADX INFO: renamed from: s0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0120a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f12134a = new HashSet(Arrays.asList(w.d().a()));
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class e extends a {
        public e(String str) {
            super("IMPLEMENTATION_ONLY_FEATURE", str);
        }

        @Override // s0.a
        public final boolean c() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class g extends a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class i extends a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class j extends a {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f12132a = str;
        this.f12133b = str2;
        f12131c.add(this);
    }

    public static Set e() {
        return Collections.unmodifiableSet(f12131c);
    }

    @Override // s0.h
    public String a() {
        return this.f12132a;
    }

    @Override // s0.h
    public boolean b() {
        return c() || d();
    }

    public abstract boolean c();

    public boolean d() {
        return hc.b.b(C0120a.f12134a, this.f12133b);
    }
}
