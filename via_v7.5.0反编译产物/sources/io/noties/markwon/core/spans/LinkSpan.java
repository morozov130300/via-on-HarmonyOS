package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import e6.c;
import f6.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class LinkSpan extends URLSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6432c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6433e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f6434m;

    public LinkSpan(a aVar, String str, c cVar) {
        super(str);
        this.f6432c = aVar;
        this.f6433e = str;
        this.f6434m = cVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f6434m.a(view, this.f6433e);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.f6432c.f(textPaint);
    }
}
