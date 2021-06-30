package com.anqi.es.controller;

import com.anqi.es.highclient.RestHighLevelClientService;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xjl
 */
@RestController
public class EsController {

    @Autowired
    RestHighLevelClientService service;

    @GetMapping("/es")
    public String testHigh(HttpServletResponse httpServletResponse) throws IOException{
        String source = "{\n" +
                "  \"name\" : \"阿达大大\",\n" +
                "  \"price\" : 300,\n" +
                "  \"num\" : 800,\n" +
                "  \"date\" : \"2019-07-28\"\n" +
                "}";

        IndexResponse response = service.addDoc("idx_clouthing", source);

        httpServletResponse.getWriter().println();

        return response.toString();
    }
}
