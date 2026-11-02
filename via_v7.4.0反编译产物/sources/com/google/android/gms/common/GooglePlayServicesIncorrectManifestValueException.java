package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import q1.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@KeepName
/* loaded from: classes.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i10) {
        super(i10, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + b.f11237a + " but found " + i10 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
