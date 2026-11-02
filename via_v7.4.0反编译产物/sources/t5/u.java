package t5;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public int f12242a;

    /* renamed from: b, reason: collision with root package name */
    public WindowManager f12243b;

    /* renamed from: c, reason: collision with root package name */
    public OrientationEventListener f12244c;

    /* renamed from: d, reason: collision with root package name */
    public t f12245d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends OrientationEventListener {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int rotation;
            WindowManager windowManager = u.this.f12243b;
            t tVar = u.this.f12245d;
            if (u.this.f12243b == null || tVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == u.this.f12242a) {
                return;
            }
            u.this.f12242a = rotation;
            tVar.a(rotation);
        }
    }

    public void e(Context context, t tVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f12245d = tVar;
        this.f12243b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f12244c = aVar;
        aVar.enable();
        this.f12242a = this.f12243b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f12244c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f12244c = null;
        this.f12243b = null;
        this.f12245d = null;
    }
}
