package s7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends r7.a {
    @Override // r7.a
    public Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        h.e(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d10) {
        return ThreadLocalRandom.current().nextDouble(d10);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10) {
        return ThreadLocalRandom.current().nextLong(j10);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10, long j11) {
        return ThreadLocalRandom.current().nextLong(j10, j11);
    }
}
