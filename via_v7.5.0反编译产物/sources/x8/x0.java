package x8;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile x0 f14648b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache f14649a = new a(Math.max(2048, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 64));

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends LruCache {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            if (bitmap.isRecycled()) {
                return 0;
            }
            return Math.max(1, bitmap.getByteCount() / 1024);
        }
    }

    public static x0 c() {
        if (f14648b == null) {
            synchronized (x0.class) {
                try {
                    if (f14648b == null) {
                        f14648b = new x0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f14648b;
    }

    public void a() {
        this.f14649a.evictAll();
    }

    public final String b(Context context, String str) {
        return y0.e(context, str);
    }

    public Bitmap d(Context context, String str) {
        String strB = b(context, str);
        if (strB == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) this.f14649a.get(strB);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapD = y0.d(context, str);
        if (bitmapD != null && !bitmapD.isRecycled()) {
            this.f14649a.put(strB, bitmapD);
        }
        return bitmapD;
    }
}
