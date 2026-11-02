package f8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q extends c {

    /* renamed from: u0, reason: collision with root package name */
    public static final String f6015u0 = "q";

    /* renamed from: s0, reason: collision with root package name */
    public b f6016s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f6017t0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f6016s0 == null) {
                return;
            }
            int id = view.getId();
            if (id == x7.p.f13821l1) {
                q.this.f6016s0.d();
                return;
            }
            if (id == x7.p.f13863z1) {
                q.this.f6016s0.a();
                return;
            }
            if (id == x7.p.f13857x1) {
                q.this.f6016s0.b();
            } else if (id == x7.p.f13797d1) {
                q.this.f6016s0.c();
            } else if (id == x7.p.f13814j0) {
                q.this.d3();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public static /* synthetic */ boolean a3(q qVar, View view) {
        String string = qVar.f6017t0.getText().toString();
        if (string.isEmpty()) {
            return true;
        }
        g6.n.a(qVar.I(), string, x7.u.og);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        b bVar = this.f6016s0;
        if (bVar != null) {
            bVar.c();
            this.f6016s0 = null;
        }
        super.F1();
    }

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.L);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        a aVar = new a();
        view.findViewById(x7.p.f13821l1).setOnClickListener(aVar);
        view.findViewById(x7.p.f13863z1).setOnClickListener(aVar);
        view.findViewById(x7.p.f13857x1).setOnClickListener(aVar);
        view.findViewById(x7.p.f13797d1).setOnClickListener(aVar);
        view.findViewById(x7.p.f13814j0).setOnClickListener(aVar);
        view.findViewById(x7.p.f13814j0).setRotation((this.f5968o0 & 80) == 80 ? 0.0f : 180.0f);
        TextView textView = (TextView) view.findViewById(x7.p.f13815j1);
        this.f6017t0 = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: f8.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return q.a3(this.f6013a, view2);
            }
        });
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13867b, viewGroup, false);
    }

    @Override // f8.c
    public void Y2() {
        View viewC1 = c1();
        g6.y.K(viewC1 == null ? null : viewC1.findViewById(x7.p.f13814j0));
    }

    public final void d3() {
        int i10 = this.f5968o0;
        if ((i10 & 48) == 48) {
            i10 = (i10 & (-49)) | 80;
        } else if ((i10 & 80) == 80) {
            i10 = (i10 & (-81)) | 48;
        }
        Z2(i10);
        if (c1() != null) {
            x.r.c(c1().findViewById(x7.p.f13814j0)).c((i10 & 80) == 80 ? 0.0f : 180.0f).d(240L).f();
        }
    }

    public void e3(b bVar) {
        this.f6016s0 = bVar;
    }

    public void f3(String str) {
        if (str == null || str.isEmpty()) {
            this.f6017t0.setText((CharSequence) null);
        } else {
            this.f6017t0.setText(str);
        }
    }
}
