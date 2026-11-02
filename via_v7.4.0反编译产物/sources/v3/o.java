package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final q[] f12998b = new q[0];

    /* renamed from: a, reason: collision with root package name */
    public final q[] f12999a;

    public o(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z10 = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new d(z10));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new w3.e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new x3.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new d());
            arrayList.add(new a());
            arrayList.add(new f());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new w3.e());
            arrayList.add(new x3.d());
        }
        this.f12999a = (q[]) arrayList.toArray(f12998b);
    }

    @Override // v3.q
    public com.google.zxing.j c(int i10, s3.a aVar, Map map) throws NotFoundException {
        for (q qVar : this.f12999a) {
            try {
                return qVar.c(i10, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // v3.q, com.google.zxing.i
    public void reset() {
        for (q qVar : this.f12999a) {
            qVar.reset();
        }
    }
}
