package n;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f10410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f10411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c1[] f10412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c1[] f10413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10414e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10415f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f10416g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f10417h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f10418i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f10419j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f10420k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f10421l;

        /* JADX INFO: renamed from: n.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class C0100a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f10422a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f10423b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f10424c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f10425d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f10426e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList f10427f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f10428g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f10429h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f10430i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f10431j;

            public C0100a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.g(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f10427f;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    if (it.hasNext()) {
                        g.a(it.next());
                        throw null;
                    }
                }
                return new a(this.f10422a, this.f10423b, this.f10424c, this.f10426e, arrayList2.isEmpty() ? null : (c1[]) arrayList2.toArray(new c1[arrayList2.size()]), arrayList.isEmpty() ? null : (c1[]) arrayList.toArray(new c1[arrayList.size()]), this.f10425d, this.f10428g, this.f10429h, this.f10430i, this.f10431j);
            }

            public final void b() {
                if (this.f10430i && this.f10424c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0100a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, c1[] c1VarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f10425d = true;
                this.f10429h = true;
                this.f10422a = iconCompat;
                this.f10423b = d.d(charSequence);
                this.f10424c = pendingIntent;
                this.f10426e = bundle;
                this.f10427f = c1VarArr == null ? null : new ArrayList(Arrays.asList(c1VarArr));
                this.f10425d = z10;
                this.f10428g = i10;
                this.f10429h = z11;
                this.f10430i = z12;
                this.f10431j = z13;
            }
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, c1[] c1VarArr, c1[] c1VarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f10415f = true;
            this.f10411b = iconCompat;
            if (iconCompat != null && iconCompat.k() == 2) {
                this.f10418i = iconCompat.h();
            }
            this.f10419j = d.d(charSequence);
            this.f10420k = pendingIntent;
            this.f10410a = bundle == null ? new Bundle() : bundle;
            this.f10412c = c1VarArr;
            this.f10413d = c1VarArr2;
            this.f10414e = z10;
            this.f10416g = i10;
            this.f10415f = z11;
            this.f10417h = z12;
            this.f10421l = z13;
        }

        public PendingIntent a() {
            return this.f10420k;
        }

        public boolean b() {
            return this.f10414e;
        }

        public c1[] c() {
            return this.f10413d;
        }

        public Bundle d() {
            return this.f10410a;
        }

        public IconCompat e() {
            int i10;
            if (this.f10411b == null && (i10 = this.f10418i) != 0) {
                this.f10411b = IconCompat.g(null, "", i10);
            }
            return this.f10411b;
        }

        public c1[] f() {
            return this.f10412c;
        }

        public int g() {
            return this.f10416g;
        }

        public boolean h() {
            return this.f10415f;
        }

        public CharSequence i() {
            return this.f10419j;
        }

        public boolean j() {
            return this.f10421l;
        }

        public boolean k() {
            return this.f10417h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f10432e;

        @Override // n.h.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f10432e);
            }
        }

        @Override // n.h.e
        public void b(f fVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(fVar.a()).setBigContentTitle(this.f10460b).bigText(this.f10432e);
            if (this.f10462d) {
                bigTextStyleBigText.setSummaryText(this.f10461c);
            }
        }

        @Override // n.h.e
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f10432e = d.d(charSequence);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {
        public boolean A;
        public boolean B;
        public String C;
        public Bundle D;
        public Notification G;
        public RemoteViews H;
        public RemoteViews I;
        public RemoteViews J;
        public String K;
        public String M;
        public o.l N;
        public long O;
        public boolean R;
        public Notification S;
        public boolean T;
        public Icon U;
        public ArrayList V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10433a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f10437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f10438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f10439g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f10440h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f10441i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Bitmap f10442j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f10443k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10444l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f10445m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f10447o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public e f10448p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public CharSequence f10449q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f10450r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence[] f10451s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f10452t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f10453u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f10454v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f10455w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f10456x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f10457y;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f10434b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f10435c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f10436d = new ArrayList();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f10446n = true;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f10458z = false;
        public int E = 0;
        public int F = 0;
        public int L = 0;
        public int P = 0;
        public int Q = 0;

        public d(Context context, String str) {
            Notification notification = new Notification();
            this.S = notification;
            this.f10433a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f10445m = 0;
            this.V = new ArrayList();
            this.R = true;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public d a(a aVar) {
            if (aVar != null) {
                this.f10434b.add(aVar);
            }
            return this;
        }

        public Notification b() {
            return new s0(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z10) {
            j(16, z10);
            return this;
        }

        public d f(String str) {
            this.C = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f10439g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f10438f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f10437e = d(charSequence);
            return this;
        }

        public final void j(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.S;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (i10 ^ (-1)) & notification2.flags;
            }
        }

        public d k(boolean z10) {
            j(2, z10);
            return this;
        }

        public d l(int i10, int i11, boolean z10) {
            this.f10452t = i10;
            this.f10453u = i11;
            this.f10454v = z10;
            return this;
        }

        public d m(boolean z10) {
            this.T = z10;
            return this;
        }

        public d n(int i10) {
            this.S.icon = i10;
            return this;
        }

        public d o(e eVar) {
            if (this.f10448p != eVar) {
                this.f10448p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d p(long j10) {
            this.S.when = j10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f10459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f10460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f10461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10462d = false;

        public void a(Bundle bundle) {
            if (this.f10462d) {
                bundle.putCharSequence("android.summaryText", this.f10461c);
            }
            CharSequence charSequence = this.f10460b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(f fVar);

        public abstract String c();

        public RemoteViews d(f fVar) {
            return null;
        }

        public RemoteViews e(f fVar) {
            return null;
        }

        public RemoteViews f(f fVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f10459a != dVar) {
                this.f10459a = dVar;
                if (dVar != null) {
                    dVar.o(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
