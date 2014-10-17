package com.sapient.vo;

import java.util.Set;

public class Author {

	private int authorId;
	private String authorName;
	private AuthorContact authorContact;
	private Set<Book> authorBooks;

	public Set<Book> getAuthorBooks() {
		return authorBooks;
	}

	public void setAuthorBooks(Set<Book> authorBooks) {
		this.authorBooks = authorBooks;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public AuthorContact getAuthorContact() {
		return authorContact;
	}

	public void setAuthorContact(AuthorContact authorContact) {
		this.authorContact = authorContact;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result
				+ ((authorName == null) ? 0 : authorName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (authorId != other.authorId)
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}

}
