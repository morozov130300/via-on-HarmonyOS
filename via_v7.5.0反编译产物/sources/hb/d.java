package hb;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import mark.via.Shell;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends m8.f {
    public static /* synthetic */ boolean f3(d dVar, View view) {
        dVar.n3();
        return true;
    }

    public static List i3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, d.class, w7.u.Cc);
        if (!x8.a0.h()) {
            hVar.b(12, w7.u.f14095j2, new String[0]);
        }
        if (x8.a0.h() || x8.a0.g() || x8.a0.e()) {
            hVar.b(5, w7.u.D7, new String[0]);
        }
        if (x8.f.h()) {
            hVar.b(6, w7.u.C7, new String[0]);
        }
        hVar.b(13, w7.u.B4, new String[0]);
        if (x8.f.h()) {
            hVar.b(14, w7.u.wi, new String[0]);
        }
        hVar.b(4, w7.u.f14197q6, new String[0]);
        hVar.b(2, w7.u.Sf, new String[0]);
        hVar.b(3, w7.u.Ma, new String[0]);
        hVar.b(1, w7.u.F9, new String[0]);
        if (x8.f.h()) {
            hVar.d("about.filing", 16, "备案号", new String[0]);
        }
        return hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(View view, int i10, v5.q qVar) {
        switch (qVar.c()) {
            case 1:
                FragmentUtils.i(this, i4.class);
                break;
            case 2:
                k3(la.s.j().z().e());
                break;
            case 3:
                k3(la.s.j().z().b());
                break;
            case 4:
                k3("https://github.com/tuyafeng/Via");
                break;
            case 5:
                if (x8.a0.h() && !x8.f.h()) {
                    k3("http://viayoo.com/contact/telegram/");
                } else {
                    k3("http://viayoo.com/contact/telegram-zh/");
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
                androidx.fragment.app.q qVarS0 = s0();
                if (qVarS0 instanceof Shell) {
                    com.tuyafeng.support.utils.n.q(G(), w7.u.f14123l2);
                    ((Shell) qVarS0).a0();
                }
                break;
            case 13:
                N2(Intent.createChooser(x8.e1.g("yafengtu@gmail.com", "", "", ""), X0(w7.u.B4)));
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        x8.r3.e(this.f7946t0);
        boolean zH = x8.f.h();
        boolean zH2 = x8.a0.h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ib.a(X0(w7.u.f14066h1), "7.5.0", x8.f.c(), X0(w7.u.f14068h3), w7.o.P0));
        if (!zH2) {
            arrayList.add(new v5.q(12, X0(w7.u.f14095j2)));
        }
        if (zH2 || x8.a0.g() || x8.a0.e()) {
            arrayList.add(new v5.q(5, X0(w7.u.D7)));
        }
        if (zH) {
            arrayList.add(new v5.q(6, X0(w7.u.C7)));
        }
        arrayList.add(new v5.q(13, X0(w7.u.B4)));
        if (zH) {
            arrayList.add(new v5.q(14, X0(w7.u.wi)));
        }
        arrayList.add(new v5.q(4, X0(w7.u.f14197q6)));
        arrayList.add(new v5.q(2, X0(w7.u.Sf)));
        arrayList.add(new v5.q(3, X0(w7.u.Ma)));
        arrayList.add(new v5.q(1, X0(w7.u.F9)));
        if (zH) {
            arrayList.add(new v5.q(16, "备案号", "沪ICP备2022019616号-3A"));
        }
        t5.f fVar = new t5.f(arrayList);
        ib.f fVar2 = new ib.f();
        fVar2.q(new ib.f.c() { // from class: hb.a
            @Override // ib.f.c
            public final void a(View view2) {
                this.f5782a.l3();
            }
        });
        fVar2.r(new ib.f.d() { // from class: hb.b
            @Override // ib.f.d
            public final boolean a(View view2) {
                return d.f3(this.f5799a, view2);
            }
        });
        fVar.K(ib.a.class, fVar2);
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.c
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5821a.j3(view2, i10, (v5.q) obj);
            }
        }));
        this.f7946t0.setAdapter(fVar);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Cc);
    }

    public final void k3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        x8.z.O(G(), str);
    }

    public final void l3() {
        FragmentUtils.i(this, n0.class);
    }

    public final void m3() {
        q5.k.l(G()).f0(w7.u.V3).J(w7.u.W3).X(R.string.ok, null).h0();
    }

    public final void n3() {
        try {
            N2(new Intent("com.android.webview.SHOW_DEV_UI"));
        } catch (Exception unused) {
        }
    }
}
