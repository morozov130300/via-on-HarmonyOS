package d8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends c {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f3984x0 = "q";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public b f3985u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public TextView f3986v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public TextView f3987w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f3985u0 == null) {
                return;
            }
            int id = view.getId();
            if (id == w7.p.f13887l1) {
                q.this.f3985u0.e();
                return;
            }
            if (id == w7.p.A1) {
                q.this.f3985u0.a();
                return;
            }
            if (id == w7.p.f13923x1) {
                q.this.e3(!view.isSelected());
                return;
            }
            if (id == w7.p.f13926y1) {
                q.this.f3985u0.b();
            } else if (id == w7.p.f13863d1) {
                q.this.f3985u0.d();
            } else if (id == w7.p.f13871g0) {
                q.this.c3();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();
    }

    public static /* synthetic */ boolean Y2(q qVar, View view) {
        String string = qVar.f3986v0.getText().toString();
        if (string.isEmpty()) {
            return true;
        }
        com.tuyafeng.support.utils.n.a(qVar.G(), string, w7.u.Eg);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        b bVar = this.f3985u0;
        if (bVar != null) {
            bVar.d();
            this.f3985u0 = null;
        }
        super.D1();
    }

    @Override // d8.c
    public CharSequence U2() {
        return X0(w7.u.M);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        a aVar = new a();
        view.findViewById(w7.p.f13887l1).setOnClickListener(aVar);
        view.findViewById(w7.p.A1).setOnClickListener(aVar);
        TextView textView = (TextView) view.findViewById(w7.p.f13923x1);
        this.f3987w0 = textView;
        textView.setTextColor(v8.h.g(G(), v8.h.o(G())));
        this.f3987w0.setOnClickListener(aVar);
        view.findViewById(w7.p.f13926y1).setOnClickListener(aVar);
        view.findViewById(w7.p.f13863d1).setOnClickListener(aVar);
        view.findViewById(w7.p.f13871g0).setOnClickListener(aVar);
        view.findViewById(w7.p.f13871g0).setRotation((this.f3944q0 & 80) == 80 ? 0.0f : 180.0f);
        this.f3986v0 = (TextView) view.findViewById(w7.p.f13881j1);
        f3(null);
        this.f3986v0.setOnLongClickListener(new View.OnLongClickListener() { // from class: d8.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return q.Y2(this.f3983a, view2);
            }
        });
    }

    @Override // d8.c
    public View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13933b, viewGroup, false);
    }

    @Override // d8.c
    public void W2() {
        View viewA1 = a1();
        com.tuyafeng.support.utils.x.L(viewA1 == null ? null : viewA1.findViewById(w7.p.f13871g0));
    }

    public final void c3() {
        int i10 = this.f3944q0;
        if ((i10 & 48) == 48) {
            i10 = (i10 & (-49)) | 80;
        } else if ((i10 & 80) == 80) {
            i10 = (i10 & (-81)) | 48;
        }
        X2(i10);
        if (a1() != null) {
            y.r.c(a1().findViewById(w7.p.f13871g0)).c((i10 & 80) == 80 ? 0.0f : 180.0f).d(240L).f();
        }
    }

    public void d3(b bVar) {
        this.f3985u0 = bVar;
    }

    public final void e3(boolean z10) {
        this.f3987w0.setSelected(z10);
        this.f3985u0.c(z10);
    }

    public void f3(String str) {
        this.f3986v0.setText(str);
        this.f3987w0.setEnabled((str == null || str.isEmpty()) ? false : true);
        if (this.f3987w0.isSelected()) {
            e3(false);
        }
        TextView textView = this.f3987w0;
        textView.setAlpha(textView.isEnabled() ? 1.0f : 0.5f);
    }
}
