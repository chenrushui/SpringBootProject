package com.demo.www.springbootdemo.mapper;

import com.demo.www.springbootdemo.pojo.Title;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2019/3/24.
 * author:crs
 * Description:TitleMapper
 */
@Mapper
public interface TitleMapper {

    /**
     * 插入新的职称
     *
     * @param title
     * @return
     */
    int insertNewTitle(Title title);

    List<Title> selectByType(Integer id);

    List<Title> selectAll();

    Title selectById(Integer id);

    Title updateByPrimaryKeySelective(Title title);

    int deleteTitleById(Integer id);


}
