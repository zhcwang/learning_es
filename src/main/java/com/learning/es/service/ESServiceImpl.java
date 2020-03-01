package com.learning.es.service;

import com.learning.es.persistence.ESRepository;
import com.learning.es.po.DocBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.AliasQuery;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("elasticService")
public class ESServiceImpl implements ESService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    private ESRepository esRepository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(DocBean.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(DocBean docBean) {
        esRepository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        esRepository.saveAll(list);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return esRepository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        return esRepository.findByContent(content,pageable);
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return esRepository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return esRepository.findBySecordCode(secordCode,pageable);
    }

    @Override
    public Page<DocBean> query(String key) {
        return esRepository.findByContent(key,pageable);
    }
}
