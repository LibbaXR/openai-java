// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantUpdateParamsTest {

    @Test
    fun create() {
        BetaAssistantUpdateParams.builder()
            .assistantId("assistant_id")
            .description("description")
            .instructions("instructions")
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .model(BetaAssistantUpdateParams.Model.O3_MINI)
            .name("name")
            .reasoningEffort(BetaAssistantUpdateParams.ReasoningEffort.LOW)
            .responseFormatAuto()
            .temperature(1.0)
            .toolResources(
                BetaAssistantUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
            .addTool(CodeInterpreterTool.builder().build())
            .topP(1.0)
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaAssistantUpdateParams.builder()
                .assistantId("assistant_id")
                .description("description")
                .instructions("instructions")
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(BetaAssistantUpdateParams.Model.O3_MINI)
                .name("name")
                .reasoningEffort(BetaAssistantUpdateParams.ReasoningEffort.LOW)
                .responseFormatAuto()
                .temperature(1.0)
                .toolResources(
                    BetaAssistantUpdateParams.ToolResources.builder()
                        .codeInterpreter(
                            BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                                .addFileId("string")
                                .build()
                        )
                        .fileSearch(
                            BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                                .addVectorStoreId("string")
                                .build()
                        )
                        .build()
                )
                .addTool(CodeInterpreterTool.builder().build())
                .topP(1.0)
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.description()).contains("description")
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.model()).contains(BetaAssistantUpdateParams.Model.O3_MINI)
        assertThat(body.name()).contains("name")
        assertThat(body.reasoningEffort()).contains(BetaAssistantUpdateParams.ReasoningEffort.LOW)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolResources())
            .contains(
                BetaAssistantUpdateParams.ToolResources.builder()
                    .codeInterpreter(
                        BetaAssistantUpdateParams.ToolResources.CodeInterpreter.builder()
                            .addFileId("string")
                            .build()
                    )
                    .fileSearch(
                        BetaAssistantUpdateParams.ToolResources.FileSearch.builder()
                            .addVectorStoreId("string")
                            .build()
                    )
                    .build()
            )
        assertThat(body.tools())
            .contains(
                listOf(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
            )
        assertThat(body.topP()).contains(1.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BetaAssistantUpdateParams.builder().assistantId("assistant_id").build()
        val body = params._body()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = BetaAssistantUpdateParams.builder().assistantId("assistant_id").build()
        assertThat(params).isNotNull
        // path param "assistantId"
        assertThat(params.getPathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
