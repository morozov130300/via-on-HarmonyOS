package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final b f1386a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1387b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final List f1388c = new ArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f1389a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f1390b;

        public void a(int i10) {
            if (i10 < 64) {
                this.f1389a &= (1 << i10) ^ (-1);
                return;
            }
            a aVar = this.f1390b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public int b(int i10) {
            a aVar = this.f1390b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f1389a) : Long.bitCount(this.f1389a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f1389a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f1389a);
        }

        public final void c() {
            if (this.f1390b == null) {
                this.f1390b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f1389a & (1 << i10)) != 0;
            }
            c();
            return this.f1390b.d(i10 - 64);
        }

        public void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f1390b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f1389a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f1389a = ((j10 & (j11 ^ (-1))) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f1390b != null) {
                c();
                this.f1390b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f1390b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f1389a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (j10 ^ (-1));
            this.f1389a = j12;
            long j13 = j10 - 1;
            this.f1389a = (j12 & j13) | Long.rotateRight((j13 ^ (-1)) & j12, 1);
            a aVar = this.f1390b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1390b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f1389a = 0L;
            a aVar = this.f1390b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 < 64) {
                this.f1389a |= 1 << i10;
            } else {
                c();
                this.f1390b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f1390b == null) {
                return Long.toBinaryString(this.f1389a);
            }
            return this.f1390b.toString() + "xx" + Long.toBinaryString(this.f1389a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        View a(int i10);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.c0 f(View view);

        void g(int i10);

        void h(View view);

        void i(View view, int i10);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public d(b bVar) {
        this.f1386a = bVar;
    }

    public void a(View view, int i10, boolean z10) {
        int iC = i10 < 0 ? this.f1386a.c() : h(i10);
        this.f1387b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f1386a.i(view, iC);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int iC = i10 < 0 ? this.f1386a.c() : h(i10);
        this.f1387b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f1386a.k(view, iC, layoutParams);
    }

    public void d(int i10) {
        int iH = h(i10);
        this.f1387b.f(iH);
        this.f1386a.g(iH);
    }

    public View e(int i10) {
        int size = this.f1388c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f1388c.get(i11);
            RecyclerView.c0 c0VarF = this.f1386a.f(view);
            if (c0VarF.o() == i10 && !c0VarF.v() && !c0VarF.x()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f1386a.a(h(i10));
    }

    public int g() {
        return this.f1386a.c() - this.f1388c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int iC = this.f1386a.c();
        int i11 = i10;
        while (i11 < iC) {
            int iB = i10 - (i11 - this.f1387b.b(i11));
            if (iB == 0) {
                while (this.f1387b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iB;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f1386a.a(i10);
    }

    public int j() {
        return this.f1386a.c();
    }

    public void k(View view) {
        int iE = this.f1386a.e(view);
        if (iE >= 0) {
            this.f1387b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f1388c.add(view);
        this.f1386a.b(view);
    }

    public int m(View view) {
        int iE = this.f1386a.e(view);
        if (iE == -1 || this.f1387b.d(iE)) {
            return -1;
        }
        return iE - this.f1387b.b(iE);
    }

    public boolean n(View view) {
        return this.f1388c.contains(view);
    }

    public void o() {
        this.f1387b.g();
        for (int size = this.f1388c.size() - 1; size >= 0; size--) {
            this.f1386a.h((View) this.f1388c.get(size));
            this.f1388c.remove(size);
        }
        this.f1386a.d();
    }

    public void p(View view) {
        int iE = this.f1386a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f1387b.f(iE)) {
            t(view);
        }
        this.f1386a.j(iE);
    }

    public void q(int i10) {
        int iH = h(i10);
        View viewA = this.f1386a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f1387b.f(iH)) {
            t(viewA);
        }
        this.f1386a.j(iH);
    }

    public boolean r(View view) {
        int iE = this.f1386a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f1387b.d(iE)) {
            return false;
        }
        this.f1387b.f(iE);
        t(view);
        this.f1386a.j(iE);
        return true;
    }

    public void s(View view) {
        int iE = this.f1386a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1387b.d(iE)) {
            this.f1387b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f1388c.remove(view)) {
            return false;
        }
        this.f1386a.h(view);
        return true;
    }

    public String toString() {
        return this.f1387b.toString() + ", hidden list:" + this.f1388c.size();
    }
}
