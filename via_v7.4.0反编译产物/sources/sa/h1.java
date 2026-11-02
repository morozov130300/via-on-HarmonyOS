package sa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h1 extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public a f11905c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(View view, int i10, boolean z10, e1 e1Var);
    }

    public static /* synthetic */ void l(h1 h1Var, b6.g gVar, e1 e1Var, CompoundButton compoundButton, boolean z10) {
        a aVar = h1Var.f11905c;
        if (aVar != null) {
            aVar.a(compoundButton, gVar.l(), z10, e1Var);
        }
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(final b6.g gVar, final e1 e1Var) {
        super.b(gVar, e1Var);
        r5.c cVarA = e1Var.a();
        int i10 = a6.o.f122e;
        gVar.X(i10, cVarA.g());
        int i11 = a6.o.f123j;
        gVar.Y(i11, !g6.p.f(cVarA.i()));
        gVar.X(i11, cVarA.i());
        int i12 = a6.o.f124k;
        CheckBox checkBox = (CheckBox) gVar.P(i12);
        g6.y.i(checkBox, g6.y.h(gVar.O(), 24.0f));
        checkBox.setVisibility(0);
        checkBox.setClickable(true);
        checkBox.setFocusable(true);
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(cVarA.j());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sa.g1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                h1.l(this.f11900a, gVar, e1Var, compoundButton, z10);
            }
        });
        gVar.f1219a.setEnabled(e1Var.b());
        float f10 = (!e1Var.b() || cVarA.k()) ? 0.5f : 1.0f;
        gVar.Q(i10, f10);
        gVar.Q(i11, f10);
        gVar.Q(i12, f10);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        a6.o oVar = new a6.o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(oVar);
    }

    public void o(a aVar) {
        this.f11905c = aVar;
    }
}
