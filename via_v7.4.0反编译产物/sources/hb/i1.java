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
import com.tuyafeng.support.widget.z;
import h6.a;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i1 extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f6576o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f6577p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f6578q0;

    public static /* synthetic */ void d3(q4.b bVar) {
        bVar.setFillViewport(true);
        z8.r3.f(bVar);
        z8.r3.h(bVar);
    }

    public static /* synthetic */ void e3(Context context, EditText editText) {
        x8.g.h(editText);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setInputType(131073);
        editText.setTextColor(g6.e.a(context, x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(context, x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(context));
        editText.setGravity(48);
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
        super.V2();
    }

    private boolean i3() {
        return z8.v0.d(this.f6577p0.getText().toString()).equals(this.f6578q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(boolean z10) {
        String string = this.f6577p0.getText().toString();
        z8.v0.d(string);
        if (i3()) {
            if (!z10) {
                Bundle bundle = new Bundle();
                bundle.putString("text", string);
                N0().x1("edit_text_result", bundle);
            }
            h3();
            return;
        }
        if (z10) {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: hb.f1
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f6541a.j3(false);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: hb.g1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6554a.h3();
                }
            }).f0();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("text", string);
        N0().x1("edit_text_result", bundle2);
        h3();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        EditText editText = this.f6577p0;
        if (editText != null) {
            z8.f.e(editText);
        }
        super.O1();
    }

    @Override // o8.h
    public void V2() {
        j3(true);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        Bundle bundleY0 = y0();
        boolean z10 = false;
        if (bundleY0 != null) {
            this.f6576o0.setTitle(bundleY0.getString("title"));
            String string = bundleY0.getString("text");
            String string2 = bundleY0.getString("placeholder");
            this.f6577p0.setText(string);
            this.f6577p0.setHint(string2);
            this.f6578q0 = z8.v0.d(string);
            z10 = bundleY0.getBoolean("code", false);
        } else {
            this.f6578q0 = "";
        }
        z8.r3.o(this.f6577p0, z10);
        if (z10) {
            EditText editText = this.f6577p0;
            editText.setInputType(editText.getInputType() | 524288);
            this.f6577p0.setTypeface(Typeface.MONOSPACE);
        }
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        final Context contextI = I();
        this.f6577p0 = (EditText) new h6.a(new EditText(contextI), new FrameLayout.LayoutParams(-1, -2)).f(0).S(g6.y.h(contextI, 16.0f)).M(g6.y.h(contextI, 16.0f)).V(new a.InterfaceC0076a() { // from class: hb.d1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                i1.e3(contextI, (EditText) obj);
            }
        }).l();
        ScrollView scrollView = (ScrollView) new h6.a(new q4.b(contextI), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: hb.e1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                i1.d3((q4.b) obj);
            }
        }).l();
        scrollView.addView(this.f6577p0);
        return scrollView;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.bh));
        zVar.c(new z.b(1, 1, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: hb.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6565a.j3(false);
            }
        });
        this.f6576o0 = zVar;
    }

    @Override // o8.h
    public boolean l() {
        return i3();
    }
}
