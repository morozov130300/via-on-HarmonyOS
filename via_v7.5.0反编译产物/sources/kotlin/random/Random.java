package kotlin.random;

import java.io.Serializable;
import k7.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import q7.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class Random {
    public static final Default Default = new Default(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Random f7320c = b.f7217a.b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class Default extends Random implements Serializable {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(f fVar) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i10) {
            return Random.f7320c.nextBits(i10);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.f7320c.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            h.f(array, "array");
            return Random.f7320c.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.f7320c.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.f7320c.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.f7320c.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.f7320c.nextLong();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i10) {
            return Random.f7320c.nextBytes(i10);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10) {
            return Random.f7320c.nextDouble(d10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10) {
            return Random.f7320c.nextInt(i10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10) {
            return Random.f7320c.nextLong(j10);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i10, int i11) {
            h.f(array, "array");
            return Random.f7320c.nextBytes(array, i10, i11);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10, double d11) {
            return Random.f7320c.nextDouble(d10, d11);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10, int i11) {
            return Random.f7320c.nextInt(i10, i11);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10, long j11) {
            return Random.f7320c.nextLong(j10, j11);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return random.nextBytes(bArr, i10, i11);
    }

    public abstract int nextBits(int i10);

    public abstract boolean nextBoolean();

    public abstract byte[] nextBytes(byte[] bArr);

    public byte[] nextBytes(byte[] array, int i10, int i11) {
        h.f(array, "array");
        if (i10 < 0 || i10 > array.length || i11 < 0 || i11 > array.length) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") or toIndex (" + i11 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i10 > i11) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") must be not greater than toIndex (" + i11 + ").").toString());
        }
        int i12 = (i11 - i10) / 4;
        for (int i13 = 0; i13 < i12; i13++) {
            int iNextInt = nextInt();
            array[i10] = (byte) iNextInt;
            array[i10 + 1] = (byte) (iNextInt >>> 8);
            array[i10 + 2] = (byte) (iNextInt >>> 16);
            array[i10 + 3] = (byte) (iNextInt >>> 24);
            i10 += 4;
        }
        int i14 = i11 - i10;
        int iNextBits = nextBits(i14 * 8);
        for (int i15 = 0; i15 < i14; i15++) {
            array[i10 + i15] = (byte) (iNextBits >>> (i15 * 8));
        }
        return array;
    }

    public abstract double nextDouble();

    public double nextDouble(double d10) {
        return nextDouble(0.0d, d10);
    }

    public abstract float nextFloat();

    public abstract int nextInt();

    public abstract int nextInt(int i10);

    public int nextInt(int i10, int i11) {
        int iNextInt;
        int i12;
        int iNextBits;
        c.c(i10, i11);
        int i13 = i11 - i10;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                iNextBits = nextBits(c.e(i13));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i12 = iNextInt % i13;
                } while ((iNextInt - i12) + (i13 - 1) < 0);
                iNextBits = i12;
            }
            return i10 + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i10 <= iNextInt2 && iNextInt2 < i11) {
                return iNextInt2;
            }
        }
    }

    public abstract long nextLong();

    public long nextLong(long j10) {
        return nextLong(0L, j10);
    }

    public double nextDouble(double d10, double d11) {
        double dNextDouble;
        c.b(d10, d11);
        double d12 = d11 - d10;
        if (!Double.isInfinite(d12) || Math.abs(d10) > Double.MAX_VALUE || Math.abs(d11) > Double.MAX_VALUE) {
            dNextDouble = d10 + (nextDouble() * d12);
        } else {
            double dNextDouble2 = nextDouble();
            double d13 = 2;
            Double.isNaN(d13);
            Double.isNaN(d13);
            double d14 = dNextDouble2 * ((d11 / d13) - (d10 / d13));
            dNextDouble = d10 + d14 + d14;
        }
        return dNextDouble >= d11 ? Math.nextAfter(d11, Double.NEGATIVE_INFINITY) : dNextDouble;
    }

    public long nextLong(long j10, long j11) {
        long jNextLong;
        long j12;
        long jNextBits;
        int iNextInt;
        c.d(j10, j11);
        long j13 = j11 - j10;
        if (j13 > 0) {
            if (((-j13) & j13) == j13) {
                int i10 = (int) j13;
                int i11 = (int) (j13 >>> 32);
                if (i10 != 0) {
                    iNextInt = nextBits(c.e(i10));
                } else if (i11 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(c.e(i11))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                jNextBits = ((long) iNextInt) & 4294967295L;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j12 = jNextLong % j13;
                } while ((jNextLong - j12) + (j13 - 1) < 0);
                jNextBits = j12;
            }
            return j10 + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j10 <= jNextLong2 && jNextLong2 < j11) {
                return jNextLong2;
            }
        }
    }

    public byte[] nextBytes(int i10) {
        return nextBytes(new byte[i10]);
    }
}
