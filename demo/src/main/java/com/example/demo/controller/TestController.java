package com.example.demo.controller;

import com.example.demo.dao.ArticleSearchRepository;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.Author;
import com.example.demo.pojo.Tutorial;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by admin on 17/6/1.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @RequestMapping("/add")
    public String testSaveArticleIndex() {
        Author author = new Author();
        author.setId(1L);
        author.setName("test");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        return articleSearchRepository.save(article).toString();
    }

    @RequestMapping("/query")
    public String testSearch() {
        String queryString = "springboot";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        StringBuffer sb = new StringBuffer();
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            //System.out.println(iterator.next());
        }
        logger.info(sb.toString());
        return sb.toString();
    }
}