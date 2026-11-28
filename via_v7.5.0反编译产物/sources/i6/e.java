package i6;

import android.content.Context;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6288g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6291c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6295g;

        public e h() {
            return new e(this);
        }

        public a i(int i10) {
            this.f6290b = i10;
            return this;
        }

        public a j(int i10) {
            this.f6291c = i10;
            return this;
        }

        public a k(int i10) {
            this.f6289a = i10;
            return this;
        }

        public a l(int i10) {
            this.f6293e = i10;
            return this;
        }

        public a m(int i10) {
            this.f6294f = i10;
            return this;
        }

        public a n(int i10) {
            this.f6295g = i10;
            return this;
        }

        public a o(int i10) {
            this.f6292d = i10;
            return this;
        }
    }

    public e(a aVar) {
        this.f6282a = aVar.f6289a;
        this.f6283b = aVar.f6290b;
        this.f6284c = aVar.f6291c;
        this.f6285d = aVar.f6292d;
        this.f6286e = aVar.f6293e;
        this.f6287f = aVar.f6294f;
        this.f6288g = aVar.f6295g;
    }

    public static a e(Context context) {
        n6.b bVarA = n6.b.a(context);
        return f().k(bVarA.b(4)).j(bVarA.b(1));
    }

    public static a f() {
        return new a();
    }

    public void a(Paint paint) {
        int iA = this.f6283b;
        if (iA == 0) {
            iA = n6.a.a(paint.getColor(), 75);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public void b(Paint paint) {
        paint.setColor(this.f6286e);
        paint.setStyle(Paint.Style.FILL);
    }

    public void c(Paint paint) {
        paint.setColor(this.f6287f);
        paint.setStyle(Paint.Style.FILL);
    }

    public void d(Paint paint) {
        int iA = this.f6285d;
        if (iA == 0) {
            iA = n6.a.a(paint.getColor(), 22);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public int g(Paint paint) {
        int i10 = this.f6284c;
        return i10 == -1 ? (int) (paint.getStrokeWidth() + 0.5f) : i10;
    }

    public int h() {
        return this.f6282a;
    }
}
