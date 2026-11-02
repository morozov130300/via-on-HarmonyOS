package u5;

import android.graphics.Rect;
import java.util.List;
import t5.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public v f12865a;

    /* renamed from: b, reason: collision with root package name */
    public int f12866b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12867c = false;

    /* renamed from: d, reason: collision with root package name */
    public j f12868d = new g();

    public f(int i10, v vVar) {
        this.f12866b = i10;
        this.f12865a = vVar;
    }

    public v a(List list, boolean z10) {
        return this.f12868d.b(list, b(z10));
    }

    public v b(boolean z10) {
        v vVar = this.f12865a;
        if (vVar == null) {
            return null;
        }
        return z10 ? vVar.b() : vVar;
    }

    public int c() {
        return this.f12866b;
    }

    public Rect d(v vVar) {
        return this.f12868d.d(vVar, this.f12865a);
    }

    public void e(j jVar) {
        this.f12868d = jVar;
    }
}
