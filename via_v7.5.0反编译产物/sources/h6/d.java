package h6;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends MetricAffectingSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5710c;

    public d(f6.a aVar) {
        this.f5710c = aVar;
    }

    public final void a(TextPaint textPaint) {
        this.f5710c.c(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
        textPaint.bgColor = this.f5710c.m(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
