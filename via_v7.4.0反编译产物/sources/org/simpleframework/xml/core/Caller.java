package org.simpleframework.xml.core;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Caller {
    private final Function commit;
    private final Function complete;
    private final Context context;
    private final Function persist;
    private final Function replace;
    private final Function resolve;
    private final Function validate;

    public Caller(Scanner scanner, Context context) {
        this.validate = scanner.getValidate();
        this.complete = scanner.getComplete();
        this.replace = scanner.getReplace();
        this.resolve = scanner.getResolve();
        this.persist = scanner.getPersist();
        this.commit = scanner.getCommit();
        this.context = context;
    }

    public void commit(Object obj) {
        Function function = this.commit;
        if (function != null) {
            function.call(this.context, obj);
        }
    }

    public void complete(Object obj) {
        Function function = this.complete;
        if (function != null) {
            function.call(this.context, obj);
        }
    }

    public void persist(Object obj) {
        Function function = this.persist;
        if (function != null) {
            function.call(this.context, obj);
        }
    }

    public Object replace(Object obj) {
        Function function = this.replace;
        return function != null ? function.call(this.context, obj) : obj;
    }

    public Object resolve(Object obj) {
        Function function = this.resolve;
        return function != null ? function.call(this.context, obj) : obj;
    }

    public void validate(Object obj) {
        Function function = this.validate;
        if (function != null) {
            function.call(this.context, obj);
        }
    }
}
