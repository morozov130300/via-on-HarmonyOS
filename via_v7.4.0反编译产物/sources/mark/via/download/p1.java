package mark.via.download;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.common.widget.SizedGridLayoutManager;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p1 extends k8.a {
    public RecyclerView C0;
    public TextView D0;
    public y5.f E0;
    public SizedGridLayoutManager F0;
    public String G0;
    public String H0;
    public Runnable I0;

    public static /* synthetic */ void k3(p1 p1Var, q1 q1Var) {
        Fragment fragmentM0 = p1Var.M0();
        if (fragmentM0 == null || !fragmentM0.i1() || fragmentM0.p1() || w1.e(fragmentM0, q1Var, p1Var.G0)) {
            return;
        }
        g6.n.q(fragmentM0.I(), x7.u.f14134q9);
    }

    public static p1 r3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("file_path", str);
        bundle.putString("mime_type", str2);
        p1 p1Var = new p1();
        p1Var.H2(bundle);
        return p1Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13873h, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.findViewById(x7.p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f9927a.X2();
            }
        });
        this.C0 = (RecyclerView) view.findViewById(R.id.list);
        TextView textView = (TextView) view.findViewById(x7.p.f13818k1);
        this.D0 = textView;
        r3.e(textView);
        SizedGridLayoutManager sizedGridLayoutManager = new SizedGridLayoutManager(I(), 1);
        this.F0 = sizedGridLayoutManager;
        this.C0.setLayoutManager(sizedGridLayoutManager);
        int iH = g6.y.h(I(), 4.0f);
        this.C0.setClipToPadding(false);
        int i10 = iH * 2;
        this.C0.setPadding(i10, 0, i10, 0);
        this.C0.k(new com.tuyafeng.support.widget.x(iH, iH));
        r3.d(this.C0);
        this.E0 = new y5.f(Collections.EMPTY_LIST);
        this.E0.K(q1.class, new r1(new y5.g() { // from class: mark.via.download.l1
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                this.f9931a.p3((q1) obj);
            }
        }));
        this.E0.F(true);
        this.C0.setAdapter(this.E0);
        q3();
    }

    public final void o3(List list) {
        if (list.isEmpty()) {
            this.C0.setVisibility(8);
            this.D0.setVisibility(0);
        } else {
            this.D0.setVisibility(8);
            this.C0.setVisibility(0);
            this.E0.M(list);
            this.E0.l();
        }
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Runnable runnable = this.I0;
        this.I0 = null;
        super.onDismiss(dialogInterface);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void p3(final q1 q1Var) {
        this.I0 = new Runnable() { // from class: mark.via.download.m1
            @Override // java.lang.Runnable
            public final void run() {
                p1.k3(this.f9934e, q1Var);
            }
        };
        X2();
    }

    public final void q3() {
        s3();
        final Context contextI = I();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: mark.via.download.n1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                p1 p1Var = this.f9939e;
                return w1.g(contextI, p1Var.G0, p1Var.H0);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: mark.via.download.o1
            @Override // a7.e
            public final void accept(Object obj) {
                this.f9945e.o3((List) obj);
            }
        }, new x7.g0());
    }

    public final void s3() {
        Context contextI = I();
        int iZ = g6.y.z(contextI);
        int iY = g6.y.y(contextI);
        this.F0.e3(Math.max(1, iZ / Math.max(1, g6.y.h(contextI, 95.0f))));
        this.F0.h3((iY * 2) / 3);
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        Bundle bundleY0 = y0();
        this.G0 = bundleY0 == null ? null : bundleY0.getString("file_path");
        this.H0 = bundleY0 != null ? bundleY0.getString("mime_type") : null;
    }
}
