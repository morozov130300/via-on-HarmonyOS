package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k[] f3435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BarcodeFormat f3436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f3437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3438g;

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, kVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(k[] kVarArr) {
        k[] kVarArr2 = this.f3435d;
        if (kVarArr2 == null) {
            this.f3435d = kVarArr;
            return;
        }
        if (kVarArr == null || kVarArr.length <= 0) {
            return;
        }
        k[] kVarArr3 = new k[kVarArr2.length + kVarArr.length];
        System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
        System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
        this.f3435d = kVarArr3;
    }

    public BarcodeFormat b() {
        return this.f3436e;
    }

    public byte[] c() {
        return this.f3433b;
    }

    public Map d() {
        return this.f3437f;
    }

    public k[] e() {
        return this.f3435d;
    }

    public String f() {
        return this.f3432a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f3437f;
            if (map2 == null) {
                this.f3437f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f3437f == null) {
            this.f3437f = new EnumMap(ResultMetadataType.class);
        }
        this.f3437f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f3432a;
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, kVarArr, barcodeFormat, j10);
    }

    public j(String str, byte[] bArr, int i10, k[] kVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f3432a = str;
        this.f3433b = bArr;
        this.f3434c = i10;
        this.f3435d = kVarArr;
        this.f3436e = barcodeFormat;
        this.f3437f = null;
        this.f3438g = j10;
    }
}
