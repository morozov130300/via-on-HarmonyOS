package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f865a;

    public u(w wVar) {
        this.f865a = wVar;
    }

    public static u b(w wVar) {
        return new u((w) x.g.c(wVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManagerR = this.f865a.r();
        w wVar = this.f865a;
        fragmentManagerR.o(wVar, wVar, fragment);
    }

    public void c() {
        this.f865a.r().C();
    }

    public boolean d(MenuItem menuItem) {
        return this.f865a.r().F(menuItem);
    }

    public void e() {
        this.f865a.r().G();
    }

    public void f() {
        this.f865a.r().I();
    }

    public void g() {
        this.f865a.r().R();
    }

    public void h() {
        this.f865a.r().V();
    }

    public void i() {
        this.f865a.r().W();
    }

    public void j() {
        this.f865a.r().Y();
    }

    public boolean k() {
        return this.f865a.r().f0(true);
    }

    public FragmentManager l() {
        return this.f865a.r();
    }

    public void m() {
        this.f865a.r().Z0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f865a.r().C0().onCreateView(view, str, context, attributeSet);
    }
}
