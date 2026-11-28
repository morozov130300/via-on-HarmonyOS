package hb;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k1 extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f5931r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public EditText f5932s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f5933t0;

    public static /* synthetic */ void c3(Context context, EditText editText) {
        v8.g.h(editText);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setInputType(131073);
        editText.setTextSize(0, v8.h.q(context));
        editText.setGravity(48);
    }

    public static /* synthetic */ void d3(r5.b bVar) {
        bVar.setFillViewport(true);
        x8.r3.g(bVar);
    }

    public static /* synthetic */ void f3(k1 k1Var, ScrollView scrollView) {
        x8.r3.k(k1Var.f5932s0);
        x8.r3.i(scrollView);
    }

    public static Bundle g3(String str, String str2, String str3, boolean z10) {
        Bundle bundle = new Bundle();
        if (str != null && !str.isEmpty()) {
            bundle.putString("title", str);
        }
        if (str2 != null && !str2.isEmpty()) {
            bundle.putString("text", str2);
        }
        if (str3 != null && !str3.isEmpty()) {
            bundle.putString("placeholder", str3);
        }
        if (z10) {
            bundle.putBoolean("code", true);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3() {
        super.T2();
    }

    private boolean i3() {
        return x8.v0.d(this.f5932s0.getText().toString()).equals(this.f5933t0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(boolean z10) {
        String string = this.f5932s0.getText().toString();
        x8.v0.d(string);
        if (i3()) {
            if (!z10) {
                Bundle bundle = new Bundle();
                bundle.putString("text", string);
                L0().y1("edit_text_result", bundle);
            }
            h3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: hb.e1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f5850a.j3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: hb.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f5862a.h3();
                }
            }).h0();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("text", string);
        L0().y1("edit_text_result", bundle2);
        h3();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        EditText editText = this.f5932s0;
        if (editText != null) {
            x8.f.e(editText);
        }
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        j3(true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        Bundle bundleW0 = w0();
        boolean z10 = false;
        if (bundleW0 != null) {
            this.f5931r0.setTitle(bundleW0.getString("title"));
            String string = bundleW0.getString("text");
            String string2 = bundleW0.getString("placeholder");
            this.f5932s0.setText(string);
            this.f5932s0.setHint(string2);
            this.f5933t0 = x8.v0.d(string);
            z10 = bundleW0.getBoolean("code", false);
        } else {
            this.f5933t0 = "";
        }
        x8.r3.p(this.f5932s0, z10);
        if (z10) {
            EditText editText = this.f5932s0;
            editText.setInputType(editText.getInputType() | 524288);
            this.f5932s0.setTypeface(Typeface.MONOSPACE);
        }
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        final Context contextG = G();
        this.f5932s0 = (EditText) new b6.a(new EditText(contextG), new FrameLayout.LayoutParams(-1, -2)).f(0).S(com.tuyafeng.support.utils.x.h(contextG, 16.0f)).M(com.tuyafeng.support.utils.x.h(contextG, 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: hb.g1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k1.c3(contextG, (EditText) obj);
            }
        }).l();
        final ScrollView scrollView = (ScrollView) new b6.a(new r5.b(contextG), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: hb.h1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k1.d3((r5.b) obj);
            }
        }).l();
        scrollView.addView(this.f5932s0);
        X2(new Runnable() { // from class: hb.i1
            @Override // java.lang.Runnable
            public final void run() {
                k1.f3(this.f5897c, scrollView);
            }
        });
        return scrollView;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.Ah));
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: hb.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5918a.j3(false);
            }
        });
        this.f5931r0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        return i3();
    }
}
