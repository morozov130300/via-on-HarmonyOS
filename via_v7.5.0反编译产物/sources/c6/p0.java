package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f2086a = new p0();

    public final String a(String secret, String view) {
        kotlin.jvm.internal.h.f(secret, "secret");
        kotlin.jvm.internal.h.f(view, "view");
        return "(function(){\"use strict\";function t(t){var e=\"" + secret + "\",n=JSON.stringify({action:101,runAt:t,from:" + view + "});window&&window.webkit?webkit.messageHandlers.viaAndroidBridgeMessageHandler.postMessage({key:e,msg:n}):window&&window.via&&window.via.postMessage(e,n)}try{t(1)}catch(t){}try{\"loading\"===document.readyState?document.addEventListener(\"DOMContentLoaded\",function(){t(2)}):t(2)}catch(t){}try{\"complete\"!==document.readyState?window.addEventListener(\"load\",function(){t(4)}):t(4)}catch(t){}})();";
    }
}
