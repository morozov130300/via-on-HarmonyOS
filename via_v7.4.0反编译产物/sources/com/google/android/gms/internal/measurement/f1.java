package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f1 extends o0 implements h1 {
    public f1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void beginAdUnitExposure(String str, long j10) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeLong(j10);
        a0(23, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        q0.d(parcelY, bundle);
        a0(9, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void endAdUnitExposure(String str, long j10) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeLong(j10);
        a0(24, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void generateEventId(k1 k1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, k1Var);
        a0(22, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getCachedAppInstanceId(k1 k1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, k1Var);
        a0(19, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getConditionalUserProperties(String str, String str2, k1 k1Var) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        q0.e(parcelY, k1Var);
        a0(10, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getCurrentScreenClass(k1 k1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, k1Var);
        a0(17, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getCurrentScreenName(k1 k1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, k1Var);
        a0(16, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getGmpAppId(k1 k1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, k1Var);
        a0(21, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getMaxUserProperties(String str, k1 k1Var) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        q0.e(parcelY, k1Var);
        a0(6, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void getUserProperties(String str, String str2, boolean z10, k1 k1Var) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        ClassLoader classLoader = q0.f3696a;
        parcelY.writeInt(z10 ? 1 : 0);
        q0.e(parcelY, k1Var);
        a0(5, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void initialize(y1.a aVar, zzcl zzclVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        q0.d(parcelY, zzclVar);
        parcelY.writeLong(j10);
        a0(1, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        q0.d(parcelY, bundle);
        parcelY.writeInt(z10 ? 1 : 0);
        parcelY.writeInt(z11 ? 1 : 0);
        parcelY.writeLong(j10);
        a0(2, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void logHealthData(int i10, String str, y1.a aVar, y1.a aVar2, y1.a aVar3) {
        Parcel parcelY = Y();
        parcelY.writeInt(5);
        parcelY.writeString(str);
        q0.e(parcelY, aVar);
        q0.e(parcelY, aVar2);
        q0.e(parcelY, aVar3);
        a0(33, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityCreated(y1.a aVar, Bundle bundle, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        q0.d(parcelY, bundle);
        parcelY.writeLong(j10);
        a0(27, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityDestroyed(y1.a aVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeLong(j10);
        a0(28, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityPaused(y1.a aVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeLong(j10);
        a0(29, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityResumed(y1.a aVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeLong(j10);
        a0(30, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivitySaveInstanceState(y1.a aVar, k1 k1Var, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        q0.e(parcelY, k1Var);
        parcelY.writeLong(j10);
        a0(31, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityStarted(y1.a aVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeLong(j10);
        a0(25, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void onActivityStopped(y1.a aVar, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeLong(j10);
        a0(26, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void registerOnMeasurementEventListener(n1 n1Var) {
        Parcel parcelY = Y();
        q0.e(parcelY, n1Var);
        a0(35, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void setConditionalUserProperty(Bundle bundle, long j10) {
        Parcel parcelY = Y();
        q0.d(parcelY, bundle);
        parcelY.writeLong(j10);
        a0(8, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void setCurrentScreen(y1.a aVar, String str, String str2, long j10) {
        Parcel parcelY = Y();
        q0.e(parcelY, aVar);
        parcelY.writeString(str);
        parcelY.writeString(str2);
        parcelY.writeLong(j10);
        a0(15, parcelY);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void setDataCollectionEnabled(boolean z10) {
        Parcel parcelY = Y();
        ClassLoader classLoader = q0.f3696a;
        parcelY.writeInt(z10 ? 1 : 0);
        a0(39, parcelY);
    }
}
