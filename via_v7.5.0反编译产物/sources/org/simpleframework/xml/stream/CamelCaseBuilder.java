package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class CamelCaseBuilder implements Style {
    protected final boolean attribute;
    protected final boolean element;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class Attribute extends Splitter {
        private boolean capital;

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

        private Attribute(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class Element extends Attribute {
        private boolean capital;

        @Override // org.simpleframework.xml.stream.CamelCaseBuilder.Attribute, org.simpleframework.xml.stream.Splitter
        public void parse(char[] cArr, int i10, int i11) {
            if (CamelCaseBuilder.this.element || this.capital) {
                cArr[i10] = toUpper(cArr[i10]);
            }
            this.capital = true;
        }

        private Element(String str) {
            super(str);
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
