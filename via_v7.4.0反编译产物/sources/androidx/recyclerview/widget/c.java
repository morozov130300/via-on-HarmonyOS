package androidx.recyclerview.widget;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements o {

    /* renamed from: a, reason: collision with root package name */
    public final o f1381a;

    /* renamed from: b, reason: collision with root package name */
    public int f1382b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1383c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1384d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f1385e = null;

    public c(o oVar) {
        this.f1381a = oVar;
    }

    @Override // androidx.recyclerview.widget.o
    public void a(int i10, int i11) {
        e();
        this.f1381a.a(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void b(int i10, int i11) {
        int i12;
        if (this.f1382b == 1 && i10 >= (i12 = this.f1383c)) {
            int i13 = this.f1384d;
            if (i10 <= i12 + i13) {
                this.f1384d = i13 + i11;
                this.f1383c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f1383c = i10;
        this.f1384d = i11;
        this.f1382b = 1;
    }

    @Override // androidx.recyclerview.widget.o
    public void c(int i10, int i11) {
        int i12;
        if (this.f1382b == 2 && (i12 = this.f1383c) >= i10 && i12 <= i10 + i11) {
            this.f1384d += i11;
            this.f1383c = i10;
        } else {
            e();
            this.f1383c = i10;
            this.f1384d = i11;
            this.f1382b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.o
    public void d(int i10, int i11, Object obj) {
        int i12;
        if (this.f1382b == 3) {
            int i13 = this.f1383c;
            int i14 = this.f1384d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f1385e == obj) {
                this.f1383c = Math.min(i10, i13);
                this.f1384d = Math.max(i14 + i13, i12) - this.f1383c;
                return;
            }
        }
        e();
        this.f1383c = i10;
        this.f1384d = i11;
        this.f1385e = obj;
        this.f1382b = 3;
    }

    public void e() {
        int i10 = this.f1382b;
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            this.f1381a.b(this.f1383c, this.f1384d);
        } else if (i10 == 2) {
            this.f1381a.c(this.f1383c, this.f1384d);
        } else if (i10 == 3) {
            this.f1381a.d(this.f1383c, this.f1384d, this.f1385e);
        }
        this.f1385e = null;
        this.f1382b = 0;
    }
}
