// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ChatCompletionToolMessageParam.Builder::class)
@NoAutoDetect
class ChatCompletionToolMessageParam
private constructor(
    private val role: JsonField<Role>,
    private val content: JsonField<Content>,
    private val toolCallId: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The role of the messages author, in this case `tool`. */
    fun role(): Role = role.getRequired("role")

    /** The contents of the tool message. */
    fun content(): Content = content.getRequired("content")

    /** Tool call that this message is responding to. */
    fun toolCallId(): String = toolCallId.getRequired("tool_call_id")

    /** The role of the messages author, in this case `tool`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** The contents of the tool message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** Tool call that this message is responding to. */
    @JsonProperty("tool_call_id") @ExcludeMissing fun _toolCallId() = toolCallId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionToolMessageParam = apply {
        if (!validated) {
            role()
            content()
            toolCallId()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var role: JsonField<Role> = JsonMissing.of()
        private var content: JsonField<Content> = JsonMissing.of()
        private var toolCallId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionToolMessageParam: ChatCompletionToolMessageParam) = apply {
            this.role = chatCompletionToolMessageParam.role
            this.content = chatCompletionToolMessageParam.content
            this.toolCallId = chatCompletionToolMessageParam.toolCallId
            additionalProperties(chatCompletionToolMessageParam.additionalProperties)
        }

        /** The role of the messages author, in this case `tool`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `tool`. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** The contents of the tool message. */
        fun content(content: Content) = content(JsonField.of(content))

        /** The contents of the tool message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** Tool call that this message is responding to. */
        fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

        /** Tool call that this message is responding to. */
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        fun toolCallId(toolCallId: JsonField<String>) = apply { this.toolCallId = toolCallId }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionToolMessageParam =
            ChatCompletionToolMessageParam(
                role,
                content,
                toolCallId,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val string: String? = null,
        private val chatCompletionContentPartTexts: List<ChatCompletionContentPartText>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The contents of the tool message. */
        fun string(): Optional<String> = Optional.ofNullable(string)
        /**
         * An array of content parts with a defined type. For tool messages, only type `text` is
         * supported.
         */
        fun chatCompletionContentPartTexts(): Optional<List<ChatCompletionContentPartText>> =
            Optional.ofNullable(chatCompletionContentPartTexts)

        fun isString(): Boolean = string != null

        fun isChatCompletionContentPartTexts(): Boolean = chatCompletionContentPartTexts != null

        fun asString(): String = string.getOrThrow("string")

        fun asChatCompletionContentPartTexts(): List<ChatCompletionContentPartText> =
            chatCompletionContentPartTexts.getOrThrow("chatCompletionContentPartTexts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                chatCompletionContentPartTexts != null ->
                    visitor.visitChatCompletionContentPartTexts(chatCompletionContentPartTexts)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Content = apply {
            if (!validated) {
                if (string == null && chatCompletionContentPartTexts == null) {
                    throw OpenAIInvalidDataException("Unknown Content: $_json")
                }
                chatCompletionContentPartTexts?.forEach { it.validate() }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && this.string == other.string && this.chatCompletionContentPartTexts == other.chatCompletionContentPartTexts /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(string, chatCompletionContentPartTexts) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                string != null -> "Content{string=$string}"
                chatCompletionContentPartTexts != null ->
                    "Content{chatCompletionContentPartTexts=$chatCompletionContentPartTexts}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }
        }

        companion object {

            @JvmStatic fun ofString(string: String) = Content(string = string)

            @JvmStatic
            fun ofChatCompletionContentPartTexts(
                chatCompletionContentPartTexts: List<ChatCompletionContentPartText>
            ) = Content(chatCompletionContentPartTexts = chatCompletionContentPartTexts)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitChatCompletionContentPartTexts(
                chatCompletionContentPartTexts: List<ChatCompletionContentPartText>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPartText>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Content(chatCompletionContentPartTexts = it, _json = json)
                    }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.chatCompletionContentPartTexts != null ->
                        generator.writeObject(value.chatCompletionContentPartTexts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val TOOL = Role(JsonField.of("tool"))

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            TOOL,
        }

        enum class Value {
            TOOL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                TOOL -> Value.TOOL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                TOOL -> Known.TOOL
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionToolMessageParam && this.role == other.role && this.content == other.content && this.toolCallId == other.toolCallId && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(role, content, toolCallId, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionToolMessageParam{role=$role, content=$content, toolCallId=$toolCallId, additionalProperties=$additionalProperties}"
}
