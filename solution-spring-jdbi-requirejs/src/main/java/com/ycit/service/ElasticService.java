package com.ycit.service;

import com.ycit.beans.criteria.PerpCriteria;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xlch on 2017/1/4.
 */
@Service
public class ElasticService {

    private static final String INDEX_EVENT = "events_all";
    private static final String TYPE_EVENT = "event";

    @Autowired
    private JestClient jestClient;

    public void find() {
        SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder
                .searchSource();
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_EVENT)
                .addType(TYPE_EVENT)
                .build();
    }

    public void findPerps(PerpCriteria criteria) throws Exception {
        String ageRange = criteria.getAgeRange();
        String hometown = criteria.getHometown();
        Long startTime = criteria.getStartTime();
        Long endTime = criteria.getEndTime();
        String polygon = criteria.getPolygon();
        if (StringUtils.isNotBlank(ageRange)) {

        }
        QueryBuilder queryBuilder=  QueryBuilders.matchAllQuery();
        SearchSourceBuilder builder = new SearchSourceBuilder().size(100).query(queryBuilder);
        Search search = new Search.Builder(builder.toString())
                .addIndex(INDEX_EVENT)
                .addType(TYPE_EVENT)
                .build();
        JestResult jestResult = jestClient.execute(search);
    }

}
