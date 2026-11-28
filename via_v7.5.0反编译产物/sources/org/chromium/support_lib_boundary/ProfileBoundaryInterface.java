package org.chromium.support_lib_boundary;

import android.os.CancellationSignal;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface ProfileBoundaryInterface {
    void addOriginMatchedHeader(String str, String str2, Set<String> set);

    void addQuicHints(Set<String> set);

    void clearAllOriginMatchedHeaders();

    @Deprecated
    void clearOriginMatchedHeader(String str);

    void clearOriginMatchedHeader(String str, String str2);

    void clearPrefetch(String str, Executor executor, InvocationHandler invocationHandler);

    CookieManager getCookieManager();

    GeolocationPermissions getGeoLocationPermissions();

    int getMaxPrefetches();

    int getMaxPrerenders();

    String getName();

    List<InvocationHandler> getOriginMatchedHeaders(String str, String str2);

    int getPrefetchTtlSeconds();

    ServiceWorkerController getServiceWorkerController();

    WebStorage getWebStorage();

    boolean hasOriginMatchedHeader(String str);

    void preconnect(String str);

    void prefetchUrl(String str, CancellationSignal cancellationSignal, Executor executor, InvocationHandler invocationHandler);

    void prefetchUrl(String str, CancellationSignal cancellationSignal, Executor executor, InvocationHandler invocationHandler, InvocationHandler invocationHandler2);

    void setMaxPrefetches(Integer num);

    void setMaxPrerenders(Integer num);

    @Deprecated
    void setOriginMatchedHeader(String str, String str2, Set<String> set);

    void setPrefetchTtlSeconds(Integer num);

    void setSpeculativeLoadingConfig(InvocationHandler invocationHandler);

    void warmUpRendererProcess();
}
