package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final b f1609a;

    /* renamed from: b, reason: collision with root package name */
    public a f1610b = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1611a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f1612b;

        /* renamed from: c, reason: collision with root package name */
        public int f1613c;

        /* renamed from: d, reason: collision with root package name */
        public int f1614d;

        /* renamed from: e, reason: collision with root package name */
        public int f1615e;

        public void a(int i10) {
            this.f1611a = i10 | this.f1611a;
        }

        public boolean b() {
            int i10 = this.f1611a;
            if ((i10 & 7) != 0 && (i10 & c(this.f1614d, this.f1612b)) == 0) {
                return false;
            }
            int i11 = this.f1611a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f1614d, this.f1613c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f1611a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f1615e, this.f1612b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f1611a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f1615e, this.f1613c) << 12)) != 0;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f1611a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f1612b = i10;
            this.f1613c = i11;
            this.f1614d = i12;
            this.f1615e = i13;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public w(b bVar) {
        this.f1609a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int iC = this.f1609a.c();
        int iD = this.f1609a.d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View viewA = this.f1609a.a(i10);
            this.f1610b.e(iC, iD, this.f1609a.b(viewA), this.f1609a.e(viewA));
            if (i12 != 0) {
                this.f1610b.d();
                this.f1610b.a(i12);
                if (this.f1610b.b()) {
                    return viewA;
                }
            }
            if (i13 != 0) {
                this.f1610b.d();
                this.f1610b.a(i13);
                if (this.f1610b.b()) {
                    view = viewA;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f1610b.e(this.f1609a.c(), this.f1609a.d(), this.f1609a.b(view), this.f1609a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f1610b.d();
        this.f1610b.a(i10);
        return this.f1610b.b();
    }
}
