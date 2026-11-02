package v3;

import com.google.zxing.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t implements com.google.zxing.m {

    /* renamed from: a, reason: collision with root package name */
    public final i f13004a = new i();

    @Override // com.google.zxing.m
    public s3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.f13004a.a('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
    }
}
