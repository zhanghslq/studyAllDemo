package com.zhs.admin;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;

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
    public static void deleteTopics(){
        AdminClient adminClient = adminClient();
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Collections.singleton("zhs-topic"));

        System.out.println(deleteTopicsResult);
    }
    public static void describeTopics() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        DescribeTopicsResult result = adminClient.describeTopics(Collections.singleton("zhs_topic"));
        Map<String, TopicDescription> stringTopicDescriptionMap = result.all().get();
        stringTopicDescriptionMap.entrySet().forEach(entry->{
            System.out.println("name"+entry.getKey()+"value:"+entry.getValue());
        });

    }
    public static void describeConfig() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, "zhs_topic");
        DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(Collections.singleton(configResource));
        Map<ConfigResource, Config> configResourceConfigMap = describeConfigsResult.all().get();

        System.out.println("==========================");
        configResourceConfigMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println("=================");
            System.out.println(entry.getValue());
        });

    }
    public static void alterConfig() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        HashMap<ConfigResource, Config> configHashMap = new HashMap<>();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, "zhs_topic");
        Config config = new Config(Collections.singleton(new ConfigEntry("preallocate", "true")));
        configHashMap.put(configResource,config);
//        AlterConfigsResult alterConfigsResult = adminClient.alterConfigs(configHashMap);
        HashMap<ConfigResource, Collection<AlterConfigOp>> configMaps = new HashMap<>();
        AlterConfigOp alterConfigOp = new AlterConfigOp(new ConfigEntry("", ""), AlterConfigOp.OpType.SET);

        configMaps.put(configResource,Collections.singletonList(alterConfigOp));
        AlterConfigsResult alterConfigsResult = adminClient.incrementalAlterConfigs(configMaps);
        

        alterConfigsResult.all().get();

    }
    public static void incrPartitions(int partions) throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        HashMap<String, NewPartitions> map = new HashMap<>();
        NewPartitions newPartitions = NewPartitions.increaseTo(partions);
        map.put("zhs_topic",newPartitions);
        CreatePartitionsResult partitions = adminClient.createPartitions(map);
        partitions.all().get();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*AdminClient adminClient = AdminSimple.adminClient();
        System.out.println(adminClient);*/
//        createTopic();
        //deleteTopics();
//        topicList();
//        describeTopics();
//        incrPartitions(2);
        describeConfig();
    }
}
