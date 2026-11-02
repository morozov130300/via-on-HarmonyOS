package h9;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends h9.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6439a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f6440b;

    /* renamed from: c, reason: collision with root package name */
    public String f6441c;

    /* renamed from: d, reason: collision with root package name */
    public String f6442d;

    /* renamed from: e, reason: collision with root package name */
    public String f6443e;

    /* renamed from: f, reason: collision with root package name */
    public String f6444f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6445g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6446a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f6447b;

        /* renamed from: c, reason: collision with root package name */
        public String f6448c;

        /* renamed from: d, reason: collision with root package name */
        public String f6449d;

        /* renamed from: e, reason: collision with root package name */
        public String f6450e;

        /* renamed from: f, reason: collision with root package name */
        public String f6451f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f6452g;

        public b(int i10) {
            this.f6446a = i10;
        }

        public d a() {
            return new d(this.f6446a, this.f6447b, this.f6448c, this.f6449d, this.f6450e, this.f6451f, this.f6452g);
        }

        public b b(Drawable drawable) {
            this.f6447b = drawable;
            return this;
        }

        public b c(String str, String str2) {
            this.f6450e = str;
            this.f6451f = str2;
            return this;
        }

        public b d(boolean z10) {
            this.f6452g = z10;
            return this;
        }

        public b e(String str, String str2) {
            this.f6448c = str;
            this.f6449d = str2;
            return this;
        }
    }

    public d(int i10, Drawable drawable, String str, String str2, String str3, String str4, boolean z10) {
        this.f6439a = i10;
        this.f6440b = drawable;
        this.f6441c = str;
        this.f6442d = str2;
        this.f6443e = str3;
        this.f6444f = str4;
        this.f6445g = z10;
    }

    @Override // h9.a
    public Drawable a() {
        return this.f6440b;
    }

    @Override // h9.a
    public int b() {
        return this.f6439a;
    }

    @Override // h9.a
    public String c() {
        String str;
        return (this.f6445g || (str = this.f6444f) == null) ? this.f6442d : str;
    }

    @Override // h9.a
    public String d() {
        String str;
        return (this.f6445g || (str = this.f6443e) == null) ? this.f6441c : str;
    }

    public boolean h() {
        return this.f6445g;
    }

    public void i(boolean z10) {
        this.f6445g = z10;
    }
}
