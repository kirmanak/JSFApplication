package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import javax.annotation.PreDestroy;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {
    private final List<RowBean> list;
    private final String sessionId;

    public TableBean () {
      list = new ArrayList<>();
      final RowBean example = new RowBean();
      list.add(example);
      sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
    }

    public List<RowBean> getList () {
        /*
        final List<RowBean> results = ORM.getRows(sessionId); 
        if (results != null) {
            list.clear();
            list.addAll(results);
        }
        */
    	return list;
    }

    public String getSessionId () {
        return this.sessionId;
    }

    @PreDestroy
    private void removeSession () {
        /*
        ORM.removeSession(getSessionId());
        */
    }

}
