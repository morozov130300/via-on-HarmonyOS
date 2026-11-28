package androidx.activity.result;

import e.e;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e.d f445a = e.b.f4057a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e.d f446a = e.b.f4057a;

        public final d a() {
            d dVar = new d();
            dVar.b(this.f446a);
            return dVar;
        }

        public final a b(e.d mediaType) {
            h.f(mediaType, "mediaType");
            this.f446a = mediaType;
            return this;
        }
    }

    public final e.d a() {
        return this.f445a;
    }

    public final void b(e.d dVar) {
        h.f(dVar, "<set-?>");
        this.f445a = dVar;
    }
}
