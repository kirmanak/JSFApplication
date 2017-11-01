package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import javax.annotation.PreDestroy;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {
    private final List<RowBean> list;
    private final String sessionId;

    public TableBean () {
      list = new ArrayList<>();
      final RowBean example = new RowBean();
      example.setX(1);
      example.setY(-2);
      example.setR(2);
      list.add(example);
      final RowBean secondExample = new RowBean();
      secondExample.setX(-1);
      secondExample.setY(-1);
      secondExample.setR(5);
      list.add(secondExample);
      sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
    }

    public String getListAsJson () {
        return new Gson().toJson(getList());
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
    public void removeSession () {
        /*
        ORM.removeSession(getSessionId());
        */
    }

}
