package d8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import x8.x0;
import x8.y0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f4003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f4004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f4005e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w5.g f4006c;

        public a(w5.g gVar) {
            this.f4006c = gVar;
        }

        @Override // p5.c
        public void a(View view) {
            int iL = this.f4006c.l();
            if (iL == -1 || y.this.f4003c == null) {
                return;
            }
            y.this.f4003c.a(iL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(RecyclerView.d0 d0Var);
    }

    public static /* synthetic */ boolean l(y yVar, w5.g gVar, View view, MotionEvent motionEvent) {
        c cVar;
        yVar.getClass();
        if (motionEvent.getAction() != 0 || (cVar = yVar.f4004d) == null) {
            return false;
        }
        cVar.a(gVar);
        return false;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(final w5.g gVar, r4.a aVar) {
        super.b(gVar, aVar);
        Context context = gVar.f1138a.getContext();
        mark.via.common.widget.b0 b0Var = (mark.via.common.widget.b0) gVar.f1138a;
        if (this.f4005e == null) {
            this.f4005e = com.tuyafeng.support.utils.e.f(lb.g.c(context, w7.o.I1, w7.u.Rf), com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
            int iD = com.tuyafeng.support.utils.f.d(context, w7.n.f13753f);
            this.f4005e.setBounds(0, 0, iD, iD);
        }
        TextView textView = b0Var.getTextView();
        String strF = x8.z.F(aVar.getTitle(), aVar.getUrl());
        if (TextUtils.isEmpty(strF)) {
            strF = aVar.getUrl();
        }
        if (TextUtils.isEmpty(strF)) {
            strF = context.getString(w7.u.Ah);
        }
        textView.setText(strF);
        Typeface typefaceI = v8.g.i();
        if (aVar.d()) {
            textView.setTypeface(typefaceI, 1);
            textView.setTextColor(v8.h.j(context));
        } else {
            textView.setTypeface(typefaceI, 0);
            textView.setTextColor(v8.h.o(context));
        }
        Bitmap bitmapT = aVar.t();
        if (bitmapT == null) {
            bitmapT = x0.c().d(context, aVar.getUrl());
        }
        y0.i(b0Var.getIconView(), bitmapT, this.f4005e);
        b0Var.getCloseView().setContentDescription(context.getString(w7.u.f14314z2, strF));
        b0Var.getCloseView().setOnClickListener(new a(gVar));
        b0Var.getIconView().setOnTouchListener(new View.OnTouchListener() { // from class: d8.x
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return y.l(this.f4001a, gVar, view, motionEvent);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g((mark.via.common.widget.b0) new b6.a(new mark.via.common.widget.b0(context), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(context, w7.n.B))).l());
    }

    public void p(b bVar) {
        this.f4003c = bVar;
    }

    public void q(c cVar) {
        this.f4004d = cVar;
    }
}
