package hb;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c8 extends k8.a {
    public EditText C0;
    public EditText D0;
    public CheckBox E0;
    public TextView F0;
    public c G0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ aa.c f6514e;

        public a(aa.c cVar) {
            this.f6514e = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c8.this.p3(this.f6514e.e(), c8.this.Z0(x7.u.Cf));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ aa.c f6516e;

        public b(aa.c cVar) {
            this.f6516e = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c8.this.p3(this.f6516e.b(), c8.this.Z0(x7.u.Aa));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(String str, String str2);
    }

    public static /* synthetic */ void j3(c8 c8Var, View view) {
        if (!c8Var.E0.isChecked()) {
            g6.y.X(c8Var.E0);
            g6.y.X(c8Var.F0);
            g6.n.s(c8Var.I(), c8Var.F0.getText().toString());
            return;
        }
        String string = c8Var.C0.getText().toString();
        String string2 = c8Var.D0.getText().toString();
        if (string.isEmpty()) {
            g6.y.X(c8Var.C0);
            g6.n.i(c8Var.C0);
        } else if (string2.isEmpty()) {
            g6.y.X(c8Var.D0);
            g6.n.i(c8Var.D0);
        } else {
            c cVar = c8Var.G0;
            if (cVar != null) {
                cVar.a(string, string2);
            }
            c8Var.X2();
        }
    }

    public static /* synthetic */ void l3(c8 c8Var, View view) {
        if (c8Var.F0.getSelectionStart() == c8Var.F0.getSelectionEnd()) {
            c8Var.E0.setChecked(!r1.isChecked());
        }
    }

    public static c8 n3() {
        return new c8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(String str, String str2) {
        f8.n3(str, str2).h3(z0(), null);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13877l, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        this.C0 = (EditText) view.findViewById(x7.p.f13837r);
        this.D0 = (EditText) view.findViewById(x7.p.f13819l);
        this.E0 = (CheckBox) view.findViewById(x7.p.f13798e);
        this.F0 = (TextView) view.findViewById(x7.p.Y0);
        this.C0.setText(pa.r.j().R());
        g6.y.R(this.D0);
        aa.c cVarY = pa.r.j().y();
        String strZ0 = Z0(x7.u.Cf);
        String strZ02 = Z0(x7.u.Aa);
        String strA1 = a1(x7.u.Ka, strZ0, strZ02);
        SpannableString spannableString = new SpannableString(strA1);
        int iIndexOf = strA1.indexOf(strZ0);
        int length = strZ0.length() + iIndexOf;
        spannableString.setSpan(new a(cVarY), iIndexOf, length, 33);
        int iJ = x8.h.j(I());
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf, length, 33);
        int iIndexOf2 = strA1.indexOf(strZ02);
        int length2 = strZ02.length() + iIndexOf2;
        spannableString.setSpan(new b(cVarY), iIndexOf2, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf2, length2, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf2, length2, 33);
        this.F0.setText(spannableString);
        this.F0.setMovementMethod(LinkMovementMethod.getInstance());
        x.r.X(this.F0, new z8.h1(this.F0, A0(), "loginAgree"));
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: hb.z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c8.l3(this.f6867a, view2);
            }
        });
        view.findViewById(x7.p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: hb.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6473a.X2();
            }
        });
        view.findViewById(x7.p.f13812i1).setOnClickListener(new View.OnClickListener() { // from class: hb.b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c8.j3(this.f6486a, view2);
            }
        });
    }

    @Override // k8.a
    public int i3() {
        return 2;
    }

    public void o3(c cVar) {
        this.G0 = cVar;
    }
}
