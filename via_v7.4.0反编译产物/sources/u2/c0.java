package u2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c0 implements List, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public final List f12614e;

    public c0(List list) {
        this.f12614e = Collections.unmodifiableList(list);
    }

    public static c0 c(List list) {
        return new c0(list);
    }

    public static c0 f(Object... objArr) {
        return new c0(Arrays.asList(objArr));
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.f12614e.add(i10, obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f12614e.add(obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection collection) {
        return this.f12614e.addAll(i10, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f12614e.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f12614e.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f12614e.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f12614e.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f12614e.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.f12614e.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f12614e.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f12614e.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f12614e.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f12614e.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f12614e.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return this.f12614e.listIterator();
    }

    @Override // java.util.List
    public ListIterator listIterator(int i10) {
        return this.f12614e.listIterator(i10);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        return this.f12614e.remove(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f12614e.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f12614e.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f12614e.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        return this.f12614e.set(i10, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f12614e.size();
    }

    @Override // java.util.List
    public List subList(int i10, int i11) {
        return this.f12614e.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f12614e.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f12614e.toArray(objArr);
    }
}
