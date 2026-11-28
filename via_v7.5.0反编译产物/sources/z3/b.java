package z3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {
    public b(t3.a aVar) {
        super(aVar);
    }

    @Override // z3.i
    public void h(StringBuilder sb2, int i10) {
        if (i10 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // z3.i
    public int i(int i10) {
        return i10 < 10000 ? i10 : i10 - 10000;
    }
}
