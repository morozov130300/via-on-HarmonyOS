package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f4135a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4136b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4137c;

    /* renamed from: d, reason: collision with root package name */
    public k[] f4138d;

    /* renamed from: e, reason: collision with root package name */
    public final BarcodeFormat f4139e;

    /* renamed from: f, reason: collision with root package name */
    public Map f4140f;

    /* renamed from: g, reason: collision with root package name */
    public final long f4141g;

    public j(String str, byte[] bArr, int i10, k[] kVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f4135a = str;
        this.f4136b = bArr;
        this.f4137c = i10;
        this.f4138d = kVarArr;
        this.f4139e = barcodeFormat;
        this.f4140f = null;
        this.f4141g = j10;
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, kVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, kVarArr, barcodeFormat, j10);
    }

    public void a(k[] kVarArr) {
        k[] kVarArr2 = this.f4138d;
        if (kVarArr2 == null) {
            this.f4138d = kVarArr;
            return;
        }
        if (kVarArr == null || kVarArr.length <= 0) {
            return;
        }
        k[] kVarArr3 = new k[kVarArr2.length + kVarArr.length];
        System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
        System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
        this.f4138d = kVarArr3;
    }

    public BarcodeFormat b() {
        return this.f4139e;
    }

    public byte[] c() {
        return this.f4136b;
    }

    public Map d() {
        return this.f4140f;
    }

    public k[] e() {
        return this.f4138d;
    }

    public String f() {
        return this.f4135a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f4140f;
            if (map2 == null) {
                this.f4140f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f4140f == null) {
            this.f4140f = new EnumMap(ResultMetadataType.class);
        }
        this.f4140f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f4135a;
    }
}
