package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Collections;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l6 extends o8.g {

    /* renamed from: v0, reason: collision with root package name */
    public static final String f6644v0 = "hb.l6";

    /* renamed from: r0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f6645r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6646s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f6647t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    public int f6648u0 = -1;

    public static /* synthetic */ void h3(l6 l6Var, View view, int i10, a6.g gVar) {
        l6Var.m3(i10);
        if (l6Var.f6647t0) {
            l6Var.l3();
        }
    }

    private void i3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.g(0, Z0(x7.u.G9), false));
        arrayList.add(new a6.l(Z0(x7.u.Nd)));
        int[] iArr = {5, 10, 11, 12, 13, 9, 16, 27};
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = iArr[i10];
            arrayList.add(new a6.g(i11, v4.b(I(), i11), false));
        }
        arrayList.add(new a6.l(Z0(x7.u.f14169t5)));
        int[] iArr2 = {7, 30, 8, 23, 28, 26, 14, 15, 24, 25, 29};
        for (int i12 = 0; i12 < 11; i12++) {
            int i13 = iArr2[i12];
            arrayList.add(new a6.g(i13, v4.b(I(), i13), false));
        }
        arrayList.add(new a6.l(Z0(x7.u.B0)));
        int i14 = new int[]{4}[0];
        arrayList.add(new a6.g(i14, v4.b(I(), i14), false));
        arrayList.add(new a6.l(Z0(x7.u.Qh)));
        int[] iArr3 = {19, 1, 20, 6, 18, 17, 2, 3};
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = iArr3[i15];
            arrayList.add(new a6.g(i16, v4.b(I(), i16), false));
        }
        this.f6646s0.M(arrayList);
        this.f6646s0.l();
        int i17 = y0() == null ? 0 : y0().getInt(Name.MARK, 0);
        this.f6647t0 = y0() != null && y0().getBoolean("disposable", false);
        int i18 = 0;
        while (true) {
            if (i18 >= arrayList.size()) {
                i18 = 0;
                break;
            }
            Object obj = arrayList.get(i18);
            if ((obj instanceof a6.g) && ((a6.g) obj).c() == i17) {
                break;
            } else {
                i18++;
            }
        }
        m3(i18);
        this.f10459q0.p1(i18);
        if (this.f6647t0) {
            return;
        }
        this.f6645r0.c(new z.b(0, 0, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: hb.k6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6629a.l3();
            }
        });
    }

    public static Bundle j3(int i10, boolean z10) {
        Bundle bundle = new Bundle();
        if (i10 >= 0) {
            bundle.putInt(Name.MARK, i10);
        }
        if (z10) {
            bundle.putBoolean("disposable", true);
        }
        return bundle;
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6646s0 = new y5.f(Collections.EMPTY_LIST);
        a6.j jVar = new a6.j();
        jVar.j(new y5.g() { // from class: hb.j6
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                l6.h3(this.f6617a, view2, i10, (a6.g) obj);
            }
        });
        this.f6646s0.K(a6.g.class, jVar);
        this.f6646s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f6646s0);
        i3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f13983fc));
        this.f6645r0 = zVar;
    }

    public final boolean k3() {
        int i10 = this.f6648u0;
        if (i10 < 0 || i10 >= this.f6646s0.g()) {
            return false;
        }
        Object obj = this.f6646s0.H().get(this.f6648u0);
        if (!(obj instanceof a6.g)) {
            return false;
        }
        N0().x1(f6644v0, v5.a.b().d(Name.MARK, ((a6.g) obj).c()).a());
        return true;
    }

    public final void l3() {
        if (k3()) {
            l0().onBackPressed();
        }
    }

    public final void m3(int i10) {
        if (this.f6648u0 == i10 || i10 < 0 || i10 >= this.f6646s0.g()) {
            return;
        }
        int i11 = this.f6648u0;
        this.f6648u0 = i10;
        if (i11 >= 0) {
            Object obj = this.f6646s0.H().get(i11);
            if (obj instanceof a6.g) {
                ((a6.g) obj).j(false);
                this.f6646s0.m(i11);
            }
        }
        Object obj2 = this.f6646s0.H().get(i10);
        if (obj2 instanceof a6.g) {
            ((a6.g) obj2).j(true);
            this.f6646s0.m(i10);
        }
    }
}
