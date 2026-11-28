package cb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import c6.y1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2416d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f2419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f2420h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f2417e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2418f = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2421i = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(RecyclerView.d0 d0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        boolean a(int i10);
    }

    public static /* synthetic */ boolean l(i0 i0Var, w5.g gVar, View view, MotionEvent motionEvent) {
        a aVar;
        i0Var.getClass();
        if (motionEvent.getAction() != 0 || (aVar = i0Var.f2420h) == null) {
            return true;
        }
        aVar.a(gVar);
        return true;
    }

    public static /* synthetic */ boolean m(i0 i0Var, w5.g gVar, View view, MotionEvent motionEvent) {
        a aVar;
        i0Var.getClass();
        if (motionEvent.getAction() != 0 || (aVar = i0Var.f2420h) == null) {
            return true;
        }
        aVar.a(gVar);
        return true;
    }

    public int n() {
        return this.f2421i;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(final w5.g gVar, cb.a aVar) {
        super.b(gVar, aVar);
        Context contextO = gVar.O();
        String strJ = com.tuyafeng.support.utils.p.j(aVar.g(), 256);
        gVar.X(w7.p.f13908s1, strJ);
        boolean z10 = this.f2415c && !aVar.i();
        gVar.Y(w7.p.T, z10);
        ImageView imageView = (ImageView) gVar.P(w7.p.S);
        if (aVar.a() != null) {
            if (this.f2417e == null) {
                Drawable drawableC = lb.g.c(contextO, w7.o.f13784d0, w7.u.te);
                this.f2417e = drawableC;
                com.tuyafeng.support.utils.h.a(drawableC, com.tuyafeng.support.utils.e.a(contextO, w7.k.f13729i));
            }
            imageView.setImageDrawable(this.f2417e);
            gVar.U(w7.p.f13908s1, contextO.getString(w7.u.f14276w3, strJ));
        } else if (aVar.b() != null) {
            Bitmap bitmapD = x8.x0.c().d(contextO, a2.f1958a.g(aVar.b().g()));
            if (bitmapD != null) {
                x8.y0.i(imageView, bitmapD, null);
            } else {
                if (this.f2418f == null) {
                    Drawable drawableC2 = lb.g.c(contextO, w7.o.f13837v, w7.u.ie);
                    this.f2418f = drawableC2;
                    com.tuyafeng.support.utils.h.a(drawableC2, com.tuyafeng.support.utils.e.a(contextO, w7.k.f13729i));
                }
                imageView.setImageDrawable(this.f2418f);
            }
            gVar.U(w7.p.f13908s1, null);
        }
        w(gVar, aVar, this.f2421i);
        b bVar = this.f2419g;
        boolean z11 = bVar != null && bVar.a(gVar.l());
        CheckBox checkBox = (CheckBox) gVar.P(w7.p.f13876i);
        checkBox.setClickable(false);
        checkBox.setFocusable(false);
        checkBox.setVisibility(z10 ? 0 : 8);
        checkBox.setChecked(z11);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: cb.g0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return i0.m(this.f2404a, gVar, view, motionEvent);
            }
        });
        View viewP = gVar.P(w7.p.T);
        viewP.setVisibility((aVar.i() || !this.f2416d) ? 8 : 0);
        viewP.setOnTouchListener(new View.OnTouchListener() { // from class: cb.h0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return i0.l(this.f2410a, gVar, view, motionEvent);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, cb.a aVar, List list) {
        if (list.isEmpty()) {
            b(gVar, aVar);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof Boolean) {
                ((CheckBox) gVar.P(w7.p.f13876i)).setChecked(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                w(gVar, aVar, ((Integer) obj).intValue());
            }
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(w7.r.f13953v, viewGroup, false);
        v8.g.d((TextView) viewInflate.findViewById(w7.p.f13908s1));
        v8.g.d((TextView) viewInflate.findViewById(w7.p.f13911t1));
        return new w5.g(viewInflate);
    }

    public void r(int i10) {
        if (i10 == this.f2421i) {
            return;
        }
        this.f2421i = i10;
    }

    public void s(a aVar) {
        this.f2420h = aVar;
    }

    public void t(b bVar) {
        this.f2419g = bVar;
    }

    public void u(boolean z10) {
        if (this.f2415c == z10) {
            return;
        }
        this.f2415c = z10;
    }

    public void v(boolean z10) {
        if (this.f2416d == z10) {
            return;
        }
        this.f2416d = z10;
    }

    public final void w(w5.g gVar, cb.a aVar, int i10) {
        boolean z10 = !aVar.i() && i10 == 1;
        gVar.Y(w7.p.f13911t1, z10);
        if (z10) {
            if (aVar.a() != null) {
                gVar.X(w7.p.f13911t1, gVar.O().getResources().getQuantityString(w7.t.f13961c, aVar.c(), Integer.valueOf(aVar.c())));
            } else if (aVar.b() != null) {
                gVar.X(w7.p.f13911t1, y1.f2139a.d(aVar.b().g()));
            }
        }
    }
}
