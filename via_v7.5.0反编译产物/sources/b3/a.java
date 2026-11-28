package b3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f1721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1722c;

    public a(int i10, d... dVarArr) {
        this.f1720a = i10;
        this.f1721b = dVarArr;
        this.f1722c = new b(i10);
    }

    @Override // b3.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f1720a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.f1721b) {
            if (stackTraceElementArrA.length <= this.f1720a) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f1720a ? this.f1722c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
