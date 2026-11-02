package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class LocaleTransform implements Transform<Locale> {
    private final Pattern pattern = Pattern.compile("_");

    private Locale read(String[] strArr) {
        String[] strArr2 = new String[3];
        strArr2[0] = "";
        strArr2[1] = "";
        strArr2[2] = "";
        for (int i10 = 0; i10 < 3; i10++) {
            if (i10 < strArr.length) {
                strArr2[i10] = strArr[i10];
            }
        }
        return new Locale(strArr2[0], strArr2[1], strArr2[2]);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Locale read(String str) throws InvalidFormatException {
        String[] strArrSplit = this.pattern.split(str);
        if (strArrSplit.length >= 1) {
            return read(strArrSplit);
        }
        throw new InvalidFormatException("Invalid locale %s", str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Locale locale) {
        return locale.toString();
    }
}
