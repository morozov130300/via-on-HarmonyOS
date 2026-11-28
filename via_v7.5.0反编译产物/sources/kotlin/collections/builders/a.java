package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MapBuilder f7294c;

    public a(MapBuilder backing) {
        h.f(backing, "backing");
        this.f7294c = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        h.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f7294c.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        h.f(elements, "elements");
        return this.f7294c.containsAllEntries$kotlin_stdlib(elements);
    }

    @Override // f7.a
    public boolean f(Map.Entry element) {
        h.f(element, "element");
        return this.f7294c.containsEntry$kotlin_stdlib(element);
    }

    @Override // f7.a
    public boolean g(Map.Entry element) {
        h.f(element, "element");
        return this.f7294c.removeEntry$kotlin_stdlib(element);
    }

    @Override // e7.f
    public int getSize() {
        return this.f7294c.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry element) {
        h.f(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f7294c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f7294c.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        h.f(elements, "elements");
        this.f7294c.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        h.f(elements, "elements");
        this.f7294c.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
