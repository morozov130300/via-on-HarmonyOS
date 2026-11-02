package hb;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import ib.e;
import java.util.ArrayList;
import mark.via.Shell;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends o8.g {
    public static /* synthetic */ boolean g3(d dVar, View view) {
        dVar.n3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(View view, int i10, a6.q qVar) {
        switch (qVar.c()) {
            case 1:
                g6.i.g(this, j4.class);
                break;
            case 2:
                k3(pa.r.j().y().e());
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                k3(pa.r.j().y().b());
                break;
            case 4:
                k3("https://github.com/tuyafeng/Via");
                break;
            case 5:
                if (z8.c0.i() && !z8.f.h()) {
                    k3("http://viayoo.com/contact/telegram/");
                    break;
                } else {
                    k3("http://viayoo.com/contact/telegram-zh/");
                    break;
                }
                break;
            case 6:
                k3("http://viayoo.com/contact/qqgroup/");
                break;
            case 7:
                m3();
                break;
            case 9:
                k3("https://twitter.com/tuyafeng");
                break;
            case 10:
                k3("https://weibo.com/u/7558014976");
                break;
            case 12:
                androidx.fragment.app.q qVarU0 = u0();
                if (qVarU0 instanceof Shell) {
                    g6.n.q(I(), x7.u.Y1);
                    ((Shell) qVarU0).c0();
                    break;
                }
                break;
            case 13:
                P2(Intent.createChooser(z8.f1.g("yafengtu@gmail.com", "", "", ""), Z0(x7.u.f14101o4)));
                break;
            case 14:
                k3("http://viayoo.com/contact/wechat/");
                break;
            case 15:
                k3("https://support.qq.com/product/438363");
                break;
            case 16:
                k3("https://beian.miit.gov.cn/");
                break;
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        z8.r3.d(this.f10459q0);
        boolean zH = z8.f.h();
        boolean zI = z8.c0.i();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ib.a(Z0(x7.u.f13958e1), "7.4.0.b13.edf6737e", z8.f.c(), Z0(x7.u.V2), x7.o.R0));
        if (!zI) {
            arrayList.add(new a6.q(12, Z0(x7.u.W1)));
        }
        if (zI || z8.c0.g() || z8.c0.e()) {
            arrayList.add(new a6.q(5, Z0(x7.u.f14145r7)));
        }
        if (zH) {
            arrayList.add(new a6.q(6, Z0(x7.u.f14132q7)));
        }
        arrayList.add(new a6.q(13, Z0(x7.u.f14101o4)));
        if (zH) {
            arrayList.add(new a6.q(14, Z0(x7.u.Rh)));
        }
        arrayList.add(new a6.q(4, Z0(x7.u.f13963e6)));
        arrayList.add(new a6.q(2, Z0(x7.u.Cf)));
        arrayList.add(new a6.q(3, Z0(x7.u.Aa)));
        arrayList.add(new a6.q(1, Z0(x7.u.f14186u9)));
        if (zH) {
            arrayList.add(new a6.q(16, "\u5907\u6848\u53f7", "\u6caaICP\u59072022019616\u53f7-3A"));
        }
        y5.f fVar = new y5.f(arrayList);
        ib.e eVar = new ib.e();
        eVar.p(new e.d() { // from class: hb.a
            @Override // ib.e.d
            public final void a(View view2) {
                this.f6460a.l3();
            }
        });
        eVar.q(new e.InterfaceC0082e() { // from class: hb.b
            @Override // ib.e.InterfaceC0082e
            public final boolean a(View view2) {
                return d.g3(this.f6474a, view2);
            }
        });
        fVar.K(ib.a.class, eVar);
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.c
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6487a.j3(view2, i10, (a6.q) obj);
            }
        }));
        this.f10459q0.setAdapter(fVar);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.f14109oc);
    }

    public final void k3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z8.b0.P(I(), str);
    }

    public final void l3() {
        g6.i.g(this, n0.class);
    }

    public final void m3() {
        w5.k.l(I()).d0(x7.u.I3).I(x7.u.J3).V(R.string.ok, null).f0();
    }

    public final void n3() {
        try {
            P2(new Intent("com.android.webview.SHOW_DEV_UI"));
        } catch (Exception unused) {
        }
    }
}
