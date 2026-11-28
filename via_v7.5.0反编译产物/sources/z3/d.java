package z3;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends h {
    public d(t3.a aVar) {
        super(aVar);
    }

    @Override // z3.j
    public String d() throws NotFoundException {
        if (c().n() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        int iF = b().f(48, 2);
        sb2.append("(393");
        sb2.append(iF);
        sb2.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb2.append('0');
        }
        if (iF2 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(iF2);
        sb2.append(b().c(60, null).b());
        return sb2.toString();
    }
}
