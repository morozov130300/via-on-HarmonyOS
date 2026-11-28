package x7;

import android.R;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.q;
import com.tuyafeng.support.utils.FragmentUtils;
import com.tuyafeng.support.utils.x;
import la.s;
import mark.via.Shell;
import q5.k;
import v8.h;
import w7.n;
import w7.p;
import w7.r;
import w7.u;
import x8.g1;
import x8.h3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends m8.a {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x9.c f14525c;

        public a(x9.c cVar) {
            this.f14525c = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.Z2(this.f14525c.e(), c.this.X0(u.Sf));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x9.c f14527c;

        public b(x9.c cVar) {
            this.f14527c = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.Z2(this.f14527c.b(), c.this.X0(u.Ma));
        }
    }

    /* JADX INFO: renamed from: x7.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0156c extends p5.c {
        public C0156c() {
        }

        @Override // p5.c
        public void a(View view) {
            c.this.X2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends p5.c {
        public d() {
        }

        @Override // p5.c
        public void a(View view) {
            c.this.Y2();
        }
    }

    public static /* synthetic */ boolean S2(c cVar, View view, int i10, KeyEvent keyEvent) {
        int nextFocusDownId;
        cVar.getClass();
        TextView textView = (TextView) view;
        int selectionEnd = textView.getSelectionEnd();
        int action = keyEvent.getAction();
        if (action == 0) {
            view.onKeyDown(i10, keyEvent);
        }
        if (action == 1) {
            view.onKeyUp(i10, keyEvent);
        }
        if (selectionEnd == textView.getSelectionEnd() && action == 0 && i10 == 20 && (nextFocusDownId = view.getNextFocusDownId()) != -1) {
            View viewFindViewById = cVar.a1() == null ? null : cVar.a1().findViewById(nextFocusDownId);
            if (viewFindViewById != null) {
                viewFindViewById.requestFocus();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        FragmentUtils.j(this, g.class, g.g3(str, str2));
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13946o, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        h3.e(view);
        x9.c cVarZ = s.j().z();
        TextView textView = (TextView) view.findViewById(p.Z0);
        String strX0 = X0(u.Sf);
        String strX1 = X0(u.Ma);
        String strY0 = Y0(u.f14281w8, strX0, strX1);
        SpannableString spannableString = new SpannableString(strY0);
        int iIndexOf = strY0.indexOf(strX0);
        int length = strX0.length() + iIndexOf;
        spannableString.setSpan(new a(cVarZ), iIndexOf, length, 33);
        int iJ = h.j(G());
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf, length, 33);
        int iIndexOf2 = strY0.indexOf(strX1);
        int length2 = strX1.length() + iIndexOf2;
        spannableString.setSpan(new b(cVarZ), iIndexOf2, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf2, length2, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf2, length2, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        y.r.Y(textView, new g1(textView, y0(), "homeAgree"));
        textView.setOnKeyListener(new View.OnKeyListener() { // from class: x7.a
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return c.S2(this.f14523a, view2, i10, keyEvent);
            }
        });
        TextView textView2 = (TextView) view.findViewById(p.X0);
        x.P(textView2, new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.f.d(G(), n.f13763p)).h(h.j(G())).j(h.k(G())).a());
        textView2.setOnClickListener(new C0156c());
        view.findViewById(p.f13875h1).setOnClickListener(new d());
    }

    public final void X2() {
        s.j().s1(1);
        q qVarI0 = i0();
        if (qVarI0 instanceof Shell) {
            ((Shell) qVarI0).d0();
        }
    }

    public final void Y2() {
        k.l(G()).f0(u.I3).J(u.Q0).X(R.string.ok, null).T(u.f13972a5, new View.OnClickListener() { // from class: x7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14524a.i0().finish();
            }
        }).h0();
    }
}
