package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class PathParser implements Expression {
    protected boolean attribute;
    protected String cache;
    protected int count;
    protected char[] data;
    protected String location;
    protected int off;
    protected String path;
    protected int start;
    protected Style style;
    protected Type type;
    protected Cache<String> attributes = new ConcurrentCache();
    protected Cache<String> elements = new ConcurrentCache();
    protected List<Integer> indexes = new ArrayList();
    protected List<String> prefixes = new ArrayList();
    protected List<String> names = new ArrayList();
    protected StringBuilder builder = new StringBuilder();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class PathSection implements Expression {
        private int begin;
        private List<String> cache = new ArrayList();
        private int end;
        private String path;
        private String section;

        public PathSection(int i10, int i11) {
            this.begin = i10;
            this.end = i11;
        }

        private String getCanonicalPath() {
            int i10 = 0;
            int iIndexOf = 0;
            while (i10 < this.begin) {
                iIndexOf = PathParser.this.location.indexOf(47, iIndexOf + 1);
                i10++;
            }
            int iIndexOf2 = iIndexOf;
            while (i10 <= this.end) {
                iIndexOf2 = PathParser.this.location.indexOf(47, iIndexOf2 + 1);
                if (iIndexOf2 == -1) {
                    iIndexOf2 = PathParser.this.location.length();
                }
                i10++;
            }
            return PathParser.this.location.substring(iIndexOf + 1, iIndexOf2);
        }

        private String getFragment() {
            int i10 = PathParser.this.start;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 > this.end) {
                    break;
                }
                PathParser pathParser = PathParser.this;
                if (i10 >= pathParser.count) {
                    i10++;
                    break;
                }
                int i13 = i10 + 1;
                if (pathParser.data[i10] == '/' && (i11 = i11 + 1) == this.begin) {
                    i10 = i13;
                    i12 = i10;
                } else {
                    i10 = i13;
                }
            }
            return new String(PathParser.this.data, i12, (i10 - 1) - i12);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getAttribute(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getAttributePath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getElement(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getElementPath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getFirst() {
            return PathParser.this.names.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public int getIndex() {
            return PathParser.this.indexes.get(this.begin).intValue();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getLast() {
            return PathParser.this.names.get(this.end);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPath() {
            if (this.section == null) {
                this.section = getCanonicalPath();
            }
            return this.section;
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i10) {
            return getPath(i10, 0);
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i10, int i11) {
            return PathParser.this.new PathSection(this.begin + i10, this.end - i11);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPrefix() {
            return PathParser.this.prefixes.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isAttribute() {
            PathParser pathParser = PathParser.this;
            return pathParser.attribute && this.end >= pathParser.names.size() - 1;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isEmpty() {
            return this.begin == this.end;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isPath() {
            return this.end - this.begin >= 1;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            if (this.cache.isEmpty()) {
                for (int i10 = this.begin; i10 <= this.end; i10++) {
                    String str = PathParser.this.names.get(i10);
                    if (str != null) {
                        this.cache.add(str);
                    }
                }
            }
            return this.cache.iterator();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String toString() {
            if (this.path == null) {
                this.path = getFragment();
            }
            return this.path;
        }
    }

    public PathParser(String str, Type type, Format format) throws PathException {
        this.style = format.getStyle();
        this.type = type;
        this.path = str;
        parse(str);
    }

    private void align() {
        if (this.names.size() > this.indexes.size()) {
            this.indexes.add(1);
        }
    }

    private void attribute() throws PathException {
        char c10;
        int i10 = this.off + 1;
        this.off = i10;
        do {
            int i11 = this.off;
            if (i11 >= this.count) {
                if (i11 <= i10) {
                    throw new PathException("Attribute reference in '%s' for %s is empty", this.path, this.type);
                }
                this.attribute = true;
                attribute(i10, i11 - i10);
                return;
            }
            char[] cArr = this.data;
            this.off = i11 + 1;
            c10 = cArr[i11];
        } while (isValid(c10));
        throw new PathException("Illegal character '%s' in attribute for '%s' in %s", Character.valueOf(c10), this.path, this.type);
    }

    private void attribute(int i10, int i11) {
        String str = new String(this.data, i10, i11);
        if (i11 > 0) {
            attribute(str);
        }
    }

    private void attribute(String str) {
        String attribute = this.style.getAttribute(str);
        this.prefixes.add(null);
        this.names.add(attribute);
    }

    private void build() {
        int size = this.names.size();
        int i10 = size - 1;
        for (int i11 = 0; i11 < size; i11++) {
            String str = this.prefixes.get(i11);
            String str2 = this.names.get(i11);
            int iIntValue = this.indexes.get(i11).intValue();
            if (i11 > 0) {
                this.builder.append('/');
            }
            if (this.attribute && i11 == i10) {
                this.builder.append('@');
                this.builder.append(str2);
            } else {
                if (str != null) {
                    this.builder.append(str);
                    this.builder.append(':');
                }
                this.builder.append(str2);
                this.builder.append('[');
                this.builder.append(iIntValue);
                this.builder.append(']');
            }
        }
        this.location = this.builder.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        element(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void element() throws PathException {
        int i10 = this.off;
        int i11 = 0;
        while (true) {
            int i12 = this.off;
            if (i12 >= this.count) {
                break;
            }
            char[] cArr = this.data;
            this.off = i12 + 1;
            char c10 = cArr[i12];
            if (isValid(c10)) {
                i11++;
            } else if (c10 == '@') {
                this.off--;
            } else if (c10 == '[') {
                index();
            } else if (c10 != '/') {
                throw new PathException("Illegal character '%s' in element for '%s' in %s", Character.valueOf(c10), this.path, this.type);
            }
        }
    }

    private void element(int i10, int i11) {
        String str = new String(this.data, i10, i11);
        if (i11 > 0) {
            element(str);
        }
    }

    private void element(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf > 0) {
            strSubstring = str.substring(0, iIndexOf);
            str = str.substring(iIndexOf + 1);
        } else {
            strSubstring = null;
        }
        String element = this.style.getElement(str);
        this.prefixes.add(strSubstring);
        this.names.add(element);
    }

    private void index() throws PathException {
        int i10;
        if (this.data[this.off - 1] == '[') {
            i10 = 0;
            while (true) {
                int i11 = this.off;
                if (i11 >= this.count) {
                    break;
                }
                char[] cArr = this.data;
                this.off = i11 + 1;
                char c10 = cArr[i11];
                if (!isDigit(c10)) {
                    break;
                } else {
                    i10 = ((i10 * 10) + c10) - 48;
                }
            }
        } else {
            i10 = 0;
        }
        char[] cArr2 = this.data;
        int i12 = this.off;
        this.off = i12 + 1;
        if (cArr2[i12 - 1] != ']') {
            throw new PathException("Invalid index for path '%s' in %s", this.path, this.type);
        }
        this.indexes.add(Integer.valueOf(i10));
    }

    private boolean isDigit(char c10) {
        return Character.isDigit(c10);
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private boolean isLetter(char c10) {
        return Character.isLetterOrDigit(c10);
    }

    private boolean isSpecial(char c10) {
        return c10 == '_' || c10 == '-' || c10 == ':';
    }

    private boolean isValid(char c10) {
        return isLetter(c10) || isSpecial(c10);
    }

    private void parse(String str) throws PathException {
        if (str != null) {
            int length = str.length();
            this.count = length;
            char[] cArr = new char[length];
            this.data = cArr;
            str.getChars(0, length, cArr, 0);
        }
        path();
    }

    private void path() throws PathException {
        char c10 = this.data[this.off];
        if (c10 == '/') {
            throw new PathException("Path '%s' in %s references document root", this.path, this.type);
        }
        if (c10 == '.') {
            skip();
        }
        while (this.off < this.count) {
            if (this.attribute) {
                throw new PathException("Path '%s' in %s references an invalid attribute", this.path, this.type);
            }
            segment();
        }
        truncate();
        build();
    }

    private void segment() throws PathException {
        char c10 = this.data[this.off];
        if (c10 == '/') {
            throw new PathException("Invalid path expression '%s' in %s", this.path, this.type);
        }
        if (c10 == '@') {
            attribute();
        } else {
            element();
        }
        align();
    }

    private void skip() throws PathException {
        char[] cArr = this.data;
        if (cArr.length > 1) {
            int i10 = this.off;
            if (cArr[i10 + 1] != '/') {
                throw new PathException("Path '%s' in %s has an illegal syntax", this.path, this.type);
            }
            this.off = i10 + 1;
        }
        int i11 = this.off + 1;
        this.off = i11;
        this.start = i11;
    }

    private void truncate() {
        int i10 = this.off;
        int i11 = i10 - 1;
        char[] cArr = this.data;
        if (i11 >= cArr.length) {
            this.off = i10 - 1;
        } else if (cArr[i10 - 1] == '/') {
            this.off = i10 - 1;
        }
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getAttribute(String str) {
        if (isEmpty(this.location)) {
            return this.style.getAttribute(str);
        }
        String strFetch = this.attributes.fetch(str);
        if (strFetch == null && (strFetch = getAttributePath(this.location, str)) != null) {
            this.attributes.cache(str, strFetch);
        }
        return strFetch;
    }

    public String getAttributePath(String str, String str2) {
        String attribute = this.style.getAttribute(str2);
        if (isEmpty(str)) {
            return attribute;
        }
        return str + "/@" + attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getElement(String str) {
        if (isEmpty(this.location)) {
            return this.style.getElement(str);
        }
        String strFetch = this.elements.fetch(str);
        if (strFetch == null && (strFetch = getElementPath(this.location, str)) != null) {
            this.elements.cache(str, strFetch);
        }
        return strFetch;
    }

    public String getElementPath(String str, String str2) {
        String element = this.style.getElement(str2);
        if (isEmpty(element)) {
            return str;
        }
        if (isEmpty(str)) {
            return element;
        }
        return str + "/" + element + "[1]";
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getFirst() {
        return this.names.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public int getIndex() {
        return this.indexes.get(0).intValue();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getLast() {
        return this.names.get(this.names.size() - 1);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPath() {
        return this.location;
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i10) {
        return getPath(i10, 0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i10, int i11) {
        int size = (this.names.size() - 1) - i11;
        return size >= i10 ? new PathSection(i10, size) : new PathSection(i10, i10);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPrefix() {
        return this.prefixes.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isEmpty() {
        return isEmpty(this.location);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isPath() {
        return this.names.size() > 1;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.names.iterator();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String toString() {
        int i10 = this.off;
        int i11 = this.start;
        int i12 = i10 - i11;
        if (this.cache == null) {
            this.cache = new String(this.data, i11, i12);
        }
        return this.cache;
    }
}
