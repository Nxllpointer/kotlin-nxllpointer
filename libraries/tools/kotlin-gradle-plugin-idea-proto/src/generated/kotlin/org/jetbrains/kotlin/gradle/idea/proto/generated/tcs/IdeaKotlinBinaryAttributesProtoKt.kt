//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: proto_tcs.proto

package org.jetbrains.kotlin.gradle.idea.proto.generated.tcs;

@kotlin.jvm.JvmName("-initializeideaKotlinBinaryAttributesProto")
inline fun ideaKotlinBinaryAttributesProto(block: org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProtoKt.Dsl.() -> kotlin.Unit): org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto =
  org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProtoKt.Dsl._create(org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto.newBuilder()).apply { block() }._build()
object IdeaKotlinBinaryAttributesProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class AttributesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
     val attributes: com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      @kotlin.jvm.JvmSynthetic
      @JvmName("getAttributesMap")
      get() = com.google.protobuf.kotlin.DslMap(
        _builder.getAttributesMap()
      )
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
    @JvmName("putAttributes")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      .put(key: kotlin.String, value: kotlin.String) {
         _builder.putAttributes(key, value)
       }
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("setAttributes")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      .set(key: kotlin.String, value: kotlin.String) {
         put(key, value)
       }
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("removeAttributes")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      .remove(key: kotlin.String) {
         _builder.removeAttributes(key)
       }
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("putAllAttributes")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      .putAll(map: kotlin.collections.Map<kotlin.String, kotlin.String>) {
         _builder.putAllAttributes(map)
       }
    /**
     * <code>map&lt;string, string&gt; attributes = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("clearAttributes")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, kotlin.String, AttributesProxy>
      .clear() {
         _builder.clearAttributes()
       }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto.copy(block: org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProtoKt.Dsl.() -> kotlin.Unit): org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProto =
  org.jetbrains.kotlin.gradle.idea.proto.generated.tcs.IdeaKotlinBinaryAttributesProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

