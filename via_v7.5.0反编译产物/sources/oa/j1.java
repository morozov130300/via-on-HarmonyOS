package oa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j1 extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f11024c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(View view, int i10, boolean z10, g1 g1Var);
    }

    public static /* synthetic */ void l(j1 j1Var, w5.g gVar, g1 g1Var, CompoundButton compoundButton, boolean z10) {
        a aVar = j1Var.f11024c;
        if (aVar != null) {
            aVar.a(compoundButton, gVar.l(), z10, g1Var);
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(final w5.g gVar, final g1 g1Var) {
        super.b(gVar, g1Var);
        ra.c cVarA = g1Var.a();
        int i10 = v5.o.f13406c;
        gVar.X(i10, cVarA.g());
        int i11 = v5.o.f13407e;
        gVar.Y(i11, !com.tuyafeng.support.utils.p.f(cVarA.i()));
        gVar.X(i11, cVarA.i());
        int i12 = v5.o.f13408m;
        CheckBox checkBox = (CheckBox) gVar.P(i12);
        com.tuyafeng.support.utils.x.i(checkBox, com.tuyafeng.support.utils.x.h(gVar.O(), 24.0f));
        checkBox.setVisibility(0);
        checkBox.setClickable(true);
        checkBox.setFocusable(true);
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(cVarA.j());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: oa.i1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                j1.l(this.f11018a, gVar, g1Var, compoundButton, z10);
            }
        });
        gVar.f1138a.setEnabled(g1Var.b());
        float f10 = (!g1Var.b() || cVarA.k()) ? 0.5f : 1.0f;
        gVar.Q(i10, f10);
        gVar.Q(i11, f10);
        gVar.Q(i12, f10);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        v5.o oVar = new v5.o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(oVar);
    }

    public void o(a aVar) {
        this.f11024c = aVar;
    }
}
