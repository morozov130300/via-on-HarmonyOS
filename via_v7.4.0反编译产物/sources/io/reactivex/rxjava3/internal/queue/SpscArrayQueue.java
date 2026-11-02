package io.reactivex.rxjava3.internal.queue;

import d7.d;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements d {

    /* renamed from: e, reason: collision with root package name */
    public static final Integer f7375e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscArrayQueue(int i10) {
        super(io.reactivex.rxjava3.internal.util.d.a(i10));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i10 / 4, f7375e.intValue());
    }

    public int calcElementOffset(long j10) {
        return this.mask & ((int) j10);
    }

    public int calcElementOffset(long j10, int i10) {
        return ((int) j10) & i10;
    }

    @Override // d7.e
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // d7.e
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i10) {
        return get(i10);
    }

    @Override // d7.e
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i10 = this.mask;
        long j10 = this.producerIndex.get();
        int iCalcElementOffset = calcElementOffset(j10, i10);
        if (j10 >= this.producerLookAhead) {
            long j11 = this.lookAheadStep + j10;
            if (lvElement(calcElementOffset(j11, i10)) == null) {
                this.producerLookAhead = j11;
            } else if (lvElement(iCalcElementOffset) != null) {
                return false;
            }
        }
        soElement(iCalcElementOffset, e10);
        soProducerIndex(j10 + 1);
        return true;
    }

    public boolean offer(E e10, E e11) {
        return offer(e10) && offer(e11);
    }

    @Override // d7.d, d7.e
    public E poll() {
        long j10 = this.consumerIndex.get();
        int iCalcElementOffset = calcElementOffset(j10);
        E eLvElement = lvElement(iCalcElementOffset);
        if (eLvElement == null) {
            return null;
        }
        soConsumerIndex(j10 + 1);
        soElement(iCalcElementOffset, null);
        return eLvElement;
    }

    public void soConsumerIndex(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    public void soElement(int i10, E e10) {
        lazySet(i10, e10);
    }

    public void soProducerIndex(long j10) {
        this.producerIndex.lazySet(j10);
    }
}
