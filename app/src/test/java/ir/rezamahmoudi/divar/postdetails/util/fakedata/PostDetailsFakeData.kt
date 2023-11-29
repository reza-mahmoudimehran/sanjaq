package ir.rezamahmoudi.divar.postdetails.util.fakedata

import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_DESCRIPTION_ROW_DTO_TEST_OBJECT
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_HEADER_ROW_DTO_TEST_OBJECT
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_TITLE_ROW_DTO_TEST_OBJECT
import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams

val POST_DETAILS_WIDGETS_TEST_OBJECT = listOf(
    WIDGET_HEADER_ROW_DTO_TEST_OBJECT,
    WIDGET_TITLE_ROW_DTO_TEST_OBJECT,
    WIDGET_DESCRIPTION_ROW_DTO_TEST_OBJECT
)

val POST_DETAILS_DTO_TEST_OBJECT = PostDetailsDto(
    widgets = POST_DETAILS_WIDGETS_TEST_OBJECT,
    enableContact = true,
    contactButtonText = "contactButtonText"
)

val FETCH_POST_DETAILS_PARAMS_TEST_OBJECT = FetchPostDetailsParams("postToken")
