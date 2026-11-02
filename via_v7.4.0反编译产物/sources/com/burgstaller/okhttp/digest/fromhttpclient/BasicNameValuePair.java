package com.burgstaller.okhttp.digest.fromhttpclient;

import java.io.Serializable;
import y0.i;
import y0.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class BasicNameValuePair implements j, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = str;
        this.value = str2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        return (this.name.equals(basicNameValuePair.name) && this.value == basicNameValuePair.value) || ((str = this.value) != null && str.equals(basicNameValuePair.value));
    }

    @Override // y0.j
    public String getName() {
        return this.name;
    }

    @Override // y0.j
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return i.d(i.d(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb2 = new StringBuilder(this.name.length() + 1 + this.value.length());
        sb2.append(this.name);
        sb2.append("=");
        sb2.append(this.value);
        return sb2.toString();
    }
}
