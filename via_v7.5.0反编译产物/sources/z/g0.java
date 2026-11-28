package z;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15113a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f15114a;

        public a(g0 g0Var) {
            this.f15114a = g0Var;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            d0 d0VarB = this.f15114a.b(i10);
            if (d0VarB == null) {
                return null;
            }
            return d0VarB.m0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i10) {
            List listC = this.f15114a.c(str, i10);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(((d0) listC.get(i11)).m0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f15114a.f(i10, i11, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends a {
        public b(g0 g0Var) {
            super(g0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            d0 d0VarD = this.f15114a.d(i10);
            if (d0VarD == null) {
                return null;
            }
            return d0VarD.m0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends b {
        public c(g0 g0Var) {
            super(g0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f15114a.a(i10, d0.n0(accessibilityNodeInfo), str, bundle);
        }
    }

    public g0() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f15113a = new c(this);
        } else {
            this.f15113a = new b(this);
        }
    }

    public d0 b(int i10) {
        return null;
    }

    public List c(String str, int i10) {
        return null;
    }

    public d0 d(int i10) {
        return null;
    }

    public Object e() {
        return this.f15113a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public g0(Object obj) {
        this.f15113a = obj;
    }

    public void a(int i10, d0 d0Var, String str, Bundle bundle) {
    }
}
