package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
import y.d0;
import y.g0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends x.a {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f1599d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1600e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends x.a {

        /* renamed from: d, reason: collision with root package name */
        public final s f1601d;

        /* renamed from: e, reason: collision with root package name */
        public Map f1602e = new WeakHashMap();

        public a(s sVar) {
            this.f1601d = sVar;
        }

        @Override // x.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            x.a aVar = (x.a) this.f1602e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // x.a
        public g0 b(View view) {
            x.a aVar = (x.a) this.f1602e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // x.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // x.a
        public void g(View view, d0 d0Var) {
            if (this.f1601d.o() || this.f1601d.f1599d.getLayoutManager() == null) {
                super.g(view, d0Var);
                return;
            }
            this.f1601d.f1599d.getLayoutManager().P0(view, d0Var);
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                aVar.g(view, d0Var);
            } else {
                super.g(view, d0Var);
            }
        }

        @Override // x.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // x.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            x.a aVar = (x.a) this.f1602e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // x.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (this.f1601d.o() || this.f1601d.f1599d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f1601d.f1599d.getLayoutManager().j1(view, i10, bundle);
        }

        @Override // x.a
        public void l(View view, int i10) {
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        @Override // x.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            x.a aVar = (x.a) this.f1602e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        public x.a n(View view) {
            return (x.a) this.f1602e.remove(view);
        }

        public void o(View view) {
            x.a aVarK = x.r.k(view);
            if (aVarK == null || aVarK == this) {
                return;
            }
            this.f1602e.put(view, aVarK);
        }
    }

    public s(RecyclerView recyclerView) {
        this.f1599d = recyclerView;
        x.a aVarN = n();
        if (aVarN == null || !(aVarN instanceof a)) {
            this.f1600e = new a(this);
        } else {
            this.f1600e = (a) aVarN;
        }
    }

    @Override // x.a
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

    @Override // x.a
    public void g(View view, d0 d0Var) {
        super.g(view, d0Var);
        if (o() || this.f1599d.getLayoutManager() == null) {
            return;
        }
        this.f1599d.getLayoutManager().O0(d0Var);
    }

    @Override // x.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f1599d.getLayoutManager() == null) {
            return false;
        }
        return this.f1599d.getLayoutManager().h1(i10, bundle);
    }

    public x.a n() {
        return this.f1600e;
    }

    public boolean o() {
        return this.f1599d.s0();
    }
}
