package v5;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends t5.a {
    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(g gVar) {
        return gVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, g gVar2) {
        super.b(gVar, gVar2);
        gVar.X(i.f13392c, gVar2.a());
        int i10 = i.f13393e;
        gVar.X(i10, gVar2.d());
        gVar.Y(i10, !TextUtils.isEmpty(gVar2.d()));
        gVar.T(i.f13394m, gVar2.i());
        gVar.f1138a.setAlpha(gVar2.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!gVar2.e());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        i iVar = new i(context);
        iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(iVar);
    }
}
