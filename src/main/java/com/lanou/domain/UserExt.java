package com.lanou.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class UserExt {
    private User user;
    private List<Integer> idList;//id集合

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
