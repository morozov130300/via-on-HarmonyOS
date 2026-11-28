package mark.via.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class PdfViewer extends View implements r5.a.c {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final ExecutorService f9862h0 = Executors.newFixedThreadPool(3);
    public float A;
    public final PointF B;
    public final PointF C;
    public float D;
    public float E;
    public final PointF F;
    public final PointF G;
    public boolean H;
    public float I;
    public float J;
    public int K;
    public final OverScroller L;
    public d0.d M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public Future S;
    public Future T;
    public Future U;
    public int V;
    public final LruCache W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final e4.a f9863a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public e f9864b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PdfRenderer f9865c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final r5.a f9866c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int[] f9867d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9868e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f9869e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f9870f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f9871g0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f9873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f9874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f9875p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f9876q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f9877r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GestureDetector f9878s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f9879t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f9880u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f9881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f9882w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f9883x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f9884y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f9885z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class PageRect implements Parcelable {
        public static final Parcelable.Creator<PageRect> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f9890c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f9891e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PageRect createFromParcel(Parcel parcel) {
                return new PageRect(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public PageRect[] newArray(int i10) {
                return new PageRect[i10];
            }
        }

        public PageRect(Parcel parcel) {
            this(parcel.readFloat(), (RectF) parcel.readParcelable(Rect.class.getClassLoader()));
        }

        public RectF b() {
            return this.f9891e;
        }

        public float c() {
            return this.f9890c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f9890c);
            parcel.writeParcelable(this.f9891e, i10);
        }

        public PageRect(float f10, RectF rectF) {
            this.f9890c = f10;
            this.f9891e = rectF;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends LruCache {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                return 0;
            }
            return Math.max(1, bitmap.getByteCount() / 1024);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference f9893c;

        public b(PdfViewer pdfViewer) {
            this.f9893c = new WeakReference(pdfViewer);
        }

        @Override // java.lang.Runnable
        public void run() {
            PdfRenderer pdfRenderer;
            PageRect pageRect;
            RectF rectFB;
            PdfViewer pdfViewer = (PdfViewer) this.f9893c.get();
            if (pdfViewer == null || (pdfRenderer = pdfViewer.f9865c) == null) {
                return;
            }
            List list = pdfViewer.f9873n;
            int i10 = pdfViewer.R;
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int[] displayedPageRange = pdfViewer.getDisplayedPageRange();
            for (int i11 = displayedPageRange[0]; i11 <= displayedPageRange[1]; i11++) {
                if (i11 >= 0 && i11 < list.size() && (rectFB = (pageRect = (PageRect) list.get(i11)).b()) != null && rectFB.width() > 0.0f && rectFB.height() > 0.0f) {
                    float fMax = pdfViewer.A;
                    int iMax = Math.max(1, Math.round(rectFB.width() * fMax));
                    int iMax2 = Math.max(1, Math.round(rectFB.height() * fMax));
                    long j10 = ((long) iMax) * ((long) iMax2);
                    if (j10 > 8000000) {
                        double d10 = j10;
                        Double.isNaN(d10);
                        fMax = Math.max(1.0f, fMax * ((float) Math.sqrt(8000000.0d / d10)));
                        iMax = Math.max(1, Math.round(rectFB.width() * fMax));
                        iMax2 = Math.max(1, Math.round(rectFB.height() * fMax));
                    }
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                        Matrix matrix = new Matrix();
                        float fC = pageRect.c() * fMax;
                        matrix.postScale(fC, fC);
                        PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i11);
                        pageOpenPage.render(bitmapCreateBitmap, null, matrix, 1);
                        pageOpenPage.close();
                        arrayList.add(new DrawingPage(pageRect, bitmapCreateBitmap, i11, PdfViewer.M(rectFB, bitmapCreateBitmap)));
                    } catch (Throwable unused) {
                    }
                }
            }
            Message message = new Message();
            message.what = 3;
            message.getData().putInt("index", i10);
            message.getData().putParcelableArrayList("list", arrayList);
            pdfViewer.f9879t.sendMessage(message);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference f9894c;

        public c(PdfViewer pdfViewer) {
            this.f9894c = new WeakReference(pdfViewer);
        }

        @Override // java.lang.Runnable
        public void run() {
            PdfViewer pdfViewer = (PdfViewer) this.f9894c.get();
            if (pdfViewer == null) {
                return;
            }
            PdfRenderer pdfRenderer = pdfViewer.f9865c;
            if (pdfRenderer == null) {
                throw new NullPointerException("pdfRenderer is null!");
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            float f10 = pdfViewer.f9883x;
            float paddingLeft = pdfViewer.getPaddingLeft() + pdfViewer.f9882w;
            float measuredWidth = (pdfViewer.getMeasuredWidth() - pdfViewer.getPaddingRight()) - pdfViewer.f9882w;
            int pageCount = pdfRenderer.getPageCount();
            for (int i10 = 0; i10 < pageCount; i10++) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i10);
                float width = (measuredWidth - paddingLeft) / pageOpenPage.getWidth();
                float height = pageOpenPage.getHeight() * width;
                if (i10 != 0) {
                    f10 += pdfViewer.f9885z;
                }
                RectF rectF = new RectF(paddingLeft, f10, measuredWidth, height + f10);
                f10 = rectF.bottom;
                arrayList.add(new PageRect(width, rectF));
                pageOpenPage.close();
            }
            Message message = new Message();
            message.what = 1;
            message.getData().putParcelableArrayList("list", arrayList);
            pdfViewer.f9879t.sendMessage(message);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f9895a;

        public d(PdfViewer pdfViewer) {
            this.f9895a = new WeakReference(pdfViewer);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            PdfViewer pdfViewer = (PdfViewer) this.f9895a.get();
            boolean z10 = false;
            if (pdfViewer == null) {
                return false;
            }
            if (motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) < 100.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) < 100.0f) || (Math.abs(f10) < pdfViewer.K && Math.abs(f11) < pdfViewer.K))) {
                return super.onFling(motionEvent, motionEvent2, f10, f11);
            }
            float minTranslateY = pdfViewer.getMinTranslateY();
            boolean z11 = pdfViewer.B.y >= 0.0f && f11 > 0.0f;
            if (pdfViewer.B.y <= minTranslateY && f11 < 0.0f) {
                z10 = true;
            }
            if (!z11 && !z10) {
                pdfViewer.t0(f10, f11);
                return true;
            }
            pdfViewer.P = true;
            pdfViewer.N = z11 ? 1 : 2;
            pdfViewer.setPivotY(z11 ? 0.0f : pdfViewer.getHeight());
            pdfViewer.e(f11);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            PdfViewer pdfViewer = (PdfViewer) this.f9895a.get();
            if (pdfViewer == null) {
                return false;
            }
            float f12 = pdfViewer.B.y - f11;
            float fB0 = pdfViewer.b0(f12);
            float f13 = f12 - fB0;
            boolean z10 = Math.abs(f11) >= Math.abs(f10) && f13 != 0.0f && fB0 == pdfViewer.B.y;
            if (z10) {
                pdfViewer.f0(f13);
            } else {
                pdfViewer.p0();
            }
            if (z10) {
                f10 = 0.0f;
            }
            float fA0 = pdfViewer.a0(pdfViewer.B.x - f10);
            if (fA0 == pdfViewer.B.x && fB0 == pdfViewer.B.y) {
                return z10;
            }
            pdfViewer.z0(fA0, fB0, true);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PdfViewer pdfViewer = (PdfViewer) this.f9895a.get();
            if (pdfViewer == null) {
                return true;
            }
            pdfViewer.performClick();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        void a(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f9896a;

        public f(PdfViewer pdfViewer) {
            this.f9896a = new WeakReference(pdfViewer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            PdfViewer pdfViewer = (PdfViewer) this.f9896a.get();
            if (pdfViewer == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                ArrayList parcelableArrayList = message.getData().getParcelableArrayList("list");
                if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                    return;
                }
                pdfViewer.f9877r = ((PageRect) parcelableArrayList.get(parcelableArrayList.size() - 1)).b().bottom + pdfViewer.f9884y;
                pdfViewer.f9876q = pdfViewer.getWidth();
                pdfViewer.f9873n.addAll(parcelableArrayList);
                pdfViewer.awakenScrollBars();
                pdfViewer.invalidate();
                pdfViewer.v0();
                if (pdfViewer.f9864b0 != null) {
                    pdfViewer.f9864b0.a(pdfViewer.R, parcelableArrayList.size());
                    return;
                }
                return;
            }
            if (i10 == 2) {
                int i11 = message.getData().getInt("index");
                ArrayList parcelableArrayList2 = message.getData().getParcelableArrayList("list");
                if (pdfViewer.R != i11 || parcelableArrayList2 == null || parcelableArrayList2.isEmpty()) {
                    return;
                }
                pdfViewer.f9874o.clear();
                pdfViewer.f9874o.addAll(parcelableArrayList2);
                pdfViewer.invalidate();
                pdfViewer.w0();
                return;
            }
            if (i10 != 3) {
                if (i10 != 4) {
                    return;
                }
                pdfViewer.requestLayout();
                pdfViewer.s0((String) message.obj);
                return;
            }
            int i12 = message.getData().getInt("index");
            ArrayList parcelableArrayList3 = message.getData().getParcelableArrayList("list");
            if (pdfViewer.R != i12 || parcelableArrayList3 == null || parcelableArrayList3.isEmpty()) {
                return;
            }
            pdfViewer.f9875p.clear();
            pdfViewer.f9875p.addAll(parcelableArrayList3);
            pdfViewer.invalidate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference f9897c;

        public g(PdfViewer pdfViewer) {
            this.f9897c = new WeakReference(pdfViewer);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            PdfViewer pdfViewer = (PdfViewer) this.f9897c.get();
            if (pdfViewer == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PdfRenderer pdfRenderer = pdfViewer.f9865c;
            if (pdfRenderer == null) {
                return;
            }
            List list = pdfViewer.f9873n;
            int i11 = pdfViewer.R;
            int iMax = Math.max(0, i11 - pdfViewer.V);
            int i12 = 1;
            int iMin = Math.min(pdfViewer.V + i11, list.size() - 1);
            while (iMax <= iMin) {
                PageRect pageRect = (PageRect) list.get(iMax);
                RectF rectFB = pageRect.b();
                Bitmap bitmapC0 = pdfViewer.c0(iMax, pageRect);
                if (bitmapC0 == null) {
                    PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(iMax);
                    int iMax2 = Math.max(i12, Math.round(rectFB.width() / pageRect.c()));
                    int iMax3 = Math.max(i12, Math.round(rectFB.height() / pageRect.c()));
                    long j10 = ((long) iMax2) * ((long) iMax3);
                    if (j10 > 6000000) {
                        double d10 = j10;
                        Double.isNaN(d10);
                        float fSqrt = (float) Math.sqrt(6000000.0d / d10);
                        i10 = 1;
                        iMax2 = Math.max(1, Math.round(iMax2 * fSqrt));
                        iMax3 = Math.max(1, Math.round(iMax3 * fSqrt));
                    } else {
                        i10 = 1;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax2, iMax3, Bitmap.Config.ARGB_8888);
                    pageOpenPage.render(bitmapCreateBitmap, null, null, i10);
                    pageOpenPage.close();
                    pdfViewer.m0(iMax, pageRect, bitmapCreateBitmap);
                    bitmapC0 = bitmapCreateBitmap;
                }
                arrayList.add(new DrawingPage(pageRect, bitmapC0, iMax, PdfViewer.M(rectFB, bitmapC0)));
                iMax++;
                i12 = 1;
            }
            Message message = new Message();
            message.what = 2;
            message.getData().putInt("index", i11);
            message.getData().putParcelableArrayList("list", arrayList);
            pdfViewer.f9879t.sendMessage(message);
        }
    }

    public PdfViewer(Context context) {
        super(context);
        this.f9873n = new ArrayList();
        this.f9874o = new ArrayList();
        this.f9875p = new ArrayList();
        this.f9876q = 0.0f;
        this.f9877r = 0.0f;
        this.f9878s = new GestureDetector(getContext(), new d(this));
        this.f9879t = new f(this);
        this.f9880u = new Paint();
        this.f9881v = new Paint();
        this.f9882w = S(8);
        this.f9883x = S(8);
        this.f9884y = S(8);
        this.f9885z = S(8);
        this.A = 1.0f;
        this.B = new PointF();
        this.C = new PointF();
        this.D = this.A;
        this.E = 0.0f;
        this.F = new PointF();
        this.G = new PointF();
        this.H = true;
        this.I = 10.0f;
        this.J = 0.5f;
        this.K = 0;
        this.L = new OverScroller(getContext());
        this.M = null;
        this.N = 0;
        this.O = false;
        this.P = false;
        this.Q = 0;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = 2;
        this.W = Q();
        this.f9863a0 = getDiskLruCache();
        this.f9864b0 = null;
        this.f9866c0 = new r5.a.b(this).a();
        this.f9867d0 = new int[]{-1, -1};
        this.f9869e0 = S(24);
        g0();
    }

    public static float M(RectF rectF, Bitmap bitmap) {
        if (rectF == null || bitmap == null || bitmap.getWidth() <= 0) {
            return 1.0f;
        }
        return rectF.width() / bitmap.getWidth();
    }

    private e4.a getDiskLruCache() {
        try {
            File externalCacheDir = getContext().getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = getContext().getCacheDir();
            }
            File file = new File(externalCacheDir, "pdf_viewer");
            if (file.exists() && file.isFile() && !file.delete()) {
                return null;
            }
            if (file.exists() || file.mkdirs()) {
                return e4.a.t(file, 1, 1, 20971520L);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getDisplayedPageRange() {
        int[] iArr = {-1, -1};
        if (!this.f9873n.isEmpty()) {
            float f10 = this.A;
            float fAbs = Math.abs(f10 == 0.0f ? this.B.y : this.B.y / f10);
            float measuredHeight = (this.A == 0.0f ? getMeasuredHeight() : getMeasuredHeight() / this.A) + fAbs;
            int size = this.f9873n.size();
            int i10 = 0;
            while (i10 < size && ((PageRect) this.f9873n.get(i10)).b().bottom <= fAbs) {
                i10++;
            }
            iArr[0] = i10;
            int i11 = size - 1;
            while (i11 >= 0 && ((PageRect) this.f9873n.get(i11)).b().top >= measuredHeight) {
                i11--;
            }
            iArr[1] = i11;
            if (i11 < iArr[0]) {
                iArr[0] = i11;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMinTranslateY() {
        return Math.min(getHeight() - (this.A * this.f9877r), 0.0f);
    }

    private int getVerticalScrollExtentCompat() {
        return Math.max(0, getHeight());
    }

    private int getVerticalScrollOffsetCompat() {
        return Math.min(Math.max(0, Math.round(-this.B.y)), Math.max(0, Math.round(this.f9877r * this.A) - getHeight()));
    }

    private int getVerticalScrollRangeCompat() {
        int verticalScrollExtentCompat = getVerticalScrollExtentCompat();
        float f10 = this.f9877r;
        return f10 <= 0.0f ? verticalScrollExtentCompat : Math.max(verticalScrollExtentCompat, Math.round(f10 * this.A));
    }

    public final void N() {
        int[] displayedPageRange = getDisplayedPageRange();
        int i10 = 0;
        int i11 = displayedPageRange[0];
        if (i11 < 0) {
            return;
        }
        if (i11 == displayedPageRange[1]) {
            if (this.R != i11) {
                this.R = i11;
                j0();
                return;
            }
            return;
        }
        float f10 = this.A;
        float fAbs = Math.abs(f10 == 0.0f ? this.B.y : this.B.y / f10);
        float measuredHeight = (this.A == 0.0f ? getMeasuredHeight() : getMeasuredHeight() / this.A) + fAbs;
        int i12 = this.R;
        for (int i13 = displayedPageRange[0]; i13 <= displayedPageRange[1]; i13++) {
            RectF rectF = ((PageRect) this.f9873n.get(i13)).f9891e;
            int iMin = (int) (Math.min(rectF.bottom, measuredHeight) - Math.max(rectF.top, fAbs));
            if (iMin > i10) {
                i12 = i13;
                i10 = iMin;
            }
        }
        if (i12 != this.R) {
            this.R = i12;
            j0();
            v0();
        }
        x0();
    }

    public final void O() {
        if (this.f9875p.isEmpty()) {
            return;
        }
        Future future = this.T;
        if (future != null && !future.isDone()) {
            this.T.cancel(true);
        }
        this.f9875p.clear();
        invalidate();
    }

    public final void P() {
        PdfRenderer pdfRenderer = this.f9865c;
        if (pdfRenderer == null) {
            return;
        }
        pdfRenderer.close();
        this.f9865c = null;
    }

    public final LruCache Q() {
        return new a(Math.max(8192, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8));
    }

    public final float R(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f11;
        double d10 = f14 * f14;
        double d11 = f12 - f13;
        Double.isNaN(d11);
        Double.isNaN(d11);
        Double.isNaN(d10);
        return (float) Math.sqrt(d10 + (d11 * d11));
    }

    public final int S(int i10) {
        return (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
    }

    public final void T(Canvas canvas) {
        if (this.f9873n.isEmpty()) {
            return;
        }
        float f10 = this.B.y + (this.f9877r * this.A);
        if (f10 >= getHeight()) {
            return;
        }
        canvas.drawRect(0.0f, Math.max(0.0f, f10), getWidth(), getHeight(), this.f9881v);
    }

    public final void U(Canvas canvas) {
        if (this.f9873n.isEmpty()) {
            return;
        }
        RectF rectFB = ((PageRect) this.f9873n.get(0)).b();
        List list = this.f9873n;
        RectF rectFB2 = ((PageRect) list.get(list.size() - 1)).b();
        canvas.drawRect(getPaddingLeft(), 0.0f, getWidth() - getPaddingRight(), rectFB.top, this.f9881v);
        canvas.drawRect(getPaddingLeft(), rectFB2.bottom, getWidth() - getPaddingRight(), rectFB2.bottom + this.f9884y, this.f9881v);
        canvas.drawRect(getPaddingLeft(), rectFB.top, getPaddingLeft() + this.f9882w, rectFB2.bottom, this.f9881v);
        canvas.drawRect((getWidth() - getPaddingRight()) - this.f9882w, rectFB.top, getWidth() - getPaddingRight(), rectFB2.bottom, this.f9881v);
    }

    public final void V(Canvas canvas) {
        if (this.f9873n.isEmpty()) {
            return;
        }
        float f10 = this.B.x;
        if (f10 <= 0.0f) {
            return;
        }
        int iCeil = (int) Math.ceil(f10);
        canvas.drawRect(getPaddingLeft(), 0.0f, iCeil, getMeasuredHeight(), this.f9881v);
        canvas.drawRect((getWidth() - getPaddingRight()) - iCeil, 0.0f, getWidth() - getPaddingRight(), getHeight(), this.f9881v);
    }

    public final void W(Canvas canvas) {
        for (DrawingPage drawingPage : this.f9874o) {
            if (drawingPage.f9886c != null && drawingPage.f9886c.f9891e != null && drawingPage.e() != null) {
                Iterator it = this.f9875p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        RectF rectF = drawingPage.f9886c.f9891e;
                        float f10 = drawingPage.f9889n <= 0.0f ? 1.0f : drawingPage.f9889n;
                        canvas.save();
                        canvas.translate(rectF.left, rectF.top);
                        canvas.scale(f10, f10);
                        canvas.drawBitmap(drawingPage.e(), 0.0f, 0.0f, this.f9880u);
                        canvas.restore();
                        break;
                    }
                    DrawingPage drawingPage2 = (DrawingPage) it.next();
                    if (drawingPage2.f9886c != null && drawingPage2.f9886c.f9891e != null && drawingPage2.f9887e != null && drawingPage2.f9888m == drawingPage.f9888m) {
                        break;
                    }
                }
            }
        }
    }

    public final void X(Canvas canvas) {
        Canvas canvas2;
        int size = this.f9873n.size();
        int i10 = 0;
        while (i10 < size) {
            RectF rectF = ((PageRect) this.f9873n.get(i10)).f9891e;
            canvas.drawRect(rectF, this.f9880u);
            if (i10 < size - 1) {
                canvas2 = canvas;
                canvas2.drawRect(getPaddingLeft(), rectF.bottom, getMeasuredWidth() - getPaddingRight(), rectF.bottom + this.f9885z, this.f9881v);
            } else {
                canvas2 = canvas;
            }
            i10++;
            canvas = canvas2;
        }
    }

    public final void Y(Canvas canvas) {
        for (DrawingPage drawingPage : this.f9875p) {
            if (drawingPage.f9886c != null && drawingPage.f9886c.f9891e != null && drawingPage.f9887e != null) {
                RectF rectF = drawingPage.f9886c.f9891e;
                float f10 = drawingPage.f9889n <= 0.0f ? 1.0f : drawingPage.f9889n;
                canvas.save();
                canvas.translate(rectF.left, rectF.top);
                canvas.scale(f10, f10);
                canvas.drawBitmap(drawingPage.e(), 0.0f, 0.0f, this.f9880u);
                canvas.restore();
            }
        }
    }

    public final String Z(int i10, PageRect pageRect) {
        int iRound = 0;
        int iRound2 = (pageRect == null || pageRect.b() == null) ? 0 : Math.round(pageRect.b().width());
        if (pageRect != null && pageRect.b() != null) {
            iRound = Math.round(pageRect.b().height());
        }
        try {
            return i0(this.f9868e + "_" + this.f9872m + "_" + i10 + "_" + iRound2 + "_" + iRound);
        } catch (Exception e10) {
            e10.printStackTrace();
            return this.f9868e.hashCode() + "_" + this.f9872m + "_" + i10 + "_" + iRound2 + "_" + iRound;
        }
    }

    @Override // r5.a.c
    public int a() {
        return getVerticalScrollRangeCompat();
    }

    public final float a0(float f10) {
        float f11 = this.f9876q * this.A;
        float width = getWidth();
        if (this.A < 1.0f) {
            return Math.max((width - f11) / 2.0f, 0.0f);
        }
        if (f10 > 0.0f) {
            return 0.0f;
        }
        return Math.max(f10, Math.min(width - f11, 0.0f));
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.f9866c0.c();
    }

    @Override // r5.a.c
    public void b(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    public final float b0(float f10) {
        if (f10 > 0.0f) {
            return 0.0f;
        }
        return Math.max(f10, getMinTranslateY());
    }

    @Override // r5.a.c
    public int c() {
        return getVerticalScrollExtentCompat();
    }

    public final Bitmap c0(int i10, PageRect pageRect) {
        String strZ = Z(i10, pageRect);
        Bitmap bitmapD0 = d0(strZ);
        return bitmapD0 == null ? e0(strZ) : bitmapD0;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        boolean z10 = false;
        if (!this.L.computeScrollOffset()) {
            if (this.O) {
                this.O = false;
                this.P = false;
                v0();
                return;
            }
            return;
        }
        float f10 = this.B.y;
        float fA0 = a0(this.L.getCurrX());
        float fB0 = b0(this.L.getCurrY());
        z0(fA0, fB0, true);
        float minTranslateY = getMinTranslateY();
        boolean z11 = f10 < 0.0f && fB0 >= 0.0f;
        if (f10 > minTranslateY && fB0 <= minTranslateY) {
            z10 = true;
        }
        if (this.O && !this.P && (z11 || z10)) {
            this.P = true;
            this.N = z11 ? 1 : 2;
            setPivotY(z11 ? 0.0f : getHeight());
            float currVelocity = this.L.getCurrVelocity();
            if (!z11) {
                currVelocity = -currVelocity;
            }
            e(currVelocity);
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return getVerticalScrollExtentCompat();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return getVerticalScrollOffsetCompat();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return getVerticalScrollRangeCompat();
    }

    @Override // r5.a.c
    public int d() {
        return getVerticalScrollOffsetCompat();
    }

    public final Bitmap d0(String str) {
        return (Bitmap) this.W.get(str);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.A < 1.0f) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.Q == 2 || this.B.x != 0.0f) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9870f0 = motionEvent.getX();
            this.f9871g0 = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float x10 = motionEvent.getX() - this.f9870f0;
            float y10 = motionEvent.getY() - this.f9871g0;
            if (Math.abs(x10) > 10.0f && Math.abs(x10) > Math.abs(y10) && this.B.x == 0.0f) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f10) {
        if (f10 == 0.0f || getHeight() == 0) {
            return;
        }
        d0.d dVar = this.M;
        if (dVar != null) {
            dVar.b();
        }
        float fMin = Math.min(0.05f, (Math.abs(f10) / 20000.0f) * 0.25f);
        if (fMin <= 0.0f) {
            return;
        }
        setScaleY(fMin + 1.0f);
        p0();
    }

    public final Bitmap e0(String str) throws Throwable {
        e4.a aVar = this.f9863a0;
        Bitmap bitmapDecodeFileDescriptor = null;
        if (aVar == null) {
            return null;
        }
        try {
            e4.a.e eVarR = aVar.r(str);
            if (eVarR == null) {
                return null;
            }
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(((FileInputStream) eVarR.a(0)).getFD(), null, new BitmapFactory.Options());
            if (bitmapDecodeFileDescriptor == null) {
                return bitmapDecodeFileDescriptor;
            }
            o0(str, bitmapDecodeFileDescriptor);
            return bitmapDecodeFileDescriptor;
        } catch (Exception e10) {
            e10.printStackTrace();
            return bitmapDecodeFileDescriptor;
        }
    }

    public final void f0(float f10) {
        if (getHeight() == 0 || f10 == 0.0f) {
            return;
        }
        int i10 = f10 > 0.0f ? 1 : 2;
        if (this.N != i10) {
            this.N = i10;
            setPivotY(i10 == 1 ? 0.0f : getHeight());
        }
        d0.d dVar = this.M;
        if (dVar != null) {
            dVar.b();
        }
        float scaleY = getScaleY();
        float fAbs = (Math.abs(f10) / getHeight()) * 0.15f * Math.max(0.0f, Math.min(1.0f, (1.05f - scaleY) / 0.05f));
        if (fAbs == 0.0f) {
            return;
        }
        setScaleY(Math.min(1.05f, Math.max(1.0f, scaleY + fAbs)));
    }

    public final void g0() {
        this.f9880u.setColor(-1);
        this.f9880u.setAntiAlias(true);
        this.f9880u.setFilterBitmap(true);
        this.f9880u.setDither(true);
        this.f9881v.setColor(-10066330);
        this.f9881v.setAntiAlias(true);
        this.K = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    }

    @Override // r5.a.c
    public r5.a getFastScrollDelegate() {
        return this.f9866c0;
    }

    public boolean h0() {
        return this.A > 1.0f;
    }

    public final String i0(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("The value to md5 can not be null");
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes("UTF-8"));
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }

    public final void j0() {
        e eVar = this.f9864b0;
        if (eVar != null) {
            eVar.a(this.R, this.f9873n.size());
        }
    }

    public final boolean k0(MotionEvent motionEvent) {
        if (!this.H) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            v0();
            return true;
        }
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                return false;
            }
            this.E = R(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
            this.D = this.A;
            this.C.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            this.F.set(this.B);
            return this.H;
        }
        if (motionEvent.getPointerCount() < 2) {
            return false;
        }
        this.A = Math.min(Math.max(this.J, (R(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1)) / this.E) * this.D), this.I);
        float x10 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        float y10 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        PointF pointF = this.C;
        float f10 = pointF.x;
        PointF pointF2 = this.F;
        float f11 = f10 - pointF2.x;
        float f12 = pointF.y - pointF2.y;
        float f13 = this.A;
        float f14 = this.D;
        y0(a0(x10 - (f11 * (f13 / f14))), b0(y10 - (f12 * (f13 / f14))), this.G);
        PointF pointF3 = this.G;
        z0(pointF3.x, pointF3.y, true);
        return true;
    }

    public final void l0(Canvas canvas) {
        PointF pointF = this.B;
        canvas.translate(pointF.x, pointF.y);
        float f10 = this.A;
        canvas.scale(f10, f10);
    }

    public final void m0(int i10, PageRect pageRect, Bitmap bitmap) {
        String strZ = Z(i10, pageRect);
        o0(strZ, bitmap);
        n0(strZ, bitmap);
    }

    public final void n0(String str, Bitmap bitmap) {
        e4.a aVar = this.f9863a0;
        if (aVar == null) {
            return;
        }
        try {
            e4.a.c cVarP = aVar.p(str);
            if (cVarP == null) {
                return;
            }
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, cVarP.f(0));
            cVarP.e();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void o0(String str, Bitmap bitmap) {
        this.W.put(str, bitmap);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9866c0.i();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f9866c0.j();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9873n.isEmpty()) {
            this.f9866c0.e(canvas);
            return;
        }
        canvas.save();
        l0(canvas);
        X(canvas);
        W(canvas);
        Y(canvas);
        U(canvas);
        canvas.restore();
        T(canvas);
        V(canvas);
        this.f9866c0.e(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i10), getSuggestedMinimumWidth()), Math.max(View.MeasureSpec.getSize(i11), getSuggestedMinimumHeight()));
        if (this.U == null) {
            this.U = f9862h0.submit(new c(this));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zK0;
        if (this.f9866c0.n(motionEvent)) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Q = 1;
            u0();
            this.f9867d0 = getDisplayedPageRange();
            this.f9878s.onTouchEvent(motionEvent);
            zK0 = true;
        } else if (actionMasked == 1) {
            int i10 = this.Q;
            if (i10 == 1) {
                if (!this.f9878s.onTouchEvent(motionEvent)) {
                    p0();
                    v0();
                }
                zK0 = true;
            } else {
                zK0 = i10 == 2 ? k0(motionEvent) : false;
            }
            this.Q = 0;
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                p0();
                this.Q = 0;
            } else if (actionMasked == 5) {
                this.Q = 2;
                u0();
                zK0 = k0(motionEvent);
            }
            zK0 = false;
        } else {
            int i11 = this.Q;
            if (i11 == 1) {
                zK0 = this.f9878s.onTouchEvent(motionEvent);
            } else if (i11 == 2) {
                O();
                zK0 = k0(motionEvent);
            } else {
                zK0 = false;
            }
        }
        return zK0 || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        r5.a aVar = this.f9866c0;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f9866c0.q(i10);
    }

    public final void p0() {
        if (getScaleY() == 1.0f) {
            this.N = 0;
            return;
        }
        d0.d dVar = this.M;
        if (dVar == null || !dVar.f()) {
            d0.d dVar2 = this.M;
            if (dVar2 != null) {
                dVar2.b();
            }
            d0.d dVarO = new d0.d(this, d0.b.f3810q).o(new d0.e().e(1.0f).d(0.75f).f(200.0f));
            this.M = dVarO;
            dVarO.j();
            this.N = 0;
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void q0() {
        u0();
        d0.d dVar = this.M;
        if (dVar != null) {
            dVar.b();
        }
        setScaleY(1.0f);
        this.N = 0;
        this.f9873n.clear();
        this.f9874o.clear();
        this.f9875p.clear();
        this.f9876q = 0.0f;
        this.f9877r = 0.0f;
        this.A = 1.0f;
        this.B.set(0.0f, 0.0f);
        this.R = 0;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    public void r0(Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            if ("file".equals(uri.getScheme())) {
                String path = uri.getPath();
                if (path != null) {
                    parcelFileDescriptorOpenFileDescriptor = ParcelFileDescriptor.open(new File(path), 268435456);
                } else {
                    parcelFileDescriptorOpenFileDescriptor = null;
                }
            } else if ("content".equals(uri.getScheme())) {
                parcelFileDescriptorOpenFileDescriptor = getContext().getContentResolver().openFileDescriptor(uri, "r");
            } else {
                parcelFileDescriptorOpenFileDescriptor = null;
            }
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                return;
            }
            P();
            q0();
            this.f9865c = new PdfRenderer(parcelFileDescriptorOpenFileDescriptor);
            this.f9868e = uri.toString();
            this.U = null;
            invalidate();
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void s0(String str) {
        try {
            File file = new File(str);
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
            P();
            q0();
            this.f9865c = new PdfRenderer(parcelFileDescriptorOpen);
            this.f9868e = file.getName();
            this.f9872m = file.lastModified();
            this.U = null;
            invalidate();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        scrollTo(Math.max(0, Math.round(-this.B.x)) + i10, getVerticalScrollOffsetCompat() + i11);
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        u0();
        p0();
        z0(a0(-i10), b0(-i11), true);
    }

    public void setMaxScale(float f10) {
        this.I = Math.min(f10, 20.0f);
    }

    public void setMinScale(float f10) {
        this.J = Math.max(0.25f, f10);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("limit must >= 1");
        }
        if (i10 != this.V) {
            this.V = i10;
        }
    }

    public void setOnPageChangedListener(e eVar) {
        this.f9864b0 = eVar;
    }

    public final void t0(float f10, float f11) {
        int iFloor;
        int i10;
        float f12 = this.f9876q * this.A;
        if (f12 <= getWidth()) {
            iFloor = Math.round(a0(this.B.x));
            i10 = iFloor;
        } else {
            iFloor = (int) Math.floor(Math.min(getWidth() - f12, 0.0f));
            i10 = 0;
        }
        this.L.fling(Math.round(this.B.x), Math.round(this.B.y), Math.round(f10), Math.round(f11), iFloor, i10, (int) Math.floor(Math.min(getHeight() - (this.f9877r * this.A), 0.0f)), 0);
        if (this.L.isFinished()) {
            this.O = false;
            this.P = false;
            v0();
        } else {
            this.O = true;
            this.P = false;
            postInvalidateOnAnimation();
        }
    }

    public final void u0() {
        if (!this.L.isFinished()) {
            this.L.abortAnimation();
        }
        this.O = false;
        this.P = false;
    }

    public final void v0() {
        Future future = this.S;
        if (future != null && !future.isDone()) {
            this.S.cancel(true);
        }
        this.S = f9862h0.submit(new g(this));
    }

    public final void w0() {
        if (this.Q != 0) {
            return;
        }
        Future future = this.T;
        if (future != null && !future.isDone()) {
            this.T.cancel(true);
        }
        this.T = f9862h0.submit(new b(this));
    }

    public final void x0() {
        if (this.f9875p.isEmpty()) {
            return;
        }
        int[] displayedPageRange = getDisplayedPageRange();
        boolean z10 = false;
        int i10 = displayedPageRange[0];
        if (i10 < 0 || displayedPageRange[1] < 0) {
            return;
        }
        int iMax = Math.max(0, i10 - 1);
        int iMin = Math.min(this.f9873n.size() - 1, displayedPageRange[1] + 1);
        for (int size = this.f9875p.size() - 1; size >= 0; size--) {
            int i11 = ((DrawingPage) this.f9875p.get(size)).f9888m;
            if (i11 < iMax || i11 > iMin) {
                this.f9875p.remove(size);
                z10 = true;
            }
        }
        if (z10) {
            invalidate();
        }
    }

    public final void y0(float f10, float f11, PointF pointF) {
        if (Math.abs(this.A - 1.0f) > 0.06f) {
            pointF.set(f10, f11);
            return;
        }
        float fA0 = a0(0.0f);
        if (Math.abs(f10 - fA0) > this.f9869e0 || Math.abs(f11 - 0.0f) > this.f9869e0) {
            pointF.set(f10, f11);
        } else {
            this.A = 1.0f;
            pointF.set(fA0, 0.0f);
        }
    }

    public final boolean z0(float f10, float f11, boolean z10) {
        PointF pointF = this.B;
        if (f10 == pointF.x && f11 == pointF.y) {
            return false;
        }
        pointF.set(f10, f11);
        invalidate();
        N();
        if (!z10) {
            return true;
        }
        awakenScrollBars();
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class DrawingPage implements Parcelable {
        public static final Parcelable.Creator<DrawingPage> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PageRect f9886c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bitmap f9887e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f9888m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f9889n;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DrawingPage createFromParcel(Parcel parcel) {
                return new DrawingPage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public DrawingPage[] newArray(int i10) {
                return new DrawingPage[i10];
            }
        }

        public DrawingPage(Parcel parcel) {
            this((PageRect) parcel.readParcelable(PageRect.class.getClassLoader()), (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader()), parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bitmap e() {
            return this.f9887e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f9886c, i10);
            parcel.writeParcelable(this.f9887e, i10);
            parcel.writeInt(this.f9888m);
            parcel.writeFloat(this.f9889n);
        }

        public DrawingPage(PageRect pageRect, Bitmap bitmap, int i10, float f10) {
            this.f9886c = pageRect;
            this.f9887e = bitmap;
            this.f9888m = i10;
            this.f9889n = f10;
        }
    }

    @Override // r5.a.c
    public View getFastScrollableView() {
        return this;
    }
}
