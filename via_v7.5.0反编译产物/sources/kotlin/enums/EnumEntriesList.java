package kotlin.enums;

import e7.c;
import e7.l;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class EnumEntriesList<T extends Enum<T>> extends c implements j7.a, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] entries) {
        h.f(entries, "entries");
        this.entries = entries;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    @Override // e7.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((Enum) obj);
        }
        return false;
    }

    @Override // e7.b
    public int getSize() {
        return this.entries.length;
    }

    @Override // e7.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }

    @Override // e7.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((Enum) obj);
        }
        return -1;
    }

    public boolean contains(T element) {
        h.f(element, "element");
        return ((Enum) l.o(this.entries, element.ordinal())) == element;
    }

    @Override // e7.c, java.util.List
    public T get(int i10) {
        c.Companion.a(i10, this.entries.length);
        return this.entries[i10];
    }

    public int indexOf(T element) {
        h.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) l.o(this.entries, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        h.f(element, "element");
        return indexOf((Object) element);
    }
}
