package f8;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4529g = new a(22, null, null, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f4531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4535f;

    public a(int i10, Drawable drawable, String str, boolean z10) {
        this(i10, drawable, str, z10, false);
    }

    public static a g() {
        return f4529g;
    }

    public String a() {
        String str = this.f4535f;
        return str == null ? this.f4532c : str;
    }

    public Drawable b() {
        return this.f4531b;
    }

    public int c() {
        return this.f4530a;
    }

    public String d() {
        return this.f4532c;
    }

    public boolean e() {
        return this.f4533d;
    }

    public boolean f() {
        return this.f4534e;
    }

    public void h(String str) {
        this.f4535f = str;
    }

    public void i(boolean z10) {
        this.f4533d = z10;
    }

    public void j(boolean z10) {
        this.f4534e = z10;
    }

    public void k(String str) {
        this.f4532c = str;
    }

    public a(int i10, Drawable drawable, String str, boolean z10, boolean z11) {
        this.f4530a = i10;
        this.f4531b = drawable;
        this.f4532c = str;
        this.f4533d = z10;
        this.f4534e = z11;
    }
}
