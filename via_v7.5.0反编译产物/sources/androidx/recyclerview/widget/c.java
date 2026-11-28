package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f1282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1283b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1284c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1285d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1286e = null;

    public c(o oVar) {
        this.f1282a = oVar;
    }

    @Override // androidx.recyclerview.widget.o
    public void a(int i10, int i11) {
        e();
        this.f1282a.a(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void b(int i10, int i11) {
        int i12;
        if (this.f1283b == 1 && i10 >= (i12 = this.f1284c)) {
            int i13 = this.f1285d;
            if (i10 <= i12 + i13) {
                this.f1285d = i13 + i11;
                this.f1284c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f1284c = i10;
        this.f1285d = i11;
        this.f1283b = 1;
    }

    @Override // androidx.recyclerview.widget.o
    public void c(int i10, int i11) {
        int i12;
        if (this.f1283b == 2 && (i12 = this.f1284c) >= i10 && i12 <= i10 + i11) {
            this.f1285d += i11;
            this.f1284c = i10;
        } else {
            e();
            this.f1284c = i10;
            this.f1285d = i11;
            this.f1283b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.o
    public void d(int i10, int i11, Object obj) {
        int i12;
        if (this.f1283b == 3) {
            int i13 = this.f1284c;
            int i14 = this.f1285d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f1286e == obj) {
                this.f1284c = Math.min(i10, i13);
                this.f1285d = Math.max(i14 + i13, i12) - this.f1284c;
                return;
            }
        }
        e();
        this.f1284c = i10;
        this.f1285d = i11;
        this.f1286e = obj;
        this.f1283b = 3;
    }

    public void e() {
        int i10 = this.f1283b;
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            this.f1282a.b(this.f1284c, this.f1285d);
        } else if (i10 == 2) {
            this.f1282a.c(this.f1284c, this.f1285d);
        } else if (i10 == 3) {
            this.f1282a.d(this.f1284c, this.f1285d, this.f1286e);
        }
        this.f1286e = null;
        this.f1283b = 0;
    }
}
