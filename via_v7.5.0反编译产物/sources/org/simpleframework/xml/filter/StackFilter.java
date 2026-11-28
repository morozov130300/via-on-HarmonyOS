package org.simpleframework.xml.filter;

import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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
