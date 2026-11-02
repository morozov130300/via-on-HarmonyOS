package d8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f4589a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f4590b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final List f4591c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d, reason: collision with root package name */
    public boolean f4592d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4593e = false;

    public void a(int i10, String str, boolean z10, boolean z11) {
        if (i10 != this.f4589a) {
            return;
        }
        n9.c cVar = new n9.c(str, z10, z11);
        if (cVar.e() && this.f4593e) {
            return;
        }
        if (!this.f4593e && !this.f4592d && cVar.e()) {
            this.f4592d = true;
        }
        this.f4591c.add(cVar);
    }

    public void b() {
        this.f4591c.clear();
        this.f4592d = false;
    }

    public List c() {
        return this.f4590b != this.f4589a ? new ArrayList() : this.f4591c;
    }

    public boolean d() {
        return this.f4590b != this.f4589a || this.f4591c.isEmpty();
    }

    public boolean e() {
        return d() || this.f4593e || !this.f4592d;
    }

    public void f(int i10) {
        this.f4590b = i10;
    }

    public void g(boolean z10) {
        this.f4593e = z10;
    }

    public void h(int i10) {
        this.f4589a = i10;
    }
}
