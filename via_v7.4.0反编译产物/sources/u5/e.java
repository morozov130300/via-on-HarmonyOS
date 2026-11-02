package u5;

import android.graphics.Rect;
import android.util.Log;
import t5.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends j {

    /* renamed from: b, reason: collision with root package name */
    public static final String f12864b = "e";

    @Override // u5.j
    public float c(v vVar, v vVar2) {
        if (vVar.f12247e <= 0 || vVar.f12248j <= 0) {
            return 0.0f;
        }
        v vVarC = vVar.c(vVar2);
        float fPow = (vVarC.f12247e * 1.0f) / vVar.f12247e;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f10 = ((vVarC.f12247e * 1.0f) / vVar2.f12247e) + ((vVarC.f12248j * 1.0f) / vVar2.f12248j);
        return fPow * ((1.0f / f10) / f10);
    }

    @Override // u5.j
    public Rect d(v vVar, v vVar2) {
        v vVarC = vVar.c(vVar2);
        Log.i(f12864b, "Preview: " + vVar + "; Scaled: " + vVarC + "; Want: " + vVar2);
        int i10 = (vVarC.f12247e - vVar2.f12247e) / 2;
        int i11 = (vVarC.f12248j - vVar2.f12248j) / 2;
        return new Rect(-i10, -i11, vVarC.f12247e - i10, vVarC.f12248j - i11);
    }
}
