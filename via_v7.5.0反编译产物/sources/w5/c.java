package w5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13659c = f.f13666a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13660d = f.f13667b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13661e = f.f13668c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13662f = f.f13669d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13663g = f.f13670e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13665b;

    public c(int i10, int i11) {
        this.f13664a = i10;
        this.f13665b = i11;
    }

    public static c b() {
        return new c(-2, 0);
    }

    public static c c() {
        return new c(-4, 0);
    }

    public static c d() {
        return new c(-5, 0);
    }

    public static c e(int i10) {
        return new c(0, i10);
    }

    public static c f() {
        return new c(-7, 0);
    }

    public static c g() {
        return new c(-6, 0);
    }

    public static c h() {
        return new c(-1, 0);
    }

    public View a(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        return this.f13665b != 0 ? LayoutInflater.from(context).inflate(this.f13665b, viewGroup, false) : f.i(context, this.f13664a);
    }
}
