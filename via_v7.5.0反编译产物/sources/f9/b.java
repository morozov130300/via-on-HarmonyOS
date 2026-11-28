package f9;

import android.graphics.drawable.Drawable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends f9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f4538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4545i;

    /* JADX INFO: renamed from: f9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0069b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f4547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4548c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f4552g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f4553h;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4549d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4550e = 100;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4551f = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4554i = -1;

        public C0069b(int i10) {
            this.f4546a = i10;
        }

        public b a() {
            return new b(this.f4546a, this.f4547b, this.f4548c, this.f4549d, this.f4550e, this.f4551f, this.f4552g, this.f4553h, this.f4554i);
        }

        public C0069b b(Drawable drawable) {
            this.f4547b = drawable;
            return this;
        }

        public C0069b c(int i10) {
            this.f4551f = i10;
            return this;
        }

        public C0069b d(int i10, int i11) {
            this.f4549d = i10;
            this.f4550e = i11;
            return this;
        }

        public C0069b e(int i10, String str) {
            this.f4554i = i10;
            this.f4553h = str;
            return this;
        }

        public C0069b f(String str) {
            this.f4552g = str;
            return this;
        }

        public C0069b g(String str) {
            this.f4548c = str;
            return this;
        }
    }

    @Override // f9.a
    public Drawable a() {
        return this.f4538b;
    }

    @Override // f9.a
    public int b() {
        return this.f4537a;
    }

    @Override // f9.a
    public String c() {
        if (this.f4542f == this.f4545i) {
            return this.f4544h;
        }
        String str = this.f4543g;
        return (str == null || !str.contains("%")) ? this.f4543g : String.format(Locale.getDefault(), this.f4543g, Integer.valueOf(this.f4542f));
    }

    @Override // f9.a
    public String d() {
        return this.f4539c;
    }

    public int h() {
        return this.f4541e;
    }

    public int i() {
        return this.f4540d;
    }

    public int j() {
        return this.f4542f;
    }

    public int k() {
        return this.f4545i;
    }

    public void l(int i10) {
        this.f4542f = i10;
    }

    public b(int i10, Drawable drawable, String str, int i11, int i12, int i13, String str2, String str3, int i14) {
        this.f4537a = i10;
        this.f4538b = drawable;
        this.f4539c = str;
        this.f4540d = i11;
        this.f4541e = i12;
        this.f4542f = i13;
        this.f4543g = str2;
        this.f4544h = str3;
        this.f4545i = i14;
    }
}
