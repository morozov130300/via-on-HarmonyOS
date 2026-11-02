package b8;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public y f1860m0;

    /* renamed from: n0, reason: collision with root package name */
    public EditText f1861n0;

    /* renamed from: o0, reason: collision with root package name */
    public EditText f1862o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f1863p0;

    /* renamed from: q0, reason: collision with root package name */
    public CheckBox f1864q0;

    public static /* synthetic */ void Z2(h hVar, o9.b bVar) {
        View viewC1 = hVar.c1();
        if (viewC1 != null) {
            boolean zF = g6.p.f(bVar.c());
            viewC1.findViewById(x7.p.f13803f1).setVisibility(zF ? 8 : 0);
            ((TextView) viewC1.findViewById(x7.p.H1)).setText(zF ? x7.u.f13928c : x7.u.Uf);
        }
        hVar.f1861n0.setText(bVar.e());
        hVar.f1862o0.setText(bVar.g());
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13870e, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(final View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.post(new Runnable() { // from class: b8.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1845e.f1860m0.P(view.getHeight());
            }
        });
        this.f1861n0 = (EditText) view.findViewById(x7.p.f13831p);
        EditText editText = (EditText) view.findViewById(x7.p.f13834q);
        this.f1862o0 = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        this.f1863p0 = (TextView) view.findViewById(x7.p.f13836q1);
        this.f1864q0 = (CheckBox) view.findViewById(x7.p.f13795d);
        this.f1863p0.setOnClickListener(new View.OnClickListener() { // from class: b8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1848a.f1860m0.O(1);
            }
        });
        view.findViewById(x7.p.f13812i1).setOnClickListener(new View.OnClickListener() { // from class: b8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1850a.b3();
            }
        });
        view.findViewById(x7.p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: b8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1852a.f1860m0.v();
            }
        });
        view.findViewById(x7.p.f13803f1).setOnClickListener(new View.OnClickListener() { // from class: b8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f1854a.f1860m0.x();
            }
        });
        TextView textView = (TextView) view.findViewById(x7.p.H1);
        textView.setTypeface(textView.getTypeface(), 1);
        this.f1860m0.B().g(d1(), new androidx.lifecycle.m() { // from class: b8.f
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                h.Z2(this.f1856a, (o9.b) obj);
            }
        });
        this.f1860m0.z().g(d1(), new androidx.lifecycle.m() { // from class: b8.g
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                h hVar = this.f1858a;
                o9.a aVar = (o9.a) obj;
                hVar.f1863p0.setText(g6.p.f(aVar.b()) ? hVar.Z0(x7.u.f14149rb) : aVar.e());
            }
        });
    }

    public final void b3() {
        String strTrim = this.f1861n0.getText().toString().trim();
        String strTrim2 = this.f1862o0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            g6.y.X(this.f1861n0);
            g6.n.i(this.f1861n0);
        } else if (strTrim2.isEmpty()) {
            g6.y.X(this.f1862o0);
            g6.n.i(this.f1862o0);
        } else {
            this.f1860m0.M(i6.i0.f7006a.v(strTrim2, pa.r.j().Z0()), strTrim, this.f1864q0.isChecked());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f1860m0 = (y) new androidx.lifecycle.y(B2(), pa.r.n()).a(y.class);
    }
}
