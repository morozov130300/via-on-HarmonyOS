package t5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends a {
    @Override // t5.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, Object obj) {
        super.b(gVar, obj);
        l(gVar, obj, gVar.l());
    }

    public abstract void l(w5.g gVar, Object obj, int i10);

    public void m(w5.g gVar, Object obj, int i10, List list) {
        l(gVar, obj, i10);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, Object obj, List list) {
        super.b(gVar, obj);
        if (list.isEmpty()) {
            l(gVar, obj, gVar.l());
        } else {
            m(gVar, obj, gVar.l(), list);
        }
    }

    public abstract View o(ViewGroup viewGroup);

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g(o(viewGroup));
    }
}
