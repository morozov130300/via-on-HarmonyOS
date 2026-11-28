package v2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements List, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f13153c;

    public c0(List list) {
        this.f13153c = Collections.unmodifiableList(list);
    }

    public static c0 c(List list) {
        return new c0(list);
    }

    public static c0 f(Object... objArr) {
        return new c0(Arrays.asList(objArr));
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f13153c.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f13153c.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f13153c.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f13153c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f13153c.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f13153c.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.f13153c.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f13153c.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f13153c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f13153c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f13153c.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f13153c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return this.f13153c.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f13153c.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f13153c.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f13153c.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        return this.f13153c.set(i10, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f13153c.size();
    }

    @Override // java.util.List
    public List subList(int i10, int i11) {
        return this.f13153c.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f13153c.toArray();
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.f13153c.add(i10, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection collection) {
        return this.f13153c.addAll(i10, collection);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i10) {
        return this.f13153c.listIterator(i10);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        return this.f13153c.remove(i10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f13153c.toArray(objArr);
    }
}
