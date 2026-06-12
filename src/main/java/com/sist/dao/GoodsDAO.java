package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
public class GoodsDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 기능
	// 1. 목록 출력
	public static List<GoodsVO> goodsListData(Map map) {
		SqlSession session=ssf.openSession();
		List<GoodsVO> list=session.selectList("goodsListData",map);
		if(session!=null) session.close();
		return list;
	}
	
	// 1-1. 총페이지
	public static int goodsTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("goodsTotalPage",map);
		if(session!=null) session.close();
		return total;
	}
	
	// 2. 상세보기
	public static GoodsVO goodsDetailData(Map map) {
		SqlSession session=ssf.openSession();
		session.update("hitIncrement",map);
		session.commit();
		GoodsVO vo=session.selectOne("goodsDetailData",map);
		if(session!=null) session.close();
		return vo;
	}
}
