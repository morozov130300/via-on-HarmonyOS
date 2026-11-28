package b8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1775a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1776b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1777c = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1778d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1779e = false;

    public void a(int i10, String str, boolean z10, boolean z11) {
        if (i10 != this.f1775a) {
            return;
        }
        l9.c cVar = new l9.c(str, z10, z11);
        if (cVar.e() && this.f1779e) {
            return;
        }
        if (!this.f1779e && !this.f1778d && cVar.e()) {
            this.f1778d = true;
        }
        this.f1777c.add(cVar);
    }

    public void b() {
        this.f1777c.clear();
        this.f1778d = false;
    }

    public List c() {
        return this.f1776b != this.f1775a ? new ArrayList() : this.f1777c;
    }

    public boolean d() {
        return this.f1776b != this.f1775a || this.f1777c.isEmpty();
    }

    public boolean e() {
        return d() || this.f1779e || !this.f1778d;
    }

    public void f(int i10) {
        this.f1776b = i10;
    }

    public void g(boolean z10) {
        this.f1779e = z10;
    }

    public void h(int i10) {
        this.f1775a = i10;
    }
}
