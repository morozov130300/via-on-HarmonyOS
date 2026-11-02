package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.firebase.analytics.FirebaseAnalytics;
import d2.b;
import d2.c;
import d2.e;
import f2.d6;
import f2.h5;
import f2.p7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    /* renamed from: b, reason: collision with root package name */
    public static volatile AppMeasurement f3945b;

    /* renamed from: a, reason: collision with root package name */
    public final e f3946a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty(Bundle bundle) {
            f.h(bundle);
            this.mAppId = (String) d6.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) d6.a(bundle, "origin", String.class, null);
            this.mName = (String) d6.a(bundle, "name", String.class, null);
            this.mValue = d6.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) d6.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) d6.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) d6.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) d6.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) d6.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) d6.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) d6.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) d6.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) d6.a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) d6.a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) d6.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) d6.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(h5 h5Var) {
        this.f3946a = new b(h5Var);
    }

    public AppMeasurement(p7 p7Var) {
        this.f3946a = new c(p7Var);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (f3945b == null) {
            synchronized (AppMeasurement.class) {
                if (f3945b == null) {
                    p7 p7Var = (p7) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (p7Var != null) {
                        f3945b = new AppMeasurement(p7Var);
                    } else {
                        f3945b = new AppMeasurement(h5.H(context, new zzcl(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return f3945b;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.f3946a.k(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f3946a.l(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.f3946a.m(str);
    }

    @Keep
    public long generateEventId() {
        return this.f3946a.a();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f3946a.e();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List listC = this.f3946a.c(str, str2);
        ArrayList arrayList = new ArrayList(listC == null ? 0 : listC.size());
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty((Bundle) it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f3946a.f();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f3946a.i();
    }

    @Keep
    public String getGmpAppId() {
        return this.f3946a.j();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        return this.f3946a.b(str);
    }

    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z10) {
        return this.f3946a.d(str, str2, z10);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.f3946a.h(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        f.h(conditionalUserProperty);
        e eVar = this.f3946a;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            d6.b(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        eVar.g(bundle);
    }
}
