package o5;

import android.graphics.Rect;
import java.util.List;
import n5.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f10964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10966c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f10967d = new g();

    public f(int i10, v vVar) {
        this.f10965b = i10;
        this.f10964a = vVar;
    }

    public v a(List list, boolean z10) {
        return this.f10967d.b(list, b(z10));
    }

    public v b(boolean z10) {
        v vVar = this.f10964a;
        if (vVar == null) {
            return null;
        }
        return z10 ? vVar.d() : vVar;
    }

    public int c() {
        return this.f10965b;
    }

    public Rect d(v vVar) {
        return this.f10967d.d(vVar, this.f10964a);
    }

    public void e(j jVar) {
        this.f10967d = jVar;
    }
}
