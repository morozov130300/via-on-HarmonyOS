package a8;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import c6.a2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public a0 f144o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public EditText f145p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public EditText f146q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public TextView f147r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public CheckBox f148s0;

    public static /* synthetic */ void X2(h hVar, m9.b bVar) {
        View viewA1 = hVar.a1();
        if (viewA1 != null) {
            boolean zF = com.tuyafeng.support.utils.p.f(bVar.c());
            viewA1.findViewById(w7.p.f13869f1).setVisibility(zF ? 8 : 0);
            ((TextView) viewA1.findViewById(w7.p.H1)).setText(zF ? w7.u.f13994c : w7.u.kg);
        }
        hVar.f145p0.setText(bVar.e());
        hVar.f146q0.setText(bVar.g());
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13936e, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(final View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.post(new Runnable() { // from class: a8.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f106c.f144o0.W(view.getHeight());
            }
        });
        this.f145p0 = (EditText) view.findViewById(w7.p.f13894o);
        EditText editText = (EditText) view.findViewById(w7.p.f13897p);
        this.f146q0 = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        this.f147r0 = (TextView) view.findViewById(w7.p.f13902q1);
        this.f148s0 = (CheckBox) view.findViewById(w7.p.f13861d);
        this.f147r0.setOnClickListener(new View.OnClickListener() { // from class: a8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f127a.f144o0.V(1);
            }
        });
        view.findViewById(w7.p.f13878i1).setOnClickListener(new View.OnClickListener() { // from class: a8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f130a.Z2();
            }
        });
        view.findViewById(w7.p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: a8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f134a.f144o0.x();
            }
        });
        view.findViewById(w7.p.f13869f1).setOnClickListener(new View.OnClickListener() { // from class: a8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f136a.f144o0.A();
            }
        });
        TextView textView = (TextView) view.findViewById(w7.p.H1);
        textView.setTypeface(textView.getTypeface(), 1);
        this.f144o0.E().g(b1(), new androidx.lifecycle.o() { // from class: a8.f
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                h.X2(this.f138a, (m9.b) obj);
            }
        });
        this.f144o0.C().g(b1(), new androidx.lifecycle.o() { // from class: a8.g
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                h hVar = this.f142a;
                m9.a aVar = (m9.a) obj;
                hVar.f147r0.setText(com.tuyafeng.support.utils.p.f(aVar.b()) ? hVar.X0(w7.u.Eb) : aVar.e());
            }
        });
    }

    public final void Z2() {
        String strTrim = this.f145p0.getText().toString().trim();
        String strTrim2 = this.f146q0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(this.f145p0);
            com.tuyafeng.support.utils.n.i(this.f145p0);
        } else if (strTrim2.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(this.f146q0);
            com.tuyafeng.support.utils.n.i(this.f146q0);
        } else {
            this.f144o0.S(a2.f1958a.w(strTrim2, la.s.j().b1()), strTrim, this.f148s0.isChecked());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f144o0 = (a0) new androidx.lifecycle.a0(z2(), la.s.n()).a(a0.class);
    }
}
