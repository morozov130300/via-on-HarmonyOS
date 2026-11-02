package com.google.zxing.qrcode.decoder;

import s3.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return i11 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 + i11) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 / 2) + (i11 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (i10 * i11) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i10, int i11) {
            return (((i10 + i11) + ((i10 * i11) % 3)) & 1) == 0;
        }
    };

    public abstract boolean isMasked(int i10, int i11);

    public final void unmaskBitMatrix(b bVar, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (isMasked(i11, i12)) {
                    bVar.d(i12, i11);
                }
            }
        }
    }
}
