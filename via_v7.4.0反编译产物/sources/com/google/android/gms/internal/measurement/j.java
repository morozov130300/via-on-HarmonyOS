package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j implements r {

    /* renamed from: e, reason: collision with root package name */
    public final Double f3565e;

    public j(Double d10) {
        if (d10 == null) {
            this.f3565e = Double.valueOf(Double.NaN);
        } else {
            this.f3565e = d10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new j(this.f3565e);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return this.f3565e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.f3565e.equals(((j) obj).f3565e);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() throws NumberFormatException {
        if (Double.isNaN(this.f3565e.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.f3565e.doubleValue())) {
            return this.f3565e.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalA = i.a(BigDecimal.valueOf(this.f3565e.doubleValue()));
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimalA.scale() > 0 ? bigDecimalA.precision() : bigDecimalA.scale()) - 1);
        String str = decimalFormat.format(bigDecimalA);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i10 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i10 >= 0 || i10 <= -7) && (i10 < 0 || i10 >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimalA.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        boolean z10 = false;
        if (!Double.isNaN(this.f3565e.doubleValue()) && this.f3565e.doubleValue() != 0.0d) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    public final int hashCode() {
        return this.f3565e.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        if ("toString".equals(str)) {
            return new v(f());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", f(), str));
    }

    public final String toString() {
        return f();
    }
}
