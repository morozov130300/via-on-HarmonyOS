package h9;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends h9.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6431a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f6432b;

    /* renamed from: c, reason: collision with root package name */
    public String f6433c;

    /* renamed from: d, reason: collision with root package name */
    public String f6434d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6435a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f6436b;

        /* renamed from: c, reason: collision with root package name */
        public String f6437c;

        /* renamed from: d, reason: collision with root package name */
        public String f6438d;

        public b(int i10) {
            this.f6435a = i10;
        }

        public c a() {
            return new c(this.f6435a, this.f6436b, this.f6437c, this.f6438d);
        }

        public b b(Drawable drawable) {
            this.f6436b = drawable;
            return this;
        }

        public b c(String str) {
            this.f6438d = str;
            return this;
        }

        public b d(String str) {
            this.f6437c = str;
            return this;
        }
    }

    public c(int i10, Drawable drawable, String str, String str2) {
        this.f6431a = i10;
        this.f6432b = drawable;
        this.f6433c = str;
        this.f6434d = str2;
    }

    @Override // h9.a
    public Drawable a() {
        return this.f6432b;
    }

    @Override // h9.a
    public int b() {
        return this.f6431a;
    }

    @Override // h9.a
    public String c() {
        return this.f6434d;
    }

    @Override // h9.a
    public String d() {
        return this.f6433c;
    }

    public void h(String str) {
        this.f6434d = str;
    }
}
