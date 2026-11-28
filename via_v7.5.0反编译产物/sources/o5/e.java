package o5;

import android.graphics.Rect;
import android.util.Log;
import n5.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10963b = "e";

    @Override // o5.j
    public float c(v vVar, v vVar2) {
        if (vVar.f10676c <= 0 || vVar.f10677e <= 0) {
            return 0.0f;
        }
        v vVarE = vVar.e(vVar2);
        float fPow = (vVarE.f10676c * 1.0f) / vVar.f10676c;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f10 = ((vVarE.f10676c * 1.0f) / vVar2.f10676c) + ((vVarE.f10677e * 1.0f) / vVar2.f10677e);
        return fPow * ((1.0f / f10) / f10);
    }

    @Override // o5.j
    public Rect d(v vVar, v vVar2) {
        v vVarE = vVar.e(vVar2);
        Log.i(f10963b, "Preview: " + vVar + "; Scaled: " + vVarE + "; Want: " + vVar2);
        int i10 = (vVarE.f10676c - vVar2.f10676c) / 2;
        int i11 = (vVarE.f10677e - vVar2.f10677e) / 2;
        return new Rect(-i10, -i11, vVarE.f10676c - i10, vVarE.f10677e - i11);
    }
}
