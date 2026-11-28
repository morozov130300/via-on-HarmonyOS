package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.util.Match;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Resolver<M extends Match> extends AbstractSet<M> {
    protected final Resolver<M>.Stack stack = new Stack();
    protected final Resolver<M>.Cache cache = new Cache();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class Cache extends LimitedCache<List<M>> {
        public Cache() {
            super(1024);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class Stack extends LinkedList<M> {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class Sequence implements Iterator<M> {
            private int cursor;

            public Sequence() {
                this.cursor = Stack.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cursor > 0;
            }

            @Override // java.util.Iterator
            public void remove() {
                Stack.this.purge(this.cursor);
            }

            @Override // java.util.Iterator
            public M next() {
                if (!hasNext()) {
                    return null;
                }
                Stack stack = Stack.this;
                int i10 = this.cursor - 1;
                this.cursor = i10;
                return (M) stack.get(i10);
            }
        }

        private Stack() {
        }

        public void purge(int i10) {
            Resolver.this.cache.clear();
            remove(i10);
        }

        public Iterator<M> sequence() {
            return new Sequence();
        }

        @Override // java.util.LinkedList, java.util.Deque
        public void push(M m10) {
            Resolver.this.cache.clear();
            addFirst(m10);
        }
    }

    private boolean match(char[] cArr, char[] cArr2) {
        return match(cArr, 0, cArr2, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.cache.clear();
        this.stack.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<M> iterator() {
        return this.stack.sequence();
    }

    public boolean remove(M m10) {
        this.cache.clear();
        return this.stack.remove(m10);
    }

    public M resolve(String str) {
        List<M> listResolveAll = (List) this.cache.get(str);
        if (listResolveAll == null) {
            listResolveAll = resolveAll(str);
        }
        if (listResolveAll.isEmpty()) {
            return null;
        }
        return listResolveAll.get(0);
    }

    public List<M> resolveAll(String str) {
        List<M> list = (List) this.cache.get(str);
        if (list != null) {
            return list;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            return null;
        }
        return resolveAll(str, charArray);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.stack.size();
    }

    private boolean match(char[] cArr, int i10, char[] cArr2, int i11) {
        while (i11 < cArr2.length && i10 < cArr.length) {
            if (cArr2[i11] == '*') {
                do {
                    char c10 = cArr2[i11];
                    if (c10 == '*') {
                        i11++;
                    } else {
                        if (c10 == '?' && (i11 = i11 + 1) >= cArr2.length) {
                            return true;
                        }
                        while (i10 < cArr.length) {
                            char c11 = cArr[i10];
                            char c12 = cArr2[i11];
                            if (c11 == c12 || c12 == '?') {
                                if (cArr2[i11 - 1] == '?') {
                                    break;
                                }
                                if (match(cArr, i10, cArr2, i11)) {
                                    return true;
                                }
                            }
                            i10++;
                        }
                        if (cArr.length == i10) {
                            return false;
                        }
                    }
                } while (i11 < cArr2.length);
                return true;
            }
            int i12 = i10 + 1;
            int i13 = i11 + 1;
            if (cArr[i10] != cArr2[i11] && cArr2[i11] != '?') {
                return false;
            }
            i10 = i12;
            i11 = i13;
        }
        if (cArr2.length == i11) {
            return cArr.length == i10;
        }
        while (cArr2[i11] == '*') {
            i11++;
            if (i11 >= cArr2.length) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(M m10) {
        this.stack.push((Match) m10);
        return true;
    }

    private List<M> resolveAll(String str, char[] cArr) {
        ArrayList arrayList = new ArrayList();
        for (M m10 : this.stack) {
            if (match(cArr, m10.getPattern().toCharArray())) {
                this.cache.put(str, arrayList);
                arrayList.add(m10);
            }
        }
        return arrayList;
    }
}
