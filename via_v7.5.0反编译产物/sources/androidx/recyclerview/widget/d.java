package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1288b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1289c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f1290a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f1291b;

        public void a(int i10) {
            if (i10 < 64) {
                this.f1290a &= (1 << i10) ^ (-1);
                return;
            }
            a aVar = this.f1291b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public int b(int i10) {
            a aVar = this.f1291b;
            if (aVar == null) {
                return i10 >= 64 ? Long.bitCount(this.f1290a) : Long.bitCount(this.f1290a & ((1 << i10) - 1));
            }
            return i10 < 64 ? Long.bitCount(this.f1290a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f1290a);
        }

        public final void c() {
            if (this.f1291b == null) {
                this.f1291b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f1290a & (1 << i10)) != 0;
            }
            c();
            return this.f1291b.d(i10 - 64);
        }

        public void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f1291b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f1290a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f1290a = ((j10 & (j11 ^ (-1))) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f1291b != null) {
                c();
                this.f1291b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f1291b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f1290a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (j10 ^ (-1));
            this.f1290a = j12;
            long j13 = j10 - 1;
            this.f1290a = (j12 & j13) | Long.rotateRight((j13 ^ (-1)) & j12, 1);
            a aVar = this.f1291b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1291b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f1290a = 0L;
            a aVar = this.f1291b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 < 64) {
                this.f1290a |= 1 << i10;
            } else {
                c();
                this.f1291b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f1291b == null) {
                return Long.toBinaryString(this.f1290a);
            }
            return this.f1291b.toString() + "xx" + Long.toBinaryString(this.f1290a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        View a(int i10);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.d0 f(View view);

        void g(int i10);

        void h(View view);

        void i(View view, int i10);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public d(b bVar) {
        this.f1287a = bVar;
    }

    public void a(View view, int i10, boolean z10) {
        int iC = i10 < 0 ? this.f1287a.c() : h(i10);
        this.f1288b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f1287a.i(view, iC);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int iC = i10 < 0 ? this.f1287a.c() : h(i10);
        this.f1288b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f1287a.k(view, iC, layoutParams);
    }

    public void d(int i10) {
        int iH = h(i10);
        this.f1288b.f(iH);
        this.f1287a.g(iH);
    }

    public View e(int i10) {
        int size = this.f1289c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f1289c.get(i11);
            RecyclerView.d0 d0VarF = this.f1287a.f(view);
            if (d0VarF.o() == i10 && !d0VarF.v() && !d0VarF.x()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f1287a.a(h(i10));
    }

    public int g() {
        return this.f1287a.c() - this.f1289c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int iC = this.f1287a.c();
        int i11 = i10;
        while (i11 < iC) {
            int iB = i10 - (i11 - this.f1288b.b(i11));
            if (iB == 0) {
                while (this.f1288b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iB;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f1287a.a(i10);
    }

    public int j() {
        return this.f1287a.c();
    }

    public void k(View view) {
        int iE = this.f1287a.e(view);
        if (iE >= 0) {
            this.f1288b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f1289c.add(view);
        this.f1287a.b(view);
    }

    public int m(View view) {
        int iE = this.f1287a.e(view);
        if (iE == -1 || this.f1288b.d(iE)) {
            return -1;
        }
        return iE - this.f1288b.b(iE);
    }

    public boolean n(View view) {
        return this.f1289c.contains(view);
    }

    public void o() {
        this.f1288b.g();
        for (int size = this.f1289c.size() - 1; size >= 0; size--) {
            this.f1287a.h((View) this.f1289c.get(size));
            this.f1289c.remove(size);
        }
        this.f1287a.d();
    }

    public void p(View view) {
        int iE = this.f1287a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f1288b.f(iE)) {
            t(view);
        }
        this.f1287a.j(iE);
    }

    public void q(int i10) {
        int iH = h(i10);
        View viewA = this.f1287a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f1288b.f(iH)) {
            t(viewA);
        }
        this.f1287a.j(iH);
    }

    public boolean r(View view) {
        int iE = this.f1287a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f1288b.d(iE)) {
            return false;
        }
        this.f1288b.f(iE);
        t(view);
        this.f1287a.j(iE);
        return true;
    }

    public void s(View view) {
        int iE = this.f1287a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1288b.d(iE)) {
            this.f1288b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f1289c.remove(view)) {
            return false;
        }
        this.f1287a.h(view);
        return true;
    }

    public String toString() {
        return this.f1288b.toString() + ", hidden list:" + this.f1289c.size();
    }
}
