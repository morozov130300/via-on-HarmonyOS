package c8;

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
import c8.za;
import h6.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class za extends k8.a {
    public EditText C0;
    public EditText D0;
    public ImageView E0;
    public RecyclerView F0;
    public y5.f G0;
    public String H0;
    public String I0;
    public String J0;
    public final wa.a K0 = new wa.r(this);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            za.this.w3();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends y5.a {
        public b() {
        }

        public static /* synthetic */ void l(b bVar, Context context, TextView textView) {
            bVar.getClass();
            z8.r3.p(textView);
            x8.g.m(textView, x8.h.u(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(x8.h.p(context));
            textView.setMaxWidth(g6.y.h(za.this.I(), 120.0f));
            x8.g.d(textView);
        }

        @Override // y5.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(b6.g gVar, v9.f fVar) {
            super.b(gVar, fVar);
            ((TextView) gVar.f1219a).setText(fVar.h());
        }

        @Override // y5.d
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b6.g d(final Context context, ViewGroup viewGroup) {
            return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).e(x8.h.f(context)).N(1, 8).V(new a.InterfaceC0076a() { // from class: c8.ab
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    za.b.l(this.f2341a, context, (TextView) obj);
                }
            }).l());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends v5.c {
        public c() {
        }

        @Override // v5.c
        public void a(View view) {
            za.this.H0 = null;
            za.this.I0 = null;
            za.this.X2();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends v5.c {
        public d() {
        }

        @Override // v5.c
        public void a(View view) {
            za.this.x3();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e extends wa.s {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v9.f f2972b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, v9.f fVar) {
            super(context);
            this.f2972b = fVar;
        }

        public static /* synthetic */ void b(e eVar, v9.f fVar) {
            za.this.C0.setText(fVar.h());
            za.this.D0.setText(fVar.e());
        }

        public static /* synthetic */ v9.f c(v9.f fVar) {
            v9.f fVarF = pa.r.i().f(fVar.b());
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
            final v9.f fVar = this.f2972b;
            ((autodispose2.m) x6.f.h(new Callable() { // from class: c8.bb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return za.e.c(fVar);
                }
            }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(za.this.d1()))).a(new a7.e() { // from class: c8.cb
                @Override // a7.e
                public final void accept(Object obj) {
                    za.e.b(this.f2388e, (v9.f) obj);
                }
            }, new x7.g0());
        }
    }

    public static /* synthetic */ void k3(za zaVar, String str, Bundle bundle) {
        zaVar.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            zaVar.t3(pa.r.i().h(string));
        }
        zaVar.N0().x("passresult");
    }

    public static /* synthetic */ x5.a l3(za zaVar) {
        zaVar.getClass();
        v9.g gVarI = pa.r.i();
        return x5.a.f(!gVarI.j() ? gVarI.e(zaVar.J0) : null);
    }

    public static /* synthetic */ void m3(za zaVar, x5.a aVar) {
        zaVar.getClass();
        if (!aVar.d()) {
            zaVar.F0.setVisibility(8);
            zaVar.E0.setVisibility(8);
            return;
        }
        List list = (List) aVar.c();
        if (list == null || list.isEmpty()) {
            zaVar.F0.setVisibility(8);
            return;
        }
        zaVar.G0.M(list);
        zaVar.G0.l();
        zaVar.F0.setVisibility(0);
    }

    private void u3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.xa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return za.l3(this.f2919e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.ya
            @Override // a7.e
            public final void accept(Object obj) {
                za.m3(this.f2949e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public static za v3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        za zaVar = new za();
        zaVar.H2(bundle);
        return zaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3() {
        N0().y1("passresult", this, new androidx.fragment.app.i0() { // from class: c8.wa
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                za.k3(this.f2904a, str, bundle);
            }
        });
        va.c0.x3(i6.i0.f7006a.e(this.J0)).h3(N0(), va.c0.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13872g, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        EditText editText = (EditText) view.findViewById(x7.p.f13837r);
        this.C0 = editText;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            editText.setAutofillHints(new String[]{"username"});
        }
        EditText editText2 = (EditText) view.findViewById(x7.p.f13819l);
        this.D0 = editText2;
        if (i10 >= 26) {
            editText2.setAutofillHints(new String[]{"password"});
        }
        this.D0.setInputType(524417);
        g6.y.R(this.D0);
        ImageView imageView = (ImageView) view.findViewById(x7.p.Y);
        this.E0 = imageView;
        imageView.setOnClickListener(new a());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(x7.p.B0);
        this.F0 = recyclerView;
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        this.F0.setLayoutManager(new LinearLayoutManager(A0(), 0, false));
        this.F0.k(new com.tuyafeng.support.widget.x(g6.y.h(A0(), 6.0f), g6.y.h(A0(), 4.0f)));
        z8.r3.d(this.F0);
        this.G0 = new y5.f(Collections.EMPTY_LIST);
        b bVar = new b();
        bVar.j(new y5.g() { // from class: c8.va
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                this.f2887a.t3((v9.f) obj);
            }
        });
        this.G0.K(v9.f.class, bVar);
        this.F0.setAdapter(this.G0);
        view.findViewById(x7.p.f13797d1).setOnClickListener(new c());
        view.findViewById(x7.p.f13812i1).setOnClickListener(new d());
        x8.g.f(view);
        this.J0 = y0() != null ? y0().getString("url", null) : null;
        u3();
    }

    @Override // androidx.fragment.app.k
    public Dialog b3(Bundle bundle) {
        Dialog dialogB3 = super.b3(bundle);
        dialogB3.setCancelable(true);
        dialogB3.setCanceledOnTouchOutside(false);
        return dialogB3;
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Bundle bundle = new Bundle();
        String str = this.H0;
        if (str != null) {
            bundle.putString("username", str);
        }
        String str2 = this.I0;
        if (str2 != null) {
            bundle.putString("password", str2);
        }
        N0().x1("url", bundle);
        super.onDismiss(dialogInterface);
    }

    public final void t3(v9.f fVar) {
        if (fVar == null) {
            return;
        }
        this.K0.a(Z0(x7.u.f14247z5), Z0(x7.u.Zg), new e(I(), fVar));
    }

    public final void x3() {
        this.H0 = g6.p.k(this.C0.getText().toString());
        this.I0 = g6.p.k(this.D0.getText().toString());
        X2();
    }
}
