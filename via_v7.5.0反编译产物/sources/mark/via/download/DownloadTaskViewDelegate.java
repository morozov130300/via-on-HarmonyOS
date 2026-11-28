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
import x8.t3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class DownloadTaskViewDelegate extends t5.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10115n = w7.o.Z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10116o = w7.o.X;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10117p = w7.o.W;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10118q = w7.o.f13775a0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10119r = w7.o.V;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10120s = w7.o.U;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10121t = w7.o.Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10122a = new LinkedHashMap<j, o1>(64, 0.75f, true) { // from class: mark.via.download.DownloadTaskViewDelegate.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<j, o1> entry) {
            return size() > 64;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f10123b = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.a f10124c = new s6.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f10125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.p f10126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f10127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f10128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f10129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f10130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f10131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10134m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f10135c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, d dVar) {
            super(j10);
            this.f10135c = dVar;
        }

        @Override // p5.c
        public void a(View view) {
            int iL;
            if (DownloadTaskViewDelegate.this.f10127f == null || (iL = this.f10135c.l()) == -1) {
                return;
            }
            DownloadTaskViewDelegate.this.f10127f.a(view, iL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f10137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g5.c f10138d;

        public b(d dVar, g5.c cVar) {
            this.f10137c = dVar;
            this.f10138d = cVar;
        }

        @Override // p5.c
        public void a(View view) {
            int iL = this.f10137c.l();
            if (iL == -1 || DownloadTaskViewDelegate.this.f10129h == null) {
                return;
            }
            DownloadTaskViewDelegate.this.f10129h.a(view, iL, this.f10138d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements r6.s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s6.b f10140c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j f10141e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f10142m;

        public c(j jVar, int i10) {
            this.f10141e = jVar;
            this.f10142m = i10;
        }

        @Override // r6.s
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(x.d dVar) {
            DownloadTaskViewDelegate.this.f10124c.a(this.f10140c);
            DownloadTaskViewDelegate.this.f10123b.remove(dVar.f14455a);
            if (DownloadTaskViewDelegate.this.f10134m) {
                return;
            }
            DownloadTaskViewDelegate.this.f10122a.put((j) dVar.f14455a, (o1) dVar.f14456b);
            if (DownloadTaskViewDelegate.this.f10128g != null) {
                DownloadTaskViewDelegate.this.f10128g.a(((j) dVar.f14455a).f10149a, 2);
            }
        }

        @Override // r6.s
        public void onError(Throwable th) {
            DownloadTaskViewDelegate.this.f10124c.a(this.f10140c);
            DownloadTaskViewDelegate.this.f10123b.remove(this.f10141e);
            if (DownloadTaskViewDelegate.this.f10134m) {
                return;
            }
            DownloadTaskViewDelegate.this.f10122a.put(this.f10141e, new o1(this.f10142m));
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            this.f10140c = bVar;
            DownloadTaskViewDelegate.this.f10124c.b(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends w5.g {
        public CheckBox A;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public ImageView f10144v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public TextView f10145w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public ProgressBar f10146x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public TextView f10147y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public ImageView f10148z;

        public d(View view) {
            super(view);
            this.f10144v = (ImageView) view.findViewById(w7.p.N);
            this.f10145w = (TextView) view.findViewById(w7.p.f13896o1);
            this.f10146x = (ProgressBar) view.findViewById(w7.p.f13889m0);
            this.f10147y = (TextView) view.findViewById(w7.p.B1);
            this.f10148z = (ImageView) view.findViewById(w7.p.Y);
            this.A = (CheckBox) view.findViewById(w7.p.f13876i);
            v8.g.d(this.f10145w);
            v8.g.d(this.f10147y);
            this.f10146x.setProgressDrawable(Z(view.getContext()));
        }

        public static Drawable Z(Context context) {
            int iB = com.tuyafeng.support.utils.f.b(context, w7.m.f13739c);
            int iK = v8.h.k(context);
            int iJ = v8.h.j(context);
            int iH = com.tuyafeng.support.utils.x.h(context, 2.0f);
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        boolean a(int i10, g5.c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface f {
        void a(View view, int i10, g5.c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface g {
        boolean a(View view, int i10, g5.c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface h {
        void a(View view, int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface i {
        void a(long j10, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10151c;

        public j(long j10, String str, long j11) {
            this.f10149a = j10;
            this.f10150b = str;
            this.f10151c = j11;
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
            return this.f10149a == jVar.f10149a && this.f10151c == jVar.f10151c && x8.t1.a(this.f10150b, jVar.f10150b);
        }

        public int hashCode() {
            return x8.t1.b(Long.valueOf(this.f10149a), this.f10150b, Long.valueOf(this.f10151c));
        }
    }

    public DownloadTaskViewDelegate() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        this.f10125d = executorServiceNewFixedThreadPool;
        this.f10126e = a7.a.b(executorServiceNewFixedThreadPool);
    }

    public static /* synthetic */ x.d i(DownloadTaskViewDelegate downloadTaskViewDelegate, int i10, Context context, g5.c cVar, j jVar) {
        Drawable drawableX;
        downloadTaskViewDelegate.getClass();
        int i11 = f10121t;
        if (i10 == i11 || i10 == f10118q) {
            drawableX = downloadTaskViewDelegate.x(context, cVar.f(), i10 == i11);
        } else {
            drawableX = i10 == f10120s ? downloadTaskViewDelegate.u(context, cVar.f()) : null;
        }
        return new x.d(jVar, new o1(i10, drawableX));
    }

    public static /* synthetic */ boolean j(DownloadTaskViewDelegate downloadTaskViewDelegate, d dVar, g5.c cVar, View view) {
        g gVar;
        downloadTaskViewDelegate.getClass();
        int iL = dVar.l();
        return (iL == -1 || (gVar = downloadTaskViewDelegate.f10130i) == null || !gVar.a(view, iL, cVar)) ? false : true;
    }

    public final String A(Context context, g5.c cVar) {
        String string;
        int iQ = cVar.q();
        if (!g5.b.d(iQ) && !g5.b.c(iQ)) {
            if (g5.b.e(iQ)) {
                return x8.z.v(context, Math.max(cVar.c(), cVar.r()));
            }
            if (g5.b.b(iQ)) {
                return t(context, cVar.d());
            }
            return null;
        }
        String string2 = cVar.r() <= 0 ? context.getString(w7.u.f14195q4, s(context, cVar.c())) : context.getString(w7.u.f14181p4, s(context, cVar.c()), s(context, cVar.r()));
        if (g5.b.c(iQ)) {
            return context.getString(w7.u.f14237t4, string2, context.getString(w7.u.f14264v4));
        }
        if (g5.b.f(iQ)) {
            return context.getString(w7.u.f14237t4, string2, context.getString(w7.u.f14277w4));
        }
        if (cVar.p() < 0) {
            string = context.getString(w7.u.f14251u4);
        } else {
            string = s(context, cVar.p()) + "/s";
        }
        if (cVar.r() > 0) {
            return context.getString(w7.u.f14223s4, string2, string, r(context, cVar));
        }
        return context.getString(w7.u.f14209r4, string2, string);
    }

    public final String B(Context context, g5.c cVar) {
        return com.tuyafeng.support.utils.p.f(cVar.l()) ? cVar.t() : cVar.l();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(final d dVar, final g5.c cVar) {
        Context context = dVar.f1138a.getContext();
        dVar.f10144v.setImageDrawable(y(context, cVar));
        dVar.f10145w.setText(B(context, cVar));
        dVar.f10147y.setText(A(context, cVar));
        int iQ = cVar.q();
        boolean zD = g5.b.d(iQ);
        if (g5.b.e(iQ)) {
            dVar.f10148z.setVisibility(8);
        } else {
            dVar.f10148z.setImageResource(zD ? w7.o.F : w7.o.G);
            dVar.f10148z.setEnabled(!this.f10132k);
            dVar.f10148z.setContentDescription(context.getString(zD ? w7.u.f13971a4 : w7.u.f13985b4));
            dVar.f10148z.setOnClickListener(new a(500L, dVar));
            dVar.f10148z.setVisibility(this.f10132k ? 8 : 0);
        }
        int iZ = z(context, cVar);
        if (iZ >= 0) {
            dVar.f10146x.setVisibility(0);
            dVar.f10146x.setProgress(iZ);
        } else {
            dVar.f10146x.setVisibility(8);
        }
        if (this.f10132k) {
            int iL = dVar.l();
            e eVar = this.f10131j;
            boolean z10 = eVar != null && eVar.a(iL, cVar);
            dVar.A.setChecked(z10);
            dVar.A.setVisibility(0);
            dVar.f1138a.setSelected(z10);
            y.r.g0(dVar.f1138a, context.getString(z10 ? w7.u.f13980b : w7.u.f13966a));
        } else {
            dVar.A.setVisibility(8);
            dVar.f1138a.setSelected(false);
            y.r.g0(dVar.f1138a, null);
        }
        dVar.f1138a.setOnClickListener(new b(dVar, cVar));
        dVar.f1138a.setOnLongClickListener(new View.OnLongClickListener() { // from class: mark.via.download.q1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return DownloadTaskViewDelegate.j(this.f10283a, dVar, cVar, view);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
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
        Context context = dVar.f1138a.getContext();
        if ((iIntValue | 1) == 1 && g5.b.d(cVar.q())) {
            dVar.f10147y.setText(A(context, cVar));
            dVar.f10146x.setProgress(z(context, cVar));
        }
        if ((iIntValue | 2) == 2) {
            dVar.f10144v.setImageDrawable(y(context, cVar));
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public d d(Context context, ViewGroup viewGroup) {
        return new d(LayoutInflater.from(context).inflate(w7.r.f13955x, viewGroup, false));
    }

    public void F() {
        this.f10134m = true;
        this.f10133l = false;
        this.f10124c.dispose();
        this.f10123b.clear();
        this.f10122a.clear();
        this.f10125d.shutdownNow();
        this.f10128g = null;
    }

    public final void G(Context context, final g5.c cVar, final j jVar, final int i10) {
        if (this.f10123b.add(jVar)) {
            final Context applicationContext = context.getApplicationContext();
            r6.q.f(new Callable() { // from class: mark.via.download.p1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DownloadTaskViewDelegate.i(this.f10275c, i10, applicationContext, cVar, jVar);
                }
            }).k(this.f10126e).i(q6.b.b()).c(new c(jVar, i10));
        }
    }

    public void H(e eVar) {
        this.f10131j = eVar;
    }

    public void I(boolean z10) {
        this.f10132k = z10;
    }

    public void J(f fVar) {
        this.f10129h = fVar;
    }

    public void K(g gVar) {
        this.f10130i = gVar;
    }

    public void L(i iVar) {
        this.f10128g = iVar;
    }

    public void M(h hVar) {
        this.f10127f = hVar;
    }

    public void N(boolean z10) {
        this.f10133l = z10 && !this.f10134m;
    }

    public final String r(Context context, g5.c cVar) {
        if (cVar.r() <= 0 || cVar.p() <= 0) {
            return context.getString(w7.u.f14013d4);
        }
        int iR = (int) ((cVar.r() - cVar.c()) / cVar.p());
        if (iR <= 60) {
            return context.getResources().getQuantityString(w7.t.f13964f, iR, Integer.valueOf(iR));
        }
        int i10 = iR / 60;
        if (i10 <= 120) {
            return context.getResources().getQuantityString(w7.t.f13962d, i10, Integer.valueOf(i10));
        }
        int i11 = i10 / 60;
        return i11 <= 12 ? context.getResources().getQuantityString(w7.t.f13960b, i11, Integer.valueOf(i11)) : context.getString(w7.u.f14013d4);
    }

    public final String s(Context context, long j10) {
        return x8.z.v(context, j10);
    }

    public String t(Context context, String str) {
        return (str == null || str.isEmpty()) ? context.getString(w7.u.f14027e4) : context.getString(w7.u.f14041f4, str);
    }

    public final Drawable u(Context context, Uri uri) throws Throwable {
        Drawable drawableB = t3.b(context, uri);
        if (drawableB != null) {
            int iH = com.tuyafeng.support.utils.x.h(context, 24.0f);
            drawableB.setBounds(0, 0, iH, iH);
        }
        return drawableB;
    }

    public final int v(String str) {
        if (str == null || str.isEmpty()) {
            return f10115n;
        }
        if (str.startsWith("audio/")) {
            return f10117p;
        }
        if (str.startsWith("video/")) {
            return f10118q;
        }
        if (str.startsWith("image/")) {
            return f10121t;
        }
        if ("application/vnd.android.package-archive".equals(str)) {
            return f10120s;
        }
        if (str.startsWith("text/") || str.contains("document") || "application/pdf".equals(str)) {
            return f10116o;
        }
        return (str.contains("zip") || str.contains("compress")) ? f10119r : f10115n;
    }

    public final Drawable w(Context context, int i10) {
        Drawable drawableE = com.tuyafeng.support.utils.f.e(context, i10);
        int iA = com.tuyafeng.support.utils.e.a(context, w7.k.f13729i);
        if (drawableE != null) {
            drawableE.setColorFilter(iA, PorterDuff.Mode.SRC_IN);
        }
        return drawableE;
    }

    public final Drawable x(Context context, Uri uri, boolean z10) {
        int iH = com.tuyafeng.support.utils.x.h(context, 24.0f);
        Bitmap bitmapD = t3.d(context, uri, iH, iH, z10);
        if (bitmapD != null) {
            return new i8.l(bitmapD, com.tuyafeng.support.utils.x.h(context, 2.0f));
        }
        return null;
    }

    public final Drawable y(Context context, g5.c cVar) {
        int iV = v(cVar.k());
        if (!g5.b.e(cVar.q()) || (iV != f10120s && iV != f10121t && iV != f10118q)) {
            return w(context, iV);
        }
        j jVarC = j.c(cVar);
        o1 o1Var = (o1) this.f10122a.get(jVarC);
        if (o1Var != null) {
            return o1Var.c() ? o1Var.b() : w(context, o1Var.a());
        }
        if (this.f10133l && !this.f10134m) {
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
