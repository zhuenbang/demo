package com.example.demo.api;

import com.example.demo.vo.people;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author zhuenbang
 * @description
 * @date 2018/9/3 18:52
 */
@RestController
public class SearchApi {
    @Autowired
    private TransportClient client;

    /**
     * @Description: 查询数据
     * @Param: [id]
     * @returns: org.springframework.http.ResponseEntity
     * @Author: zhuenbang
     * @Date: 2018/9/3 19:21
     */
    @GetMapping("/get/people/man")
    public ResponseEntity get(@RequestParam(value = "id", required = false) String id) {
        GetResponse response = client.prepareGet("people", "man", id).get();
        if (!response.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /** 
    * @Description:
    * @Param: [po] 
    * @returns: org.springframework.http.ResponseEntity 
    * @Author: zhuenbang
    * @Date: 2018/9/3 19:38
    */
    @PostMapping("/add/people/man")
    public ResponseEntity add(@RequestBody people po) {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
                    .field("age", po.getAge())
                    .field("name", po.getName())
                    .field("country", po.getCountry())
                    .field("data", po.getData())
                    .endObject();
            IndexResponse indexResponse = client.prepareIndex("people", "man")
                    .setSource(builder)
                    .get();
            return new ResponseEntity(indexResponse.getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/people/man")
    public ResponseEntity delete(){
        DeleteResponse deleteResponse = client.prepareDelete("people", "man", "AWWfN3vet-PvC1C26h4s").get();
        return new ResponseEntity(deleteResponse.getResult().toString(),HttpStatus.OK);
    }
}
