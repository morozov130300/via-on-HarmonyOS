package mark.via.common;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import k8.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class SoftInputAssistObserver extends r implements f {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9542a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f9542a = iArr;
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9542a[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9542a[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SoftInputAssistObserver(Activity activity) {
        super(activity);
    }

    @Override // androidx.lifecycle.f
    public void a(h hVar, Lifecycle.Event event) {
        int i10 = a.f9542a[event.ordinal()];
        if (i10 == 1) {
            f();
        } else if (i10 == 2) {
            g();
        } else {
            if (i10 != 3) {
                return;
            }
            e();
        }
    }
}
