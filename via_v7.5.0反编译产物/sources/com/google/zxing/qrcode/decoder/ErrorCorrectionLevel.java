package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ErrorCorrectionLevel[] f3452c;
    private final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f3452c = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i10) {
        this.bits = i10;
    }

    public static ErrorCorrectionLevel forBits(int i10) {
        if (i10 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = f3452c;
            if (i10 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i10];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
