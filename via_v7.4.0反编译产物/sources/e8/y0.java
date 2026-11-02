package e8;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import e8.z0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final ca.d f4889a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f4890b;

    /* renamed from: c, reason: collision with root package name */
    public final z0 f4891c;

    public y0(ca.d dVar, w9.l lVar, z0 z0Var) {
        this.f4889a = dVar;
        this.f4890b = lVar;
        this.f4891c = z0Var;
    }

    public static /* synthetic */ void G(Set set, PermissionRequest permissionRequest, String[] strArr, boolean z10) {
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

    public static /* synthetic */ void H(y0 y0Var, GeolocationPermissions.Callback callback, String str, String str2, View view, k.p pVar) {
        y0Var.getClass();
        callback.invoke(str, false, pVar.f13338b);
        if (pVar.f13338b) {
            y0Var.S(str2, 2);
        }
    }

    public static /* synthetic */ void I(y0 y0Var, GeolocationPermissions.Callback callback, String str, String str2, View view, k.p pVar) {
        y0Var.getClass();
        callback.invoke(str, true, pVar.f13338b);
        if (pVar.f13338b) {
            y0Var.S(str2, 1);
        }
        y0Var.Q(str2);
    }

    public static /* synthetic */ void J(y0 y0Var, String str, String[] strArr, boolean z10) {
        y0Var.getClass();
        if (strArr.length > 0) {
            g6.n.s(y0Var.f4891c.b(), y0Var.f4891c.b().getString(x7.u.Mc, str));
        }
    }

    public static /* synthetic */ void L(y0 y0Var, String str, Set set, Set set2, PermissionRequest permissionRequest, String[] strArr, boolean z10) {
        if (z10) {
            ba.a aVarI = y0Var.f4889a.i(str);
            aVarI.S(true);
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            if (set.contains("android.webkit.resource.AUDIO_CAPTURE")) {
                aVarI.b0(hashSet.contains("android.webkit.resource.AUDIO_CAPTURE") ? 1 : 2);
            }
            if (set.contains("android.webkit.resource.VIDEO_CAPTURE")) {
                aVarI.N(hashSet.contains("android.webkit.resource.VIDEO_CAPTURE") ? 1 : 2);
            }
            if (!aVarI.r()) {
                y0Var.f4889a.g(str, aVarI);
            }
        } else {
            y0Var.getClass();
        }
        set2.addAll(Arrays.asList(strArr));
        y0Var.R(permissionRequest, set2);
    }

    public final int M(String str) {
        boolean zI = this.f4890b.m2().i();
        ba.b bVarE = this.f4889a.e(str);
        return (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.a() == 0) ? zI ? 3 : 2 : bVarE.a();
    }

    public final int N(String str) {
        boolean zU = this.f4890b.m2().u();
        ba.b bVarE = this.f4889a.e(str);
        return (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.f() == 0) ? zU ? 3 : 2 : bVarE.f();
    }

    public final int O(String str) {
        boolean zV = this.f4890b.m2().v();
        ba.b bVarE = this.f4889a.e(str);
        return (str == null || str.isEmpty() || bVarE == null || !bVarE.s() || bVarE.g() == 0) ? zV ? 3 : 2 : bVarE.g();
    }

    public final Set P(String[] strArr) {
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

    public final void Q(final String str) {
        this.f4891c.c(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new z0.a() { // from class: e8.x0
            @Override // e8.z0.a
            public final void a(String[] strArr, boolean z10) {
                y0.J(this.f4883a, str, strArr, z10);
            }
        });
    }

    public final void R(final PermissionRequest permissionRequest, final Set set) {
        if (Build.VERSION.SDK_INT < 21 || permissionRequest == null) {
            return;
        }
        if (set == null || set.isEmpty()) {
            permissionRequest.deny();
            return;
        }
        String[] strArr = (String[]) P((String[]) set.toArray(new String[0])).toArray(new String[0]);
        if (strArr.length == 0) {
            permissionRequest.grant((String[]) set.toArray(new String[0]));
        } else {
            this.f4891c.c(strArr, new z0.a() { // from class: e8.w0
                @Override // e8.z0.a
                public final void a(String[] strArr2, boolean z10) {
                    y0.G(set, permissionRequest, strArr2, z10);
                }
            });
        }
    }

    public final void S(String str, int i10) {
        String strA = kb.c.a(str);
        if (strA == null || strA.isEmpty()) {
            return;
        }
        ba.a aVarI = this.f4889a.i(strA);
        if (aVarI.s() && aVarI.f() == i10) {
            return;
        }
        aVarI.S(true);
        aVarI.a0(i10);
        this.f4889a.g(strA, aVarI);
    }

    @Override // p4.a
    public boolean h(final String str, final GeolocationPermissions.Callback callback) {
        int iN;
        final String strE = i6.i0.f7006a.e(str);
        if (strE == null || strE.isEmpty() || (iN = N(strE)) == 2) {
            callback.invoke(str, false, false);
            return true;
        }
        if (iN != 1) {
            w5.k.l(this.f4891c.b()).d0(x7.u.F7).J(this.f4891c.b().getString(x7.u.Nc, strE)).w(x7.u.Ta, false).T(new DialogInterface.OnCancelListener() { // from class: e8.s0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    callback.invoke(str, false, false);
                }
            }).V(x7.u.f13970f, new k.m() { // from class: e8.t0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    y0.I(this.f4864a, callback, str, strE, view, pVar);
                }
            }).P(x7.u.f14241z, new k.m() { // from class: e8.u0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    y0.H(this.f4869a, callback, str, strE, view, pVar);
                }
            }).f0();
            return true;
        }
        callback.invoke(str, true, true);
        Q(strE);
        return true;
    }

    @Override // p4.a
    public void o(t4.b bVar, String str, Bitmap bitmap) {
        if (str != null && str.startsWith("http") && this.f4890b.m2().F()) {
            s4.b.g(bVar, "javascript:(function(){var a=window;try{delete a.RTCPeerConnection,delete a.webkitRTCPeerConnection,delete a.mozRTCPeerConnection}catch(b){}})();");
        }
    }

    @Override // p4.a
    public boolean p(final PermissionRequest permissionRequest) {
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
                int iO = O(str);
                if (iO == 1) {
                    hashSet.add(str2);
                } else if (iO == 3) {
                    hashSet2.add(str2);
                }
            } else if ("android.webkit.resource.VIDEO_CAPTURE".equals(str2)) {
                int iM = M(str);
                if (iM == 1) {
                    hashSet.add(str2);
                } else if (iM == 3) {
                    hashSet2.add(str2);
                }
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty()) {
            permissionRequest.deny();
            return true;
        }
        if (hashSet2.isEmpty()) {
            R(permissionRequest, hashSet);
            return true;
        }
        this.f4891c.a(str, (String[]) hashSet2.toArray(new String[0]), new z0.a() { // from class: e8.v0
            @Override // e8.z0.a
            public final void a(String[] strArr, boolean z10) {
                y0.L(this.f4874a, str, hashSet2, hashSet, permissionRequest, strArr, z10);
            }
        });
        return true;
    }
}
