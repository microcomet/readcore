/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年12月11日 上午2:09:04.
 */

package com.cleanread.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.mybatis.spring.SqlSessionTemplate;

import com.cleanread.model.Article;
import com.cleanread.model.Chapter;
import com.cleanread.service.NovelService;
import com.cleanread.util.Constant;

/**
 * @author fanwei
 *
 */
public class NovelServiceImpl implements NovelService {
	
	private SqlSessionTemplate sqlSessionTemplate;

	

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}


	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	public boolean saveArticle(Article article) {
		// TODO Auto-generated method stub
		if(article == null || article.getArticleName() == null){
			return false;
		}
		try {
			File path = new File(Constant.NOVEL_STORAGE_DIRETORY + article.getArticleName());
			if(!(path.exists()&&path.isDirectory())){
				if(!path.mkdirs()) return false;
			}
			File file = new File(Constant.NOVEL_STORAGE_DIRETORY + article.getArticleName() + "//" + article.getArticleName() + ".txt");
			if(file.isFile() && file.exists())
			{
				file.delete();
			}
			StringBuffer sb = new StringBuffer();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for(int i = 0; i < article.getContent().size(); i++){
				Chapter cp = article.getContent().get(i);
				sb.append(cp.getChapterId());
				sb.append("  ");
				sb.append(cp.getChapterName());
				sb.append("\r\n");
				sb.append(cp.getContent());
				out.write(sb.toString());
				sb.delete(0, sb.length());
			}
			out.flush();
			out.close();
			return true;
		} catch(IOException e){
			e.printStackTrace();
		}
		finally{
			
		}
		return false;
	}
}
