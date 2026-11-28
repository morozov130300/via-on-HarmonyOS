package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
import z.d0;
import z.g0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s extends y.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f1500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1501e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends y.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s f1502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f1503e = new WeakHashMap();

        public a(s sVar) {
            this.f1502d = sVar;
        }

        @Override // y.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = (y.a) this.f1503e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // y.a
        public g0 b(View view) {
            y.a aVar = (y.a) this.f1503e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // y.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // y.a
        public void g(View view, d0 d0Var) {
            if (this.f1502d.o() || this.f1502d.f1500d.getLayoutManager() == null) {
                super.g(view, d0Var);
                return;
            }
            this.f1502d.f1500d.getLayoutManager().P0(view, d0Var);
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                aVar.g(view, d0Var);
            } else {
                super.g(view, d0Var);
            }
        }

        @Override // y.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // y.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = (y.a) this.f1503e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // y.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (this.f1502d.o() || this.f1502d.f1500d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f1502d.f1500d.getLayoutManager().j1(view, i10, bundle);
        }

        @Override // y.a
        public void l(View view, int i10) {
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        @Override // y.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            y.a aVar = (y.a) this.f1503e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        public y.a n(View view) {
            return (y.a) this.f1503e.remove(view);
        }

        public void o(View view) {
            y.a aVarK = y.r.k(view);
            if (aVarK == null || aVarK == this) {
                return;
            }
            this.f1503e.put(view, aVarK);
        }
    }

    public s(RecyclerView recyclerView) {
        this.f1500d = recyclerView;
        y.a aVarN = n();
        if (aVarN == null || !(aVarN instanceof a)) {
            this.f1501e = new a(this);
        } else {
            this.f1501e = (a) aVarN;
        }
    }

    @Override // y.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().L0(accessibilityEvent);
        }
    }

    @Override // y.a
    public void g(View view, d0 d0Var) {
        super.g(view, d0Var);
        if (o() || this.f1500d.getLayoutManager() == null) {
            return;
        }
        this.f1500d.getLayoutManager().O0(d0Var);
    }

    @Override // y.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f1500d.getLayoutManager() == null) {
            return false;
        }
        return this.f1500d.getLayoutManager().h1(i10, bundle);
    }

    public y.a n() {
        return this.f1501e;
    }

    public boolean o() {
        return this.f1500d.s0();
    }
}
