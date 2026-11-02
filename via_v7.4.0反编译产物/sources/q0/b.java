package q0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f11199a;

    /* renamed from: b, reason: collision with root package name */
    public final List f11200b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11201c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public boolean f11204c = false;

        /* renamed from: a, reason: collision with root package name */
        public final List f11202a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List f11203b = new ArrayList();

        public a a(String str) {
            this.f11203b.add(str);
            return this;
        }

        public a b() {
            return c("*");
        }

        public a c(String str) {
            this.f11202a.add(new C0114b(str, "direct://"));
            return this;
        }

        public a d(String str) {
            this.f11202a.add(new C0114b(str));
            return this;
        }

        public b e() {
            return new b(h(), f(), i());
        }

        public final List f() {
            return this.f11203b;
        }

        public a g() {
            return a("<local>");
        }

        public final List h() {
            return this.f11202a;
        }

        public final boolean i() {
            return this.f11204c;
        }

        public a j(boolean z10) {
            this.f11204c = z10;
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: q0.b$b, reason: collision with other inner class name */
    public static final class C0114b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11205a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11206b;

        public C0114b(String str) {
            this("*", str);
        }

        public C0114b(String str, String str2) {
            this.f11205a = str;
            this.f11206b = str2;
        }

        public String a() {
            return this.f11205a;
        }

        public String b() {
            return this.f11206b;
        }
    }

    public b(List list, List list2, boolean z10) {
        this.f11199a = list;
        this.f11200b = list2;
        this.f11201c = z10;
    }

    public List a() {
        return Collections.unmodifiableList(this.f11200b);
    }

    public List b() {
        return Collections.unmodifiableList(this.f11199a);
    }

    public boolean c() {
        return this.f11201c;
    }
}
