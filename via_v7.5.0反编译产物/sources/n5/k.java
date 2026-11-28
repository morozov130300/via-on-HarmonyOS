package n5;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BarcodeView f10629c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f10630e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f10631m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements n5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n5.a f10632a;

        public b(n5.a aVar) {
            this.f10632a = aVar;
        }

        @Override // n5.a
        public void a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k.this.f10630e.a(((e) it.next()).a());
            }
            this.f10632a.a(list);
        }

        @Override // n5.a
        public void b(d dVar) {
            this.f10632a.b(dVar);
        }
    }

    public k(Context context) {
        super(context);
        c();
    }

    public void b(n5.a aVar) {
        this.f10629c.G(new b(aVar));
    }

    public final void c() {
        d(null);
    }

    public final void d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f10666l);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(r.f10667m, q.f10654a);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(p.f10643a);
        this.f10629c = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.q(attributeSet);
        y yVar = (y) findViewById(p.f10653k);
        this.f10630e = yVar;
        if (yVar == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        yVar.setCameraPreview(this.f10629c);
        this.f10631m = (TextView) findViewById(p.f10652j);
    }

    public void e() {
        this.f10629c.t();
    }

    public void f() {
        this.f10629c.w();
    }

    public void g() {
        this.f10629c.setTorch(false);
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(p.f10643a);
    }

    public CameraSettings getCameraSettings() {
        return this.f10629c.getCameraSettings();
    }

    public h getDecoderFactory() {
        return this.f10629c.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f10631m;
    }

    public y getViewFinder() {
        return this.f10630e;
    }

    public void h() {
        this.f10629c.setTorch(true);
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
        this.f10629c.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(h hVar) {
        this.f10629c.setDecoderFactory(hVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f10631m;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }
}
