package z7;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f15288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15289b;

    public l(Drawable drawable, String str) {
        this.f15288a = drawable;
        this.f15289b = str;
    }

    public Drawable a() {
        return this.f15288a;
    }

    public String b() {
        return this.f15289b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return x8.t1.a(this.f15289b, ((l) obj).f15289b);
    }

    public int hashCode() {
        return x8.t1.b(this.f15289b);
    }
}
