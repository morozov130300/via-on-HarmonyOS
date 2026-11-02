package t5;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tuyafeng.scanner.BarcodeView;
import com.tuyafeng.scanner.camera.CameraSettings;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public BarcodeView f12200e;

    /* renamed from: j, reason: collision with root package name */
    public y f12201j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12202k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements t5.a {

        /* renamed from: a, reason: collision with root package name */
        public t5.a f12203a;

        public b(t5.a aVar) {
            this.f12203a = aVar;
        }

        @Override // t5.a
        public void a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k.this.f12201j.a(((e) it.next()).a());
            }
            this.f12203a.a(list);
        }

        @Override // t5.a
        public void b(d dVar) {
            this.f12203a.b(dVar);
        }
    }

    public k(Context context) {
        super(context);
        c();
    }

    public void b(t5.a aVar) {
        this.f12200e.G(new b(aVar));
    }

    public final void c() {
        d(null);
    }

    public final void d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f12237l);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(r.f12238m, q.f12225a);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(p.f12214a);
        this.f12200e = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.q(attributeSet);
        y yVar = (y) findViewById(p.f12224k);
        this.f12201j = yVar;
        if (yVar == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        yVar.setCameraPreview(this.f12200e);
        this.f12202k = (TextView) findViewById(p.f12223j);
    }

    public void e() {
        this.f12200e.t();
    }

    public void f() {
        this.f12200e.w();
    }

    public void g() {
        this.f12200e.setTorch(false);
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(p.f12214a);
    }

    public CameraSettings getCameraSettings() {
        return this.f12200e.getCameraSettings();
    }

    public h getDecoderFactory() {
        return this.f12200e.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f12202k;
    }

    public y getViewFinder() {
        return this.f12201j;
    }

    public void h() {
        this.f12200e.setTorch(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 24) {
            h();
            return true;
        }
        if (i10 == 25) {
            g();
            return true;
        }
        if (i10 == 27 || i10 == 80) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f12200e.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(h hVar) {
        this.f12200e.setDecoderFactory(hVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f12202k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }
}
