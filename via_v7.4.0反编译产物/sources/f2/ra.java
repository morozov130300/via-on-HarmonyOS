package f2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ra extends ba {
    public ra(pa paVar) {
        super(paVar);
    }

    public static com.google.android.gms.internal.measurement.z9 E(com.google.android.gms.internal.measurement.z9 z9Var, byte[] bArr) {
        com.google.android.gms.internal.measurement.q8 q8VarA = com.google.android.gms.internal.measurement.q8.a();
        return q8VarA != null ? z9Var.h(bArr, q8VarA) : z9Var.k(bArr);
    }

    public static List J(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 * 64) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static boolean N(List list, int i10) {
        if (i10 < list.size() * 64) {
            return ((1 << (i10 % 64)) & ((Long) list.get(i10 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static boolean P(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static final void m(com.google.android.gms.internal.measurement.i4 i4Var, String str, Object obj) {
        List listH = i4Var.H();
        int i10 = 0;
        while (true) {
            if (i10 >= listH.size()) {
                i10 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.n4) listH.get(i10)).J())) {
                break;
            } else {
                i10++;
            }
        }
        com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
        m4VarH.B(str);
        if (obj instanceof Long) {
            m4VarH.A(((Long) obj).longValue());
        }
        if (i10 >= 0) {
            i4Var.B(i10, m4VarH);
        } else {
            i4Var.w(m4VarH);
        }
    }

    public static final boolean n(zzau zzauVar, zzq zzqVar) {
        t1.f.h(zzauVar);
        t1.f.h(zzqVar);
        return (TextUtils.isEmpty(zzqVar.f3977j) && TextUtils.isEmpty(zzqVar.f3992y)) ? false : true;
    }

    public static final com.google.android.gms.internal.measurement.n4 o(com.google.android.gms.internal.measurement.j4 j4Var, String str) {
        for (com.google.android.gms.internal.measurement.n4 n4Var : j4Var.L()) {
            if (n4Var.J().equals(str)) {
                return n4Var;
            }
        }
        return null;
    }

    public static final Object p(com.google.android.gms.internal.measurement.j4 j4Var, String str) {
        com.google.android.gms.internal.measurement.n4 n4VarO = o(j4Var, str);
        if (n4VarO == null) {
            return null;
        }
        if (n4VarO.a0()) {
            return n4VarO.K();
        }
        if (n4VarO.Y()) {
            return Long.valueOf(n4VarO.G());
        }
        if (n4VarO.W()) {
            return Double.valueOf(n4VarO.D());
        }
        if (n4VarO.F() <= 0) {
            return null;
        }
        List<com.google.android.gms.internal.measurement.n4> listL = n4VarO.L();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.n4 n4Var : listL) {
            if (n4Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.n4 n4Var2 : n4Var.L()) {
                    if (n4Var2.a0()) {
                        bundle.putString(n4Var2.J(), n4Var2.K());
                    } else if (n4Var2.Y()) {
                        bundle.putLong(n4Var2.J(), n4Var2.G());
                    } else if (n4Var2.W()) {
                        bundle.putDouble(n4Var2.J(), n4Var2.D());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static final void s(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    public static final String t(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    public static final void u(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.z4 z4Var) {
        if (z4Var == null) {
            return;
        }
        s(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (z4Var.E() != 0) {
            s(sb2, 4);
            sb2.append("results: ");
            int i11 = 0;
            for (Long l10 : z4Var.L()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i11 = i12;
            }
            sb2.append('\n');
        }
        if (z4Var.G() != 0) {
            s(sb2, 4);
            sb2.append("status: ");
            int i13 = 0;
            for (Long l11 : z4Var.N()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i13 = i14;
            }
            sb2.append('\n');
        }
        if (z4Var.D() != 0) {
            s(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.h4 h4Var : z4Var.K()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb2.append(", ");
                }
                sb2.append(h4Var.K() ? Integer.valueOf(h4Var.D()) : null);
                sb2.append(":");
                sb2.append(h4Var.J() ? Long.valueOf(h4Var.E()) : null);
                i15 = i16;
            }
            sb2.append("}\n");
        }
        if (z4Var.F() != 0) {
            s(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i17 = 0;
            for (com.google.android.gms.internal.measurement.b5 b5Var : z4Var.M()) {
                int i18 = i17 + 1;
                if (i17 != 0) {
                    sb2.append(", ");
                }
                sb2.append(b5Var.L() ? Integer.valueOf(b5Var.E()) : null);
                sb2.append(": [");
                Iterator it = b5Var.I().iterator();
                int i19 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i20 = i19 + 1;
                    if (i19 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i19 = i20;
                }
                sb2.append("]");
                i17 = i18;
            }
            sb2.append("}\n");
        }
        s(sb2, 3);
        sb2.append("}\n");
    }

    public static final void v(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        s(sb2, i10 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    public static final void w(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.g3 g3Var) {
        if (g3Var == null) {
            return;
        }
        s(sb2, i10);
        sb2.append(str);
        sb2.append(" {\n");
        if (g3Var.J()) {
            int iO = g3Var.O();
            v(sb2, i10, "comparison_type", iO != 1 ? iO != 2 ? iO != 3 ? iO != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (g3Var.L()) {
            v(sb2, i10, "match_as_float", Boolean.valueOf(g3Var.I()));
        }
        if (g3Var.K()) {
            v(sb2, i10, "comparison_value", g3Var.F());
        }
        if (g3Var.N()) {
            v(sb2, i10, "min_comparison_value", g3Var.H());
        }
        if (g3Var.M()) {
            v(sb2, i10, "max_comparison_value", g3Var.G());
        }
        s(sb2, i10);
        sb2.append("}\n");
    }

    public static int x(com.google.android.gms.internal.measurement.t4 t4Var, String str) {
        for (int i10 = 0; i10 < t4Var.o0(); i10++) {
            if (str.equals(t4Var.i0(i10).I())) {
                return i10;
            }
        }
        return -1;
    }

    public final Bundle A(Map map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList2.add(A((Map) arrayList.get(i10), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final Parcelable B(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.f5030a.d().r().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final zzau C(com.google.android.gms.internal.measurement.b bVar) {
        Object obj;
        Bundle bundleA = A(bVar.e(), true);
        String string = (!bundleA.containsKey("_o") || (obj = bundleA.get("_o")) == null) ? "app" : obj.toString();
        String strB = g6.b(bVar.d());
        if (strB == null) {
            strB = bVar.d();
        }
        return new zzau(strB, new zzas(bundleA), string, bVar.a());
    }

    public final com.google.android.gms.internal.measurement.j4 D(p pVar) {
        com.google.android.gms.internal.measurement.i4 i4VarH = com.google.android.gms.internal.measurement.j4.H();
        i4VarH.D(pVar.f5574e);
        r rVar = new r(pVar.f5575f);
        while (rVar.hasNext()) {
            String next = rVar.next();
            com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
            m4VarH.B(next);
            Object objN = pVar.f5575f.n(next);
            t1.f.h(objN);
            L(m4VarH, objN);
            i4VarH.w(m4VarH);
        }
        return (com.google.android.gms.internal.measurement.j4) i4VarH.o();
    }

    public final String F(com.google.android.gms.internal.measurement.s4 s4Var) {
        if (s4Var == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.u4 u4Var : s4Var.G()) {
            if (u4Var != null) {
                s(sb2, 1);
                sb2.append("bundle {\n");
                if (u4Var.s1()) {
                    v(sb2, 1, "protocol_version", Integer.valueOf(u4Var.C1()));
                }
                ae.b();
                if (this.f5030a.z().B(u4Var.W1(), i3.f5328q0) && u4Var.v1()) {
                    v(sb2, 1, "session_stitching_token", u4Var.O());
                }
                v(sb2, 1, "platform", u4Var.M());
                if (u4Var.o1()) {
                    v(sb2, 1, "gmp_version", Long.valueOf(u4Var.K1()));
                }
                if (u4Var.A1()) {
                    v(sb2, 1, "uploading_gmp_version", Long.valueOf(u4Var.Q1()));
                }
                if (u4Var.m1()) {
                    v(sb2, 1, "dynamite_version", Long.valueOf(u4Var.I1()));
                }
                if (u4Var.j1()) {
                    v(sb2, 1, "config_version", Long.valueOf(u4Var.G1()));
                }
                v(sb2, 1, "gmp_app_id", u4Var.J());
                v(sb2, 1, "admob_app_id", u4Var.V1());
                v(sb2, 1, "app_id", u4Var.W1());
                v(sb2, 1, "app_version", u4Var.E());
                if (u4Var.h1()) {
                    v(sb2, 1, "app_version_major", Integer.valueOf(u4Var.d0()));
                }
                v(sb2, 1, "firebase_instance_id", u4Var.I());
                if (u4Var.l1()) {
                    v(sb2, 1, "dev_cert_hash", Long.valueOf(u4Var.H1()));
                }
                v(sb2, 1, "app_store", u4Var.D());
                if (u4Var.z1()) {
                    v(sb2, 1, "upload_timestamp_millis", Long.valueOf(u4Var.P1()));
                }
                if (u4Var.w1()) {
                    v(sb2, 1, "start_timestamp_millis", Long.valueOf(u4Var.N1()));
                }
                if (u4Var.n1()) {
                    v(sb2, 1, "end_timestamp_millis", Long.valueOf(u4Var.J1()));
                }
                if (u4Var.r1()) {
                    v(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(u4Var.M1()));
                }
                if (u4Var.q1()) {
                    v(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(u4Var.L1()));
                }
                v(sb2, 1, "app_instance_id", u4Var.X1());
                v(sb2, 1, "resettable_device_id", u4Var.N());
                v(sb2, 1, "ds_id", u4Var.H());
                if (u4Var.p1()) {
                    v(sb2, 1, "limited_ad_tracking", Boolean.valueOf(u4Var.C0()));
                }
                v(sb2, 1, "os_version", u4Var.L());
                v(sb2, 1, "device_model", u4Var.G());
                v(sb2, 1, "user_default_language", u4Var.P());
                if (u4Var.y1()) {
                    v(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(u4Var.E1()));
                }
                if (u4Var.i1()) {
                    v(sb2, 1, "bundle_sequential_index", Integer.valueOf(u4Var.e1()));
                }
                if (u4Var.u1()) {
                    v(sb2, 1, "service_upload", Boolean.valueOf(u4Var.D0()));
                }
                v(sb2, 1, "health_monitor", u4Var.K());
                if (u4Var.t1()) {
                    v(sb2, 1, "retry_counter", Integer.valueOf(u4Var.D1()));
                }
                if (u4Var.k1()) {
                    v(sb2, 1, "consent_signals", u4Var.F());
                }
                ed.b();
                if (this.f5030a.z().B(null, i3.G0) && u4Var.x1()) {
                    v(sb2, 1, "target_os_version", Long.valueOf(u4Var.O1()));
                }
                List<com.google.android.gms.internal.measurement.d5> listS = u4Var.S();
                if (listS != null) {
                    for (com.google.android.gms.internal.measurement.d5 d5Var : listS) {
                        if (d5Var != null) {
                            s(sb2, 2);
                            sb2.append("user_property {\n");
                            v(sb2, 2, "set_timestamp_millis", d5Var.U() ? Long.valueOf(d5Var.F()) : null);
                            v(sb2, 2, "name", this.f5030a.D().f(d5Var.I()));
                            v(sb2, 2, "string_value", d5Var.J());
                            v(sb2, 2, "int_value", d5Var.T() ? Long.valueOf(d5Var.E()) : null);
                            v(sb2, 2, "double_value", d5Var.S() ? Double.valueOf(d5Var.D()) : null);
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.f4> listQ = u4Var.Q();
                if (listQ != null) {
                    for (com.google.android.gms.internal.measurement.f4 f4Var : listQ) {
                        if (f4Var != null) {
                            s(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (f4Var.N()) {
                                v(sb2, 2, "audience_id", Integer.valueOf(f4Var.D()));
                            }
                            if (f4Var.O()) {
                                v(sb2, 2, "new_audience", Boolean.valueOf(f4Var.M()));
                            }
                            u(sb2, 2, "current_data", f4Var.G());
                            if (f4Var.P()) {
                                u(sb2, 2, "previous_data", f4Var.H());
                            }
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.j4> listR = u4Var.R();
                if (listR != null) {
                    for (com.google.android.gms.internal.measurement.j4 j4Var : listR) {
                        if (j4Var != null) {
                            s(sb2, 2);
                            sb2.append("event {\n");
                            v(sb2, 2, "name", this.f5030a.D().d(j4Var.K()));
                            if (j4Var.W()) {
                                v(sb2, 2, "timestamp_millis", Long.valueOf(j4Var.G()));
                            }
                            if (j4Var.V()) {
                                v(sb2, 2, "previous_timestamp_millis", Long.valueOf(j4Var.F()));
                            }
                            if (j4Var.U()) {
                                v(sb2, 2, "count", Integer.valueOf(j4Var.D()));
                            }
                            if (j4Var.E() != 0) {
                                q(sb2, 2, j4Var.L());
                            }
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                s(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    public final String G(com.google.android.gms.internal.measurement.z2 z2Var) {
        if (z2Var == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (z2Var.R()) {
            v(sb2, 0, "filter_id", Integer.valueOf(z2Var.E()));
        }
        v(sb2, 0, "event_name", this.f5030a.D().d(z2Var.J()));
        String strT = t(z2Var.N(), z2Var.O(), z2Var.P());
        if (!strT.isEmpty()) {
            v(sb2, 0, "filter_type", strT);
        }
        if (z2Var.Q()) {
            w(sb2, 1, "event_count_filter", z2Var.I());
        }
        if (z2Var.D() > 0) {
            sb2.append("  filters {\n");
            Iterator it = z2Var.K().iterator();
            while (it.hasNext()) {
                r(sb2, 2, (com.google.android.gms.internal.measurement.b3) it.next());
            }
        }
        s(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    public final String H(com.google.android.gms.internal.measurement.i3 i3Var) {
        if (i3Var == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (i3Var.M()) {
            v(sb2, 0, "filter_id", Integer.valueOf(i3Var.D()));
        }
        v(sb2, 0, "property_name", this.f5030a.D().f(i3Var.H()));
        String strT = t(i3Var.J(), i3Var.K(), i3Var.L());
        if (!strT.isEmpty()) {
            v(sb2, 0, "filter_type", strT);
        }
        r(sb2, 1, i3Var.E());
        sb2.append("}\n");
        return sb2.toString();
    }

    public final List I(List list, List list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f5030a.d().w().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.f5030a.d().w().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    public final Map K(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(K((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Object obj2 = arrayList2.get(i10);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(K((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(K((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public final void L(com.google.android.gms.internal.measurement.m4 m4Var, Object obj) {
        t1.f.h(obj);
        m4Var.y();
        m4Var.w();
        m4Var.v();
        m4Var.x();
        if (obj instanceof String) {
            m4Var.C((String) obj);
            return;
        }
        if (obj instanceof Long) {
            m4Var.A(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            m4Var.z(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.f5030a.d().r().b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.m4 m4VarH2 = com.google.android.gms.internal.measurement.n4.H();
                    m4VarH2.B(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        m4VarH2.A(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        m4VarH2.C((String) obj2);
                    } else if (obj2 instanceof Double) {
                        m4VarH2.z(((Double) obj2).doubleValue());
                    }
                    m4VarH.u(m4VarH2);
                }
                if (m4VarH.s() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.n4) m4VarH.o());
                }
            }
        }
        m4Var.t(arrayList);
    }

    public final void M(com.google.android.gms.internal.measurement.c5 c5Var, Object obj) {
        t1.f.h(obj);
        c5Var.u();
        c5Var.t();
        c5Var.s();
        if (obj instanceof String) {
            c5Var.z((String) obj);
            return;
        }
        if (obj instanceof Long) {
            c5Var.w(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            c5Var.v(((Double) obj).doubleValue());
        } else {
            this.f5030a.d().r().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final boolean O(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(this.f5030a.a().a() - j10) > j11;
    }

    public final byte[] Q(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            this.f5030a.d().r().b("Failed to gzip content", e10);
            throw e10;
        }
    }

    @Override // f2.ba
    public final boolean l() {
        return false;
    }

    public final void q(StringBuilder sb2, int i10, List list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.n4 n4Var = (com.google.android.gms.internal.measurement.n4) it.next();
            if (n4Var != null) {
                s(sb2, i11);
                sb2.append("param {\n");
                v(sb2, i11, "name", n4Var.Z() ? this.f5030a.D().e(n4Var.J()) : null);
                v(sb2, i11, "string_value", n4Var.a0() ? n4Var.K() : null);
                v(sb2, i11, "int_value", n4Var.Y() ? Long.valueOf(n4Var.G()) : null);
                v(sb2, i11, "double_value", n4Var.W() ? Double.valueOf(n4Var.D()) : null);
                if (n4Var.F() > 0) {
                    q(sb2, i11, n4Var.L());
                }
                s(sb2, i11);
                sb2.append("}\n");
            }
        }
    }

    public final void r(StringBuilder sb2, int i10, com.google.android.gms.internal.measurement.b3 b3Var) {
        String str;
        if (b3Var == null) {
            return;
        }
        s(sb2, i10);
        sb2.append("filter {\n");
        if (b3Var.K()) {
            v(sb2, i10, "complement", Boolean.valueOf(b3Var.J()));
        }
        if (b3Var.M()) {
            v(sb2, i10, "param_name", this.f5030a.D().e(b3Var.H()));
        }
        if (b3Var.N()) {
            int i11 = i10 + 1;
            com.google.android.gms.internal.measurement.n3 n3VarG = b3Var.G();
            if (n3VarG != null) {
                s(sb2, i11);
                sb2.append("string_filter {\n");
                if (n3VarG.L()) {
                    switch (n3VarG.M()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    v(sb2, i11, "match_type", str);
                }
                if (n3VarG.K()) {
                    v(sb2, i11, "expression", n3VarG.G());
                }
                if (n3VarG.J()) {
                    v(sb2, i11, "case_sensitive", Boolean.valueOf(n3VarG.I()));
                }
                if (n3VarG.D() > 0) {
                    s(sb2, i10 + 2);
                    sb2.append("expression_list {\n");
                    for (String str2 : n3VarG.H()) {
                        s(sb2, i10 + 3);
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                s(sb2, i11);
                sb2.append("}\n");
            }
        }
        if (b3Var.L()) {
            w(sb2, i10 + 1, "number_filter", b3Var.F());
        }
        s(sb2, i10);
        sb2.append("}\n");
    }

    public final long y(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return z(str.getBytes(Charset.forName("UTF-8")));
    }

    public final long z(byte[] bArr) throws NoSuchAlgorithmException {
        t1.f.h(bArr);
        this.f5030a.N().h();
        MessageDigest messageDigestT = wa.t();
        if (messageDigestT != null) {
            return wa.s0(messageDigestT.digest(bArr));
        }
        this.f5030a.d().r().a("Failed to get MD5");
        return 0L;
    }
}
