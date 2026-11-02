package io.reactivex.rxjava3.internal.queue;

import d7.d;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class MpscLinkedQueue implements d {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f7373e = new AtomicReference();

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference f7374j = new AtomicReference();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public LinkedQueueNode(E e10) {
            spValue(e10);
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e10) {
            this.value = e10;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public LinkedQueueNode a() {
        return (LinkedQueueNode) this.f7374j.get();
    }

    public LinkedQueueNode b() {
        return (LinkedQueueNode) this.f7374j.get();
    }

    public LinkedQueueNode c() {
        return (LinkedQueueNode) this.f7373e.get();
    }

    @Override // d7.e
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    public void d(LinkedQueueNode linkedQueueNode) {
        this.f7374j.lazySet(linkedQueueNode);
    }

    public LinkedQueueNode e(LinkedQueueNode linkedQueueNode) {
        return (LinkedQueueNode) this.f7373e.getAndSet(linkedQueueNode);
    }

    @Override // d7.e
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // d7.e
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // d7.d, d7.e
    public Object poll() {
        LinkedQueueNode linkedQueueNodeLvNext;
        LinkedQueueNode linkedQueueNodeA = a();
        LinkedQueueNode linkedQueueNodeLvNext2 = linkedQueueNodeA.lvNext();
        if (linkedQueueNodeLvNext2 != null) {
            Object andNullValue = linkedQueueNodeLvNext2.getAndNullValue();
            d(linkedQueueNodeLvNext2);
            return andNullValue;
        }
        if (linkedQueueNodeA == c()) {
            return null;
        }
        do {
            linkedQueueNodeLvNext = linkedQueueNodeA.lvNext();
        } while (linkedQueueNodeLvNext == null);
        Object andNullValue2 = linkedQueueNodeLvNext.getAndNullValue();
        d(linkedQueueNodeLvNext);
        return andNullValue2;
    }
}
