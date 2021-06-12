package com.projectNanuram.entity;

import java.util.ArrayList;
import java.util.List;

public class BookWrapper {

    private List<Book>bookList;

    public BookWrapper(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookWrapper() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
	private List<ColorTest>colorList;

	public List<ColorTest> getColorList() {
		return colorList;
	}
	public void setColorList(List<ColorTest> colorList2) {
		this.colorList = colorList2;
	}
}
