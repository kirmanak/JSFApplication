package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {
    private final List<RowBean> list;

    public TableBean () {
      list = new ArrayList<>();
    }

    public List<RowBean> getList () {
    	// here should be call to ORM
    	// call returns list rowbeans of current session
    	// sorf of ORM.getList(this);
    	return list;
    }
}
