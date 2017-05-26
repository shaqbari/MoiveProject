package com.sist.movie;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author user
 *	Collectio : 자료구조
 *===========================================
 *list                           set(중복허용x, 순서x)                  Map(key는 중복x)
 *=============                  ==================                 =============================
 *ArrayList:DataBase(비동기화)                                         Map: HashMap(key-value, 클래스 등록)
 *Vector:NetWork(동기화)
 *LinkedList
 *
 *예외처리
 * =목적 : 비정상 종료를 방지하고 정상상태 유지
 * =체크(컴파일할때 체크), 언체크(runtimeException)
 * 			Object
 * 			|
 * 			Throwable
 * 			|
 *			--------------------
 *			|					|
 *			Error             Exception
 * 								|
 * 							--------------------------
 * 							|						|
 * 							Check					nonCheck
 * 													RuntimeException :할수도 있고 안할수도 있음
 * 													|
 * 													ArrayIndexOutOfBoundsException
 * 													NumberFormatException
 * 													NullPointerException
 * 													ClassCastException
 * 													ArithmeticException
 * 
 * 							IOException
 * 							SQLException
 * 							ClassNotFoundException
 * 	=직접처리 
 * 		try{
 * 			정상수행할 수 있는 코드
 * 		}catch(예외처리 종류){
 * 			예외처리 순서가 있다.
 * 		}finally{
 * 
 * 		}
 * 	=간접처리 
 * 		throws
 * 
 * 	=임의발생
 * 		throw
 * 
 * 	=사용자정의
 *
 */
public class MovieManager {
	
	
	/*<div class="box-image" >
                        <strong class="rank">No.1</strong>	
                        <a href="/movies/detail-view/?midx=79598">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79598/79598_185.jpg" alt="캐리비안의 해적: 죽은 자는 말이 없다 포스터" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-12">12세 이상</span>
                            </span>
       	웹 크롤링
	 */
	public List<MovieVO> movieMainData(){
		List<MovieVO> list=new ArrayList<MovieVO>();
		
		try{
			//소스읽기
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
			//System.out.println(doc);
			Elements poster=doc.select("div.box-image a span.thumb-image img");//css읽는 법을 따른다.
			//Elements grade=doc.select("div.box-image a span.thumb-image span.icon-grade"); 약식으로 써도 된다.
			Elements grade=doc.select("div.box-image span.ico-grade");
			Elements link=doc.select("div.box-contents a");
			//Elements link=doc.select("div.box-contents a:eq()");로 짝수별로 얻어올수 있다.
			int j=0;//하나씩 건너뛰기위해 사용할 변수 +2씩 더하자.			
			//for(int i=0; i<poster.size(); i++){//더보기에 이미지가 더 있어서 처음 7개만 읽자
			for(int i=0; i<7; i++){ 
				Element pElem=poster.get(i);
				String image=pElem.attr("src");
				Element gElem=grade.get(i);
				Element lElem=link.get(j);
				String link_data=lElem.attr("href");
				j+=2;
				/*
				 * 값을 읽어올때
				 * attr() <a href="sdsd">
				 * 				   ****
				 * text() <a>aaa</a>
				 *           ***
				 * html() <a><span>aaaa</span><b>bbb</b></a> 모양까지 가져오고 싶을때
				 * 			 ***************************  
				 * */
				
				System.out.println(image+"  "+gElem.text()+"  "+link_data);
				
				MovieVO vo=new MovieVO();
				vo.setPoster(image);
				vo.setGrade(gElem.text());
				link_data=link_data.substring(link_data.lastIndexOf("=")+1);
				vo.setLink(link_data);
				
				list.add(vo);
			}
			
			//실시간으로 보여주려면 웹상에서 
			//제공하는쪽에서 tag를 바꾸면 못읽는다.
			//그러므로 오라클에 저장해둬야 백업으로 두고 쓸수 있다.
			
		}catch(Exception ex){//io예외에 대비
			System.out.println(ex);
			
		}
		
		
		
		return list;
		
	}
	
	public static void main(String[] args) {
		MovieManager mm=new MovieManager();
		mm.movieMainData();
	}
}
