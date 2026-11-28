package v5;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f13388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13389d;

    public e(int i10, String str, Drawable drawable) {
        this(i10, str, drawable, false);
    }

    public Drawable c() {
        return this.f13388c;
    }

    public int d() {
        return this.f13387b;
    }

    public boolean e() {
        return this.f13389d;
    }

    @Override // v5.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f13387b == eVar.f13387b && this.f13389d == eVar.f13389d;
    }

    @Override // v5.d
    public int hashCode() {
        return (((super.hashCode() * 31) + this.f13387b) * 31) + (this.f13389d ? 1 : 0);
    }

    public e(int i10, String str, Drawable drawable, boolean z10) {
        super(str);
        this.f13387b = i10;
        this.f13388c = drawable;
        this.f13389d = z10;
    }
}
