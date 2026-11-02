package com.google.android.gms.tasks;

import g2.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(f fVar) {
        if (!fVar.j()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excG = fVar.g();
        return new DuplicateTaskCompletionException("Complete with: ".concat(excG != null ? "failure" : fVar.k() ? "result ".concat(String.valueOf(fVar.h())) : fVar.i() ? "cancellation" : "unknown issue"), excG);
    }
}
