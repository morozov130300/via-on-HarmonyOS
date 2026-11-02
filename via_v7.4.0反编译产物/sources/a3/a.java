package a3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f53a;

    /* renamed from: b, reason: collision with root package name */
    public final d[] f54b;

    /* renamed from: c, reason: collision with root package name */
    public final b f55c;

    public a(int i10, d... dVarArr) {
        this.f53a = i10;
        this.f54b = dVarArr;
        this.f55c = new b(i10);
    }

    @Override // a3.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f53a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.f54b) {
            if (stackTraceElementArrA.length <= this.f53a) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f53a ? this.f55c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
