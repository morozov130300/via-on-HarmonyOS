package s0;

import androidx.webkit.JavaScriptExecutionException;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends r0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsReplyProxyBoundaryInterface f12139a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements ExecuteJavaScriptCallbackBoundaryInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0.m f12140a;

        public a(r0.m mVar) {
            this.f12140a = mVar;
        }

        @Override // org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface
        public void onFailure(int i10, String str) {
            this.f12140a.onError(new JavaScriptExecutionException(l.this.f(i10), str));
        }

        @Override // org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface
        public void onSuccess(String str) {
            this.f12140a.onResult(str);
        }
    }

    public l(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f12139a = jsReplyProxyBoundaryInterface;
    }

    public static /* synthetic */ Object c(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        return new l(jsReplyProxyBoundaryInterface);
    }

    public static l e(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) hc.b.a(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (l) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable() { // from class: s0.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return l.c(jsReplyProxyBoundaryInterface);
            }
        });
    }

    @Override // r0.c
    public void a(String str, r0.m mVar) {
        if (!v.P0.d()) {
            throw v.a();
        }
        this.f12139a.executeJavaScript(str, mVar == null ? null : hc.b.c(new a(mVar)));
    }

    @Override // r0.c
    public void b(String str) {
        if (!v.V.d()) {
            throw v.a();
        }
        this.f12139a.postMessage(str);
    }

    public final int f(int i10) {
        return i10 != 1 ? 0 : 1;
    }
}
