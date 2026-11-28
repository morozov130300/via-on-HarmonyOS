package hb;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o6 extends m8.f {
    public Parcelable A0;
    public androidx.activity.o B0;
    public u9.l C0;
    public t5.f D0;
    public long E0;
    public int F0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public mark.via.common.widget.r0 f6007u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f6008v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public List f6009w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public List f6010x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f6011y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Parcelable f6012z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.activity.o {
        public a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() {
            o6.this.T2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends RecyclerView.t {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i11 == 0 || o6.this.f6008v0 == null || !o6.this.f6008v0.hasFocus()) {
                return;
            }
            o6.this.f6008v0.clearFocus();
            x8.f.e(o6.this.f6008v0);
        }
    }

    public o6() {
        List list = Collections.EMPTY_LIST;
        this.f6009w0 = list;
        this.f6010x0 = list;
        this.f6011y0 = "";
        this.E0 = 0L;
        this.F0 = 0;
    }

    public static /* synthetic */ void f3(o6 o6Var, View view, int i10, v5.q qVar) {
        if (o6Var.q3()) {
            o6Var.s3(i10);
        } else {
            o6Var.r3(qVar);
        }
    }

    public static /* synthetic */ void g3(o6 o6Var, View view) {
        o6Var.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - o6Var.E0 < 500) {
            o6Var.F0++;
        } else {
            o6Var.F0 = 1;
        }
        o6Var.E0 = jElapsedRealtime;
        if (o6Var.F0 == 5) {
            u9.d dVarT = o6Var.C0.t();
            dVarT.i(true ^ dVarT.f());
            o6Var.C0.X(dVarT);
            o6Var.F0 = 0;
            o6Var.t3();
        }
    }

    private List p3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.Fc)));
        arrayList.add(new v5.q(8, X0(w7.u.Kc)));
        arrayList.add(new v5.q(2, X0(w7.u.Hc)));
        arrayList.add(new v5.q(3, X0(w7.u.Dc)));
        arrayList.add(new v5.q(9, X0(w7.u.Ic)));
        if (this.C0.t().f()) {
            arrayList.add(new v5.q(12, X0(w7.u.f14028e5)));
        }
        arrayList.add(new v5.q(5, X0(w7.u.Cc)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q3() {
        return !this.f6011y0.trim().isEmpty();
    }

    private void r3(v5.q qVar) {
        this.f6008v0.clearFocus();
        x8.f.e(this.f6008v0);
        int iC = qVar.c();
        if (iC == 1) {
            FragmentUtils.i(this, b4.class);
            return;
        }
        if (iC == 2) {
            FragmentUtils.i(this, y4.class);
            return;
        }
        if (iC == 3) {
            FragmentUtils.i(this, z.class);
            return;
        }
        if (iC == 5) {
            FragmentUtils.i(this, d.class);
            return;
        }
        if (iC == 8) {
            FragmentUtils.i(this, b9.q.class);
            return;
        }
        if (iC == 9) {
            FragmentUtils.i(this, oa.f1.class);
            return;
        }
        if (iC == 10) {
            FragmentUtils.i(this, jb.y4.class);
        } else if (iC == 11) {
            FragmentUtils.i(this, h5.class);
        } else if (iC == 12) {
            FragmentUtils.i(this, b2.class);
        }
    }

    private void w3(List list) {
        t5.f fVar = this.D0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.D0.M(list);
        eVarB.c(this.D0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3() {
        if (q3()) {
            this.f6010x0 = mark.via.settings.search.g.b(this.f6009w0, this.f6011y0);
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.f6010x0.size(); i10++) {
                mark.via.settings.search.b bVar = (mark.via.settings.search.b) this.f6010x0.get(i10);
                arrayList.add(new v5.q((-i10) - 1, bVar.f(), TextUtils.join(" → ", bVar.c())));
            }
            w3(arrayList);
            this.f6007u0.setEmpty(arrayList.isEmpty());
        } else {
            this.f6010x0 = Collections.EMPTY_LIST;
            w3(p3());
            this.f6007u0.setEmpty(false);
        }
        this.B0.j(q3() && !i1());
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        v3();
        this.f6008v0 = null;
        this.f6007u0 = null;
        this.D0 = null;
        this.B0 = null;
        super.D1();
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (this.f6008v0 != null && z10) {
            this.B0.j(false);
        }
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        v3();
        super.M1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        if (i1()) {
            return;
        }
        t3();
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Bundle bundle) {
        v3();
        bundle.putString("settings_query", this.f6011y0);
        bundle.putParcelable("settings_home_scroll", this.f6012z0);
        bundle.putParcelable("settings_search_scroll", this.A0);
        super.S1(bundle);
    }

    @Override // m8.g
    public void T2() {
        if (!q3()) {
            super.T2();
            return;
        }
        this.f6008v0.setText("");
        this.f6008v0.clearFocus();
        x8.f.e(this.f6008v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.C0 = la.s.j();
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.D0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.m6
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                o6.f3(this.f5974a, view2, i10, (v5.q) obj);
            }
        }));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(this.D0);
        this.B0 = new a(q3());
        i0().h().h(b1(), this.B0);
        this.f6008v0.addTextChangedListener(new b());
        this.f7946t0.o(new c());
        x3();
    }

    @Override // m8.f, m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mark.via.common.widget.r0 r0Var = new mark.via.common.widget.r0(G());
        this.f6007u0 = r0Var;
        r0Var.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f6007u0.f10042o.setVisibility(8);
        EditText editText = this.f6007u0.f10041n;
        this.f6008v0 = editText;
        editText.setHint(w7.u.Jc);
        this.f6008v0.setText(this.f6011y0);
        EditText editText2 = this.f6008v0;
        editText2.setSelection(editText2.length());
        this.f6007u0.setFocusableInTouchMode(true);
        this.f6007u0.requestFocus();
        mark.via.common.widget.r0 r0Var2 = this.f6007u0;
        this.f7946t0 = r0Var2.f10038c;
        Objects.requireNonNull(r0Var2);
        X2(new va.e0(r0Var2));
        return this.f6007u0;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.Bc);
        View viewFindViewById = e0Var.findViewById(com.tuyafeng.support.widget.e0.f3730o);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: hb.n6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o6.g3(this.f5993a, view);
                }
            });
        }
    }

    @Override // m8.g
    public boolean l() {
        return !q3() && super.l();
    }

    public final void s3(int i10) {
        if (i10 < 0 || i10 >= this.f6010x0.size() || FragmentUtils.e(this)) {
            return;
        }
        v3();
        this.f6008v0.clearFocus();
        x8.f.e(this.f6008v0);
        mark.via.settings.search.b bVar = (mark.via.settings.search.b) this.f6010x0.get(i10);
        Bundle bundleA = bVar.a();
        bundleA.putInt("settings_search_target", bVar.e());
        FragmentUtils.j(this, bVar.d(), bundleA);
    }

    public final void t3() {
        this.f6009w0 = mark.via.settings.search.c.a(G());
        x3();
        u3();
    }

    public final void u3() {
        Parcelable parcelable = q3() ? this.A0 : this.f6012z0;
        if (parcelable != null) {
            this.f7946t0.getLayoutManager().d1(parcelable);
        } else {
            this.f7946t0.p1(0);
        }
    }

    public final void v3() {
        RecyclerView recyclerView = this.f7946t0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        Parcelable parcelableE1 = this.f7946t0.getLayoutManager().e1();
        if (q3()) {
            this.A0 = parcelableE1;
        } else {
            this.f6012z0 = parcelableE1;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (bundle != null) {
            this.f6011y0 = bundle.getString("settings_query", "");
            this.f6012z0 = bundle.getParcelable("settings_home_scroll");
            this.A0 = bundle.getParcelable("settings_search_scroll");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (o6.this.f6011y0.equals(charSequence.toString())) {
                return;
            }
            o6.this.v3();
            o6.this.f6011y0 = charSequence.toString();
            if (o6.this.q3()) {
                o6.this.A0 = null;
            }
            o6.this.x3();
            o6.this.u3();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
