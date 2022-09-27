package com.projects.commons;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class LocalDatePropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String result[]=text.split("-");
		System.out.println(result);
		Integer year=Integer.parseInt( result[0]);
		Integer month=Integer.parseInt(result[1]);
		Integer day=Integer.parseInt(result[2]);
		LocalDate date= LocalDate.of(year, month, day);
		setValue(date);
	}
}
