package e6;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t implements Appendable, CharSequence {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f4261c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque f4262e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4266d;

        public a(Object obj, int i10, int i11, int i12) {
            this.f4263a = obj;
            this.f4264b = i10;
            this.f4265c = i11;
            this.f4266d = i12;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends SpannableStringBuilder {
        public b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public t() {
        this("");
    }

    public static boolean g(int i10, int i11, int i12) {
        return i12 > i11 && i11 >= 0 && i12 <= i10;
    }

    public static void k(t tVar, Object obj, int i10, int i11) {
        if (obj == null || !g(tVar.length(), i10, i11)) {
            return;
        }
        l(tVar, obj, i10, i11);
    }

    public static void l(t tVar, Object obj, int i10, int i11) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                tVar.j(obj, i10, i11, 33);
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                l(tVar, obj2, i10, i11);
            }
        }
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public t append(char c10) {
        this.f4261c.append(c10);
        return this;
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t append(CharSequence charSequence) {
        e(length(), charSequence);
        this.f4261c.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public t append(CharSequence charSequence, int i10, int i11) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i10, i11);
        e(length(), charSequenceSubSequence);
        this.f4261c.append(charSequenceSubSequence);
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f4261c.charAt(i10);
    }

    public t d(String str) {
        this.f4261c.append(str);
        return this;
    }

    public final void e(int i10, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z10 = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z10) {
                    for (int i11 = 0; i11 < length; i11++) {
                        Object obj = spans[i11];
                        j(obj, spanned.getSpanStart(obj) + i10, spanned.getSpanEnd(obj) + i10, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i12 = length - 1; i12 >= 0; i12--) {
                    Object obj2 = spans[i12];
                    j(obj2, spanned.getSpanStart(obj2) + i10, spanned.getSpanEnd(obj2) + i10, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    public List f(int i10, int i11) {
        int i12;
        int length = length();
        if (!g(length, i10, i11)) {
            return Collections.EMPTY_LIST;
        }
        if (i10 == 0 && length == i11) {
            ArrayList arrayList = new ArrayList(this.f4262e);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator itDescendingIterator = this.f4262e.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            a aVar = (a) itDescendingIterator.next();
            int i13 = aVar.f4264b;
            if ((i13 >= i10 && i13 < i11) || (((i12 = aVar.f4265c) <= i11 && i12 > i10) || (i13 < i10 && i12 > i11))) {
                arrayList2.add(aVar);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.f4261c.charAt(length() - 1);
    }

    public CharSequence i(int i10) {
        a aVar;
        int i11;
        int length = length();
        b bVar = new b(this.f4261c.subSequence(i10, length));
        Iterator it = this.f4262e.iterator();
        while (it.hasNext() && (aVar = (a) it.next()) != null) {
            int i12 = aVar.f4264b;
            if (i12 >= i10 && (i11 = aVar.f4265c) <= length) {
                bVar.setSpan(aVar.f4263a, i12 - i10, i11 - i10, 33);
                it.remove();
            }
        }
        this.f4261c.replace(i10, length, "");
        return bVar;
    }

    public t j(Object obj, int i10, int i11, int i12) {
        this.f4262e.push(new a(obj, i10, i11, i12));
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f4261c.length();
    }

    public SpannableStringBuilder m() {
        b bVar = new b(this.f4261c);
        for (a aVar : this.f4262e) {
            bVar.setSpan(aVar.f4263a, aVar.f4264b, aVar.f4265c, aVar.f4266d);
        }
        return bVar;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        List<a> listF = f(i10, i11);
        if (listF.isEmpty()) {
            return this.f4261c.subSequence(i10, i11);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4261c.subSequence(i10, i11));
        int length = spannableStringBuilder.length();
        for (a aVar : listF) {
            int iMax = Math.max(0, aVar.f4264b - i10);
            spannableStringBuilder.setSpan(aVar.f4263a, iMax, Math.min(length, (aVar.f4265c - aVar.f4264b) + iMax), aVar.f4266d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f4261c.toString();
    }

    public t(CharSequence charSequence) {
        this.f4262e = new ArrayDeque(8);
        this.f4261c = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
