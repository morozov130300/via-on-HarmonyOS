package h9;

import android.graphics.drawable.Drawable;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends h9.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6413a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f6414b;

    /* renamed from: c, reason: collision with root package name */
    public String f6415c;

    /* renamed from: d, reason: collision with root package name */
    public int f6416d;

    /* renamed from: e, reason: collision with root package name */
    public int f6417e;

    /* renamed from: f, reason: collision with root package name */
    public int f6418f;

    /* renamed from: g, reason: collision with root package name */
    public String f6419g;

    /* renamed from: h, reason: collision with root package name */
    public String f6420h;

    /* renamed from: i, reason: collision with root package name */
    public int f6421i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: h9.b$b, reason: collision with other inner class name */
    public static class C0078b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6422a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f6423b;

        /* renamed from: c, reason: collision with root package name */
        public String f6424c;

        /* renamed from: g, reason: collision with root package name */
        public String f6428g;

        /* renamed from: h, reason: collision with root package name */
        public String f6429h;

        /* renamed from: d, reason: collision with root package name */
        public int f6425d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f6426e = 100;

        /* renamed from: f, reason: collision with root package name */
        public int f6427f = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f6430i = -1;

        public C0078b(int i10) {
            this.f6422a = i10;
        }

        public b a() {
            return new b(this.f6422a, this.f6423b, this.f6424c, this.f6425d, this.f6426e, this.f6427f, this.f6428g, this.f6429h, this.f6430i);
        }

        public C0078b b(Drawable drawable) {
            this.f6423b = drawable;
            return this;
        }

        public C0078b c(int i10) {
            this.f6427f = i10;
            return this;
        }

        public C0078b d(int i10, int i11) {
            this.f6425d = i10;
            this.f6426e = i11;
            return this;
        }

        public C0078b e(int i10, String str) {
            this.f6430i = i10;
            this.f6429h = str;
            return this;
        }

        public C0078b f(String str) {
            this.f6428g = str;
            return this;
        }

        public C0078b g(String str) {
            this.f6424c = str;
            return this;
        }
    }

    public b(int i10, Drawable drawable, String str, int i11, int i12, int i13, String str2, String str3, int i14) {
        this.f6413a = i10;
        this.f6414b = drawable;
        this.f6415c = str;
        this.f6416d = i11;
        this.f6417e = i12;
        this.f6418f = i13;
        this.f6419g = str2;
        this.f6420h = str3;
        this.f6421i = i14;
    }

    @Override // h9.a
    public Drawable a() {
        return this.f6414b;
    }

    @Override // h9.a
    public int b() {
        return this.f6413a;
    }

    @Override // h9.a
    public String c() {
        if (this.f6418f == this.f6421i) {
            return this.f6420h;
        }
        String str = this.f6419g;
        return (str == null || !str.contains("%")) ? this.f6419g : String.format(Locale.getDefault(), this.f6419g, Integer.valueOf(this.f6418f));
    }

    @Override // h9.a
    public String d() {
        return this.f6415c;
    }

    public int h() {
        return this.f6417e;
    }

    public int i() {
        return this.f6416d;
    }

    public int j() {
        return this.f6418f;
    }

    public int k() {
        return this.f6421i;
    }

    public void l(int i10) {
        this.f6418f = i10;
    }
}
