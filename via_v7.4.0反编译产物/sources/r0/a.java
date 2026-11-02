package r0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a implements r0.h {

    /* renamed from: c, reason: collision with root package name */
    public static final Set f11469c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f11470a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11471b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: r0.a$a, reason: collision with other inner class name */
    public static class C0118a {

        /* renamed from: a, reason: collision with root package name */
        public static final Set f11472a = new HashSet(Arrays.asList(p.d().a()));
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 23;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class e extends a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g extends a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i extends a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // r0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f11470a = str;
        this.f11471b = str2;
        f11469c.add(this);
    }

    public static Set e() {
        return Collections.unmodifiableSet(f11469c);
    }

    @Override // r0.h
    public String a() {
        return this.f11470a;
    }

    @Override // r0.h
    public boolean b() {
        return c() || d();
    }

    public abstract boolean c();

    public boolean d() {
        return dc.a.b(C0118a.f11472a, this.f11471b);
    }
}
