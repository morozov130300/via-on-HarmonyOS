package v5;

import android.graphics.drawable.Drawable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f13366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13368h;

    public a(int i10, String str, String str2, Drawable drawable, String str3, boolean z10) {
        this(i10, str, str2, drawable, str3, z10, false);
    }

    @Override // v5.q, v5.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f13366f, aVar.f13366f) && Objects.equals(this.f13367g, aVar.f13367g);
    }

    @Override // v5.q, v5.d
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f13366f, this.f13367g);
    }

    public String i() {
        return this.f13367g;
    }

    public Drawable j() {
        return this.f13366f;
    }

    public boolean k() {
        return this.f13368h;
    }

    public a(int i10, String str, String str2, Drawable drawable, String str3, boolean z10, boolean z11) {
        super(i10, str, str2, z11);
        this.f13366f = drawable;
        this.f13367g = str3;
        this.f13368h = z10;
    }
}
