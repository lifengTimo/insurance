package com.lifeng.insurance.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

/**
 * 分页工具类
 * @author PA
 *
 */
public final class QueryTool {
    public static PageRequest buildPageRequest(int pageNumber, int pageSize){
        Sort sort = new Sort(Direction.DESC, "createTime");;
      
        
        return new PageRequest(pageNumber, pageSize, sort);
    }

}