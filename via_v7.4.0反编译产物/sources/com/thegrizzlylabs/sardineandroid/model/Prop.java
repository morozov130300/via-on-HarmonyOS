package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root(strict = false)
/* loaded from: classes.dex */
public class Prop implements EntityWithAnyElement {

    @Element(required = false)
    protected Acl acl;
    protected List<org.w3c.dom.Element> any;

    @Element(required = false)
    protected String creationdate;

    @Element(name = "current-user-privilege-set")
    private CurrentUserPrivilegeSet currentUserPrivilegeSet;

    @Element(required = false)
    protected String displayname;

    @Element(required = false)
    protected String getcontentlanguage;

    @Element(required = false)
    protected String getcontentlength;

    @Element(required = false)
    protected String getcontenttype;

    @Element(required = false)
    protected String getetag;

    @Element(required = false)
    protected String getlastmodified;

    @Element(required = false)
    protected Group group;

    @Element(required = false)
    protected Lockdiscovery lockdiscovery;

    @Element(required = false)
    protected Owner owner;

    @Element(name = "principal-collection-set", required = false)
    private PrincipalCollectionSet principalCollectionSet;

    @Element(name = "current-user-principal", required = false)
    private PrincipalURL principalURL;

    @Element(name = "quota-available-bytes", required = false)
    protected QuotaAvailableBytes quotaAvailableBytes;

    @Element(name = "quota-used-bytes", required = false)
    protected QuotaUsedBytes quotaUsedBytes;

    @Element(required = false)
    protected Resourcetype resourcetype;

    @Element(required = false)
    protected Supportedlock supportedlock;

    public Acl getAcl() {
        return this.acl;
    }

    @Override // com.thegrizzlylabs.sardineandroid.model.EntityWithAnyElement
    public List<org.w3c.dom.Element> getAny() {
        if (this.any == null) {
            this.any = new ArrayList();
        }
        return this.any;
    }

    public String getCreationdate() {
        return this.creationdate;
    }

    public CurrentUserPrivilegeSet getCurrentUserPrivilegeSet() {
        return this.currentUserPrivilegeSet;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public String getGetcontentlanguage() {
        return this.getcontentlanguage;
    }

    public String getGetcontentlength() {
        return this.getcontentlength;
    }

    public String getGetcontenttype() {
        return this.getcontenttype;
    }

    public String getGetetag() {
        return this.getetag;
    }

    public String getGetlastmodified() {
        return this.getlastmodified;
    }

    public Group getGroup() {
        return this.group;
    }

    public Lockdiscovery getLockdiscovery() {
        return this.lockdiscovery;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public PrincipalCollectionSet getPrincipalCollectionSet() {
        return this.principalCollectionSet;
    }

    public PrincipalURL getPrincipalURL() {
        return this.principalURL;
    }

    public QuotaAvailableBytes getQuotaAvailableBytes() {
        return this.quotaAvailableBytes;
    }

    public QuotaUsedBytes getQuotaUsedBytes() {
        return this.quotaUsedBytes;
    }

    public Resourcetype getResourcetype() {
        return this.resourcetype;
    }

    public Supportedlock getSupportedlock() {
        return this.supportedlock;
    }

    public void setAcl(Acl acl) {
        this.acl = acl;
    }

    public void setCreationdate(String str) {
        this.creationdate = str;
    }

    public void setCurrentUserPrivilegeSet(CurrentUserPrivilegeSet currentUserPrivilegeSet) {
        this.currentUserPrivilegeSet = currentUserPrivilegeSet;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public void setGetcontentlanguage(String str) {
        this.getcontentlanguage = str;
    }

    public void setGetcontentlength(String str) {
        this.getcontentlength = str;
    }

    public void setGetcontenttype(String str) {
        this.getcontenttype = str;
    }

    public void setGetetag(String str) {
        this.getetag = str;
    }

    public void setGetlastmodified(String str) {
        this.getlastmodified = str;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setLockdiscovery(Lockdiscovery lockdiscovery) {
        this.lockdiscovery = lockdiscovery;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrincipalCollectionSet(PrincipalCollectionSet principalCollectionSet) {
        this.principalCollectionSet = principalCollectionSet;
    }

    public void setPrincipalURL(PrincipalURL principalURL) {
        this.principalURL = principalURL;
    }

    public void setQuotaAvailableBytes(QuotaAvailableBytes quotaAvailableBytes) {
        this.quotaAvailableBytes = quotaAvailableBytes;
    }

    public void setQuotaUsedBytes(QuotaUsedBytes quotaUsedBytes) {
        this.quotaUsedBytes = quotaUsedBytes;
    }

    public void setResourcetype(Resourcetype resourcetype) {
        this.resourcetype = resourcetype;
    }

    public void setSupportedlock(Supportedlock supportedlock) {
        this.supportedlock = supportedlock;
    }
}
