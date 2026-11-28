package s0;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q implements WebMessageBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f12147a = {"WEB_MESSAGE_ARRAY_BUFFER"};

    public static r0.i[] a(InvocationHandler[] invocationHandlerArr) {
        r0.i[] iVarArr = new r0.i[invocationHandlerArr.length];
        for (int i10 = 0; i10 < invocationHandlerArr.length; i10++) {
            iVarArr[i10] = new s(invocationHandlerArr[i10]);
        }
        return iVarArr;
    }

    public static r0.h b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        r0.i[] iVarArrA = a(webMessageBoundaryInterface.getPorts());
        if (!v.C.d()) {
            return new r0.h(webMessageBoundaryInterface.getData(), iVarArrA);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) hc.b.a(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new r0.h(webMessagePayloadBoundaryInterface.getAsString(), iVarArrA);
        }
        if (type != 1) {
            return null;
        }
        return new r0.h(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), iVarArrA);
    }
}
