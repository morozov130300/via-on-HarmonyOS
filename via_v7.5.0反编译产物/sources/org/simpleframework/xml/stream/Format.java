package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Format {
    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format() {
        this(3);
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }

    public Format(int i10) {
        this(i10, (String) null, new IdentityStyle());
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(int i10, String str) {
        this(i10, str, new IdentityStyle());
    }

    public Format(Verbosity verbosity) {
        this(3, verbosity);
    }

    public Format(int i10, Verbosity verbosity) {
        this(i10, new IdentityStyle(), verbosity);
    }

    public Format(Style style) {
        this(3, style);
    }

    public Format(Style style, Verbosity verbosity) {
        this(3, style, verbosity);
    }

    public Format(int i10, Style style) {
        this(i10, (String) null, style);
    }

    public Format(int i10, Style style, Verbosity verbosity) {
        this(i10, null, style, verbosity);
    }

    public Format(int i10, String str, Style style) {
        this(i10, str, style, Verbosity.HIGH);
    }

    public Format(int i10, String str, Style style, Verbosity verbosity) {
        this.verbosity = verbosity;
        this.prolog = str;
        this.indent = i10;
        this.style = style;
    }
}
