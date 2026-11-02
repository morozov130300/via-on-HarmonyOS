package org.simpleframework.xml.core;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Template {
    protected char[] buf;
    protected String cache;
    protected int count;

    public Template() {
        this(16);
    }

    public Template(int i10) {
        this.buf = new char[i10];
    }

    public void append(char c10) {
        ensureCapacity(this.count + 1);
        char[] cArr = this.buf;
        int i10 = this.count;
        this.count = i10 + 1;
        cArr[i10] = c10;
    }

    public void append(String str) {
        ensureCapacity(this.count + str.length());
        str.getChars(0, str.length(), this.buf, this.count);
        this.count += str.length();
    }

    public void append(String str, int i10, int i11) {
        ensureCapacity(this.count + i11);
        str.getChars(i10, i11, this.buf, this.count);
        this.count += i11;
    }

    public void append(Template template) {
        append(template.buf, 0, template.count);
    }

    public void append(Template template, int i10, int i11) {
        append(template.buf, i10, i11);
    }

    public void append(char[] cArr, int i10, int i11) {
        ensureCapacity(this.count + i11);
        System.arraycopy(cArr, i10, this.buf, this.count, i11);
        this.count += i11;
    }

    public void clear() {
        this.cache = null;
        this.count = 0;
    }

    public void ensureCapacity(int i10) {
        char[] cArr = this.buf;
        if (cArr.length < i10) {
            char[] cArr2 = new char[Math.max(i10, cArr.length * 2)];
            System.arraycopy(this.buf, 0, cArr2, 0, this.count);
            this.buf = cArr2;
        }
    }

    public int length() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }
}
