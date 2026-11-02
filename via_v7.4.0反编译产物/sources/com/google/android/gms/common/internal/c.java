package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends b2.a implements b {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.b
    public final Account a() {
        Parcel parcelY = Y(2, Z());
        Account account = (Account) b2.c.a(parcelY, Account.CREATOR);
        parcelY.recycle();
        return account;
    }
}
