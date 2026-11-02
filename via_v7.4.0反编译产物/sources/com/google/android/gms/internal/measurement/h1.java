package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface h1 extends IInterface {
    void beginAdUnitExposure(String str, long j10);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j10);

    void endAdUnitExposure(String str, long j10);

    void generateEventId(k1 k1Var);

    void getAppInstanceId(k1 k1Var);

    void getCachedAppInstanceId(k1 k1Var);

    void getConditionalUserProperties(String str, String str2, k1 k1Var);

    void getCurrentScreenClass(k1 k1Var);

    void getCurrentScreenName(k1 k1Var);

    void getGmpAppId(k1 k1Var);

    void getMaxUserProperties(String str, k1 k1Var);

    void getSessionId(k1 k1Var);

    void getTestFlag(k1 k1Var, int i10);

    void getUserProperties(String str, String str2, boolean z10, k1 k1Var);

    void initForTests(Map map);

    void initialize(y1.a aVar, zzcl zzclVar, long j10);

    void isDataCollectionEnabled(k1 k1Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10);

    void logEventAndBundle(String str, String str2, Bundle bundle, k1 k1Var, long j10);

    void logHealthData(int i10, String str, y1.a aVar, y1.a aVar2, y1.a aVar3);

    void onActivityCreated(y1.a aVar, Bundle bundle, long j10);

    void onActivityDestroyed(y1.a aVar, long j10);

    void onActivityPaused(y1.a aVar, long j10);

    void onActivityResumed(y1.a aVar, long j10);

    void onActivitySaveInstanceState(y1.a aVar, k1 k1Var, long j10);

    void onActivityStarted(y1.a aVar, long j10);

    void onActivityStopped(y1.a aVar, long j10);

    void performAction(Bundle bundle, k1 k1Var, long j10);

    void registerOnMeasurementEventListener(n1 n1Var);

    void resetAnalyticsData(long j10);

    void setConditionalUserProperty(Bundle bundle, long j10);

    void setConsent(Bundle bundle, long j10);

    void setConsentThirdParty(Bundle bundle, long j10);

    void setCurrentScreen(y1.a aVar, String str, String str2, long j10);

    void setDataCollectionEnabled(boolean z10);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(n1 n1Var);

    void setInstanceIdProvider(p1 p1Var);

    void setMeasurementEnabled(boolean z10, long j10);

    void setMinimumSessionDuration(long j10);

    void setSessionTimeoutDuration(long j10);

    void setUserId(String str, long j10);

    void setUserProperty(String str, String str2, y1.a aVar, boolean z10, long j10);

    void unregisterOnMeasurementEventListener(n1 n1Var);
}
