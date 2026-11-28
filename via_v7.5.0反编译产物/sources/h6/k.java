package h6;

import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static TextView a(Spanned spanned) {
        k[] kVarArr = (k[]) spanned.getSpans(0, spanned.length(), k.class);
        if (kVarArr == null || kVarArr.length <= 0) {
            return null;
        }
        k kVar = kVarArr[0];
        throw null;
    }
}
