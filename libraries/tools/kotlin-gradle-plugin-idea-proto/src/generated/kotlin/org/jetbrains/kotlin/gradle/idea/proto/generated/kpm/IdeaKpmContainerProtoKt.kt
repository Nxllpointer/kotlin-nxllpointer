//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: proto_kpm.proto

package org.jetbrains.kotlin.gradle.idea.proto.generated.kpm;

@kotlin.jvm.JvmName("-initializeideaKpmContainerProto")
inline fun ideaKpmContainerProto(block: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProtoKt.Dsl.() -> kotlin.Unit): org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto =
  org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProtoKt.Dsl._create(org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto.newBuilder()).apply { block() }._build()
object IdeaKpmContainerProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto = _builder.build()

    /**
     * <code>optional uint32 schema_version_major = 1;</code>
     */
    var schemaVersionMajor: kotlin.Int
      @JvmName("getSchemaVersionMajor")
      get() = _builder.getSchemaVersionMajor()
      @JvmName("setSchemaVersionMajor")
      set(value) {
        _builder.setSchemaVersionMajor(value)
      }
    /**
     * <code>optional uint32 schema_version_major = 1;</code>
     */
    fun clearSchemaVersionMajor() {
      _builder.clearSchemaVersionMajor()
    }
    /**
     * <code>optional uint32 schema_version_major = 1;</code>
     * @return Whether the schemaVersionMajor field is set.
     */
    fun hasSchemaVersionMajor(): kotlin.Boolean {
      return _builder.hasSchemaVersionMajor()
    }

    /**
     * <code>optional uint32 schema_version_minor = 2;</code>
     */
    var schemaVersionMinor: kotlin.Int
      @JvmName("getSchemaVersionMinor")
      get() = _builder.getSchemaVersionMinor()
      @JvmName("setSchemaVersionMinor")
      set(value) {
        _builder.setSchemaVersionMinor(value)
      }
    /**
     * <code>optional uint32 schema_version_minor = 2;</code>
     */
    fun clearSchemaVersionMinor() {
      _builder.clearSchemaVersionMinor()
    }
    /**
     * <code>optional uint32 schema_version_minor = 2;</code>
     * @return Whether the schemaVersionMinor field is set.
     */
    fun hasSchemaVersionMinor(): kotlin.Boolean {
      return _builder.hasSchemaVersionMinor()
    }

    /**
     * <code>optional uint32 schema_version_patch = 3;</code>
     */
    var schemaVersionPatch: kotlin.Int
      @JvmName("getSchemaVersionPatch")
      get() = _builder.getSchemaVersionPatch()
      @JvmName("setSchemaVersionPatch")
      set(value) {
        _builder.setSchemaVersionPatch(value)
      }
    /**
     * <code>optional uint32 schema_version_patch = 3;</code>
     */
    fun clearSchemaVersionPatch() {
      _builder.clearSchemaVersionPatch()
    }
    /**
     * <code>optional uint32 schema_version_patch = 3;</code>
     * @return Whether the schemaVersionPatch field is set.
     */
    fun hasSchemaVersionPatch(): kotlin.Boolean {
      return _builder.hasSchemaVersionPatch()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class SchemaInfosProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     */
     val schemaInfos: com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getSchemaInfosList()
      )
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     * @param value The schemaInfos to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addSchemaInfos")
    fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.add(value: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto) {
      _builder.addSchemaInfos(value)
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     * @param value The schemaInfos to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignSchemaInfos")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.plusAssign(value: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto) {
      add(value)
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     * @param values The schemaInfos to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllSchemaInfos")
    fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.addAll(values: kotlin.collections.Iterable<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto>) {
      _builder.addAllSchemaInfos(values)
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     * @param values The schemaInfos to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllSchemaInfos")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.plusAssign(values: kotlin.collections.Iterable<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto>) {
      addAll(values)
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     * @param index The index to set the value at.
     * @param value The schemaInfos to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setSchemaInfos")
    operator fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.set(index: kotlin.Int, value: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto) {
      _builder.setSchemaInfos(index, value)
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto schema_infos = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearSchemaInfos")
    fun com.google.protobuf.kotlin.DslList<org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmSchemaInfoProto, SchemaInfosProxy>.clear() {
      _builder.clearSchemaInfos()
    }


    /**
     * <code>optional .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto project = 24;</code>
     */
    var project: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto
      @JvmName("getProject")
      get() = _builder.getProject()
      @JvmName("setProject")
      set(value) {
        _builder.setProject(value)
      }
    /**
     * <code>optional .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto project = 24;</code>
     */
    fun clearProject() {
      _builder.clearProject()
    }
    /**
     * <code>optional .org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto project = 24;</code>
     * @return Whether the project field is set.
     */
    fun hasProject(): kotlin.Boolean {
      return _builder.hasProject()
    }
    val IdeaKpmContainerProtoKt.Dsl.projectOrNull: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto?
      get() = _builder.projectOrNull
  }
}
@kotlin.jvm.JvmSynthetic
inline fun org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto.copy(block: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProtoKt.Dsl.() -> kotlin.Unit): org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProto =
  org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmContainerProtoOrBuilder.projectOrNull: org.jetbrains.kotlin.gradle.idea.proto.generated.kpm.IdeaKpmProjectProto?
  get() = if (hasProject()) getProject() else null

