package mark.via.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class ga extends i8.a {
    public EditText E0;
    public EditText F0;
    public ImageView G0;
    public RecyclerView H0;
    public t5.f I0;
    public String J0;
    public String K0;
    public String L0;
    public final wa.a M0 = new wa.r(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            ga.this.w3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends t5.a {
        public b() {
        }

        public static /* synthetic */ void l(b bVar, Context context, TextView textView) {
            bVar.getClass();
            x8.r3.q(textView);
            v8.g.m(textView, v8.h.t(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(v8.h.o(context));
            textView.setMaxWidth(com.tuyafeng.support.utils.x.h(ga.this.G(), 120.0f));
            v8.g.d(textView);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(w5.g gVar, t9.f fVar) {
            super.b(gVar, fVar);
            ((TextView) gVar.f1138a).setText(fVar.h());
        }

        @Override // t5.d
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public w5.g d(final Context context, ViewGroup viewGroup) {
            return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).e(v8.h.f(context)).N(1, 8).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.ha
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    ga.b.l(this.f9204a, context, (TextView) obj);
                }
            }).l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends p5.c {
        public c() {
        }

        @Override // p5.c
        public void a(View view) {
            ga.this.J0 = null;
            ga.this.K0 = null;
            ga.this.V2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends p5.c {
        public d() {
        }

        @Override // p5.c
        public void a(View view) {
            ga.this.x3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e extends wa.s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.f f9168b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, t9.f fVar) {
            super(context);
            this.f9168b = fVar;
        }

        public static /* synthetic */ void b(e eVar, t9.f fVar) {
            ga.this.E0.setText(fVar.h());
            ga.this.F0.setText(fVar.e());
        }

        public static /* synthetic */ t9.f c(t9.f fVar) {
            t9.f fVarF = la.s.i().f(fVar.b());
            if (fVarF == null) {
                return null;
            }
            if (fVarF.h() == null && fVarF.e() == null) {
                return null;
            }
            return fVarF;
        }

        @Override // wa.b
        public void onSuccess() {
            final t9.f fVar = this.f9168b;
            ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.ia
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ga.e.c(fVar);
                }
            }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(ga.this.b1()))).a(new u6.f() { // from class: mark.via.browser.ja
                @Override // u6.f
                public final void accept(Object obj) {
                    ga.e.b(this.f9262c, (t9.f) obj);
                }
            }, new w7.e0());
        }
    }

    public static /* synthetic */ void k3(ga gaVar, String str, Bundle bundle) {
        gaVar.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            gaVar.t3(la.s.i().h(string));
        }
        gaVar.L0().x("passresult");
    }

    public static /* synthetic */ s5.a l3(ga gaVar) {
        gaVar.getClass();
        t9.g gVarI = la.s.i();
        return s5.a.f(!gVarI.j() ? gVarI.e(gaVar.L0) : null);
    }

    public static /* synthetic */ void m3(ga gaVar, s5.a aVar) {
        gaVar.getClass();
        if (!aVar.d()) {
            gaVar.H0.setVisibility(8);
            gaVar.G0.setVisibility(8);
            return;
        }
        List list = (List) aVar.c();
        if (list == null || list.isEmpty()) {
            gaVar.H0.setVisibility(8);
            return;
        }
        gaVar.I0.M(list);
        gaVar.I0.l();
        gaVar.H0.setVisibility(0);
    }

    private void u3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.ea
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ga.l3(this.f9116c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.fa
            @Override // u6.f
            public final void accept(Object obj) {
                ga.m3(this.f9143c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public static ga v3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        ga gaVar = new ga();
        gaVar.F2(bundle);
        return gaVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13938g, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        EditText editText = (EditText) view.findViewById(w7.p.f13900q);
        this.E0 = editText;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            editText.setAutofillHints(new String[]{"username"});
        }
        EditText editText2 = (EditText) view.findViewById(w7.p.f13885l);
        this.F0 = editText2;
        if (i10 >= 26) {
            editText2.setAutofillHints(new String[]{"password"});
        }
        this.F0.setInputType(524417);
        com.tuyafeng.support.utils.x.S(this.F0);
        ImageView imageView = (ImageView) view.findViewById(w7.p.X);
        this.G0 = imageView;
        imageView.setOnClickListener(new a());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(w7.p.f13922x0);
        this.H0 = recyclerView;
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        this.H0.setLayoutManager(new LinearLayoutManager(y0(), 0, false));
        this.H0.k(new com.tuyafeng.support.widget.c0(com.tuyafeng.support.utils.x.h(y0(), 6.0f), com.tuyafeng.support.utils.x.h(y0(), 4.0f)));
        x8.r3.e(this.H0);
        this.I0 = new t5.f(Collections.EMPTY_LIST);
        b bVar = new b();
        bVar.j(new t5.g() { // from class: mark.via.browser.ca
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                this.f9065a.t3((t9.f) obj);
            }
        });
        this.I0.K(t9.f.class, bVar);
        this.H0.setAdapter(this.I0);
        view.findViewById(w7.p.f13863d1).setOnClickListener(new c());
        view.findViewById(w7.p.f13878i1).setOnClickListener(new d());
        v8.g.f(view);
        this.L0 = w0() != null ? w0().getString("url", null) : null;
        u3();
    }

    @Override // androidx.fragment.app.k
    public Dialog Z2(Bundle bundle) {
        Dialog dialogZ2 = super.Z2(bundle);
        dialogZ2.setCancelable(true);
        dialogZ2.setCanceledOnTouchOutside(false);
        return dialogZ2;
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Bundle bundle = new Bundle();
        String str = this.J0;
        if (str != null) {
            bundle.putString("username", str);
        }
        String str2 = this.K0;
        if (str2 != null) {
            bundle.putString("password", str2);
        }
        L0().y1("url", bundle);
        super.onDismiss(dialogInterface);
    }

    public final void t3(t9.f fVar) {
        if (fVar == null) {
            return;
        }
        this.M0.a(X0(w7.u.K5), X0(w7.u.yh), new e(G(), fVar));
    }

    public final void w3() {
        L0().z1("passresult", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.da
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                ga.k3(this.f9094a, str, bundle);
            }
        });
        va.d0.x3(c6.a2.f1958a.f(this.L0)).g3(L0(), va.d0.class.getSimpleName());
    }

    public final void x3() {
        this.J0 = com.tuyafeng.support.utils.p.k(this.E0.getText().toString());
        this.K0 = com.tuyafeng.support.utils.p.k(this.F0.getText().toString());
        V2();
    }
}
