package t5;

import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static List a(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 != 0) {
            if ((i10 & 1) == 1) {
                arrayList.add(BarcodeFormat.AZTEC);
            }
            if ((i10 & 2) == 2) {
                arrayList.add(BarcodeFormat.CODABAR);
            }
            if ((i10 & 4) == 4) {
                arrayList.add(BarcodeFormat.CODE_39);
            }
            if ((i10 & 8) == 8) {
                arrayList.add(BarcodeFormat.CODE_93);
            }
            if ((i10 & 16) == 16) {
                arrayList.add(BarcodeFormat.CODE_128);
            }
            if ((i10 & 32) == 32) {
                arrayList.add(BarcodeFormat.DATA_MATRIX);
            }
            if ((i10 & 64) == 64) {
                arrayList.add(BarcodeFormat.EAN_8);
            }
            if ((i10 & 128) == 128) {
                arrayList.add(BarcodeFormat.EAN_13);
            }
            if ((i10 & 256) == 256) {
                arrayList.add(BarcodeFormat.ITF);
            }
            if ((i10 & 512) == 512) {
                arrayList.add(BarcodeFormat.MAXICODE);
            }
            if ((i10 & 1024) == 1024) {
                arrayList.add(BarcodeFormat.PDF_417);
            }
            if ((i10 & 2048) == 2048) {
                arrayList.add(BarcodeFormat.QR_CODE);
            }
            if ((i10 & 4096) == 4096) {
                arrayList.add(BarcodeFormat.RSS_14);
            }
            if ((i10 & 8192) == 8192) {
                arrayList.add(BarcodeFormat.RSS_EXPANDED);
            }
            if ((i10 & 16384) == 16384) {
                arrayList.add(BarcodeFormat.UPC_A);
            }
            if ((i10 & 32768) == 32768) {
                arrayList.add(BarcodeFormat.UPC_E);
            }
            if ((i10 & 65536) == 65536) {
                arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
            }
        }
        return arrayList;
    }
}
