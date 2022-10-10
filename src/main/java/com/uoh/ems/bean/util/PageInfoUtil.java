package com.uoh.ems.bean.util;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageSerializable;
import com.uoh.ems.bean.ExpertInfo;

import java.util.Collection;
import java.util.List;

/**
 * @author: XDS
 * @description: 分页工具类
 * @date:2022-10-10
 */
public class PageInfoUtil {
   public static PageInfo  PageHelper(ExpertInfo e, List list) {
      Page<ExpertInfo> page = new Page<>(e.getPageNum(),e.getPageSize());
      int total = list.size();
      int totalPage = (total + e.getPageSize() -1) /e.getPageSize();
      page.setPages(totalPage);
      page.setTotal(total);
      int startIndex = (e.getPageNum() - 1) * e.getPageSize();
      int endIndex = Math.min(startIndex + e.getPageSize(), total);
      page.addAll(list.subList(startIndex, endIndex));
      PageInfo pageInfo = new PageInfo<>(page);
      return pageInfo;
   }
}


