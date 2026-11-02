package f8;

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
import z8.x0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public b f6053c;

    /* renamed from: d, reason: collision with root package name */
    public c f6054d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f6055e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b6.g f6056c;

        public a(b6.g gVar) {
            this.f6056c = gVar;
        }

        @Override // v5.c
        public void a(View view) {
            int iL = this.f6056c.l();
            if (iL == -1 || y.this.f6053c == null) {
                return;
            }
            y.this.f6053c.a(iL);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(int i10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(RecyclerView.c0 c0Var);
    }

    public static /* synthetic */ boolean l(y yVar, b6.g gVar, View view, MotionEvent motionEvent) {
        c cVar;
        yVar.getClass();
        if (motionEvent.getAction() != 0 || (cVar = yVar.f6054d) == null) {
            return false;
        }
        cVar.a(gVar);
        return false;
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(final b6.g gVar, r4.a aVar) {
        super.b(gVar, aVar);
        Context context = gVar.f1219a.getContext();
        mark.via.common.widget.b0 b0Var = (mark.via.common.widget.b0) gVar.f1219a;
        if (this.f6055e == null) {
            this.f6055e = g6.e.f(lb.b.a(context, x7.o.L1, x7.u.Bf), g6.e.a(context, x7.k.f13662h));
            int iD = g6.f.d(context, x7.n.f13687f);
            this.f6055e.setBounds(0, 0, iD, iD);
        }
        TextView textView = b0Var.getTextView();
        String strG = z8.b0.G(aVar.getTitle(), aVar.getUrl());
        if (TextUtils.isEmpty(strG)) {
            strG = aVar.getUrl();
        }
        if (TextUtils.isEmpty(strG)) {
            strG = context.getString(x7.u.bh);
        }
        textView.setText(strG);
        Typeface typefaceI = x8.g.i();
        if (aVar.d()) {
            textView.setTypeface(typefaceI, 1);
            textView.setTextColor(x8.h.j(context));
        } else {
            textView.setTypeface(typefaceI, 0);
            textView.setTextColor(x8.h.p(context));
        }
        Bitmap bitmapU = aVar.u();
        if (bitmapU == null) {
            bitmapU = x0.c().d(context, aVar.getUrl());
        }
        if (bitmapU != null) {
            b0Var.getIconView().setImageBitmap(bitmapU);
        } else {
            b0Var.getIconView().setImageDrawable(this.f6055e);
        }
        b0Var.getCloseView().setContentDescription(context.getString(x7.u.f14071m2, strG));
        b0Var.getCloseView().setOnClickListener(new a(gVar));
        b0Var.getIconView().setOnTouchListener(new View.OnTouchListener() { // from class: f8.x
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return y.l(this.f6051a, gVar, view, motionEvent);
            }
        });
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        return new b6.g((mark.via.common.widget.b0) new h6.a(new mark.via.common.widget.b0(context), new FrameLayout.LayoutParams(-1, g6.f.d(context, x7.n.f13707z))).l());
    }

    public void p(b bVar) {
        this.f6053c = bVar;
    }

    public void q(c cVar) {
        this.f6054d = cVar;
    }
}
