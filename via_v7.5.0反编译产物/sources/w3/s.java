package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s extends x {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x f13618i = new h();

    public static com.google.zxing.j s(com.google.zxing.j jVar) throws FormatException {
        String strF = jVar.f();
        if (strF.charAt(0) != '0') {
            throw FormatException.getFormatInstance();
        }
        com.google.zxing.j jVar2 = new com.google.zxing.j(strF.substring(1), null, jVar.e(), BarcodeFormat.UPC_A);
        if (jVar.d() != null) {
            jVar2.g(jVar.d());
        }
        return jVar2;
    }

    @Override // w3.q, com.google.zxing.i
    public com.google.zxing.j a(com.google.zxing.b bVar, Map map) {
        return s(this.f13618i.a(bVar, map));
    }

    @Override // w3.q, com.google.zxing.i
    public com.google.zxing.j b(com.google.zxing.b bVar) {
        return s(this.f13618i.b(bVar));
    }

    @Override // w3.x, w3.q
    public com.google.zxing.j c(int i10, t3.a aVar, Map map) {
        return s(this.f13618i.c(i10, aVar, map));
    }

    @Override // w3.x
    public int l(t3.a aVar, int[] iArr, StringBuilder sb2) {
        return this.f13618i.l(aVar, iArr, sb2);
    }

    @Override // w3.x
    public com.google.zxing.j m(int i10, t3.a aVar, int[] iArr, Map map) {
        return s(this.f13618i.m(i10, aVar, iArr, map));
    }

    @Override // w3.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}
