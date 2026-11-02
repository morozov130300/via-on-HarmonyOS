package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import v3.a0;
import v3.n;
import v3.t;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f implements m {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4124a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f4124a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4124a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4124a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4124a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4124a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4124a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4124a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4124a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4124a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4124a[BarcodeFormat.CODABAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.google.zxing.m
    public s3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) {
        m kVar;
        switch (a.f4124a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new v3.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                kVar = new v3.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new z3.b();
                break;
            case 6:
                kVar = new v3.e();
                break;
            case 7:
                kVar = new v3.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new n();
                break;
            case 10:
                kVar = new v3.b();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.a(str, barcodeFormat, i10, i11, map);
    }
}
