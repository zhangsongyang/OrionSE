package cn.zsy.eg.google.protobuf.main;

import cn.zsy.eg.google.protobuf.bean.SearchRequestProtos;
import com.google.protobuf.InvalidProtocolBufferException;

public class TestSearchRequestProtosProtobuf {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SearchRequestProtos.SearchRequest searchRequest = SearchRequestProtos.SearchRequest.newBuilder()
            .setQuery("query")
            .setPageNumber(1234567)
            .setResultPerPage(2)
            .putProjects("name", "xxxx")
            .putProjects("old", "13")
            .addCorpus(SearchRequestProtos.SearchRequest.Corpus.WEB)
            .addCorpus(SearchRequestProtos.SearchRequest.Corpus.NEWS)
            .build();
        System.out.println(searchRequest.isInitialized());
        byte[] bytes = searchRequest.toByteArray();
        SearchRequestProtos.SearchRequest addressBook = SearchRequestProtos.SearchRequest.parseFrom(bytes);
        System.out.println(addressBook.toString());
        System.out.println(addressBook.getProjectsMap().toString());

    }

}
