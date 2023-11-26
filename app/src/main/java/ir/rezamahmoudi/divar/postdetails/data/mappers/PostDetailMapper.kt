package ir.rezamahmoudi.divar.postdetails.data.mappers

import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity
import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel
import kotlinx.collections.immutable.toImmutableList

fun PostDetailsEntity.asDomain() = PostDetailsUiModel(
    widgets = widgets.map { it.data.asDomain() }.toImmutableList(),
    enableContact = enableContact,
    contactButtonText = contactButtonText
)

fun PostDetailsDto.mapToEntity(postToken: String) = PostDetailsEntity(
    postToken = postToken,
    widgets = widgets,
    enableContact = enableContact,
    contactButtonText = contactButtonText
)
