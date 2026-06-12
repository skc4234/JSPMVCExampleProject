package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.GoodsDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import com.sist.vo.*;

@Controller
public class GoodsModel {
	private String[] table= {
		"",
		"goods_all",
		"goods_best",
		"goods_new",
		"goods_special"
	};
	
	private String[] title= {
		"",
		"전체 상품",
		"베스트 상품",
		"신상품",
		"특가 상품"
	};
	
	private String[] order= {
		"",
		"no ASC",
		"hit DESC",
		"goods_name ASC"
	};
	@RequestMapping("goods/list.do")
	public String goods_list(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		if(page==null) page="1";
		String tno=request.getParameter("tno");
		if(tno==null) tno="1";
		
		int curPage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("table", table[Integer.parseInt(tno)]);
		map.put("start", (curPage*12)-12);
		
		List<GoodsVO> list=GoodsDAO.goodsListData(map);
		int totalPage=GoodsDAO.goodsTotalPage(map);
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		request.setAttribute("tno", tno);
		request.setAttribute("title", title[Integer.parseInt(tno)]);
		
		return "../goods/list.jsp";
	}
	
	@RequestMapping("goods/detail.do")
	public String goods_detail(HttpServletRequest request, HttpServletResponse response) {
		String no=request.getParameter("no");
		String tno=request.getParameter("tno");
		int page=(Integer.parseInt(no)-1)/12+1;
		Map map=new HashMap();
		map.put("no", Integer.parseInt(no));
		map.put("table", table[Integer.parseInt(tno)]);
		
		GoodsVO vo=GoodsDAO.goodsDetailData(map);
		
		request.setAttribute("vo", vo);
		request.setAttribute("tno", tno);
		request.setAttribute("page", page);
		
		return "../goods/detail.jsp";
	}
}
