package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import v3.o;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements i {

    /* renamed from: c, reason: collision with root package name */
    public static final i[] f4121c = new i[0];

    /* renamed from: a, reason: collision with root package name */
    public Map f4122a;

    /* renamed from: b, reason: collision with root package name */
    public i[] f4123b;

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
        i[] iVarArr = this.f4123b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return iVar.a(bVar, this.f4122a);
                } catch (ReaderException unused) {
                }
            }
            Map map = this.f4122a;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                bVar.a().c();
                for (i iVar2 : this.f4123b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    try {
                        return iVar2.a(bVar, this.f4122a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public j d(b bVar) {
        if (this.f4123b == null) {
            e(null);
        }
        return c(bVar);
    }

    public void e(Map map) {
        this.f4122a = map;
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z11 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z11 && !z10) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new z3.a());
            }
            if (z11 && z10) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z10) {
                arrayList.add(new o(map));
            }
            arrayList.add(new z3.a());
            if (z10) {
                arrayList.add(new o(map));
            }
        }
        this.f4123b = (i[]) arrayList.toArray(f4121c);
    }

    @Override // com.google.zxing.i
    public void reset() {
        i[] iVarArr = this.f4123b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                iVar.reset();
            }
        }
    }
}
