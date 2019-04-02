// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/datalabeling/v1beta1/data_labeling_service.proto

package com.google.cloud.datalabeling.v1beta1;

public interface CreateDatasetRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.datalabeling.v1beta1.CreateDatasetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. Dataset resource parent, format:
   * projects/{project_id}
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. Dataset resource parent, format:
   * projects/{project_id}
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Required. The dataset to be created.
   * </pre>
   *
   * <code>.google.cloud.datalabeling.v1beta1.Dataset dataset = 2;</code>
   */
  boolean hasDataset();
  /**
   *
   *
   * <pre>
   * Required. The dataset to be created.
   * </pre>
   *
   * <code>.google.cloud.datalabeling.v1beta1.Dataset dataset = 2;</code>
   */
  com.google.cloud.datalabeling.v1beta1.Dataset getDataset();
  /**
   *
   *
   * <pre>
   * Required. The dataset to be created.
   * </pre>
   *
   * <code>.google.cloud.datalabeling.v1beta1.Dataset dataset = 2;</code>
   */
  com.google.cloud.datalabeling.v1beta1.DatasetOrBuilder getDatasetOrBuilder();
}
