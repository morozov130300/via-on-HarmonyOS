package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.b;
import t1.f;
import u1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new b();

    /* renamed from: e, reason: collision with root package name */
    public final int f3286e;

    /* renamed from: j, reason: collision with root package name */
    public final String f3287j;

    public Scope(int i10, String str) {
        f.e(str, "scopeUri must not be null or empty");
        this.f3286e = i10;
        this.f3287j = str;
    }

    public String c() {
        return this.f3287j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f3287j.equals(((Scope) obj).f3287j);
        }
        return false;
    }

    public int hashCode() {
        return this.f3287j.hashCode();
    }

    public String toString() {
        return this.f3287j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.j(parcel, 1, this.f3286e);
        a.o(parcel, 2, c(), false);
        a.b(parcel, iA);
    }
}
