package o5;

import android.graphics.Rect;
import n5.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends j {
    public static float e(float f10) {
        return f10 < 1.0f ? 1.0f / f10 : f10;
    }

    @Override // o5.j
    public float c(v vVar, v vVar2) {
        int i10 = vVar.f10676c;
        if (i10 <= 0 || vVar.f10677e <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i10 * 1.0f) / vVar2.f10676c)) / e((vVar.f10677e * 1.0f) / vVar2.f10677e);
        float fE2 = e(((vVar.f10676c * 1.0f) / vVar.f10677e) / ((vVar2.f10676c * 1.0f) / vVar2.f10677e));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // o5.j
    public Rect d(v vVar, v vVar2) {
        return new Rect(0, 0, vVar2.f10676c, vVar2.f10677e);
    }
}
