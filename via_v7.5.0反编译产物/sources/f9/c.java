package f9;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends f9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f4556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4558d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f4560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4562d;

        public b(int i10) {
            this.f4559a = i10;
        }

        public c a() {
            return new c(this.f4559a, this.f4560b, this.f4561c, this.f4562d);
        }

        public b b(Drawable drawable) {
            this.f4560b = drawable;
            return this;
        }

        public b c(String str) {
            this.f4562d = str;
            return this;
        }

        public b d(String str) {
            this.f4561c = str;
            return this;
        }
    }

    @Override // f9.a
    public Drawable a() {
        return this.f4556b;
    }

    @Override // f9.a
    public int b() {
        return this.f4555a;
    }

    @Override // f9.a
    public String c() {
        return this.f4558d;
    }

    @Override // f9.a
    public String d() {
        return this.f4557c;
    }

    public void h(String str) {
        this.f4558d = str;
    }

    public c(int i10, Drawable drawable, String str, String str2) {
        this.f4555a = i10;
        this.f4556b = drawable;
        this.f4557c = str;
        this.f4558d = str2;
    }
}
