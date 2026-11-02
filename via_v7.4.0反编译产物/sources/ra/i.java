package ra;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import x7.p;
import x7.r;
import x7.u;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends o8.g {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            return b6.c.e(r.C).a(viewGroup);
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, b bVar, int i10) {
            gVar.X(p.J, bVar.f11629a);
            gVar.X(p.I, i.this.Z0(bVar.f11630b));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11629a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11630b;

        public b(String str, int i10) {
            this.f11629a = str;
            this.f11630b = i10;
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("Ctrl + t", u.O));
        arrayList.add(new b("Ctrl + Tab", u.F9));
        arrayList.add(new b("Ctrl + Shift + Tab", u.E9));
        arrayList.add(new b("Alt + \u2190", u.A9));
        arrayList.add(new b("Alt + \u2192", u.B9));
        arrayList.add(new b("Ctrl + w", u.f14251z9));
        arrayList.add(new b("Alt + f", u.f14114p3));
        arrayList.add(new b("Ctrl + Shift + b", u.f14026j));
        arrayList.add(new b("Ctrl + h", u.H));
        arrayList.add(new b("Ctrl + f", u.F));
        arrayList.add(new b("Ctrl + l", u.D9));
        arrayList.add(new b("F5 / Ctrl + r", u.M9));
        arrayList.add(new b("Ctrl + u", u.f13957e0));
        arrayList.add(new b("Ctrl + d", u.f13928c));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        y5.f fVar = new y5.f(arrayList);
        fVar.K(b.class, new a());
        this.f10459q0.setAdapter(fVar);
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        v3.a(zVar, u.f14184u7);
    }
}
