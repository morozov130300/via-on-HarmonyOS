package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import java.util.Map;
import w3.a0;
import w3.n;
import w3.t;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements m {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3421a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f3421a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3421a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3421a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3421a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3421a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3421a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3421a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3421a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3421a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3421a[BarcodeFormat.CODABAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.google.zxing.m
    public t3.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) {
        m kVar;
        switch (a.f3421a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new w3.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new w3.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new a4.b();
                break;
            case 6:
                kVar = new w3.e();
                break;
            case 7:
                kVar = new w3.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new n();
                break;
            case 10:
                kVar = new w3.b();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.a(str, barcodeFormat, i10, i11, map);
    }
}
