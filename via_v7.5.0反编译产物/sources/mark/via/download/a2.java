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
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a2 extends i8.a {
    public RecyclerView E0;
    public TextView F0;
    public t5.f G0;
    public SizedGridLayoutManager H0;
    public String I0;
    public String J0;
    public Runnable K0;

    public static /* synthetic */ void k3(a2 a2Var, b2 b2Var) {
        Fragment fragmentK0 = a2Var.K0();
        if (fragmentK0 == null || !fragmentK0.g1() || fragmentK0.n1() || h2.e(fragmentK0, b2Var, a2Var.I0)) {
            return;
        }
        com.tuyafeng.support.utils.n.q(fragmentK0.G(), w7.u.B9);
    }

    public static a2 r3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("file_path", str);
        bundle.putString("mime_type", str2);
        a2 a2Var = new a2();
        a2Var.F2(bundle);
        return a2Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13939h, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.findViewById(w7.p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10306a.V2();
            }
        });
        this.E0 = (RecyclerView) view.findViewById(R.id.list);
        TextView textView = (TextView) view.findViewById(w7.p.f13884k1);
        this.F0 = textView;
        r3.f(textView);
        SizedGridLayoutManager sizedGridLayoutManager = new SizedGridLayoutManager(G(), 1);
        this.H0 = sizedGridLayoutManager;
        this.E0.setLayoutManager(sizedGridLayoutManager);
        int iH = com.tuyafeng.support.utils.x.h(G(), 4.0f);
        this.E0.setClipToPadding(false);
        int i10 = iH * 2;
        this.E0.setPadding(i10, 0, i10, 0);
        this.E0.k(new com.tuyafeng.support.widget.c0(iH, iH));
        r3.e(this.E0);
        this.G0 = new t5.f(Collections.EMPTY_LIST);
        this.G0.K(b2.class, new c2(new t5.g() { // from class: mark.via.download.w1
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                this.f10311a.p3((b2) obj);
            }
        }));
        this.G0.F(true);
        this.E0.setAdapter(this.G0);
        q3();
    }

    public final void o3(List list) {
        if (list.isEmpty()) {
            this.E0.setVisibility(8);
            this.F0.setVisibility(0);
        } else {
            this.F0.setVisibility(8);
            this.E0.setVisibility(0);
            this.G0.M(list);
            this.G0.l();
        }
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Runnable runnable = this.K0;
        this.K0 = null;
        super.onDismiss(dialogInterface);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void p3(final b2 b2Var) {
        this.K0 = new Runnable() { // from class: mark.via.download.x1
            @Override // java.lang.Runnable
            public final void run() {
                a2.k3(this.f10317c, b2Var);
            }
        };
        V2();
    }

    public final void q3() {
        s3();
        final Context contextG = G();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.download.y1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                a2 a2Var = this.f10322c;
                return h2.g(contextG, a2Var.I0, a2Var.J0);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.download.z1
            @Override // u6.f
            public final void accept(Object obj) {
                this.f10329c.o3((List) obj);
            }
        }, new w7.e0());
    }

    public final void s3() {
        Context contextG = G();
        int iZ = com.tuyafeng.support.utils.x.z(contextG);
        int iY = com.tuyafeng.support.utils.x.y(contextG);
        this.H0.e3(Math.max(1, iZ / Math.max(1, com.tuyafeng.support.utils.x.h(contextG, 95.0f))));
        this.H0.h3((iY * 2) / 3);
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        Bundle bundleW0 = w0();
        this.I0 = bundleW0 == null ? null : bundleW0.getString("file_path");
        this.J0 = bundleW0 != null ? bundleW0.getString("mime_type") : null;
    }
}
