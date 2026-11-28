package v5;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tuyafeng.support.utils.x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s extends t5.a {
    public s() {
    }

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(q qVar) {
        return qVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, q qVar) {
        super.b(gVar, qVar);
        int i10 = r.f13418c;
        gVar.X(i10, qVar.a());
        int i11 = r.f13419e;
        gVar.X(i11, qVar.d());
        gVar.Y(i11, !TextUtils.isEmpty(qVar.d()));
        x.P(gVar.f1138a, qVar.f() ? new ColorDrawable(com.tuyafeng.support.utils.f.b(gVar.O(), w7.m.f13738b)) : com.tuyafeng.support.utils.f.e(gVar.O(), w7.o.f13786e));
        gVar.P(i10).setAlpha(qVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(qVar.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!qVar.e());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        r rVar = new r(context);
        rVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(rVar);
    }

    public s(t5.g gVar) {
        super(gVar);
    }
}
