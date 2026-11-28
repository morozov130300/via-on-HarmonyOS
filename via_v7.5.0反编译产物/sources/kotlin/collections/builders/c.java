package kotlin.collections.builders;

import e7.d;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d implements Collection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MapBuilder f7296c;

    public c(MapBuilder backing) {
        h.f(backing, "backing");
        this.f7296c = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection elements) {
        h.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // e7.d
    public int c() {
        return this.f7296c.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f7296c.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f7296c.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f7296c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f7296c.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f7296c.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection elements) {
        h.f(elements, "elements");
        this.f7296c.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection elements) {
        h.f(elements, "elements");
        this.f7296c.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
