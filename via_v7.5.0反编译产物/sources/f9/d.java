package f9;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends f9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f4564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4569g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f4571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f4574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f4575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4576g;

        public b(int i10) {
            this.f4570a = i10;
        }

        public d a() {
            return new d(this.f4570a, this.f4571b, this.f4572c, this.f4573d, this.f4574e, this.f4575f, this.f4576g);
        }

        public b b(Drawable drawable) {
            this.f4571b = drawable;
            return this;
        }

        public b c(String str, String str2) {
            this.f4574e = str;
            this.f4575f = str2;
            return this;
        }

        public b d(boolean z10) {
            this.f4576g = z10;
            return this;
        }

        public b e(String str, String str2) {
            this.f4572c = str;
            this.f4573d = str2;
            return this;
        }
    }

    @Override // f9.a
    public Drawable a() {
        return this.f4564b;
    }

    @Override // f9.a
    public int b() {
        return this.f4563a;
    }

    @Override // f9.a
    public String c() {
        String str;
        return (this.f4569g || (str = this.f4568f) == null) ? this.f4566d : str;
    }

    @Override // f9.a
    public String d() {
        String str;
        return (this.f4569g || (str = this.f4567e) == null) ? this.f4565c : str;
    }

    public boolean h() {
        return this.f4569g;
    }

    public void i(boolean z10) {
        this.f4569g = z10;
    }

    public d(int i10, Drawable drawable, String str, String str2, String str3, String str4, boolean z10) {
        this.f4563a = i10;
        this.f4564b = drawable;
        this.f4565c = str;
        this.f4566d = str2;
        this.f4567e = str3;
        this.f4568f = str4;
        this.f4569g = z10;
    }
}
