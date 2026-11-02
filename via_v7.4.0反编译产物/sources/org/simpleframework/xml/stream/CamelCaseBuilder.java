package org.simpleframework.xml.stream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CamelCaseBuilder implements Style {
    protected final boolean attribute;
    protected final boolean element;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class Attribute extends Splitter {
        private boolean capital;

        private Attribute(String str) {
            super(str);
        }

        @Override // org.simpleframework.xml.stream.Splitter
        public void commit(char[] cArr, int i10, int i11) {
            this.builder.append(cArr, i10, i11);
        }

        @Override // org.simpleframework.xml.stream.Splitter
        public void parse(char[] cArr, int i10, int i11) {
            if (CamelCaseBuilder.this.attribute || this.capital) {
                cArr[i10] = toUpper(cArr[i10]);
            }
            this.capital = true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class Element extends Attribute {
        private boolean capital;

        private Element(String str) {
            super(str);
        }

        @Override // org.simpleframework.xml.stream.CamelCaseBuilder.Attribute, org.simpleframework.xml.stream.Splitter
        public void parse(char[] cArr, int i10, int i11) {
            if (CamelCaseBuilder.this.element || this.capital) {
                cArr[i10] = toUpper(cArr[i10]);
            }
            this.capital = true;
        }
    }

    public CamelCaseBuilder(boolean z10, boolean z11) {
        this.attribute = z11;
        this.element = z10;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        if (str != null) {
            return new Attribute(str).process();
        }
        return null;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        if (str != null) {
            return new Element(str).process();
        }
        return null;
    }
}
