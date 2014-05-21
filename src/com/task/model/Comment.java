package com.task.model;

public class Comment {
	private String id;
	private String text;
	
	public Comment(){}
	
	public String getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + "]";
	}
	
}
