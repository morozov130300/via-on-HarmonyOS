package ib;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f6407c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(RecyclerView.d0 d0Var);
    }

    public static /* synthetic */ boolean l(w wVar, w5.g gVar, View view, MotionEvent motionEvent) {
        wVar.getClass();
        if (motionEvent.getAction() != 0 || wVar.f6407c == null || view.getAlpha() != 1.0f) {
            return true;
        }
        wVar.f6407c.a(gVar);
        return true;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(final w5.g gVar, r rVar) {
        super.b(gVar, rVar);
        int i10 = u.f6396c;
        gVar.X(i10, rVar.c());
        int i11 = u.f6397e;
        gVar.X(i11, rVar.b());
        gVar.Y(i11, !TextUtils.isEmpty(rVar.b()));
        int i12 = u.f6399n;
        gVar.T(i12, rVar.d());
        gVar.P(i10).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(rVar.e() ? 0.5f : 1.0f);
        int i13 = u.f6398m;
        gVar.P(i13).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!rVar.e());
        gVar.P(i13).setOnTouchListener(new View.OnTouchListener() { // from class: ib.v
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return w.l(this.f6405a, gVar, view, motionEvent);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, r rVar, List list) {
        if (list.isEmpty()) {
            b(gVar, rVar);
            return;
        }
        for (Object obj : list) {
            if (!(obj instanceof Boolean)) {
                b(gVar, rVar);
                return;
            }
            ((CheckBox) gVar.P(u.f6399n)).setChecked(((Boolean) obj).booleanValue());
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        u uVar = new u(context);
        uVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(uVar);
    }

    public void p(a aVar) {
        this.f6407c = aVar;
    }
}
