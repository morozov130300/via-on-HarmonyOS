package w;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f13209a;

    /* renamed from: b, reason: collision with root package name */
    public int f13210b;

    public f(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f13209a = new Object[i10];
    }

    @Override // w.e
    public boolean a(Object obj) {
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f13210b;
        Object[] objArr = this.f13209a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f13210b = i10 + 1;
        return true;
    }

    @Override // w.e
    public Object b() {
        int i10 = this.f13210b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f13209a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f13210b = i10 - 1;
        return obj;
    }

    public final boolean c(Object obj) {
        for (int i10 = 0; i10 < this.f13210b; i10++) {
            if (this.f13209a[i10] == obj) {
                return true;
            }
        }
        return false;
    }
}
