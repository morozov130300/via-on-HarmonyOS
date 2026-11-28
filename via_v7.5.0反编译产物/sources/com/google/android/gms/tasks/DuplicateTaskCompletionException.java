package com.google.android.gms.tasks;

import h2.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(f fVar) {
        String strConcat;
        if (!fVar.j()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excG = fVar.g();
        if (excG != null) {
            strConcat = "failure";
        } else if (fVar.k()) {
            strConcat = "result ".concat(String.valueOf(fVar.h()));
        } else {
            strConcat = fVar.i() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException("Complete with: ".concat(strConcat), excG);
    }
}
