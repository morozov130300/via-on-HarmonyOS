package o8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.widget.z;
import g6.y;
import h6.a;
import z8.l3;
import z8.n3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public LinearLayout f10460m0;

    /* renamed from: n0, reason: collision with root package name */
    public final i f10461n0 = new a(this);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends i {
        public a(Fragment fragment) {
            super(fragment);
        }

        @Override // o8.i
        public boolean l() {
            return h.this.l();
        }

        @Override // o8.i
        public void n() {
            h.this.V2();
        }

        @Override // o8.i
        public boolean o() {
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements a.InterfaceC0076a {
        public b() {
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LinearLayout linearLayout) {
            linearLayout.setOrientation(1);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements a.InterfaceC0076a {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a extends v5.d {
            public a() {
            }

            @Override // v5.d
            public void a(View view) {
                y.N(h.this.f10460m0);
            }
        }

        public c() {
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(z zVar) {
            zVar.setOnClickListener(new a());
            h.this.a3(zVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10460m0 = (LinearLayout) new h6.a(new LinearLayout(I()), new LinearLayout.LayoutParams(-1, -1)).V(new b()).l();
        if (X2()) {
            this.f10460m0.addView((z) new h6.a(new z(I()), new LinearLayout.LayoutParams(-1, -2)).V(new c()).l());
        }
        this.f10460m0.addView(Z2(layoutInflater, viewGroup));
        return y.a0(this, this.f10460m0, W2(), Y2());
    }

    public void U2() {
        l3.b(this.f10460m0);
    }

    public void V2() {
        if (N0().V0()) {
            return;
        }
        N0().e1();
    }

    public boolean W2() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        if (n3.h(I()) && view.findViewById(y.f6242a) != null) {
            l0().h().h(d1(), this.f10461n0);
        }
        U2();
    }

    public boolean X2() {
        return true;
    }

    public boolean Y2() {
        return true;
    }

    public abstract View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void a3(z zVar) {
    }

    public boolean l() {
        return true;
    }
}
