package com.shen.uac.dao;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.awt.print.Book;

@Component
@org.apache.ibatis.annotations.Mapper
public interface BookDao extends Mapper<Book> {

}
