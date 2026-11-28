package y5;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import d0.b;
import d0.d;
import d0.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends RecyclerView.k {
    @Override // androidx.recyclerview.widget.RecyclerView.k
    public EdgeEffect a(RecyclerView recyclerView, int i10) {
        return new C0161a(recyclerView.getContext(), i10, recyclerView);
    }

    /* JADX INFO: renamed from: y5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0161a extends EdgeEffect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f14848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f14850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f14851d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0161a(Context context, int i10, RecyclerView recyclerView) {
            super(context);
            this.f14850c = i10;
            this.f14851d = recyclerView;
            this.f14848a = null;
            this.f14849b = false;
        }

        public final d a() {
            return new d(this.f14851d, e() ? b.f3809p : b.f3810q).o(new e().e(1.0f).d(0.75f).f(200.0f));
        }

        public final float b() {
            return e() ? this.f14851d.getScaleX() : this.f14851d.getScaleY();
        }

        public final int c() {
            if (e()) {
                return this.f14851d.getPivotX() == 0.0f ? 0 : 2;
            }
            return this.f14851d.getPivotY() == 0.0f ? 1 : 3;
        }

        public final void d(float f10) {
            float fB = b();
            if (!this.f14849b && fB == 1.0f) {
                this.f14849b = true;
                f();
            }
            float f11 = ((c() != this.f14850c ? -(fB - 1.0f) : 1.05f - fB) / 0.05f) * f10 * 0.15f;
            if (f11 != 0.0f) {
                g(fB + f11);
            }
            d dVar = this.f14848a;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // android.widget.EdgeEffect
        public boolean draw(Canvas canvas) {
            return false;
        }

        public final boolean e() {
            int i10 = this.f14850c;
            return i10 == 0 || i10 == 2;
        }

        public final void f() {
            if (e()) {
                RecyclerView recyclerView = this.f14851d;
                recyclerView.setPivotX(this.f14850c != 0 ? recyclerView.getWidth() : 0.0f);
            } else {
                RecyclerView recyclerView2 = this.f14851d;
                recyclerView2.setPivotY(this.f14850c != 1 ? recyclerView2.getHeight() : 0.0f);
            }
        }

        public final void g(float f10) {
            float fMin = Math.min(1.8f, Math.max(f10, 0.5f));
            if (e()) {
                this.f14851d.setScaleX(fMin);
            } else {
                this.f14851d.setScaleY(fMin);
            }
        }

        @Override // android.widget.EdgeEffect
        public boolean isFinished() {
            d dVar = this.f14848a;
            return dVar == null || !dVar.f();
        }

        @Override // android.widget.EdgeEffect
        public void onAbsorb(int i10) {
            super.onAbsorb(i10);
            f();
            float fMin = Math.min(0.05f, (i10 / 20000.0f) * 0.25f);
            d dVar = this.f14848a;
            if (dVar != null) {
                dVar.b();
            }
            d dVarA = a();
            this.f14848a = dVarA;
            dVarA.i(fMin + 1.0f);
            this.f14848a.j();
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f10) {
            super.onPull(f10);
            d(f10);
        }

        @Override // android.widget.EdgeEffect
        public void onRelease() {
            super.onRelease();
            this.f14849b = false;
            if (b() != 1.0f) {
                d dVarA = a();
                this.f14848a = dVarA;
                dVarA.j();
            }
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f10, float f11) {
            super.onPull(f10, f11);
            d(f10);
        }
    }
}
