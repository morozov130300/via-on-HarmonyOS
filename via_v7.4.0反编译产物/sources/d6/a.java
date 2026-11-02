package d6;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import c0.b;
import c0.d;
import c0.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends RecyclerView.k {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: d6.a$a, reason: collision with other inner class name */
    public class C0062a extends EdgeEffect {

        /* renamed from: a, reason: collision with root package name */
        public d f4578a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4579b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4580c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4581d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0062a(Context context, int i10, RecyclerView recyclerView) {
            super(context);
            this.f4580c = i10;
            this.f4581d = recyclerView;
            this.f4578a = null;
            this.f4579b = false;
        }

        public final d a() {
            return new d(this.f4581d, e() ? b.f2182p : b.f2183q).o(new e().e(1.0f).d(0.75f).f(200.0f));
        }

        public final float b() {
            return e() ? this.f4581d.getScaleX() : this.f4581d.getScaleY();
        }

        public final int c() {
            return e() ? this.f4581d.getPivotX() == 0.0f ? 0 : 2 : this.f4581d.getPivotY() == 0.0f ? 1 : 3;
        }

        public final void d(float f10) {
            float fB = b();
            if (!this.f4579b && fB == 1.0f) {
                this.f4579b = true;
                f();
            }
            float f11 = ((c() != this.f4580c ? -(fB - 1.0f) : 1.05f - fB) / 0.05f) * f10 * 0.15f;
            if (f11 != 0.0f) {
                g(fB + f11);
            }
            d dVar = this.f4578a;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // android.widget.EdgeEffect
        public boolean draw(Canvas canvas) {
            return false;
        }

        public final boolean e() {
            int i10 = this.f4580c;
            return i10 == 0 || i10 == 2;
        }

        public final void f() {
            if (e()) {
                this.f4581d.setPivotX(this.f4580c != 0 ? r0.getWidth() : 0.0f);
            } else {
                this.f4581d.setPivotY(this.f4580c != 1 ? r0.getHeight() : 0.0f);
            }
        }

        public final void g(float f10) {
            float fMin = Math.min(1.8f, Math.max(f10, 0.5f));
            if (e()) {
                this.f4581d.setScaleX(fMin);
            } else {
                this.f4581d.setScaleY(fMin);
            }
        }

        @Override // android.widget.EdgeEffect
        public boolean isFinished() {
            d dVar = this.f4578a;
            return dVar == null || !dVar.f();
        }

        @Override // android.widget.EdgeEffect
        public void onAbsorb(int i10) {
            super.onAbsorb(i10);
            f();
            float fMin = Math.min(0.05f, (i10 / 20000.0f) * 0.25f);
            d dVar = this.f4578a;
            if (dVar != null) {
                dVar.b();
            }
            d dVarA = a();
            this.f4578a = dVarA;
            dVarA.i(fMin + 1.0f);
            this.f4578a.j();
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f10) {
            super.onPull(f10);
            d(f10);
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f10, float f11) {
            super.onPull(f10, f11);
            d(f10);
        }

        @Override // android.widget.EdgeEffect
        public void onRelease() {
            super.onRelease();
            this.f4579b = false;
            if (b() != 1.0f) {
                d dVarA = a();
                this.f4578a = dVarA;
                dVarA.j();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public EdgeEffect a(RecyclerView recyclerView, int i10) {
        return new C0062a(recyclerView.getContext(), i10, recyclerView);
    }
}
