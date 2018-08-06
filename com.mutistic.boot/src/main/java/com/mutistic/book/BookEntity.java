package com.mutistic.book;

public class BookEntity {
	
}

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// * @program 图书实体类
// * @description Entity
// * @author mutisitic
// * @date 2018年6月4日
// */
//@Entity
//@Table(name = "book", catalog = "study")
//public class BookEntity implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1910645179881212669L;
//	
//	/**
//	 * 图书ID
//	 */
//	@Id
//	@GeneratedValue
//	@Column(name = "book_id", unique = true, nullable = false)
//	private Long bookId;
//	/**
//	 * 读者
//	 */
//	@Column(name = "reader")
//	private String reader;
//	/**
//	 * 国际标准图书编号
//	 */
//	@Column(name = "isbn")
//	private String isbn;
//	/**
//	 * 标题
//	 */
//	@Column(name = "title")
//	private String title;
//	/**
//	 * 作者
//	 */
//	@Column(name = "author")
//	private String author;
//	/**
//	 * 图书描述信息
//	 */
//	@Column(name = "description")
//	private String description;
//	
//	public Long getBookId() {
//		return bookId;
//	}
//	public void setBookId(Long bookId) {
//		this.bookId = bookId;
//	}
//	public String getReader() {
//		return reader;
//	}
//	public void setReader(String reader) {
//		this.reader = reader;
//	}
//	public String getIsbn() {
//		return isbn;
//	}
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	
//}
