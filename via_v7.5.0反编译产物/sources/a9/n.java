package a9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends t5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f252d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f253e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f254c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f255a;

        public a(Context context) {
            this.f255a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(v8.h.o(this.f255a));
            v8.g.m(textView, v8.h.q(this.f255a));
            v8.g.k(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w5.g f258d;

        public b(String str, w5.g gVar) {
            this.f257c = str;
            this.f258d = gVar;
        }

        @Override // p5.c
        public void a(View view) {
            if (n.this.f254c != null) {
                n.this.f254c.a(view, this.f257c, this.f258d.l());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(View view, String str, int i10);
    }

    public static /* synthetic */ void l(ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13846y, w7.u.je));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, String str) {
        super.b(gVar, str);
        gVar.X(f252d, str);
        gVar.P(f253e).setOnClickListener(new b(str, gVar));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, -2)).d(w7.o.f13786e).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).o(f252d).P(1, 16).T(1, 12).p(16).v(1, 40).V(new a(context)).l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(context), new FrameLayout.LayoutParams(-2, -2)).o(f253e).Y(1, 40).n(1, 40).N(1, 9).v(1, 10).p(8388629).i(w7.u.f14298y).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: a9.m
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n.l((ImageView) obj);
            }
        }).l();
        frameLayout.addView(textView);
        frameLayout.addView(imageView);
        return new w5.g(frameLayout);
    }

    public void p(c cVar) {
        this.f254c = cVar;
    }
}
