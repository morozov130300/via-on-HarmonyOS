package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import w3.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i[] f3418c = new i[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f3419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i[] f3420b;

    @Override // com.google.zxing.i
    public j a(b bVar, Map map) {
        e(map);
        return c(bVar);
    }

    @Override // com.google.zxing.i
    public j b(b bVar) {
        e(null);
        return c(bVar);
    }

    public final j c(b bVar) throws NotFoundException {
        i[] iVarArr = this.f3420b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return iVar.a(bVar, this.f3419a);
                } catch (ReaderException unused) {
                }
            }
            Map map = this.f3419a;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                bVar.a().d();
                for (i iVar2 : this.f3420b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    try {
                        return iVar2.a(bVar, this.f3419a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public j d(b bVar) {
        if (this.f3420b == null) {
            e(null);
        }
        return c(bVar);
    }

    public void e(Map map) {
        this.f3419a = map;
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z11 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z11 && !z10) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new a4.a());
            }
            if (z11 && z10) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z10) {
                arrayList.add(new o(map));
            }
            arrayList.add(new a4.a());
            if (z10) {
                arrayList.add(new o(map));
            }
        }
        this.f3420b = (i[]) arrayList.toArray(f3418c);
    }

    @Override // com.google.zxing.i
    public void reset() {
        i[] iVarArr = this.f3420b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                iVar.reset();
            }
        }
    }
}
