package ir.rezamahmoudi.divar.postdetails.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.POST_DETAILS_TABLE_NAME

@Entity(
    tableName = POST_DETAILS_TABLE_NAME
)
data class PostDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = "post_token")
    val postToken: String,
    @ColumnInfo(name = "widgets") val widgets: List<WidgetDto>,
    @ColumnInfo(name = "enable_contact") val enableContact: Boolean,
    @ColumnInfo(name = "contact_button_text") val contactButtonText: String
)
