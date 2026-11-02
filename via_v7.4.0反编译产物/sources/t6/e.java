package t6;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import n6.j;
import n6.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {
    public static int a(Canvas canvas, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Layout layoutC = j.c(spanned);
            if (layoutC != null) {
                return layoutC.getWidth();
            }
            TextView textViewA = k.a(spanned);
            if (textViewA != null) {
                return (textViewA.getWidth() - textViewA.getPaddingLeft()) - textViewA.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }
}
