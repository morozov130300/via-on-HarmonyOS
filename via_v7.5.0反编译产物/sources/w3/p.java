package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x[] f13615b = new x[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x[] f13616a;

    public p(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f13616a = (x[]) arrayList.toArray(f13615b);
    }

    @Override // w3.q
    public com.google.zxing.j c(int i10, t3.a aVar, Map map) throws NotFoundException {
        int[] iArrP = x.p(aVar);
        for (x xVar : this.f13616a) {
            try {
                com.google.zxing.j jVarM = xVar.m(i10, aVar, iArrP, map);
                boolean z10 = jVarM.b() == BarcodeFormat.EAN_13 && jVarM.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z11 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z10 || !z11) {
                    return jVarM;
                }
                com.google.zxing.j jVar = new com.google.zxing.j(jVarM.f().substring(1), jVarM.c(), jVarM.e(), BarcodeFormat.UPC_A);
                jVar.g(jVarM.d());
                return jVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // w3.q, com.google.zxing.i
    public void reset() {
        for (x xVar : this.f13616a) {
            xVar.reset();
        }
    }
}
