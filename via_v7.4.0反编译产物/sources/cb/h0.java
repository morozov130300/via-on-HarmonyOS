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
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h0 extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3119c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3120d;

    /* renamed from: g, reason: collision with root package name */
    public b f3123g;

    /* renamed from: h, reason: collision with root package name */
    public a f3124h;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f3121e = null;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f3122f = null;

    /* renamed from: i, reason: collision with root package name */
    public int f3125i = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(RecyclerView.c0 c0Var);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        boolean a(int i10);
    }

    public static /* synthetic */ boolean l(h0 h0Var, b6.g gVar, View view, MotionEvent motionEvent) {
        a aVar;
        h0Var.getClass();
        if (motionEvent.getAction() != 0 || (aVar = h0Var.f3124h) == null) {
            return true;
        }
        aVar.a(gVar);
        return true;
    }

    public static /* synthetic */ boolean m(h0 h0Var, b6.g gVar, View view, MotionEvent motionEvent) {
        a aVar;
        h0Var.getClass();
        if (motionEvent.getAction() != 0 || (aVar = h0Var.f3124h) == null) {
            return true;
        }
        aVar.a(gVar);
        return true;
    }

    public int n() {
        return this.f3125i;
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(final b6.g gVar, cb.a aVar) {
        super.b(gVar, aVar);
        Context contextO = gVar.O();
        String strJ = g6.p.j(aVar.f(), 256);
        gVar.X(x7.p.f13842s1, strJ);
        boolean z10 = this.f3119c && !aVar.h();
        gVar.Y(x7.p.U, z10);
        ImageView imageView = (ImageView) gVar.P(x7.p.T);
        if (aVar.a() != null) {
            if (this.f3121e == null) {
                Drawable drawableA = lb.b.a(contextO, x7.o.f13721e0, x7.u.ee);
                this.f3121e = drawableA;
                g6.h.a(drawableA, g6.e.a(contextO, x7.k.f13662h));
            }
            imageView.setImageDrawable(this.f3121e);
            gVar.U(x7.p.f13842s1, contextO.getString(x7.u.f14044k3, strJ));
        } else if (aVar.b() != null) {
            Bitmap bitmapD = z8.x0.c().d(contextO, i6.i0.f7006a.f(aVar.b().g()));
            if (bitmapD != null) {
                imageView.setImageBitmap(bitmapD);
            } else {
                if (this.f3122f == null) {
                    Drawable drawableA2 = lb.b.a(contextO, x7.o.f13774w, x7.u.Td);
                    this.f3122f = drawableA2;
                    g6.h.a(drawableA2, g6.e.a(contextO, x7.k.f13662h));
                }
                imageView.setImageDrawable(this.f3122f);
            }
            gVar.U(x7.p.f13842s1, null);
        }
        w(gVar, aVar, this.f3125i);
        b bVar = this.f3123g;
        boolean z11 = bVar != null && bVar.a(gVar.l());
        CheckBox checkBox = (CheckBox) gVar.P(x7.p.f13810i);
        checkBox.setClickable(false);
        checkBox.setFocusable(false);
        checkBox.setVisibility(z10 ? 0 : 8);
        checkBox.setChecked(z11);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: cb.f0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return h0.m(this.f3107a, gVar, view, motionEvent);
            }
        });
        View viewP = gVar.P(x7.p.U);
        viewP.setVisibility((aVar.h() || !this.f3120d) ? 8 : 0);
        viewP.setOnTouchListener(new View.OnTouchListener() { // from class: cb.g0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return h0.l(this.f3113a, gVar, view, motionEvent);
            }
        });
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, cb.a aVar, List list) {
        if (list.isEmpty()) {
            b(gVar, aVar);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof Boolean) {
                ((CheckBox) gVar.P(x7.p.f13810i)).setChecked(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                w(gVar, aVar, ((Integer) obj).intValue());
            }
        }
    }

    @Override // y5.d
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(x7.r.f13888w, viewGroup, false);
        x8.g.d((TextView) viewInflate.findViewById(x7.p.f13842s1));
        x8.g.d((TextView) viewInflate.findViewById(x7.p.f13845t1));
        return new b6.g(viewInflate);
    }

    public void r(int i10) {
        if (i10 == this.f3125i) {
            return;
        }
        this.f3125i = i10;
    }

    public void s(a aVar) {
        this.f3124h = aVar;
    }

    public void t(b bVar) {
        this.f3123g = bVar;
    }

    public void u(boolean z10) {
        if (this.f3119c == z10) {
            return;
        }
        this.f3119c = z10;
    }

    public void v(boolean z10) {
        if (this.f3120d == z10) {
            return;
        }
        this.f3120d = z10;
    }

    public final void w(b6.g gVar, cb.a aVar, int i10) {
        boolean z10 = !aVar.h() && i10 == 1;
        gVar.Y(x7.p.f13845t1, z10);
        if (z10) {
            if (aVar.a() != null) {
                gVar.X(x7.p.f13845t1, gVar.O().getResources().getQuantityString(x7.t.f13895c, aVar.c(), Integer.valueOf(aVar.c())));
            } else if (aVar.b() != null) {
                gVar.X(x7.p.f13845t1, i6.g0.f6993a.d(aVar.b().g()));
            }
        }
    }
}
