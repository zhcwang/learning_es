package com.learning.es.controller;

import com.learning.es.po.DocBean;
import com.learning.es.service.ESService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/es")
public class ESController {
    @Autowired
    private ESService esService;

    @GetMapping("/init")
    public void init(){
        esService.createIndex();
        List<DocBean> list =new ArrayList<>();
        list.add(new DocBean(1L,"XX0193","XX8064","xxxxxx",1));
        list.add(new DocBean(2L,"XX0210","XX7475","xxxxxxxxxx",1));
        list.add(new DocBean(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
        esService.saveAll(list);
    }

    @GetMapping("/all")
    public Iterator<DocBean> all(){
        return esService.findAll();
    }
}
