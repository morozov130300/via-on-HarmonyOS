package c8;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import c6.a2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v1 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z9.d f2290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u9.l f2291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f2292d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String[] strArr, boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(String[] strArr, a aVar);
    }

    public v1(Context context, z9.d dVar, u9.l lVar, b bVar) {
        this.f2289a = context;
        this.f2290b = dVar;
        this.f2291c = lVar;
        this.f2292d = bVar;
    }

    public static /* synthetic */ void J(v1 v1Var, String str, Set set, Set set2, PermissionRequest permissionRequest, String[] strArr, boolean z10) {
        if (z10) {
            y9.a aVarH = v1Var.f2290b.h(str);
            aVarH.S(true);
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            if (set.contains("android.webkit.resource.AUDIO_CAPTURE")) {
                aVarH.b0(hashSet.contains("android.webkit.resource.AUDIO_CAPTURE") ? 1 : 2);
            }
            if (set.contains("android.webkit.resource.VIDEO_CAPTURE")) {
                aVarH.N(hashSet.contains("android.webkit.resource.VIDEO_CAPTURE") ? 1 : 2);
            }
            if (!aVarH.r()) {
                v1Var.f2290b.k(str, aVarH);
            }
        } else {
            v1Var.getClass();
        }
        set2.addAll(Arrays.asList(strArr));
        v1Var.Z(permissionRequest, set2);
    }

    public static /* synthetic */ void K(v1 v1Var, GeolocationPermissions.Callback callback, String str, String str2, View view, q5.k.p pVar) {
        v1Var.getClass();
        callback.invoke(str, false, pVar.f11818b);
        if (pVar.f11818b) {
            v1Var.b0(str2, 2);
        }
    }

    public static /* synthetic */ void L(v1 v1Var, GeolocationPermissions.Callback callback, String str, String str2, View view, q5.k.p pVar) {
        v1Var.getClass();
        callback.invoke(str, true, pVar.f11818b);
        if (pVar.f11818b) {
            v1Var.b0(str2, 1);
        }
        v1Var.Y(str2);
    }

    public static /* synthetic */ void N(v1 v1Var, String str, StringBuilder sb2, final a aVar, final String[] strArr) {
        q5.k kVarL = q5.k.l(v1Var.f2289a);
        Context context = v1Var.f2289a;
        kVarL.g0(context.getString(w7.u.f14199q8, com.tuyafeng.support.utils.p.n(str, context.getString(w7.u.uh)))).K(sb2.toString()).x(w7.u.f14048fb, false).X(w7.u.f14036f, new q5.k.m() { // from class: c8.m1
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                aVar.a(strArr, pVar.f11818b);
            }
        }).R(w7.u.A, new q5.k.m() { // from class: c8.n1
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                aVar.a(new String[0], pVar.f11818b);
            }
        }).V(new DialogInterface.OnCancelListener() { // from class: c8.o1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                aVar.a(new String[0], false);
            }
        }).h0();
    }

    public static /* synthetic */ void P(v1 v1Var, String str, String[] strArr, boolean z10) {
        v1Var.getClass();
        if (strArr.length > 0) {
            Context context = v1Var.f2289a;
            com.tuyafeng.support.utils.n.s(context, context.getString(w7.u.bd, str));
        }
    }

    public static /* synthetic */ void S(Set set, PermissionRequest permissionRequest, String[] strArr, boolean z10) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        if (!hashSet.contains("android.permission.RECORD_AUDIO") && !hashSet.contains("android.permission.MODIFY_AUDIO_SETTINGS")) {
            set.remove("android.webkit.resource.AUDIO_CAPTURE");
        }
        if (!hashSet.contains("android.permission.CAMERA")) {
            set.remove("android.webkit.resource.VIDEO_CAPTURE");
        }
        if (set.isEmpty()) {
            permissionRequest.deny();
        } else {
            permissionRequest.grant((String[]) set.toArray(new String[0]));
        }
    }

    public final int T(String str) {
        boolean zI = this.f2291c.n2().i();
        y9.b bVarE = this.f2290b.e(str);
        if (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.a() == 0) {
            return zI ? 3 : 2;
        }
        return bVarE.a();
    }

    public final int U(String str) {
        boolean zU = this.f2291c.n2().u();
        y9.b bVarE = this.f2290b.e(str);
        if (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.f() == 0) {
            return zU ? 3 : 2;
        }
        return bVarE.f();
    }

    public final int V(String str) {
        boolean zV = this.f2291c.n2().v();
        y9.b bVarE = this.f2290b.e(str);
        if (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.g() == 0) {
            return zV ? 3 : 2;
        }
        return bVarE.g();
    }

    public final String W(String str) {
        if ("android.webkit.resource.AUDIO_CAPTURE".equals(str)) {
            Context context = this.f2289a;
            return context.getString(w7.u.Ea, context.getString(w7.u.Ca), this.f2289a.getString(w7.u.Da));
        }
        if (!"android.webkit.resource.VIDEO_CAPTURE".equals(str)) {
            return str;
        }
        Context context2 = this.f2289a;
        return context2.getString(w7.u.Ea, context2.getString(w7.u.Aa), this.f2289a.getString(w7.u.Ba));
    }

    public final Set X(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if ("android.webkit.resource.AUDIO_CAPTURE".equals(str)) {
                hashSet.add("android.permission.RECORD_AUDIO");
                hashSet.add("android.permission.MODIFY_AUDIO_SETTINGS");
            } else if ("android.webkit.resource.VIDEO_CAPTURE".equals(str)) {
                hashSet.add("android.permission.CAMERA");
            }
        }
        return hashSet;
    }

    public final void Y(final String str) {
        this.f2292d.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a() { // from class: c8.l1
            @Override // c8.v1.a
            public final void a(String[] strArr, boolean z10) {
                v1.P(this.f2230a, str, strArr, z10);
            }
        });
    }

    public final void Z(final PermissionRequest permissionRequest, final Set set) {
        if (Build.VERSION.SDK_INT < 21 || permissionRequest == null) {
            return;
        }
        if (set == null || set.isEmpty()) {
            permissionRequest.deny();
            return;
        }
        String[] strArr = (String[]) X((String[]) set.toArray(new String[0])).toArray(new String[0]);
        if (strArr.length == 0) {
            permissionRequest.grant((String[]) set.toArray(new String[0]));
        } else {
            this.f2292d.a(strArr, new a() { // from class: c8.t1
                @Override // c8.v1.a
                public final void a(String[] strArr2, boolean z10) {
                    v1.S(set, permissionRequest, strArr2, z10);
                }
            });
        }
    }

    public final void a0(final String str, final String[] strArr, final a aVar) {
        final StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArr) {
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append(this.f2289a.getString(w7.u.O7, W(str2)));
        }
        com.tuyafeng.support.utils.f.a(this.f2289a).runOnUiThread(new Runnable() { // from class: c8.u1
            @Override // java.lang.Runnable
            public final void run() {
                v1.N(this.f2281c, str, sb2, aVar, strArr);
            }
        });
    }

    public final void b0(String str, int i10) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty()) {
            return;
        }
        y9.a aVarH = this.f2290b.h(strA);
        if (aVarH.s() && aVarH.f() == i10) {
            return;
        }
        aVarH.S(true);
        aVarH.a0(i10);
        this.f2290b.k(strA, aVarH);
    }

    @Override // q4.a
    public boolean h(final String str, final GeolocationPermissions.Callback callback) {
        int iU;
        final String strF = a2.f1958a.f(str);
        if (strF == null || strF.isEmpty() || (iU = U(strF)) == 2) {
            callback.invoke(str, false, false);
            return true;
        }
        if (iU != 1) {
            q5.k.l(this.f2289a).f0(w7.u.R7).K(this.f2289a.getString(w7.u.cd, strF)).x(w7.u.f14048fb, false).V(new DialogInterface.OnCancelListener() { // from class: c8.p1
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    callback.invoke(str, false, false);
                }
            }).X(w7.u.f14036f, new q5.k.m() { // from class: c8.q1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    v1.L(this.f2245a, callback, str, strF, view, pVar);
                }
            }).R(w7.u.A, new q5.k.m() { // from class: c8.r1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    v1.K(this.f2257a, callback, str, strF, view, pVar);
                }
            }).h0();
            return true;
        }
        callback.invoke(str, true, true);
        Y(strF);
        return true;
    }

    @Override // q4.a
    public boolean q(final PermissionRequest permissionRequest) {
        String host;
        if (Build.VERSION.SDK_INT < 21 || permissionRequest == null) {
            return false;
        }
        String[] resources = permissionRequest.getResources();
        if (resources == null || resources.length == 0) {
            permissionRequest.deny();
            return true;
        }
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        Uri origin = permissionRequest.getOrigin();
        if (origin == null || origin.getHost() == null || origin.getHost().isEmpty()) {
            host = "";
        } else if (origin.getPort() == -1) {
            host = origin.getHost();
        } else {
            host = origin.getHost() + ":" + origin.getPort();
        }
        final String str = host;
        for (String str2 : resources) {
            if ("android.webkit.resource.PROTECTED_MEDIA_ID".equals(str2)) {
                hashSet.add(str2);
            } else if ("android.webkit.resource.AUDIO_CAPTURE".equals(str2)) {
                int iV = V(str);
                if (iV == 1) {
                    hashSet.add(str2);
                } else if (iV == 3) {
                    hashSet2.add(str2);
                }
            } else if ("android.webkit.resource.VIDEO_CAPTURE".equals(str2)) {
                int iT = T(str);
                if (iT == 1) {
                    hashSet.add(str2);
                } else if (iT == 3) {
                    hashSet2.add(str2);
                }
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty()) {
            permissionRequest.deny();
            return true;
        }
        if (hashSet2.isEmpty()) {
            Z(permissionRequest, hashSet);
            return true;
        }
        a0(str, (String[]) hashSet2.toArray(new String[0]), new a() { // from class: c8.s1
            @Override // c8.v1.a
            public final void a(String[] strArr, boolean z10) {
                v1.J(this.f2265a, str, hashSet2, hashSet, permissionRequest, strArr, z10);
            }
        });
        return true;
    }
}
