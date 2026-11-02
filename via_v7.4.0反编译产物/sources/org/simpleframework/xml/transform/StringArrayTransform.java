package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class StringArrayTransform implements Transform<String[]> {
    private final Pattern pattern;
    private final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String str) {
        this.pattern = Pattern.compile(str);
        this.token = str;
    }

    private String[] read(String str, String str2) {
        String[] strArrSplit = this.pattern.split(str);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String str3 = strArrSplit[i10];
            if (str3 != null) {
                strArrSplit[i10] = str3.trim();
            }
        }
        return strArrSplit;
    }

    private String write(String[] strArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (sb2.length() > 0) {
                    sb2.append(str);
                    sb2.append(' ');
                }
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String[] read(String str) {
        return read(str, this.token);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String[] strArr) {
        return write(strArr, this.token);
    }
}
