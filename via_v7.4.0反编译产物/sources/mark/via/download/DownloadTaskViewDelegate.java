package mark.via.download;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import z8.t3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class DownloadTaskViewDelegate extends y5.d {

    /* renamed from: n, reason: collision with root package name */
    public static final int f9811n = x7.o.f13709a0;

    /* renamed from: o, reason: collision with root package name */
    public static final int f9812o = x7.o.Y;

    /* renamed from: p, reason: collision with root package name */
    public static final int f9813p = x7.o.X;

    /* renamed from: q, reason: collision with root package name */
    public static final int f9814q = x7.o.f13712b0;

    /* renamed from: r, reason: collision with root package name */
    public static final int f9815r = x7.o.W;

    /* renamed from: s, reason: collision with root package name */
    public static final int f9816s = x7.o.V;

    /* renamed from: t, reason: collision with root package name */
    public static final int f9817t = x7.o.Z;

    /* renamed from: a, reason: collision with root package name */
    public final Map f9818a = new LinkedHashMap<j, d1>(64, 0.75f, true) { // from class: mark.via.download.DownloadTaskViewDelegate.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<j, d1> entry) {
            return size() > 64;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final Set f9819b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c, reason: collision with root package name */
    public final y6.a f9820c = new y6.a();

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f9821d;

    /* renamed from: e, reason: collision with root package name */
    public final x6.n f9822e;

    /* renamed from: f, reason: collision with root package name */
    public h f9823f;

    /* renamed from: g, reason: collision with root package name */
    public i f9824g;

    /* renamed from: h, reason: collision with root package name */
    public f f9825h;

    /* renamed from: i, reason: collision with root package name */
    public g f9826i;

    /* renamed from: j, reason: collision with root package name */
    public e f9827j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9828k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9829l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9830m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f9831c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, d dVar) {
            super(j10);
            this.f9831c = dVar;
        }

        @Override // v5.c
        public void a(View view) {
            int iL;
            if (DownloadTaskViewDelegate.this.f9823f == null || (iL = this.f9831c.l()) == -1) {
                return;
            }
            DownloadTaskViewDelegate.this.f9823f.a(view, iL);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f9833c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g5.c f9834d;

        public b(d dVar, g5.c cVar) {
            this.f9833c = dVar;
            this.f9834d = cVar;
        }

        @Override // v5.c
        public void a(View view) {
            int iL = this.f9833c.l();
            if (iL == -1 || DownloadTaskViewDelegate.this.f9825h == null) {
                return;
            }
            DownloadTaskViewDelegate.this.f9825h.a(view, iL, this.f9834d);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements x6.q {

        /* renamed from: e, reason: collision with root package name */
        public y6.b f9836e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ j f9837j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f9838k;

        public c(j jVar, int i10) {
            this.f9837j = jVar;
            this.f9838k = i10;
        }

        @Override // x6.q
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(w.d dVar) {
            DownloadTaskViewDelegate.this.f9820c.a(this.f9836e);
            DownloadTaskViewDelegate.this.f9819b.remove(dVar.f13207a);
            if (DownloadTaskViewDelegate.this.f9830m) {
                return;
            }
            DownloadTaskViewDelegate.this.f9818a.put((j) dVar.f13207a, (d1) dVar.f13208b);
            if (DownloadTaskViewDelegate.this.f9824g != null) {
                DownloadTaskViewDelegate.this.f9824g.a(((j) dVar.f13207a).f9845a, 2);
            }
        }

        @Override // x6.q
        public void onError(Throwable th) {
            DownloadTaskViewDelegate.this.f9820c.a(this.f9836e);
            DownloadTaskViewDelegate.this.f9819b.remove(this.f9837j);
            if (DownloadTaskViewDelegate.this.f9830m) {
                return;
            }
            DownloadTaskViewDelegate.this.f9818a.put(this.f9837j, new d1(this.f9838k));
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            this.f9836e = bVar;
            DownloadTaskViewDelegate.this.f9820c.b(bVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d extends b6.g {
        public CheckBox A;

        /* renamed from: v, reason: collision with root package name */
        public ImageView f9840v;

        /* renamed from: w, reason: collision with root package name */
        public TextView f9841w;

        /* renamed from: x, reason: collision with root package name */
        public ProgressBar f9842x;

        /* renamed from: y, reason: collision with root package name */
        public TextView f9843y;

        /* renamed from: z, reason: collision with root package name */
        public ImageView f9844z;

        public d(View view) {
            super(view);
            this.f9840v = (ImageView) view.findViewById(x7.p.P);
            this.f9841w = (TextView) view.findViewById(x7.p.f13830o1);
            this.f9842x = (ProgressBar) view.findViewById(x7.p.f13835q0);
            this.f9843y = (TextView) view.findViewById(x7.p.A1);
            this.f9844z = (ImageView) view.findViewById(x7.p.Z);
            this.A = (CheckBox) view.findViewById(x7.p.f13810i);
            x8.g.d(this.f9841w);
            x8.g.d(this.f9843y);
            this.f9842x.setProgressDrawable(Z(view.getContext()));
        }

        public static Drawable Z(Context context) {
            int iB = g6.f.b(context, x7.m.f13673c);
            int iK = x8.h.k(context);
            int iJ = x8.h.j(context);
            int iH = g6.y.h(context, 2.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iB);
            float f10 = iH;
            gradientDrawable.setCornerRadius(f10);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{iK, iJ});
            gradientDrawable2.setCornerRadius(f10);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, 3, 1)});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.progress);
            return layerDrawable;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface e {
        boolean a(int i10, g5.c cVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface f {
        void a(View view, int i10, g5.c cVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface g {
        boolean a(View view, int i10, g5.c cVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface h {
        void a(View view, int i10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface i {
        void a(long j10, Object obj);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final long f9845a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9846b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9847c;

        public j(long j10, String str, long j11) {
            this.f9845a = j10;
            this.f9846b = str;
            this.f9847c = j11;
        }

        public static j c(g5.c cVar) {
            return new j(cVar.j(), cVar.g(), cVar.s());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f9845a == jVar.f9845a && this.f9847c == jVar.f9847c && z8.u1.a(this.f9846b, jVar.f9846b);
        }

        public int hashCode() {
            return z8.u1.b(Long.valueOf(this.f9845a), this.f9846b, Long.valueOf(this.f9847c));
        }
    }

    public DownloadTaskViewDelegate() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        this.f9821d = executorServiceNewFixedThreadPool;
        this.f9822e = g7.a.b(executorServiceNewFixedThreadPool);
    }

    public static /* synthetic */ w.d i(DownloadTaskViewDelegate downloadTaskViewDelegate, int i10, Context context, g5.c cVar, j jVar) {
        Drawable drawableX;
        downloadTaskViewDelegate.getClass();
        int i11 = f9817t;
        if (i10 == i11 || i10 == f9814q) {
            drawableX = downloadTaskViewDelegate.x(context, cVar.f(), i10 == i11);
        } else {
            drawableX = i10 == f9816s ? downloadTaskViewDelegate.u(context, cVar.f()) : null;
        }
        return new w.d(jVar, new d1(i10, drawableX));
    }

    public static /* synthetic */ boolean j(DownloadTaskViewDelegate downloadTaskViewDelegate, d dVar, g5.c cVar, View view) {
        g gVar;
        downloadTaskViewDelegate.getClass();
        int iL = dVar.l();
        return (iL == -1 || (gVar = downloadTaskViewDelegate.f9826i) == null || !gVar.a(view, iL, cVar)) ? false : true;
    }

    public final String A(Context context, g5.c cVar) {
        String string;
        int iQ = cVar.q();
        if (!g5.b.d(iQ) && !g5.b.c(iQ)) {
            if (g5.b.e(iQ)) {
                return z8.b0.w(context, Math.max(cVar.c(), cVar.r()));
            }
            if (g5.b.b(iQ)) {
                return t(context, cVar.d());
            }
            return null;
        }
        String string2 = cVar.r() <= 0 ? context.getString(x7.u.f13947d4, s(context, cVar.c())) : context.getString(x7.u.f13933c4, s(context, cVar.c()), s(context, cVar.r()));
        if (g5.b.c(iQ)) {
            return context.getString(x7.u.f13989g4, string2, context.getString(x7.u.f14017i4));
        }
        if (g5.b.f(iQ)) {
            return context.getString(x7.u.f13989g4, string2, context.getString(x7.u.f14031j4));
        }
        if (cVar.p() < 0) {
            string = context.getString(x7.u.f14003h4);
        } else {
            string = s(context, cVar.p()) + "/s";
        }
        if (cVar.r() > 0) {
            return context.getString(x7.u.f13975f4, string2, string, r(context, cVar));
        }
        return context.getString(x7.u.f13961e4, string2, string);
    }

    public final String B(Context context, g5.c cVar) {
        return g6.p.f(cVar.l()) ? cVar.t() : cVar.l();
    }

    @Override // y5.d
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(final d dVar, final g5.c cVar) {
        Context context = dVar.f1219a.getContext();
        dVar.f9840v.setImageDrawable(y(context, cVar));
        dVar.f9841w.setText(B(context, cVar));
        dVar.f9843y.setText(A(context, cVar));
        int iQ = cVar.q();
        boolean zD = g5.b.d(iQ);
        if (g5.b.e(iQ)) {
            dVar.f9844z.setVisibility(8);
        } else {
            dVar.f9844z.setImageResource(zD ? x7.o.G : x7.o.H);
            dVar.f9844z.setEnabled(!this.f9828k);
            dVar.f9844z.setContentDescription(context.getString(zD ? x7.u.N3 : x7.u.O3));
            dVar.f9844z.setOnClickListener(new a(500L, dVar));
            dVar.f9844z.setVisibility(this.f9828k ? 8 : 0);
        }
        int iZ = z(context, cVar);
        if (iZ >= 0) {
            dVar.f9842x.setVisibility(0);
            dVar.f9842x.setProgress(iZ);
        } else {
            dVar.f9842x.setVisibility(8);
        }
        if (this.f9828k) {
            int iL = dVar.l();
            e eVar = this.f9827j;
            boolean z10 = eVar != null && eVar.a(iL, cVar);
            dVar.A.setChecked(z10);
            dVar.A.setVisibility(0);
            dVar.f1219a.setSelected(z10);
            x.r.f0(dVar.f1219a, context.getString(z10 ? x7.u.f13914b : x7.u.f13900a));
        } else {
            dVar.A.setVisibility(8);
            dVar.f1219a.setSelected(false);
            x.r.f0(dVar.f1219a, null);
        }
        dVar.f1219a.setOnClickListener(new b(dVar, cVar));
        dVar.f1219a.setOnLongClickListener(new View.OnLongClickListener() { // from class: mark.via.download.f1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return DownloadTaskViewDelegate.j(this.f9906a, dVar, cVar, view);
            }
        });
    }

    @Override // y5.d
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void c(d dVar, g5.c cVar, List list) {
        if (list.isEmpty()) {
            b(dVar, cVar);
            return;
        }
        int iIntValue = 0;
        for (Object obj : list) {
            if (obj instanceof Integer) {
                iIntValue |= ((Integer) obj).intValue();
            }
        }
        if (iIntValue == 0) {
            return;
        }
        Context context = dVar.f1219a.getContext();
        if ((iIntValue | 1) == 1 && g5.b.d(cVar.q())) {
            dVar.f9843y.setText(A(context, cVar));
            dVar.f9842x.setProgress(z(context, cVar));
        }
        if ((iIntValue | 2) == 2) {
            dVar.f9840v.setImageDrawable(y(context, cVar));
        }
    }

    @Override // y5.d
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public d d(Context context, ViewGroup viewGroup) {
        return new d(LayoutInflater.from(context).inflate(x7.r.f13890y, viewGroup, false));
    }

    public void F() {
        this.f9830m = true;
        this.f9829l = false;
        this.f9820c.dispose();
        this.f9819b.clear();
        this.f9818a.clear();
        this.f9821d.shutdownNow();
        this.f9824g = null;
    }

    public final void G(Context context, final g5.c cVar, final j jVar, final int i10) {
        if (this.f9819b.add(jVar)) {
            final Context applicationContext = context.getApplicationContext();
            x6.o.g(new Callable() { // from class: mark.via.download.e1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DownloadTaskViewDelegate.i(this.f9897e, i10, applicationContext, cVar, jVar);
                }
            }).l(this.f9822e).j(w6.b.b()).c(new c(jVar, i10));
        }
    }

    public void H(e eVar) {
        this.f9827j = eVar;
    }

    public void I(boolean z10) {
        this.f9828k = z10;
    }

    public void J(f fVar) {
        this.f9825h = fVar;
    }

    public void K(g gVar) {
        this.f9826i = gVar;
    }

    public void L(i iVar) {
        this.f9824g = iVar;
    }

    public void M(h hVar) {
        this.f9823f = hVar;
    }

    public void N(boolean z10) {
        this.f9829l = z10 && !this.f9830m;
    }

    public final String r(Context context, g5.c cVar) {
        if (cVar.r() <= 0 || cVar.p() <= 0) {
            return context.getString(x7.u.Q3);
        }
        int iR = (int) ((cVar.r() - cVar.c()) / cVar.p());
        if (iR <= 60) {
            return context.getResources().getQuantityString(x7.t.f13898f, iR, Integer.valueOf(iR));
        }
        int i10 = iR / 60;
        if (i10 <= 120) {
            return context.getResources().getQuantityString(x7.t.f13896d, i10, Integer.valueOf(i10));
        }
        int i11 = i10 / 60;
        return i11 <= 12 ? context.getResources().getQuantityString(x7.t.f13894b, i11, Integer.valueOf(i11)) : context.getString(x7.u.Q3);
    }

    public final String s(Context context, long j10) {
        return z8.b0.w(context, j10);
    }

    public String t(Context context, String str) {
        return (str == null || str.isEmpty()) ? context.getString(x7.u.R3) : context.getString(x7.u.S3, str);
    }

    public final Drawable u(Context context, Uri uri) throws Throwable {
        Drawable drawableB = t3.b(context, uri);
        if (drawableB != null) {
            int iH = g6.y.h(context, 24.0f);
            drawableB.setBounds(0, 0, iH, iH);
        }
        return drawableB;
    }

    public final int v(String str) {
        return (str == null || str.isEmpty()) ? f9811n : str.startsWith("audio/") ? f9813p : str.startsWith("video/") ? f9814q : str.startsWith("image/") ? f9817t : "application/vnd.android.package-archive".equals(str) ? f9816s : (str.startsWith("text/") || str.contains("document") || "application/pdf".equals(str)) ? f9812o : (str.contains("zip") || str.contains("compress")) ? f9815r : f9811n;
    }

    public final Drawable w(Context context, int i10) {
        Drawable drawableE = g6.f.e(context, i10);
        int iA = g6.e.a(context, x7.k.f13662h);
        if (drawableE != null) {
            drawableE.setColorFilter(iA, PorterDuff.Mode.SRC_IN);
        }
        return drawableE;
    }

    public final Drawable x(Context context, Uri uri, boolean z10) {
        int iH = g6.y.h(context, 24.0f);
        Bitmap bitmapD = t3.d(context, uri, iH, iH, z10);
        if (bitmapD != null) {
            return new k8.l(bitmapD, g6.y.h(context, 2.0f));
        }
        return null;
    }

    public final Drawable y(Context context, g5.c cVar) {
        int iV = v(cVar.k());
        if (!g5.b.e(cVar.q()) || (iV != f9816s && iV != f9817t && iV != f9814q)) {
            return w(context, iV);
        }
        j jVarC = j.c(cVar);
        d1 d1Var = (d1) this.f9818a.get(jVarC);
        if (d1Var != null) {
            return d1Var.c() ? d1Var.b() : w(context, d1Var.a());
        }
        if (this.f9829l && !this.f9830m) {
            G(context, cVar, jVarC, iV);
        }
        return w(context, iV);
    }

    public final int z(Context context, g5.c cVar) {
        if (!g5.b.d(cVar.q())) {
            return -1;
        }
        if (cVar.r() > 0) {
            return (int) ((cVar.c() * 1000) / cVar.r());
        }
        return 1000;
    }
}
