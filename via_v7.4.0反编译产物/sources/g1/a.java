package g1;

import d1.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6110e = new C0071a().b();

    /* renamed from: a, reason: collision with root package name */
    public final e f6111a;

    /* renamed from: b, reason: collision with root package name */
    public final List f6112b;

    /* renamed from: c, reason: collision with root package name */
    public final b f6113c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6114d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: g1.a$a, reason: collision with other inner class name */
    public static final class C0071a {

        /* renamed from: a, reason: collision with root package name */
        public e f6115a = null;

        /* renamed from: b, reason: collision with root package name */
        public List f6116b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public b f6117c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f6118d = "";

        public C0071a a(c cVar) {
            this.f6116b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.f6115a, Collections.unmodifiableList(this.f6116b), this.f6117c, this.f6118d);
        }

        public C0071a c(String str) {
            this.f6118d = str;
            return this;
        }

        public C0071a d(b bVar) {
            this.f6117c = bVar;
            return this;
        }

        public C0071a e(e eVar) {
            this.f6115a = eVar;
            return this;
        }
    }

    public a(e eVar, List list, b bVar, String str) {
        this.f6111a = eVar;
        this.f6112b = list;
        this.f6113c = bVar;
        this.f6114d = str;
    }

    public static C0071a e() {
        return new C0071a();
    }

    public String a() {
        return this.f6114d;
    }

    public b b() {
        return this.f6113c;
    }

    public List c() {
        return this.f6112b;
    }

    public e d() {
        return this.f6111a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
