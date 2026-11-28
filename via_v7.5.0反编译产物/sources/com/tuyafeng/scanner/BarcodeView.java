package com.tuyafeng.scanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import n5.d;
import n5.e;
import n5.f;
import n5.g;
import n5.h;
import n5.i;
import n5.j;
import n5.l;
import n5.p;
import n5.x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class BarcodeView extends f {
    public DecodeMode L;
    public n5.a M;
    public j N;
    public h O;
    public Handler P;
    public final Handler.Callback Q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == p.f10648f) {
                d dVar = (d) message.obj;
                if (dVar != null && BarcodeView.this.M != null && BarcodeView.this.L != DecodeMode.NONE) {
                    BarcodeView.this.M.b(dVar);
                    if (BarcodeView.this.L == DecodeMode.SINGLE) {
                        BarcodeView.this.K();
                    }
                }
                return true;
            }
            if (i10 == p.f10647e) {
                return true;
            }
            if (i10 != p.f10649g) {
                return false;
            }
            List list = (List) message.obj;
            if (BarcodeView.this.M != null && BarcodeView.this.L != DecodeMode.NONE) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new e((k) it.next()));
                }
                BarcodeView.this.M.a(arrayList);
            }
            return true;
        }
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = DecodeMode.NONE;
        this.M = null;
        this.Q = new a();
        H();
    }

    public final g E() {
        if (this.O == null) {
            this.O = F();
        }
        i iVar = new i();
        HashMap map = new HashMap();
        map.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, iVar);
        g gVarA = this.O.a(map);
        iVar.b(gVarA);
        return gVarA;
    }

    public h F() {
        return new l();
    }

    public void G(n5.a aVar) {
        this.L = DecodeMode.CONTINUOUS;
        this.M = aVar;
        I();
    }

    public final void H() {
        this.O = new l();
        this.P = new Handler(this.Q);
    }

    public final void I() {
        J();
        if (this.L == DecodeMode.NONE || !s()) {
            return;
        }
        j jVar = new j(getCameraInstance(), E(), this.P);
        this.N = jVar;
        jVar.i(getPreviewFramingRect());
        this.N.k();
    }

    public final void J() {
        j jVar = this.N;
        if (jVar != null) {
            jVar.l();
            this.N = null;
        }
    }

    public void K() {
        this.L = DecodeMode.NONE;
        this.M = null;
        J();
    }

    public h getDecoderFactory() {
        return this.O;
    }

    public void setDecoderFactory(h hVar) {
        x.a();
        this.O = hVar;
        j jVar = this.N;
        if (jVar != null) {
            jVar.j(E());
        }
    }

    @Override // n5.f
    public void t() {
        J();
        super.t();
    }

    @Override // n5.f
    public void v() {
        super.v();
        I();
    }
}
