/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file google/pubsub/v1/pubsub.proto,
 * and updates to that file get reflected here through a regular refresh process.
 * However, manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently there is only one type allowed:
 * 1. New methods (these should be added to the end of the class)
 *
 * Happy editing!
 */
package com.google.gcloud.pubsub.spi;

import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;

import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.PageDescriptor;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.gapi.gax.internal.ApiUtils;
import io.gapi.gax.protobuf.PathTemplate;
import io.grpc.Channel;
import io.grpc.ManagedChannel;

import java.io.IOException;
import java.util.List;

// Manually-added imports: add custom (non-generated) imports after this point.



// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * The service that an application uses to manipulate topics, and to send
 * messages to a topic.
 */
@javax.annotation.Generated("by the veneer generator")
public class PublisherApi implements AutoCloseable {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   */
  public static final String SERVICE_ADDRESS = "pubsub-experimental.googleapis.com";

  /**
   * The default port of the service.
   */
  public static final int DEFAULT_SERVICE_PORT = 443;


  public static final ApiCallable<Topic, Topic>
      CREATE_TOPIC = ApiCallable.create(PublisherGrpc.METHOD_CREATE_TOPIC);
  public static final ApiCallable<PublishRequest, PublishResponse>
      PUBLISH = ApiCallable.create(PublisherGrpc.METHOD_PUBLISH);
  public static final ApiCallable<GetTopicRequest, Topic>
      GET_TOPIC = ApiCallable.create(PublisherGrpc.METHOD_GET_TOPIC);
  public static final ApiCallable<ListTopicsRequest, ListTopicsResponse>
      LIST_TOPICS = ApiCallable.create(PublisherGrpc.METHOD_LIST_TOPICS);
  public static final ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      LIST_TOPIC_SUBSCRIPTIONS = ApiCallable.create(PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS);
  public static final ApiCallable<DeleteTopicRequest, Empty>
      DELETE_TOPIC = ApiCallable.create(PublisherGrpc.METHOD_DELETE_TOPIC);




  private static PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic> LIST_TOPICS_PAGE_DESC =
      new PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
        @Override public Object emptyToken() {
          return "";
        }
        @Override public ListTopicsRequest injectToken(
            ListTopicsRequest payload, Object token) {
          return ListTopicsRequest
            .newBuilder(payload)
            .setPageToken((String) token)
            .build();
        }
        @Override
        public Object extractNextToken(ListTopicsResponse payload) {
          return payload.getNextPageToken();
        }
        @Override
        public Iterable<Topic> extractResources(ListTopicsResponse payload) {
          return payload.getTopicsList();
        }
      };
  private static PageDescriptor<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> LIST_TOPIC_SUBSCRIPTIONS_PAGE_DESC =
      new PageDescriptor<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>() {
        @Override public Object emptyToken() {
          return "";
        }
        @Override public ListTopicSubscriptionsRequest injectToken(
            ListTopicSubscriptionsRequest payload, Object token) {
          return ListTopicSubscriptionsRequest
            .newBuilder(payload)
            .setPageToken((String) token)
            .build();
        }
        @Override
        public Object extractNextToken(ListTopicSubscriptionsResponse payload) {
          return payload.getNextPageToken();
        }
        @Override
        public Iterable<String> extractResources(ListTopicSubscriptionsResponse payload) {
          return payload.getSubscriptionsList();
        }
      };

  private static String ALL_SCOPES[] = {
    "https://www.googleapis.com/auth/pubsub"
  };

  public static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}");
  public static final PathTemplate TOPIC_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}/topics/{topic}");

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final ServiceApiSettings settings;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of PublisherApi with default settings.
   */
  public static PublisherApi create() throws IOException {
    return create(new ServiceApiSettings());
  }

  /**
   * Constructs an instance of PublisherApi, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static PublisherApi create(ServiceApiSettings settings) throws IOException {
    return new PublisherApi(settings);
  }

  private PublisherApi(ServiceApiSettings settings) throws IOException {
    ServiceApiSettings internalSettings = ApiUtils.settingsWithChannels(settings,
        SERVICE_ADDRESS, DEFAULT_SERVICE_PORT, ALL_SCOPES);
    this.settings = internalSettings;
    this.channel = internalSettings.getChannel();
  }

  // ==============================
  // Resource Name Helper Functions
  // ==============================

  public static final String createProject(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate(
        "project", project);
  }

  public static final String createTopic(String project, String topic) {
    return TOPIC_PATH_TEMPLATE.instantiate(
        "project", project,"topic", topic);
  }


  // ========
  // Getters
  // ========

  public Channel getChannel() {
    return channel;
  }


  // =============
  // Service Calls
  // =============

  // ----- createTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * @param name The name of the topic. It must have the format
   * `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter,
   * and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`),
   * underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent
   * signs (`%`). It must be between 3 and 255 characters in length, and it
   * must not start with `"goog"`.
   */
  public Topic createTopic(String name) {
    Topic request =
        Topic.newBuilder()
        .setName(name)
        .build();

    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Topic createTopic(Topic request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates the given topic with the given name.
   */
  public ApiCallable<Topic, Topic> createTopicCallable() {
    return ApiUtils.prepareIdempotentCallable(CREATE_TOPIC, settings).bind(channel);
  }

  // ----- publish -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns NOT_FOUND if the topic does
   * not exist. The message payload must not be empty; it must contain either a
   * non-empty data field, or at least one attribute.
   *
   * @param topic The messages in the request will be published on this topic.
   * @param messages The messages to publish.
   */
  public PublishResponse publish(String topic, List<PubsubMessage> messages) {
    PublishRequest request =
        PublishRequest.newBuilder()
        .setTopic(topic)
        .addAllMessages(messages)
        .build();

    return publish(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns NOT_FOUND if the topic does
   * not exist. The message payload must not be empty; it must contain either a
   * non-empty data field, or at least one attribute.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public PublishResponse publish(PublishRequest request) {
    return publishCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Adds one or more messages to the topic. Returns NOT_FOUND if the topic does
   * not exist. The message payload must not be empty; it must contain either a
   * non-empty data field, or at least one attribute.
   */
  public ApiCallable<PublishRequest, PublishResponse> publishCallable() {
    return PUBLISH.bind(channel);
  }

  // ----- getTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * @param topic The name of the topic to get.
   */
  public Topic getTopic(String topic) {
    GetTopicRequest request =
        GetTopicRequest.newBuilder()
        .setTopic(topic)
        .build();

    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets the configuration of a topic.
   */
  public ApiCallable<GetTopicRequest, Topic> getTopicCallable() {
    return ApiUtils.prepareIdempotentCallable(GET_TOPIC, settings).bind(channel);
  }

  // ----- listTopics -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   */
  public Iterable<Topic> listTopics(String project) {
    ListTopicsRequest request =
        ListTopicsRequest.newBuilder()
        .setProject(project)
        .build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<Topic> listTopics(ListTopicsRequest request) {
    return listTopicsStreamingCallable()
        .iterableResponseStreamCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   */
  public ApiCallable<ListTopicsRequest, Topic> listTopicsStreamingCallable() {
    return listTopicsCallable().pageStreaming(LIST_TOPICS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists matching topics.
   */
  public ApiCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return ApiUtils.prepareIdempotentCallable(LIST_TOPICS, settings).bind(channel);
  }

  // ----- listTopicSubscriptions -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   */
  public Iterable<String> listTopicSubscriptions(String topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(topic)
        .build();
    return listTopicSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<String> listTopicSubscriptions(ListTopicSubscriptionsRequest request) {
    return listTopicSubscriptionsStreamingCallable()
        .iterableResponseStreamCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   */
  public ApiCallable<ListTopicSubscriptionsRequest, String> listTopicSubscriptionsStreamingCallable() {
    return listTopicSubscriptionsCallable().pageStreaming(LIST_TOPIC_SUBSCRIPTIONS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists the name of the subscriptions for this topic.
   */
  public ApiCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse> listTopicSubscriptionsCallable() {
    return ApiUtils.prepareIdempotentCallable(LIST_TOPIC_SUBSCRIPTIONS, settings).bind(channel);
  }

  // ----- deleteTopic -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns NOT_FOUND if the topic does
   * not exist. After a topic is deleted, a new topic may be created with the
   * same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * @param topic Name of the topic to delete.
   */
  public void deleteTopic(String topic) {
    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder()
        .setTopic(topic)
        .build();

    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns NOT_FOUND if the topic does
   * not exist. After a topic is deleted, a new topic may be created with the
   * same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes the topic with the given name. Returns NOT_FOUND if the topic does
   * not exist. After a topic is deleted, a new topic may be created with the
   * same name; this is an entirely new topic with none of the old
   * configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   */
  public ApiCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return ApiUtils.prepareIdempotentCallable(DELETE_TOPIC, settings).bind(channel);
  }


  // ========
  // Cleanup
  // ========

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override public void close() {
    // Manually-added shutdown code

    // Auto-generated shutdown code
    channel.shutdown();

    // Manually-added shutdown code
  }


  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
