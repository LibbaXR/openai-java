// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionTest {

    @Test
    fun createChatCompletion() {
        val chatCompletion =
            ChatCompletion.builder()
                .id("id")
                .choices(
                    listOf(
                        ChatCompletion.Choice.builder()
                            .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                            .index(123L)
                            .logprobs(
                                ChatCompletion.Choice.Logprobs.builder()
                                    .content(
                                        listOf(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .bytes(listOf(123L))
                                                .logprob(42.23)
                                                .topLogprobs(
                                                    listOf(
                                                        ChatCompletionTokenLogprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .bytes(listOf(123L))
                                                            .logprob(42.23)
                                                            .build()
                                                    )
                                                )
                                                .build()
                                        )
                                    )
                                    .refusal(
                                        listOf(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .bytes(listOf(123L))
                                                .logprob(42.23)
                                                .topLogprobs(
                                                    listOf(
                                                        ChatCompletionTokenLogprob.TopLogprob
                                                            .builder()
                                                            .token("token")
                                                            .bytes(listOf(123L))
                                                            .logprob(42.23)
                                                            .build()
                                                    )
                                                )
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                            .message(
                                ChatCompletionMessage.builder()
                                    .content("content")
                                    .refusal("refusal")
                                    .role(ChatCompletionMessage.Role.ASSISTANT)
                                    .audio(
                                        ChatCompletionAudio.builder()
                                            .id("id")
                                            .data("data")
                                            .expiresAt(123L)
                                            .transcript("transcript")
                                            .build()
                                    )
                                    .functionCall(
                                        ChatCompletionMessage.FunctionCall.builder()
                                            .arguments("arguments")
                                            .name("name")
                                            .build()
                                    )
                                    .toolCalls(
                                        listOf(
                                            ChatCompletionMessageToolCall.builder()
                                                .id("id")
                                                .function(
                                                    ChatCompletionMessageToolCall.Function.builder()
                                                        .arguments("arguments")
                                                        .name("name")
                                                        .build()
                                                )
                                                .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
                .created(123L)
                .model("model")
                .object_(ChatCompletion.Object.CHAT_COMPLETION)
                .serviceTier(ChatCompletion.ServiceTier.SCALE)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(123L)
                        .promptTokens(123L)
                        .totalTokens(123L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(123L)
                                .audioTokens(123L)
                                .reasoningTokens(123L)
                                .rejectedPredictionTokens(123L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(123L)
                                .cachedTokens(123L)
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(chatCompletion).isNotNull
        assertThat(chatCompletion.id()).isEqualTo("id")
        assertThat(chatCompletion.choices())
            .containsExactly(
                ChatCompletion.Choice.builder()
                    .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                    .index(123L)
                    .logprobs(
                        ChatCompletion.Choice.Logprobs.builder()
                            .content(
                                listOf(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .bytes(listOf(123L))
                                        .logprob(42.23)
                                        .topLogprobs(
                                            listOf(
                                                ChatCompletionTokenLogprob.TopLogprob.builder()
                                                    .token("token")
                                                    .bytes(listOf(123L))
                                                    .logprob(42.23)
                                                    .build()
                                            )
                                        )
                                        .build()
                                )
                            )
                            .refusal(
                                listOf(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .bytes(listOf(123L))
                                        .logprob(42.23)
                                        .topLogprobs(
                                            listOf(
                                                ChatCompletionTokenLogprob.TopLogprob.builder()
                                                    .token("token")
                                                    .bytes(listOf(123L))
                                                    .logprob(42.23)
                                                    .build()
                                            )
                                        )
                                        .build()
                                )
                            )
                            .build()
                    )
                    .message(
                        ChatCompletionMessage.builder()
                            .content("content")
                            .refusal("refusal")
                            .role(ChatCompletionMessage.Role.ASSISTANT)
                            .audio(
                                ChatCompletionAudio.builder()
                                    .id("id")
                                    .data("data")
                                    .expiresAt(123L)
                                    .transcript("transcript")
                                    .build()
                            )
                            .functionCall(
                                ChatCompletionMessage.FunctionCall.builder()
                                    .arguments("arguments")
                                    .name("name")
                                    .build()
                            )
                            .toolCalls(
                                listOf(
                                    ChatCompletionMessageToolCall.builder()
                                        .id("id")
                                        .function(
                                            ChatCompletionMessageToolCall.Function.builder()
                                                .arguments("arguments")
                                                .name("name")
                                                .build()
                                        )
                                        .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                                        .build()
                                )
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(chatCompletion.created()).isEqualTo(123L)
        assertThat(chatCompletion.model()).isEqualTo("model")
        assertThat(chatCompletion.object_()).isEqualTo(ChatCompletion.Object.CHAT_COMPLETION)
        assertThat(chatCompletion.serviceTier()).contains(ChatCompletion.ServiceTier.SCALE)
        assertThat(chatCompletion.systemFingerprint()).contains("system_fingerprint")
        assertThat(chatCompletion.usage())
            .contains(
                CompletionUsage.builder()
                    .completionTokens(123L)
                    .promptTokens(123L)
                    .totalTokens(123L)
                    .completionTokensDetails(
                        CompletionUsage.CompletionTokensDetails.builder()
                            .acceptedPredictionTokens(123L)
                            .audioTokens(123L)
                            .reasoningTokens(123L)
                            .rejectedPredictionTokens(123L)
                            .build()
                    )
                    .promptTokensDetails(
                        CompletionUsage.PromptTokensDetails.builder()
                            .audioTokens(123L)
                            .cachedTokens(123L)
                            .build()
                    )
                    .build()
            )
    }
}
