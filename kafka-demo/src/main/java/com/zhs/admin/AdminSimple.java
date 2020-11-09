package com.zhs.admin;

import org.apache.kafka.clients.admin.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author: zhs
 * @since: 2020/11/9 13:05
 */
public class AdminSimple {
    public static AdminClient adminClient(){

        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"49.233.189.184:9092");
        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }
    public static void createTopic() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        // 副本集
        short rs=1;
        NewTopic newTopic = new NewTopic("zhs_topic",1,rs);
        CreateTopicsResult topics = adminClient.createTopics(Collections.singletonList(newTopic));
        System.out.println("create  topic:::"+topics.all().get());
    }
    public static void topicList() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ListTopicsOptions listTopicsOptions = new ListTopicsOptions();
        listTopicsOptions.listInternal(true);
        ListTopicsResult listTopicsResult = adminClient.listTopics(listTopicsOptions);
        Set<String> strings = listTopicsResult.names().get();
        Collection<TopicListing> topicListings = listTopicsResult.listings().get();
        System.out.println("====================================================");
        strings.forEach(System.out::println);

        System.out.println("=============");
        topicListings.forEach(System.out::println);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*AdminClient adminClient = AdminSimple.adminClient();
        System.out.println(adminClient);*/
//        createTopic();
        topicList();
    }
}
