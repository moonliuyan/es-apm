package com.liuyan.javaapmdemon.controller;

import com.liuyan.javaapmdemon.ResponseEntity;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @user: liuyan
 * @date:2020/8/13 0013 13:23
 * @desc: ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃
 * ┃　　　　　　 ┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃
 * ┗━┓　　　┏━━━┛
 * ┃　　　┃   Code is far away from bug with the animal protecting
 * ┃　　　┃
 * ┃　　　┗━━━━━━━━━┓
 * ┃　　　　　　　    ┣┓
 * ┃　　　　         ┏┛
 * ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * ┃ ┫ ┫   ┃ ┫ ┫
 * ┗━┻━┛   ┗━┻━┛
 */

@RestController
@RequestMapping("/esapi")
public class ESApiController {

    private static final String UserInfoIndexName  = "user_info_01";
    @Autowired
    RestHighLevelClient restHighLevelClient;

    /**
     * 新增数据
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ResponseEntity<IndexResponse> add() throws IOException {

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap);

        IndexResponse indexResponse= restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return new ResponseEntity(200,"ok",indexResponse);

    }

    /**
     * 删除数据
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public ResponseEntity<DeleteResponse> delete() throws IOException {

        DeleteRequest deleteRequest = new DeleteRequest(
                "posts",
                "1");
        DeleteResponse deleteResponse= restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return new ResponseEntity(200,"ok",deleteResponse);
    }

    /**
     * 删除数据
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public ResponseEntity<UpdateRequest> edit() throws IOException {

        UpdateRequest updateRequest = new UpdateRequest(
                "posts",
                "1");
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("updated", new Date());
        jsonMap.put("reason", "daily update");
        updateRequest.doc(jsonMap);
        updateRequest.docAsUpsert(true);
        UpdateResponse updateResponse= restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        return new ResponseEntity(200,"ok",updateResponse);
    }
    /**
     * 获取单条数据
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseEntity<GetResponse> get() throws IOException {

        GetRequest getRequest = new GetRequest(
                "posts",
                "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        return new ResponseEntity(200,"ok",getResponse);
    }
    /**
     * 查询多条数据
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public ResponseEntity<SearchResponse> search() throws IOException {

        SearchRequest searchRequest = new SearchRequest(
                "kibana_sample_data_flights");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("FlightNum", "ZZUNQKL"));
        sourceBuilder.from(0);
        sourceBuilder.size(20);
        searchRequest.source(sourceBuilder);

        System.out.println(searchRequest.source().toString());
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        searchResponse.getHits().getHits()
        return new ResponseEntity(200,"ok",searchResponse);
    }
}

