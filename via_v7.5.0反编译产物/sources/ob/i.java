package ob;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.lifecycle.a0;
import com.tuyafeng.support.utils.x;
import w7.p;
import w7.r;
import w7.u;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public m f11096o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public EditText f11097p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public EditText f11098q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public EditText f11099r0;

    private void L(String str) {
        new a6.h.b(G()).h(str).a().s();
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13945n, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.findViewById(p.W0).setOnClickListener(new View.OnClickListener() { // from class: ob.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11092a.f11096o0.w(1);
            }
        });
        this.f11097p0 = (EditText) view.findViewById(p.f13897p);
        this.f11098q0 = (EditText) view.findViewById(p.f13900q);
        EditText editText = (EditText) view.findViewById(p.f13885l);
        this.f11099r0 = editText;
        x.S(editText);
        qb.f fVarN = this.f11096o0.n();
        boolean zIsEmpty = TextUtils.isEmpty(fVarN.d());
        this.f11097p0.setText(fVarN.c());
        this.f11098q0.setText(fVarN.f());
        this.f11099r0.setText("");
        this.f11099r0.setHint(zIsEmpty ? X0(u.f14266v6) : X0(u.f14279w6));
        view.findViewById(p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: ob.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11093a.f11096o0.l();
            }
        });
        view.findViewById(p.f13878i1).setOnClickListener(new View.OnClickListener() { // from class: ob.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11094a.W2();
            }
        });
        View viewFindViewById = view.findViewById(p.f13914u1);
        viewFindViewById.setVisibility(zIsEmpty ? 8 : 0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ob.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i iVar = this.f11095a;
                iVar.f11096o0.s(iVar.f11097p0.getText().toString().trim(), iVar.f11098q0.getText().toString().trim());
            }
        });
    }

    public final void W2() {
        String strTrim = this.f11097p0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            x.Y(this.f11097p0);
            L(Y0(u.f14254u7, this.f11097p0.getHint()));
            return;
        }
        String strTrim2 = this.f11098q0.getText().toString().trim();
        if (strTrim2.isEmpty()) {
            x.Y(this.f11098q0);
            L(Y0(u.f14254u7, this.f11098q0.getHint()));
            return;
        }
        String strTrim3 = this.f11099r0.getText().toString().trim();
        if (!strTrim3.isEmpty() || (t1.a(this.f11096o0.n().c(), strTrim) && t1.a(this.f11096o0.n().f(), strTrim2))) {
            this.f11096o0.t(strTrim, strTrim2, strTrim3);
        } else {
            x.Y(this.f11099r0);
            L(Y0(u.f14254u7, this.f11099r0.getHint()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (K0() != null) {
            this.f11096o0 = (m) new a0(K0()).a(m.class);
        }
    }
}
