package org.simpleframework.xml.filter;

import java.util.Stack;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class StackFilter implements Filter {
    private Stack<Filter> stack = new Stack<>();

    public void push(Filter filter) {
        this.stack.push(filter);
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        String strReplace;
        int size = this.stack.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            strReplace = this.stack.get(size).replace(str);
        } while (strReplace == null);
        return strReplace;
    }
}
