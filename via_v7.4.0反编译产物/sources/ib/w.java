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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public a f7175c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(RecyclerView.c0 c0Var);
    }

    public static /* synthetic */ boolean l(w wVar, b6.g gVar, View view, MotionEvent motionEvent) {
        wVar.getClass();
        if (motionEvent.getAction() != 0 || wVar.f7175c == null || view.getAlpha() != 1.0f) {
            return true;
        }
        wVar.f7175c.a(gVar);
        return true;
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(final b6.g gVar, r rVar) {
        super.b(gVar, rVar);
        int i10 = u.f7164e;
        gVar.X(i10, rVar.c());
        int i11 = u.f7165j;
        gVar.X(i11, rVar.b());
        gVar.Y(i11, !TextUtils.isEmpty(rVar.b()));
        int i12 = u.f7167l;
        gVar.T(i12, rVar.d());
        gVar.P(i10).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(rVar.e() ? 0.5f : 1.0f);
        int i13 = u.f7166k;
        gVar.P(i13).setAlpha(rVar.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!rVar.e());
        gVar.P(i13).setOnTouchListener(new View.OnTouchListener() { // from class: ib.v
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return w.l(this.f7173a, gVar, view, motionEvent);
            }
        });
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, r rVar, List list) {
        if (list.isEmpty()) {
            b(gVar, rVar);
            return;
        }
        for (Object obj : list) {
            if (!(obj instanceof Boolean)) {
                b(gVar, rVar);
                return;
            }
            ((CheckBox) gVar.P(u.f7167l)).setChecked(((Boolean) obj).booleanValue());
        }
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        u uVar = new u(context);
        uVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(uVar);
    }

    public void p(a aVar) {
        this.f7175c = aVar;
    }
}
