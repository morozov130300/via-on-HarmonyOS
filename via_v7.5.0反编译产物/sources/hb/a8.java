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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a8 extends i8.a {
    public EditText E0;
    public EditText F0;
    public CheckBox G0;
    public TextView H0;
    public c I0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x9.c f5795c;

        public a(x9.c cVar) {
            this.f5795c = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            a8.this.p3(this.f5795c.e(), a8.this.X0(w7.u.Sf));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x9.c f5797c;

        public b(x9.c cVar) {
            this.f5797c = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            a8.this.p3(this.f5797c.b(), a8.this.X0(w7.u.Ma));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(String str, String str2);
    }

    public static /* synthetic */ void j3(a8 a8Var, View view) {
        if (!a8Var.G0.isChecked()) {
            com.tuyafeng.support.utils.x.Y(a8Var.G0);
            com.tuyafeng.support.utils.x.Y(a8Var.H0);
            com.tuyafeng.support.utils.n.s(a8Var.G(), a8Var.H0.getText().toString());
            return;
        }
        String string = a8Var.E0.getText().toString();
        String string2 = a8Var.F0.getText().toString();
        if (string.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(a8Var.E0);
            com.tuyafeng.support.utils.n.i(a8Var.E0);
        } else if (string2.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(a8Var.F0);
            com.tuyafeng.support.utils.n.i(a8Var.F0);
        } else {
            c cVar = a8Var.I0;
            if (cVar != null) {
                cVar.a(string, string2);
            }
            a8Var.V2();
        }
    }

    public static /* synthetic */ void l3(a8 a8Var, View view) {
        if (a8Var.H0.getSelectionStart() == a8Var.H0.getSelectionEnd()) {
            CheckBox checkBox = a8Var.G0;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    public static a8 n3() {
        return new a8();
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13943l, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        this.E0 = (EditText) view.findViewById(w7.p.f13900q);
        this.F0 = (EditText) view.findViewById(w7.p.f13885l);
        this.G0 = (CheckBox) view.findViewById(w7.p.f13864e);
        this.H0 = (TextView) view.findViewById(w7.p.Y0);
        this.E0.setText(la.s.j().S());
        com.tuyafeng.support.utils.x.S(this.F0);
        x9.c cVarZ = la.s.j().z();
        String strX0 = X0(w7.u.Sf);
        String strX1 = X0(w7.u.Ma);
        String strY0 = Y0(w7.u.Wa, strX0, strX1);
        SpannableString spannableString = new SpannableString(strY0);
        int iIndexOf = strY0.indexOf(strX0);
        int length = strX0.length() + iIndexOf;
        spannableString.setSpan(new a(cVarZ), iIndexOf, length, 33);
        int iJ = v8.h.j(G());
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf, length, 33);
        int iIndexOf2 = strY0.indexOf(strX1);
        int length2 = strX1.length() + iIndexOf2;
        spannableString.setSpan(new b(cVarZ), iIndexOf2, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf2, length2, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf2, length2, 33);
        this.H0.setText(spannableString);
        this.H0.setMovementMethod(LinkMovementMethod.getInstance());
        y.r.Y(this.H0, new x8.g1(this.H0, y0(), "loginAgree"));
        this.H0.setOnClickListener(new View.OnClickListener() { // from class: hb.x7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a8.l3(this.f6148a, view2);
            }
        });
        view.findViewById(w7.p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: hb.y7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6166a.V2();
            }
        });
        view.findViewById(w7.p.f13878i1).setOnClickListener(new View.OnClickListener() { // from class: hb.z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a8.j3(this.f6180a, view2);
            }
        });
    }

    @Override // i8.a
    public int i3() {
        return 2;
    }

    public void o3(c cVar) {
        this.I0 = cVar;
    }

    public final void p3(String str, String str2) {
        f8.n3(str, str2).g3(x0(), null);
    }
}
