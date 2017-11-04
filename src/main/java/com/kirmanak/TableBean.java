package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import javax.annotation.PreDestroy;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

@ManagedBean
@ApplicationScoped
public class TableBean implements Serializable {
    private final List<RowBean> list;

    public TableBean () {
      list = new ArrayList<>();
    }

    public String getListAsJson () {
        return new Gson().toJson(getList());
    }

    public List<RowBean> getList () {
        final List<RowEntity> results = ORM.getRows(); 
        if (results != null) {
            list.clear();
            for (final RowEntity entity: results) {
              final RowBean bean = new RowBean();
              bean.setR(entity.getR());
              bean.setX(entity.getX());
              bean.setY(entity.getY());
              list.add(bean);
            }
        }
    	return list;
    }

    @PreDestroy
    public void clear () {
        ORM.clear();
    }

}
