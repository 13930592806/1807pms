package com.zs.pms.util;

import java.util.Date;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	//s:源 被转换的类型
	//T：target目标类型 将要转换的类型
	//ST 类型修改后才能实现接口里的方法
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getInputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
