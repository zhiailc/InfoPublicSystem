package com.lc.info.base;

import org.apache.commons.lang3.StringUtils;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public class BaseQuery {
	private static final Integer PAGE = 1;
	private static final Integer ROWS = 10;
	private Integer page;
	private Integer rows;
	private String sort;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public PageBounds bulidPageBounds() {
		if(page == null) {
			page = PAGE;
		}
		if(rows == null) {
			rows = ROWS;
		}
		if(StringUtils.isNoneBlank(sort)) {
			sort = "id.desc";
		}
		PageBounds pageBounds = new PageBounds(page,rows,Order.formString(sort));
		return pageBounds;
	}
	
}
