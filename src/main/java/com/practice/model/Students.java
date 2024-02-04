package com.practice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {

	private List<Student> stuList;

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

}
