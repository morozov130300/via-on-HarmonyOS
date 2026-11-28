package g8;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f5563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5565d;

    public m(int i10, Drawable drawable, String str, boolean z10) {
        this.f5562a = i10;
        this.f5563b = drawable;
        this.f5564c = str;
        this.f5565d = z10;
    }

    public Drawable a() {
        return this.f5563b;
    }

    public int b() {
        return this.f5562a;
    }

    public String c() {
        return this.f5564c;
    }

    public void d(boolean z10) {
        this.f5565d = z10;
    }

    public String toString() {
        return "BrowserMenuWrapper{id=" + this.f5562a + ", title='" + this.f5564c + "', isAdded=" + this.f5565d + '}';
    }
}
