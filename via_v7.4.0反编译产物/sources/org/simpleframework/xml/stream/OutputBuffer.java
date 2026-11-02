package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class OutputBuffer {
    private StringBuilder text = new StringBuilder();

    public void append(char c10) {
        this.text.append(c10);
    }

    public void append(String str) {
        this.text.append(str);
    }

    public void append(String str, int i10, int i11) {
        this.text.append((CharSequence) str, i10, i11);
    }

    public void append(char[] cArr) {
        this.text.append(cArr, 0, cArr.length);
    }

    public void append(char[] cArr, int i10, int i11) {
        this.text.append(cArr, i10, i11);
    }

    public void clear() {
        this.text.setLength(0);
    }

    public void write(Writer writer) throws IOException {
        writer.append((CharSequence) this.text);
    }
}
