package o6;

import android.content.Context;
import android.graphics.Paint;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f10441a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10442b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10443c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10444d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10445e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10446f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10447g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f10448a;

        /* renamed from: b, reason: collision with root package name */
        public int f10449b;

        /* renamed from: c, reason: collision with root package name */
        public int f10450c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f10451d;

        /* renamed from: e, reason: collision with root package name */
        public int f10452e;

        /* renamed from: f, reason: collision with root package name */
        public int f10453f;

        /* renamed from: g, reason: collision with root package name */
        public int f10454g;

        public e h() {
            return new e(this);
        }

        public a i(int i10) {
            this.f10449b = i10;
            return this;
        }

        public a j(int i10) {
            this.f10450c = i10;
            return this;
        }

        public a k(int i10) {
            this.f10448a = i10;
            return this;
        }

        public a l(int i10) {
            this.f10452e = i10;
            return this;
        }

        public a m(int i10) {
            this.f10453f = i10;
            return this;
        }

        public a n(int i10) {
            this.f10454g = i10;
            return this;
        }

        public a o(int i10) {
            this.f10451d = i10;
            return this;
        }
    }

    public e(a aVar) {
        this.f10441a = aVar.f10448a;
        this.f10442b = aVar.f10449b;
        this.f10443c = aVar.f10450c;
        this.f10444d = aVar.f10451d;
        this.f10445e = aVar.f10452e;
        this.f10446f = aVar.f10453f;
        this.f10447g = aVar.f10454g;
    }

    public static a e(Context context) {
        t6.b bVarA = t6.b.a(context);
        return f().k(bVarA.b(4)).j(bVarA.b(1));
    }

    public static a f() {
        return new a();
    }

    public void a(Paint paint) {
        int iA = this.f10442b;
        if (iA == 0) {
            iA = t6.a.a(paint.getColor(), 75);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public void b(Paint paint) {
        paint.setColor(this.f10445e);
        paint.setStyle(Paint.Style.FILL);
    }

    public void c(Paint paint) {
        paint.setColor(this.f10446f);
        paint.setStyle(Paint.Style.FILL);
    }

    public void d(Paint paint) {
        int iA = this.f10444d;
        if (iA == 0) {
            iA = t6.a.a(paint.getColor(), 22);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public int g(Paint paint) {
        int i10 = this.f10443c;
        return i10 == -1 ? (int) (paint.getStrokeWidth() + 0.5f) : i10;
    }

    public int h() {
        return this.f10441a;
    }
}
