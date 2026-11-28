package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1511b = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1512a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1516e;

        public void a(int i10) {
            this.f1512a = i10 | this.f1512a;
        }

        public boolean b() {
            int i10 = this.f1512a;
            if ((i10 & 7) != 0 && (i10 & c(this.f1515d, this.f1513b)) == 0) {
                return false;
            }
            int i11 = this.f1512a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f1515d, this.f1514c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f1512a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f1516e, this.f1513b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f1512a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f1516e, this.f1514c) << 12)) != 0;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f1512a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f1513b = i10;
            this.f1514c = i11;
            this.f1515d = i12;
            this.f1516e = i13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public w(b bVar) {
        this.f1510a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int iC = this.f1510a.c();
        int iD = this.f1510a.d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View viewA = this.f1510a.a(i10);
            this.f1511b.e(iC, iD, this.f1510a.b(viewA), this.f1510a.e(viewA));
            if (i12 != 0) {
                this.f1511b.d();
                this.f1511b.a(i12);
                if (this.f1511b.b()) {
                    return viewA;
                }
            }
            if (i13 != 0) {
                this.f1511b.d();
                this.f1511b.a(i13);
                if (this.f1511b.b()) {
                    view = viewA;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f1511b.e(this.f1510a.c(), this.f1510a.d(), this.f1510a.b(view), this.f1510a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f1511b.d();
        this.f1511b.a(i10);
        return this.f1511b.b();
    }
}
