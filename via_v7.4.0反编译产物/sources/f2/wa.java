package f2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.vc;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class wa extends b6 {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f5798g = {"firebase_", "google_", "ga_"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f5799h = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f5800c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f5801d;

    /* renamed from: e, reason: collision with root package name */
    public int f5802e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f5803f;

    public wa(h5 h5Var) {
        super(h5Var);
        this.f5803f = null;
        this.f5801d = new AtomicLong(0L);
    }

    public static boolean Y(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean Z(String str) {
        t1.f.d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean a0(Context context) {
        ActivityInfo receiverInfo;
        t1.f.h(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean b0(Context context, boolean z10) {
        t1.f.h(context);
        return Build.VERSION.SDK_INT >= 24 ? k0(context, "com.google.android.gms.measurement.AppMeasurementJobService") : k0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean c0(String str) {
        return !f5799h[0].equals(str);
    }

    public static final boolean f0(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    public static final boolean g0(String str) {
        t1.f.h(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    public static boolean j0(String str, String[] strArr) {
        t1.f.h(strArr);
        for (String str2 : strArr) {
            if (ua.a(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static long s0(byte[] bArr) {
        t1.f.h(bArr);
        int length = bArr.length;
        int i10 = 0;
        t1.f.k(length > 0);
        long j10 = 0;
        for (int i11 = length - 1; i11 >= 0 && i11 >= bArr.length - 8; i11--) {
            j10 += (bArr[i11] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static MessageDigest t() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList v(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.f3952e);
            bundle.putString("origin", zzacVar.f3953j);
            bundle.putLong("creation_timestamp", zzacVar.f3955l);
            bundle.putString("name", zzacVar.f3954k.f3970j);
            d6.b(bundle, t1.f.h(zzacVar.f3954k.c()));
            bundle.putBoolean("active", zzacVar.f3956m);
            String str = zzacVar.f3957n;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzau zzauVar = zzacVar.f3958o;
            if (zzauVar != null) {
                bundle.putString("timed_out_event_name", zzauVar.f3964e);
                zzas zzasVar = zzauVar.f3965j;
                if (zzasVar != null) {
                    bundle.putBundle("timed_out_event_params", zzasVar.g());
                }
            }
            bundle.putLong("trigger_timeout", zzacVar.f3959p);
            zzau zzauVar2 = zzacVar.f3960q;
            if (zzauVar2 != null) {
                bundle.putString("triggered_event_name", zzauVar2.f3964e);
                zzas zzasVar2 = zzauVar2.f3965j;
                if (zzasVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzasVar2.g());
                }
            }
            bundle.putLong("triggered_timestamp", zzacVar.f3954k.f3971k);
            bundle.putLong("time_to_live", zzacVar.f3961r);
            zzau zzauVar3 = zzacVar.f3962s;
            if (zzauVar3 != null) {
                bundle.putString("expired_event_name", zzauVar3.f3964e);
                zzas zzasVar3 = zzauVar3.f3965j;
                if (zzasVar3 != null) {
                    bundle.putBundle("expired_event_params", zzasVar3.g());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void y(v7 v7Var, Bundle bundle, boolean z10) {
        if (bundle != null && v7Var != null) {
            if (!bundle.containsKey("_sc") || z10) {
                String str = v7Var.f5765a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = v7Var.f5766b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", v7Var.f5767c);
                return;
            }
            z10 = false;
        }
        if (bundle != null && v7Var == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void A(Parcelable[] parcelableArr, int i10, boolean z10) {
        t1.f.h(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i11 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (Z(str) && !j0(str, h6.f5275d) && (i11 = i11 + 1) > i10) {
                    if (z10) {
                        this.f5030a.d().s().c("Param can't contain more than " + i10 + " item-scoped custom parameters", this.f5030a.D().e(str), this.f5030a.D().b(bundle));
                        f0(bundle, 28);
                    } else {
                        this.f5030a.d().s().c("Param cannot contain item-scoped custom parameters", this.f5030a.D().e(str), this.f5030a.D().b(bundle));
                        f0(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    public final void B(w3 w3Var, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(w3Var.f5785d.keySet())) {
            if (Z(str) && (i11 = i11 + 1) > i10) {
                this.f5030a.d().s().c("Event can't contain more than " + i10 + " params", this.f5030a.D().d(w3Var.f5782a), this.f5030a.D().b(w3Var.f5785d));
                f0(w3Var.f5785d, 5);
                w3Var.f5785d.remove(str);
            }
        }
    }

    public final void C(va vaVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        f0(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        vaVar.a(str, "_err", bundle);
    }

    public final void D(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.f5030a.d().x().c("Not putting event parameter. Invalid value type. name, type", this.f5030a.D().e(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void E(com.google.android.gms.internal.measurement.k1 k1Var, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning boolean value to wrapper", e10);
        }
    }

    public final void F(com.google.android.gms.internal.measurement.k1 k1Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning bundle list to wrapper", e10);
        }
    }

    public final void G(com.google.android.gms.internal.measurement.k1 k1Var, Bundle bundle) {
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning bundle value to wrapper", e10);
        }
    }

    public final void H(com.google.android.gms.internal.measurement.k1 k1Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning byte array to wrapper", e10);
        }
    }

    public final void I(com.google.android.gms.internal.measurement.k1 k1Var, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning int value to wrapper", e10);
        }
    }

    public final void J(com.google.android.gms.internal.measurement.k1 k1Var, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning long value to wrapper", e10);
        }
    }

    public final void K(com.google.android.gms.internal.measurement.k1 k1Var, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f5030a.d().w().b("Error returning string value to wrapper", e10);
        }
    }

    public final void L(String str, String str2, String str3, Bundle bundle, List list, boolean z10) {
        int i10;
        int i11;
        wa waVar = this;
        String str4 = str2;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        g gVarZ = waVar.f5030a.z();
        vc.b();
        int i12 = (gVarZ.f5030a.z().B(null, i3.B0) && gVarZ.f5030a.N().X(231100000, true)) ? 35 : 0;
        int i13 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str5)) {
                int iO0 = !z10 ? waVar.o0(str5) : 0;
                if (iO0 == 0) {
                    iO0 = waVar.n0(str5);
                }
                i10 = iO0;
            } else {
                i10 = 0;
            }
            if (i10 != 0) {
                waVar.x(bundle, i10, str5, str5, i10 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                Bundle bundle2 = bundle;
                if (waVar.V(bundle2.get(str5))) {
                    waVar.f5030a.d().x().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str4, str3, str5);
                    i11 = 22;
                } else {
                    String str6 = str4;
                    int iO = waVar.O(str, str6, str5, bundle2.get(str5), bundle2, list2, z10, false);
                    str4 = str6;
                    bundle2 = bundle2;
                    i11 = iO;
                }
                if (i11 == 0 || "_ev".equals(str5)) {
                    waVar = this;
                    if (Z(str5) && !j0(str5, h6.f5275d)) {
                        i13++;
                        if (!waVar.X(231100000, true)) {
                            waVar.f5030a.d().s().c("Item array not supported on client's version of Google Play Services (Android Only)", waVar.f5030a.D().d(str4), waVar.f5030a.D().b(bundle2));
                            f0(bundle2, 23);
                            bundle2.remove(str5);
                        } else if (i13 > i12) {
                            vc.b();
                            if (waVar.f5030a.z().B(null, i3.B0)) {
                                waVar.f5030a.d().s().c("Item can't contain more than " + i12 + " item-scoped custom params", waVar.f5030a.D().d(str4), waVar.f5030a.D().b(bundle2));
                                f0(bundle2, 28);
                                bundle2.remove(str5);
                            } else {
                                waVar.f5030a.d().s().c("Item cannot contain custom parameters", waVar.f5030a.D().d(str4), waVar.f5030a.D().b(bundle2));
                                f0(bundle2, 23);
                                bundle2.remove(str5);
                            }
                        }
                    }
                } else {
                    waVar = this;
                    waVar.x(bundle2, i11, str5, str5, bundle2.get(str5));
                    bundle2.remove(str5);
                }
            }
            list2 = list;
        }
    }

    public final boolean M(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (g0(str)) {
                return true;
            }
            if (this.f5030a.q()) {
                this.f5030a.d().s().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", v3.z(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f5030a.q()) {
                this.f5030a.d().s().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (g0(str2)) {
            return true;
        }
        this.f5030a.d().s().b("Invalid admob_app_id. Analytics disabled.", v3.z(str2));
        return false;
    }

    public final boolean N(String str, int i10, String str2) {
        if (str2 == null) {
            this.f5030a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        this.f5030a.d().s().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int O(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z10, boolean z11) {
        int i10;
        int i11;
        int size;
        h();
        if (!V(obj)) {
            i10 = 0;
        } else {
            if (!z11) {
                return 21;
            }
            if (!j0(str3, h6.f5274c)) {
                return 20;
            }
            d9 d9VarL = this.f5030a.L();
            d9VarL.h();
            d9VarL.i();
            if (d9VarL.B() && d9VarL.f5030a.N().q0() < 200900) {
                return 25;
            }
            this.f5030a.z();
            boolean z12 = obj instanceof Parcelable[];
            if (z12) {
                size = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                }
                i10 = 0;
            }
            if (size > 200) {
                this.f5030a.d().x().d("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                this.f5030a.z();
                i10 = 17;
                if (z12) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
            }
        }
        if (Y(str2) || Y(str3)) {
            this.f5030a.z();
            i11 = 256;
        } else {
            this.f5030a.z();
            i11 = 100;
        }
        if (!Q("param", str3, i11, obj)) {
            if (!z11) {
                return 4;
            }
            if (obj instanceof Bundle) {
                L(str, str2, str3, (Bundle) obj, list, z10);
                return i10;
            }
            if (obj instanceof Parcelable[]) {
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (!(parcelable instanceof Bundle)) {
                        this.f5030a.d().x().c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                        return 4;
                    }
                    L(str, str2, str3, (Bundle) parcelable, list, z10);
                }
            } else {
                if (!(obj instanceof ArrayList)) {
                    return 4;
                }
                ArrayList arrayList2 = (ArrayList) obj;
                int size2 = arrayList2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    Object obj2 = arrayList2.get(i12);
                    if (!(obj2 instanceof Bundle)) {
                        this.f5030a.d().x().c("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                        return 4;
                    }
                    L(str, str2, str3, (Bundle) obj2, list, z10);
                }
            }
        }
        return i10;
    }

    public final boolean P(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f5030a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        t1.f.h(str2);
        String[] strArr3 = f5798g;
        for (int i10 = 0; i10 < 3; i10++) {
            if (str2.startsWith(strArr3[i10])) {
                this.f5030a.d().s().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !j0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && j0(str2, strArr2)) {
            return true;
        }
        this.f5030a.d().s().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean Q(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i10) {
                this.f5030a.d().x().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean R(String str, String str2) {
        if (str2 == null) {
            this.f5030a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f5030a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.f5030a.d().s().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f5030a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean S(String str, String str2) {
        if (str2 == null) {
            this.f5030a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f5030a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.f5030a.d().s().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f5030a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean T(String str) {
        h();
        if (x1.e.a(this.f5030a.c()).a(str) == 0) {
            return true;
        }
        this.f5030a.d().q().b("Permission not granted", str);
        return false;
    }

    public final boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strU = this.f5030a.z().u();
        this.f5030a.b();
        return strU.equals(str);
    }

    public final boolean V(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean W(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoC = x1.e.a(context).c(str, 64);
            if (packageInfoC == null || (signatureArr = packageInfoC.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            this.f5030a.d().r().b("Package name not found", e10);
            return true;
        } catch (CertificateException e11) {
            this.f5030a.d().r().b("Error obtaining certificate", e11);
            return true;
        }
    }

    public final boolean X(int i10, boolean z10) {
        Boolean boolJ = this.f5030a.L().J();
        if (q0() < i10 / 1000) {
            return (boolJ == null || boolJ.booleanValue()) ? false : true;
        }
        return true;
    }

    public final boolean d0(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            t1.f.h(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final byte[] e0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final int h0(String str) {
        if ("_ldl".equals(str)) {
            this.f5030a.z();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.f5030a.z();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.f5030a.z();
            return 100;
        }
        this.f5030a.z();
        return 36;
    }

    @Override // f2.b6
    public final void i() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.f5030a.d().w().a("Utils falling back to Random for random id");
            }
        }
        this.f5801d.set(jNextLong);
    }

    public final Object i0(int i10, Object obj, boolean z10, boolean z11) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return r(obj.toString(), i10, z10);
        }
        if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleW0 = w0((Bundle) parcelable);
                if (!bundleW0.isEmpty()) {
                    arrayList.add(bundleW0);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    @Override // f2.b6
    public final boolean j() {
        return true;
    }

    public final int l0(String str, Object obj) {
        return "_ldl".equals(str) ? Q("user property referrer", str, h0(str), obj) : Q("user property", str, h0(str), obj) ? 0 : 7;
    }

    public final int m0(String str) {
        if (!R("event", str)) {
            return 2;
        }
        if (!P("event", g6.f5206a, g6.f5207b, str)) {
            return 13;
        }
        this.f5030a.z();
        return !N("event", 40, str) ? 2 : 0;
    }

    public final int n0(String str) {
        if (!R("event param", str)) {
            return 3;
        }
        if (!P("event param", null, null, str)) {
            return 14;
        }
        this.f5030a.z();
        return !N("event param", 40, str) ? 3 : 0;
    }

    public final Object o(String str, Object obj) {
        int i10 = 256;
        if ("_ev".equals(str)) {
            this.f5030a.z();
            return i0(256, obj, true, true);
        }
        if (Y(str)) {
            this.f5030a.z();
        } else {
            this.f5030a.z();
            i10 = 100;
        }
        return i0(i10, obj, false, true);
    }

    public final int o0(String str) {
        if (!S("event param", str)) {
            return 3;
        }
        if (!P("event param", null, null, str)) {
            return 14;
        }
        this.f5030a.z();
        return !N("event param", 40, str) ? 3 : 0;
    }

    public final Object p(String str, Object obj) {
        return "_ldl".equals(str) ? i0(h0(str), obj, true, false) : i0(h0(str), obj, false, false);
    }

    public final int p0(String str) {
        if (!R("user property", str)) {
            return 6;
        }
        if (!P("user property", i6.f5350a, null, str)) {
            return 15;
        }
        this.f5030a.z();
        return !N("user property", 24, str) ? 6 : 0;
    }

    public final String q() {
        byte[] bArr = new byte[16];
        u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final int q0() {
        if (this.f5803f == null) {
            this.f5803f = Integer.valueOf(q1.b.b().a(this.f5030a.c()) / 1000);
        }
        return this.f5803f.intValue();
    }

    public final String r(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return null;
    }

    public final int r0(int i10) {
        return q1.b.b().c(this.f5030a.c(), 12451000);
    }

    public final URL s(long j10, String str, String str2, long j11) {
        try {
            t1.f.d(str2);
            t1.f.d(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 79000L, Integer.valueOf(q0())), str2, str, Long.valueOf(j11));
            if (str.equals(this.f5030a.z().v())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e10) {
            e = e10;
            this.f5030a.d().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e11) {
            e = e11;
            this.f5030a.d().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final long t0() {
        long andIncrement;
        long j10;
        if (this.f5801d.get() != 0) {
            synchronized (this.f5801d) {
                this.f5801d.compareAndSet(-1L, 1L);
                andIncrement = this.f5801d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f5801d) {
            long jNextLong = new Random(System.nanoTime() ^ this.f5030a.a().a()).nextLong();
            int i10 = this.f5802e + 1;
            this.f5802e = i10;
            j10 = jNextLong + i10;
        }
        return j10;
    }

    public final SecureRandom u() {
        h();
        if (this.f5800c == null) {
            this.f5800c = new SecureRandom();
        }
        return this.f5800c;
    }

    public final long u0(long j10, long j11) {
        return (j10 + (j11 * 60000)) / 86400000;
    }

    public final Bundle v0(Uri uri, boolean z10) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    queryParameter5 = uri.getQueryParameter("utm_id");
                    queryParameter6 = uri.getQueryParameter("dclid");
                    queryParameter7 = uri.getQueryParameter("srsltid");
                    queryParameter8 = z10 ? uri.getQueryParameter("sfmc_id") : null;
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                    queryParameter8 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && (!z10 || TextUtils.isEmpty(queryParameter8))) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter9 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString("term", queryParameter9);
                }
                String queryParameter10 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString("content", queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString("aclid", queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("cp1", queryParameter12);
                }
                String queryParameter13 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter13)) {
                    bundle.putString("anid", queryParameter13);
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("campaign_id", queryParameter5);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("dclid", queryParameter6);
                }
                String queryParameter14 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter14)) {
                    bundle.putString("source_platform", queryParameter14);
                }
                String queryParameter15 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter15)) {
                    bundle.putString("creative_format", queryParameter15);
                }
                String queryParameter16 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter16)) {
                    bundle.putString("marketing_tactic", queryParameter16);
                }
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("srsltid", queryParameter7);
                }
                if (z10 && !TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("sfmc_id", queryParameter8);
                }
                return bundle;
            } catch (UnsupportedOperationException e10) {
                this.f5030a.d().w().b("Install referrer url isn't a hierarchical URI", e10);
            }
        }
        return null;
    }

    public final void w(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            this.f5030a.d().w().b("Params already contained engagement", Long.valueOf(j11));
        } else {
            j11 = 0;
        }
        bundle.putLong("_et", j10 + j11);
    }

    public final Bundle w0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objO = o(str, bundle.get(str));
                if (objO == null) {
                    this.f5030a.d().x().b("Param value can't be null", this.f5030a.D().e(str));
                } else {
                    D(bundle2, str, objO);
                }
            }
        }
        return bundle2;
    }

    public final void x(Bundle bundle, int i10, String str, String str2, Object obj) {
        if (f0(bundle, i10)) {
            this.f5030a.z();
            bundle.putString("_ev", r(str, 40, true));
            if (obj != null) {
                t1.f.h(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final Bundle x0(String str, String str2, Bundle bundle, List list, boolean z10) {
        int iO0;
        String str3 = str2;
        List list2 = list;
        boolean zJ0 = j0(str3, g6.f5209d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iM = this.f5030a.z().m();
        int i10 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iO0 = !z10 ? o0(str4) : 0;
                if (iO0 == 0) {
                    iO0 = n0(str4);
                }
            } else {
                iO0 = 0;
            }
            if (iO0 != 0) {
                x(bundle2, iO0, str4, str4, iO0 == 3 ? str4 : null);
                bundle2.remove(str4);
            } else {
                Bundle bundle3 = bundle2;
                String str5 = str3;
                int iO = O(str, str5, str4, bundle.get(str4), bundle3, list2, z10, zJ0);
                str3 = str5;
                bundle2 = bundle3;
                if (iO == 17) {
                    x(bundle2, 17, str4, str4, Boolean.FALSE);
                } else if (iO != 0 && !"_ev".equals(str4)) {
                    x(bundle2, iO, iO == 21 ? str3 : str4, str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (Z(str4) && (i10 = i10 + 1) > iM) {
                    this.f5030a.d().s().c("Event can't contain more than " + iM + " params", this.f5030a.D().d(str3), this.f5030a.D().b(bundle));
                    f0(bundle2, 5);
                    bundle2.remove(str4);
                }
            }
            list2 = list;
        }
        return bundle2;
    }

    public final zzau y0(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m0(str2) != 0) {
            this.f5030a.d().r().b("Invalid conditional property event name", this.f5030a.D().f(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleX0 = x0(str, str2, bundle2, w1.d.b("_o"), true);
        if (z10) {
            bundleX0 = w0(bundleX0);
        }
        t1.f.h(bundleX0);
        return new zzau(str2, new zzas(bundleX0), str3, j10);
    }

    public final void z(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.f5030a.N().D(bundle, str, bundle2.get(str));
            }
        }
    }
}
