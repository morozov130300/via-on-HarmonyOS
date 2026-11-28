package w3;

import com.google.zxing.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t implements com.google.zxing.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f13619a = new i();

    @Override // com.google.zxing.m
    public t3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.f13619a.a('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
    }
}
