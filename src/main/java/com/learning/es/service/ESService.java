package com.learning.es.service;

import com.learning.es.po.DocBean;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface ESService {
    void createIndex();

    void deleteIndex(String index);

    void save(DocBean docBean);

    void saveAll(List<DocBean> list);

    Iterator<DocBean> findAll();

    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

    Page<DocBean> query(String key);
}
