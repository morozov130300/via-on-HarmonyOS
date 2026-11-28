package lb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f7620h = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f7621a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f7622b = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: lb.c
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return f.b(runnable);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.e f7623c = new k.e(32);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f7624d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f7625e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7627g;

    public static /* synthetic */ Thread b(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: lb.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c(runnable);
            }
        }, "skin-loader");
    }

    public static /* synthetic */ void c(Runnable runnable) {
        Process.setThreadPriority(10);
        runnable.run();
    }

    public static /* synthetic */ void d(final f fVar, final int i10, String str, final String str2) throws Throwable {
        synchronized (fVar) {
            try {
                if (fVar.f7627g != i10) {
                    return;
                }
                final Bitmap bitmapJ = j(str);
                fVar.f7621a.post(new Runnable() { // from class: lb.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7615c.e(str2, i10, bitmapJ);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f i() {
        return f7620h;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0055: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:86), block:B:15:0x0055 */
    public static Bitmap j(String str) throws Throwable {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        BitmapRegionDecoder bitmapRegionDecoder;
        BitmapRegionDecoder bitmapRegionDecoder2 = null;
        if (!new File(str).isFile()) {
            return null;
        }
        try {
            try {
                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(str, false);
                try {
                    int width = bitmapRegionDecoderNewInstance.getWidth();
                    int height = bitmapRegionDecoderNewInstance.getHeight();
                    int iMin = Math.min(width, height);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = x8.i.a(iMin, iMin, 96, 96);
                    Bitmap bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(new Rect((width - iMin) / 2, (height - iMin) / 2, (width + iMin) / 2, (height + iMin) / 2), options);
                    if (bitmapDecodeRegion == null) {
                        bitmapRegionDecoderNewInstance.recycle();
                        return null;
                    }
                    Bitmap bitmapCreateScaledBitmap = bitmapDecodeRegion.getWidth() > 96 ? Bitmap.createScaledBitmap(bitmapDecodeRegion, 96, 96, true) : bitmapDecodeRegion;
                    if (bitmapCreateScaledBitmap != bitmapDecodeRegion) {
                        bitmapDecodeRegion.recycle();
                    }
                    bitmapRegionDecoderNewInstance.recycle();
                    return bitmapCreateScaledBitmap;
                } catch (IOException e10) {
                    e = e10;
                    tc.a.k(e, "Failed to load skin icon: %s", str);
                    if (bitmapRegionDecoderNewInstance != null) {
                        bitmapRegionDecoderNewInstance.recycle();
                    }
                    return null;
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    tc.a.k(e, "Failed to load skin icon: %s", str);
                    if (bitmapRegionDecoderNewInstance != null) {
                        bitmapRegionDecoderNewInstance.recycle();
                    }
                    return null;
                } catch (RuntimeException e12) {
                    e = e12;
                    tc.a.k(e, "Failed to load skin icon: %s", str);
                    if (bitmapRegionDecoderNewInstance != null) {
                        bitmapRegionDecoderNewInstance.recycle();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bitmapRegionDecoder2 = bitmapRegionDecoder;
                if (bitmapRegionDecoder2 != null) {
                    bitmapRegionDecoder2.recycle();
                }
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            bitmapRegionDecoderNewInstance = null;
            tc.a.k(e, "Failed to load skin icon: %s", str);
            if (bitmapRegionDecoderNewInstance != null) {
                bitmapRegionDecoderNewInstance.recycle();
            }
            return null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            bitmapRegionDecoderNewInstance = null;
            tc.a.k(e, "Failed to load skin icon: %s", str);
            if (bitmapRegionDecoderNewInstance != null) {
                bitmapRegionDecoderNewInstance.recycle();
            }
            return null;
        } catch (RuntimeException e15) {
            e = e15;
            bitmapRegionDecoderNewInstance = null;
            tc.a.k(e, "Failed to load skin icon: %s", str);
            if (bitmapRegionDecoderNewInstance != null) {
                bitmapRegionDecoderNewInstance.recycle();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmapRegionDecoder2 != null) {
                bitmapRegionDecoder2.recycle();
            }
            throw th;
        }
    }

    public final synchronized void e(String str, int i10, Bitmap bitmap) {
        if (this.f7627g != i10) {
            return;
        }
        List list = (List) this.f7624d.remove(str);
        Bitmap bitmap2 = (Bitmap) this.f7623c.d(str);
        if (bitmap2 != null) {
            bitmap = bitmap2;
        }
        if (bitmap == null) {
            this.f7625e.add(str);
            return;
        }
        this.f7623c.e(str, bitmap);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.a(bitmap);
            }
        }
    }

    public Drawable f(String str, Drawable drawable) {
        return g(str, drawable, false);
    }

    public final Drawable g(final String str, Drawable drawable, boolean z10) throws Throwable {
        synchronized (this) {
            String str2 = this.f7626f;
            if (str2 != null && !str2.isEmpty() && str != null && str.startsWith("ic_") && !this.f7625e.contains(str)) {
                Bitmap bitmap = (Bitmap) this.f7623c.d(str);
                final String str3 = this.f7626f + File.separator + str + ".png";
                final int i10 = this.f7627g;
                if (bitmap == null && z10) {
                    Bitmap bitmapJ = j(str3);
                    synchronized (this) {
                        try {
                            if (this.f7627g != i10) {
                                return drawable;
                            }
                            Bitmap bitmap2 = (Bitmap) this.f7623c.d(str);
                            if (bitmap2 != null) {
                                bitmapJ = bitmap2;
                            }
                            if (bitmapJ == null) {
                                return drawable;
                            }
                            this.f7623c.e(str, bitmapJ);
                            this.f7625e.remove(str);
                            a aVar = new a(drawable);
                            aVar.a(bitmapJ);
                            return aVar;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                a aVar2 = new a(drawable);
                if (bitmap != null) {
                    aVar2.a(bitmap);
                    return aVar2;
                }
                List arrayList = (List) this.f7624d.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f7624d.put(str, arrayList);
                    this.f7622b.execute(new Runnable() { // from class: lb.b
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            f.d(this.f7611c, i10, str3, str);
                        }
                    });
                }
                arrayList.add(new WeakReference(aVar2));
                return aVar2;
            }
            return drawable;
        }
    }

    public Drawable h(String str, Drawable drawable) {
        return g(str, drawable, true);
    }

    public synchronized void k(String str) {
        if (TextUtils.equals(this.f7626f, str)) {
            return;
        }
        this.f7626f = str;
        this.f7627g++;
        this.f7623c.c();
        this.f7624d.clear();
        this.f7625e.clear();
    }
}
