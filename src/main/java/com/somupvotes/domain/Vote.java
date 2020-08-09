package com.somupvotes.domain;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Vote {


    @EmbeddedId
    private VoteId pk;
    private Boolean upvotes;

    public Boolean getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Boolean upvotes) {
        this.upvotes = upvotes;
    }
    public VoteId getPk() {
        return pk;
    }

    public void setPk(VoteId pk) {
        this.pk = pk;
    }

}
