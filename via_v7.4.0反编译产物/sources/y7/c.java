package y7;

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
import g6.i;
import g6.y;
import mark.via.Shell;
import w5.k;
import x7.n;
import x7.p;
import x7.r;
import x7.u;
import x8.h;
import z8.h1;
import z8.l3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends o8.a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ aa.c f14474e;

        public a(aa.c cVar) {
            this.f14474e = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.b3(this.f14474e.e(), c.this.Z0(u.Cf));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ aa.c f14476e;

        public b(aa.c cVar) {
            this.f14476e = cVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c.this.b3(this.f14476e.b(), c.this.Z0(u.Aa));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: y7.c$c, reason: collision with other inner class name */
    public class C0157c extends v5.c {
        public C0157c() {
        }

        @Override // v5.c
        public void a(View view) {
            c.this.Z2();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends v5.c {
        public d() {
        }

        @Override // v5.c
        public void a(View view) {
            c.this.a3();
        }
    }

    public static /* synthetic */ boolean U2(c cVar, View view, int i10, KeyEvent keyEvent) {
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
            View viewFindViewById = cVar.c1() == null ? null : cVar.c1().findViewById(nextFocusDownId);
            if (viewFindViewById != null) {
                viewFindViewById.requestFocus();
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13880o, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        l3.b(view);
        aa.c cVarY = pa.r.j().y();
        TextView textView = (TextView) view.findViewById(p.Z0);
        String strZ0 = Z0(u.Cf);
        String strZ02 = Z0(u.Aa);
        String strA1 = a1(u.f14049k8, strZ0, strZ02);
        SpannableString spannableString = new SpannableString(strA1);
        int iIndexOf = strA1.indexOf(strZ0);
        int length = strZ0.length() + iIndexOf;
        spannableString.setSpan(new a(cVarY), iIndexOf, length, 33);
        int iJ = h.j(I());
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf, length, 33);
        int iIndexOf2 = strA1.indexOf(strZ02);
        int length2 = strZ02.length() + iIndexOf2;
        spannableString.setSpan(new b(cVarY), iIndexOf2, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(iJ), iIndexOf2, length2, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf2, length2, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        x.r.X(textView, new h1(textView, A0(), "homeAgree"));
        textView.setOnKeyListener(new View.OnKeyListener() { // from class: y7.a
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return c.U2(this.f14472a, view2, i10, keyEvent);
            }
        });
        TextView textView2 = (TextView) view.findViewById(p.X0);
        y.O(textView2, new g6.g().c(g6.f.d(I(), n.f13697p)).h(h.j(I())).j(h.k(I())).a());
        textView2.setOnClickListener(new C0157c());
        view.findViewById(p.f13809h1).setOnClickListener(new d());
    }

    public final void Z2() {
        pa.r.j().r1(1);
        q qVarL0 = l0();
        if (qVarL0 instanceof Shell) {
            ((Shell) qVarL0).g0();
        }
    }

    public final void a3() {
        k.l(I()).d0(u.f14193v3).I(u.N0).V(R.string.ok, null).R(u.N4, new View.OnClickListener() { // from class: y7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14473a.l0().finish();
            }
        }).f0();
    }

    public final void b3(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        i.h(this, g.class, g.h3(str, str2));
    }
}
