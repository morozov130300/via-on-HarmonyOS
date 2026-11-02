package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import k6.c;
import l6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LinkSpan extends URLSpan {

    /* renamed from: e, reason: collision with root package name */
    public final a f7201e;

    /* renamed from: j, reason: collision with root package name */
    public final String f7202j;

    /* renamed from: k, reason: collision with root package name */
    public final c f7203k;

    public LinkSpan(a aVar, String str, c cVar) {
        super(str);
        this.f7201e = aVar;
        this.f7202j = str;
        this.f7203k = cVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f7203k.a(view, this.f7202j);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.f7201e.f(textPaint);
    }
}
