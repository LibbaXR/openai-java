// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toUnmodifiable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** A chat completion message generated by the model. */
@JsonDeserialize(builder = ChatCompletionMessage.Builder::class)
@NoAutoDetect
class ChatCompletionMessage
private constructor(
    private val content: JsonField<String>,
    private val refusal: JsonField<String>,
    private val toolCalls: JsonField<List<ChatCompletionMessageToolCall>>,
    private val role: JsonField<Role>,
    private val functionCall: JsonField<FunctionCall>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The contents of the message. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The refusal message generated by the model. */
    fun refusal(): Optional<String> = Optional.ofNullable(refusal.getNullable("refusal"))

    /** The tool calls generated by the model, such as function calls. */
    fun toolCalls(): Optional<List<ChatCompletionMessageToolCall>> =
        Optional.ofNullable(toolCalls.getNullable("tool_calls"))

    /** The role of the author of this message. */
    fun role(): Role = role.getRequired("role")

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    fun functionCall(): Optional<FunctionCall> =
        Optional.ofNullable(functionCall.getNullable("function_call"))

    /** The contents of the message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The refusal message generated by the model. */
    @JsonProperty("refusal") @ExcludeMissing fun _refusal() = refusal

    /** The tool calls generated by the model, such as function calls. */
    @JsonProperty("tool_calls") @ExcludeMissing fun _toolCalls() = toolCalls

    /** The role of the author of this message. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    @JsonProperty("function_call") @ExcludeMissing fun _functionCall() = functionCall

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionMessage = apply {
        if (!validated) {
            content()
            refusal()
            toolCalls().map { it.forEach { it.validate() } }
            role()
            functionCall().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<String> = JsonMissing.of()
        private var refusal: JsonField<String> = JsonMissing.of()
        private var toolCalls: JsonField<List<ChatCompletionMessageToolCall>> = JsonMissing.of()
        private var role: JsonField<Role> = JsonMissing.of()
        private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionMessage: ChatCompletionMessage) = apply {
            this.content = chatCompletionMessage.content
            this.refusal = chatCompletionMessage.refusal
            this.toolCalls = chatCompletionMessage.toolCalls
            this.role = chatCompletionMessage.role
            this.functionCall = chatCompletionMessage.functionCall
            additionalProperties(chatCompletionMessage.additionalProperties)
        }

        /** The contents of the message. */
        fun content(content: String) = content(JsonField.of(content))

        /** The contents of the message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The refusal message generated by the model. */
        fun refusal(refusal: String) = refusal(JsonField.of(refusal))

        /** The refusal message generated by the model. */
        @JsonProperty("refusal")
        @ExcludeMissing
        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

        /** The tool calls generated by the model, such as function calls. */
        fun toolCalls(toolCalls: List<ChatCompletionMessageToolCall>) =
            toolCalls(JsonField.of(toolCalls))

        /** The tool calls generated by the model, such as function calls. */
        @JsonProperty("tool_calls")
        @ExcludeMissing
        fun toolCalls(toolCalls: JsonField<List<ChatCompletionMessageToolCall>>) = apply {
            this.toolCalls = toolCalls
        }

        /** The role of the author of this message. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the author of this message. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should
         * be called, as generated by the model.
         */
        fun functionCall(functionCall: FunctionCall) = functionCall(JsonField.of(functionCall))

        /**
         * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should
         * be called, as generated by the model.
         */
        @JsonProperty("function_call")
        @ExcludeMissing
        fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
            this.functionCall = functionCall
        }

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

        fun build(): ChatCompletionMessage =
            ChatCompletionMessage(
                content,
                refusal,
                toolCalls.map { it.toUnmodifiable() },
                role,
                functionCall,
                additionalProperties.toUnmodifiable(),
            )
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

            @JvmField val ASSISTANT = Role(JsonField.of("assistant"))

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            ASSISTANT,
        }

        enum class Value {
            ASSISTANT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANT -> Value.ASSISTANT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANT -> Known.ASSISTANT
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    @JsonDeserialize(builder = FunctionCall.Builder::class)
    @NoAutoDetect
    class FunctionCall
    private constructor(
        private val arguments: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /** The name of the function to call. */
        fun name(): String = name.getRequired("name")

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

        /** The name of the function to call. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): FunctionCall = apply {
            if (!validated) {
                arguments()
                name()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var arguments: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCall: FunctionCall) = apply {
                this.arguments = functionCall.arguments
                this.name = functionCall.name
                additionalProperties(functionCall.additionalProperties)
            }

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            @JsonProperty("arguments")
            @ExcludeMissing
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the function to call. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function to call. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

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

            fun build(): FunctionCall =
                FunctionCall(
                    arguments,
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FunctionCall && this.arguments == other.arguments && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(arguments, name, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "FunctionCall{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionMessage && this.content == other.content && this.refusal == other.refusal && this.toolCalls == other.toolCalls && this.role == other.role && this.functionCall == other.functionCall && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(content, refusal, toolCalls, role, functionCall, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionMessage{content=$content, refusal=$refusal, toolCalls=$toolCalls, role=$role, functionCall=$functionCall, additionalProperties=$additionalProperties}"
}
