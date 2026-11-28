package u1;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f12782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12783b;

    public h(Context context) {
        f.h(context);
        Resources resources = context.getResources();
        this.f12782a = resources;
        this.f12783b = resources.getResourcePackageName(r1.i.f11942a);
    }

    public String a(String str) {
        int identifier = this.f12782a.getIdentifier(str, "string", this.f12783b);
        if (identifier == 0) {
            return null;
        }
        return this.f12782a.getString(identifier);
    }
}
