package ob;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import f6.h;
import g6.y;
import x7.p;
import x7.r;
import x7.u;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public m f10510m0;

    /* renamed from: n0, reason: collision with root package name */
    public EditText f10511n0;

    /* renamed from: o0, reason: collision with root package name */
    public EditText f10512o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f10513p0;

    private void N(String str) {
        new h.b(I()).h(str).a().s();
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13879n, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.findViewById(p.W0).setOnClickListener(new View.OnClickListener() { // from class: ob.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10506a.f10510m0.w(1);
            }
        });
        this.f10511n0 = (EditText) view.findViewById(p.f13834q);
        this.f10512o0 = (EditText) view.findViewById(p.f13837r);
        EditText editText = (EditText) view.findViewById(p.f13819l);
        this.f10513p0 = editText;
        y.R(editText);
        qb.f fVarN = this.f10510m0.n();
        boolean zIsEmpty = TextUtils.isEmpty(fVarN.d());
        this.f10511n0.setText(fVarN.c());
        this.f10512o0.setText(fVarN.f());
        this.f10513p0.setText("");
        this.f10513p0.setHint(zIsEmpty ? Z0(u.f14033j6) : Z0(u.f14047k6));
        view.findViewById(p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: ob.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10507a.f10510m0.l();
            }
        });
        view.findViewById(p.f13812i1).setOnClickListener(new View.OnClickListener() { // from class: ob.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10508a.Y2();
            }
        });
        View viewFindViewById = view.findViewById(p.f13848u1);
        viewFindViewById.setVisibility(zIsEmpty ? 8 : 0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ob.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i iVar = this.f10509a;
                iVar.f10510m0.s(iVar.f10511n0.getText().toString().trim(), iVar.f10512o0.getText().toString().trim());
            }
        });
    }

    public final void Y2() {
        String strTrim = this.f10511n0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            y.X(this.f10511n0);
            N(a1(u.f14020i7, this.f10511n0.getHint()));
            return;
        }
        String strTrim2 = this.f10512o0.getText().toString().trim();
        if (strTrim2.isEmpty()) {
            y.X(this.f10512o0);
            N(a1(u.f14020i7, this.f10512o0.getHint()));
            return;
        }
        String strTrim3 = this.f10513p0.getText().toString().trim();
        if (!strTrim3.isEmpty() || (u1.a(this.f10510m0.n().c(), strTrim) && u1.a(this.f10510m0.n().f(), strTrim2))) {
            this.f10510m0.t(strTrim, strTrim2, strTrim3);
        } else {
            y.X(this.f10513p0);
            N(a1(u.f14020i7, this.f10513p0.getHint()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (M0() != null) {
            this.f10510m0 = (m) new androidx.lifecycle.y(M0()).a(m.class);
        }
    }
}
