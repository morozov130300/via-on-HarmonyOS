package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import y1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g1 extends p0 implements h1 {
    public g1() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static h1 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof h1 ? (h1) iInterfaceQueryLocalInterface : new f1(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.p0
    public final boolean Y(int i10, Parcel parcel, Parcel parcel2, int i11) {
        k1 i1Var = null;
        k1 i1Var2 = null;
        k1 i1Var3 = null;
        k1 i1Var4 = null;
        n1 l1Var = null;
        n1 l1Var2 = null;
        n1 l1Var3 = null;
        k1 i1Var5 = null;
        k1 i1Var6 = null;
        k1 i1Var7 = null;
        k1 i1Var8 = null;
        k1 i1Var9 = null;
        k1 i1Var10 = null;
        p1 o1Var = null;
        k1 i1Var11 = null;
        k1 i1Var12 = null;
        k1 i1Var13 = null;
        k1 i1Var14 = null;
        k1 i1Var15 = null;
        switch (i10) {
            case 1:
                y1.a aVarZ = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                zzcl zzclVar = (zzcl) q0.a(parcel, zzcl.CREATOR);
                long j10 = parcel.readLong();
                q0.c(parcel);
                initialize(aVarZ, zzclVar, j10);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) q0.a(parcel, Bundle.CREATOR);
                boolean zF = q0.f(parcel);
                boolean zF2 = q0.f(parcel);
                long j11 = parcel.readLong();
                q0.c(parcel);
                logEvent(string, string2, bundle, zF, zF2, j11);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var = iInterfaceQueryLocalInterface instanceof k1 ? (k1) iInterfaceQueryLocalInterface : new i1(strongBinder);
                }
                long j12 = parcel.readLong();
                q0.c(parcel);
                logEventAndBundle(string3, string4, bundle2, i1Var, j12);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                y1.a aVarZ2 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                boolean zF3 = q0.f(parcel);
                long j13 = parcel.readLong();
                q0.c(parcel);
                setUserProperty(string5, string6, aVarZ2, zF3, j13);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zF4 = q0.f(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var15 = iInterfaceQueryLocalInterface2 instanceof k1 ? (k1) iInterfaceQueryLocalInterface2 : new i1(strongBinder2);
                }
                q0.c(parcel);
                getUserProperties(string7, string8, zF4, i1Var15);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var14 = iInterfaceQueryLocalInterface3 instanceof k1 ? (k1) iInterfaceQueryLocalInterface3 : new i1(strongBinder3);
                }
                q0.c(parcel);
                getMaxUserProperties(string9, i1Var14);
                break;
            case 7:
                String string10 = parcel.readString();
                long j14 = parcel.readLong();
                q0.c(parcel);
                setUserId(string10, j14);
                break;
            case 8:
                Bundle bundle3 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                long j15 = parcel.readLong();
                q0.c(parcel);
                setConditionalUserProperty(bundle3, j15);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                q0.c(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var13 = iInterfaceQueryLocalInterface4 instanceof k1 ? (k1) iInterfaceQueryLocalInterface4 : new i1(strongBinder4);
                }
                q0.c(parcel);
                getConditionalUserProperties(string13, string14, i1Var13);
                break;
            case 11:
                boolean zF5 = q0.f(parcel);
                long j16 = parcel.readLong();
                q0.c(parcel);
                setMeasurementEnabled(zF5, j16);
                break;
            case 12:
                long j17 = parcel.readLong();
                q0.c(parcel);
                resetAnalyticsData(j17);
                break;
            case 13:
                long j18 = parcel.readLong();
                q0.c(parcel);
                setMinimumSessionDuration(j18);
                break;
            case 14:
                long j19 = parcel.readLong();
                q0.c(parcel);
                setSessionTimeoutDuration(j19);
                break;
            case 15:
                y1.a aVarZ3 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j20 = parcel.readLong();
                q0.c(parcel);
                setCurrentScreen(aVarZ3, string15, string16, j20);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var12 = iInterfaceQueryLocalInterface5 instanceof k1 ? (k1) iInterfaceQueryLocalInterface5 : new i1(strongBinder5);
                }
                q0.c(parcel);
                getCurrentScreenName(i1Var12);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var11 = iInterfaceQueryLocalInterface6 instanceof k1 ? (k1) iInterfaceQueryLocalInterface6 : new i1(strongBinder6);
                }
                q0.c(parcel);
                getCurrentScreenClass(i1Var11);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    o1Var = iInterfaceQueryLocalInterface7 instanceof p1 ? (p1) iInterfaceQueryLocalInterface7 : new o1(strongBinder7);
                }
                q0.c(parcel);
                setInstanceIdProvider(o1Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var10 = iInterfaceQueryLocalInterface8 instanceof k1 ? (k1) iInterfaceQueryLocalInterface8 : new i1(strongBinder8);
                }
                q0.c(parcel);
                getCachedAppInstanceId(i1Var10);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var9 = iInterfaceQueryLocalInterface9 instanceof k1 ? (k1) iInterfaceQueryLocalInterface9 : new i1(strongBinder9);
                }
                q0.c(parcel);
                getAppInstanceId(i1Var9);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var8 = iInterfaceQueryLocalInterface10 instanceof k1 ? (k1) iInterfaceQueryLocalInterface10 : new i1(strongBinder10);
                }
                q0.c(parcel);
                getGmpAppId(i1Var8);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var7 = iInterfaceQueryLocalInterface11 instanceof k1 ? (k1) iInterfaceQueryLocalInterface11 : new i1(strongBinder11);
                }
                q0.c(parcel);
                generateEventId(i1Var7);
                break;
            case 23:
                String string17 = parcel.readString();
                long j21 = parcel.readLong();
                q0.c(parcel);
                beginAdUnitExposure(string17, j21);
                break;
            case 24:
                String string18 = parcel.readString();
                long j22 = parcel.readLong();
                q0.c(parcel);
                endAdUnitExposure(string18, j22);
                break;
            case 25:
                y1.a aVarZ4 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                long j23 = parcel.readLong();
                q0.c(parcel);
                onActivityStarted(aVarZ4, j23);
                break;
            case 26:
                y1.a aVarZ5 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                q0.c(parcel);
                onActivityStopped(aVarZ5, j24);
                break;
            case 27:
                y1.a aVarZ6 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                long j25 = parcel.readLong();
                q0.c(parcel);
                onActivityCreated(aVarZ6, bundle5, j25);
                break;
            case 28:
                y1.a aVarZ7 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                q0.c(parcel);
                onActivityDestroyed(aVarZ7, j26);
                break;
            case 29:
                y1.a aVarZ8 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                long j27 = parcel.readLong();
                q0.c(parcel);
                onActivityPaused(aVarZ8, j27);
                break;
            case 30:
                y1.a aVarZ9 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                long j28 = parcel.readLong();
                q0.c(parcel);
                onActivityResumed(aVarZ9, j28);
                break;
            case 31:
                y1.a aVarZ10 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var6 = iInterfaceQueryLocalInterface12 instanceof k1 ? (k1) iInterfaceQueryLocalInterface12 : new i1(strongBinder12);
                }
                long j29 = parcel.readLong();
                q0.c(parcel);
                onActivitySaveInstanceState(aVarZ10, i1Var6, j29);
                break;
            case 32:
                Bundle bundle6 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var5 = iInterfaceQueryLocalInterface13 instanceof k1 ? (k1) iInterfaceQueryLocalInterface13 : new i1(strongBinder13);
                }
                long j30 = parcel.readLong();
                q0.c(parcel);
                performAction(bundle6, i1Var5, j30);
                break;
            case 33:
                int i12 = parcel.readInt();
                String string19 = parcel.readString();
                y1.a aVarZ11 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                y1.a aVarZ12 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                y1.a aVarZ13 = a.AbstractBinderC0155a.Z(parcel.readStrongBinder());
                q0.c(parcel);
                logHealthData(i12, string19, aVarZ11, aVarZ12, aVarZ13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    l1Var3 = iInterfaceQueryLocalInterface14 instanceof n1 ? (n1) iInterfaceQueryLocalInterface14 : new l1(strongBinder14);
                }
                q0.c(parcel);
                setEventInterceptor(l1Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    l1Var2 = iInterfaceQueryLocalInterface15 instanceof n1 ? (n1) iInterfaceQueryLocalInterface15 : new l1(strongBinder15);
                }
                q0.c(parcel);
                registerOnMeasurementEventListener(l1Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    l1Var = iInterfaceQueryLocalInterface16 instanceof n1 ? (n1) iInterfaceQueryLocalInterface16 : new l1(strongBinder16);
                }
                q0.c(parcel);
                unregisterOnMeasurementEventListener(l1Var);
                break;
            case 37:
                HashMap mapB = q0.b(parcel);
                q0.c(parcel);
                initForTests(mapB);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var4 = iInterfaceQueryLocalInterface17 instanceof k1 ? (k1) iInterfaceQueryLocalInterface17 : new i1(strongBinder17);
                }
                int i13 = parcel.readInt();
                q0.c(parcel);
                getTestFlag(i1Var4, i13);
                break;
            case 39:
                boolean zF6 = q0.f(parcel);
                q0.c(parcel);
                setDataCollectionEnabled(zF6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var3 = iInterfaceQueryLocalInterface18 instanceof k1 ? (k1) iInterfaceQueryLocalInterface18 : new i1(strongBinder18);
                }
                q0.c(parcel);
                isDataCollectionEnabled(i1Var3);
                break;
            case 41:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                q0.c(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j31 = parcel.readLong();
                q0.c(parcel);
                clearMeasurementEnabled(j31);
                break;
            case 44:
                Bundle bundle8 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                long j32 = parcel.readLong();
                q0.c(parcel);
                setConsent(bundle8, j32);
                break;
            case 45:
                Bundle bundle9 = (Bundle) q0.a(parcel, Bundle.CREATOR);
                long j33 = parcel.readLong();
                q0.c(parcel);
                setConsentThirdParty(bundle9, j33);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    i1Var2 = iInterfaceQueryLocalInterface19 instanceof k1 ? (k1) iInterfaceQueryLocalInterface19 : new i1(strongBinder19);
                }
                q0.c(parcel);
                getSessionId(i1Var2);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
