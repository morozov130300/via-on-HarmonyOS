package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class TemplateEngine {
    private Filter filter;
    private int off;
    private Template source = new Template();
    private Template name = new Template();
    private Template text = new Template();

    public TemplateEngine(Filter filter) {
        this.filter = filter;
    }

    private void name() {
        while (true) {
            int i10 = this.off;
            Template template = this.source;
            if (i10 >= template.count) {
                break;
            }
            char[] cArr = template.buf;
            this.off = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '}') {
                replace();
                break;
            }
            this.name.append(c10);
        }
        if (this.name.length() > 0) {
            this.text.append("${");
            this.text.append(this.name);
        }
    }

    private void parse() {
        while (true) {
            int i10 = this.off;
            Template template = this.source;
            int i11 = template.count;
            if (i10 >= i11) {
                return;
            }
            char[] cArr = template.buf;
            int i12 = i10 + 1;
            this.off = i12;
            char c10 = cArr[i10];
            if (c10 == '$' && i12 < i11) {
                this.off = i10 + 2;
                if (cArr[i12] == '{') {
                    name();
                } else {
                    this.off = i10 + 1;
                }
            }
            this.text.append(c10);
        }
    }

    private void replace() {
        if (this.name.length() > 0) {
            replace(this.name);
        }
        this.name.clear();
    }

    public void clear() {
        this.name.clear();
        this.text.clear();
        this.source.clear();
        this.off = 0;
    }

    public String process(String str) {
        if (str.indexOf(36) < 0) {
            return str;
        }
        try {
            this.source.append(str);
            parse();
            return this.text.toString();
        } finally {
            clear();
        }
    }

    private void replace(Template template) {
        replace(template.toString());
    }

    private void replace(String str) {
        String strReplace = this.filter.replace(str);
        if (strReplace == null) {
            this.text.append("${");
            this.text.append(str);
            this.text.append("}");
            return;
        }
        this.text.append(strReplace);
    }
}
