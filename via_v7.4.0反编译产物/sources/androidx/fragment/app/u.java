package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final w f964a;

    public u(w wVar) {
        this.f964a = wVar;
    }

    public static u b(w wVar) {
        return new u((w) w.g.c(wVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentManager fragmentManagerS = this.f964a.s();
        w wVar = this.f964a;
        fragmentManagerS.o(wVar, wVar, fragment);
    }

    public void c() {
        this.f964a.s().C();
    }

    public boolean d(MenuItem menuItem) {
        return this.f964a.s().F(menuItem);
    }

    public void e() {
        this.f964a.s().G();
    }

    public void f() {
        this.f964a.s().I();
    }

    public void g() {
        this.f964a.s().R();
    }

    public void h() {
        this.f964a.s().V();
    }

    public void i() {
        this.f964a.s().W();
    }

    public void j() {
        this.f964a.s().Y();
    }

    public boolean k() {
        return this.f964a.s().f0(true);
    }

    public FragmentManager l() {
        return this.f964a.s();
    }

    public void m() {
        this.f964a.s().Z0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f964a.s().C0().onCreateView(view, str, context, attributeSet);
    }
}
