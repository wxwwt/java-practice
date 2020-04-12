package com.scott.java.task.clone;

/**
 * @author scott
 * @date 2019/12/22 21:59
 */

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * 图书类
 */
public class Book implements Cloneable {

    private Long id;

    private String bookname;

    private String author;

    private List<Chapter> chapterList;

    public Book() {
    }

    public Book(Long id, String bookname, String author, List<Chapter> chapterList) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.chapterList = chapterList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    /**
     * 重写Object的clone方法
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Chapter chapter1 = new Chapter("第一章", 2500, 15);
        Chapter chapter2 = new Chapter("第二章", 2600, 16);
        Book book = new Book(1L, "三国演义", "罗贯中", Lists.newArrayList(chapter1, chapter2));
        Book cloneBook = (Book) book.clone();
        System.out.println(book == cloneBook);  //false
        System.out.println(book.getChapterList() == cloneBook.getChapterList()); //true

        //给book对象的chapterList加一个元素，可以看到cloneBook的chapter也变化了
        book.getChapterList().add(new Chapter("第三章", 2500, 15));
        book.getChapterList().stream().forEach(System.out::println);
        System.out.println(cloneBook.getChapterList().size()); //3
        System.out.println(JSONObject.toJSONString(cloneBook.getChapterList()));
    }
}