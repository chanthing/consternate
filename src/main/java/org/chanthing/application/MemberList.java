package org.chanthing.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(contentAs=MemberBean.class)
public class MemberList extends ArrayList<MemberBean> implements Serializable
{

    public int id;

	public MemberList() {
	}

	@XmlElement(name="Member")
	public List<MemberBean> getList() {
		return this;
	}

	public Iterator<MemberBean>  getValues() {
		return (Iterator<MemberBean> )iterator();
	}

	public void setValues(Collection<MemberBean> v) {
		addAll(v);
	}

}
