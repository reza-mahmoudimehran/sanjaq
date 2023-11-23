package ir.rezamahmoudi.divar.postdetails.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.data.model.Dto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.core.util.mapper.asDomain
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel
import kotlinx.collections.immutable.toImmutableList

@JsonClass(generateAdapter = true)
data class PostDetailsDto(
    val widgets: List<WidgetDto>,
    @Json(name = "enable_contact") val enableContact: Boolean,
    @Json(name = "contact_button_text") val contactButtonText: String
) : Dto<PostDetailsUiModel> {
    override fun asDomain(): PostDetailsUiModel = PostDetailsUiModel(
        widgets = widgets.map { it.data.asDomain() }.toImmutableList(),
        enableContact = enableContact,
        contactButtonText = contactButtonText
    )
}
