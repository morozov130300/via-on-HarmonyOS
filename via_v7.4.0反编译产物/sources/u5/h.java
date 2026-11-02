package u5;

import android.graphics.Rect;
import t5.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends j {
    public static float e(float f10) {
        return f10 < 1.0f ? 1.0f / f10 : f10;
    }

    @Override // u5.j
    public float c(v vVar, v vVar2) {
        int i10 = vVar.f12247e;
        if (i10 <= 0 || vVar.f12248j <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i10 * 1.0f) / vVar2.f12247e)) / e((vVar.f12248j * 1.0f) / vVar2.f12248j);
        float fE2 = e(((vVar.f12247e * 1.0f) / vVar.f12248j) / ((vVar2.f12247e * 1.0f) / vVar2.f12248j));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // u5.j
    public Rect d(v vVar, v vVar2) {
        return new Rect(0, 0, vVar2.f12247e, vVar2.f12248j);
    }
}
