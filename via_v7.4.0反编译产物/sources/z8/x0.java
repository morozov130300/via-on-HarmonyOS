package z8;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x0 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile x0 f14782b;

    /* renamed from: a, reason: collision with root package name */
    public final LruCache f14783a = new a(Math.max(2048, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 64));

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends LruCache {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            if (bitmap.isRecycled()) {
                return 0;
            }
            return Math.max(1, bitmap.getByteCount() / 1024);
        }
    }

    public static x0 c() {
        if (f14782b == null) {
            synchronized (x0.class) {
                try {
                    if (f14782b == null) {
                        f14782b = new x0();
                    }
                } finally {
                }
            }
        }
        return f14782b;
    }

    public void a() {
        this.f14783a.evictAll();
    }

    public final String b(Context context, String str) {
        return y0.d(context, str);
    }

    public Bitmap d(Context context, String str) {
        String strB = b(context, str);
        if (strB == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) this.f14783a.get(strB);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapC = y0.c(context, str);
        if (bitmapC != null && !bitmapC.isRecycled()) {
            this.f14783a.put(strB, bitmapC);
        }
        return bitmapC;
    }
}
