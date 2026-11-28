package kotlin.enums;

import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final j7.a a(Enum[] entries) {
        h.f(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
