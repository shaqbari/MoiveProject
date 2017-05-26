package com.sist.movie;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author user
 *	Collectio : �ڷᱸ��
 *===========================================
 *list                           set(�ߺ����x, ����x)                  Map(key�� �ߺ�x)
 *=============                  ==================                 =============================
 *ArrayList:DataBase(�񵿱�ȭ)                                         Map: HashMap(key-value, Ŭ���� ���)
 *Vector:NetWork(����ȭ)
 *LinkedList
 *
 *����ó��
 * =���� : ������ ���Ḧ �����ϰ� ������� ����
 * =üũ(�������Ҷ� üũ), ��üũ(runtimeException)
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
 * 													RuntimeException :�Ҽ��� �ְ� ���Ҽ��� ����
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
 * 	=����ó�� 
 * 		try{
 * 			��������� �� �ִ� �ڵ�
 * 		}catch(����ó�� ����){
 * 			����ó�� ������ �ִ�.
 * 		}finally{
 * 
 * 		}
 * 	=����ó�� 
 * 		throws
 * 
 * 	=���ǹ߻�
 * 		throw
 * 
 * 	=���������
 *
 */
public class MovieManager {
	
	
	/*<div class="box-image" >
                        <strong class="rank">No.1</strong>	
                        <a href="/movies/detail-view/?midx=79598">
                            <span class="thumb-image">
                                <img src="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79598/79598_185.jpg" alt="ĳ������� ����: ���� �ڴ� ���� ���� ������" onerror="errorImage(this)"/>
                                <span class="ico-grade grade-12">12�� �̻�</span>
                            </span>
       	�� ũ�Ѹ�
	 */
	public List<MovieVO> movieMainData(){
		List<MovieVO> list=new ArrayList<MovieVO>();
		
		try{
			//�ҽ��б�
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
			//System.out.println(doc);
			Elements poster=doc.select("div.box-image a span.thumb-image img");//css�д� ���� ������.
			//Elements grade=doc.select("div.box-image a span.thumb-image span.icon-grade"); ������� �ᵵ �ȴ�.
			Elements grade=doc.select("div.box-image span.ico-grade");
			Elements link=doc.select("div.box-contents a");
			//Elements link=doc.select("div.box-contents a:eq()");�� ¦������ ���ü� �ִ�.
			int j=0;//�ϳ��� �ǳʶٱ����� ����� ���� +2�� ������.			
			//for(int i=0; i<poster.size(); i++){//�����⿡ �̹����� �� �־ ó�� 7���� ����
			for(int i=0; i<7; i++){ 
				Element pElem=poster.get(i);
				String image=pElem.attr("src");
				Element gElem=grade.get(i);
				Element lElem=link.get(j);
				String link_data=lElem.attr("href");
				j+=2;
				/*
				 * ���� �о�ö�
				 * attr() <a href="sdsd">
				 * 				   ****
				 * text() <a>aaa</a>
				 *           ***
				 * html() <a><span>aaaa</span><b>bbb</b></a> ������ �������� ������
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
			
			//�ǽð����� �����ַ��� ���󿡼� 
			//�����ϴ��ʿ��� tag�� �ٲٸ� ���д´�.
			//�׷��Ƿ� ����Ŭ�� �����ص־� ������� �ΰ� ���� �ִ�.
			
		}catch(Exception ex){//io���ܿ� ���
			System.out.println(ex);
			
		}
		
		
		
		return list;
		
	}
	
	public static void main(String[] args) {
		MovieManager mm=new MovieManager();
		mm.movieMainData();
	}
}
