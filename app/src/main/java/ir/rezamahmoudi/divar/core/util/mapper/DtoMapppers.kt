package ir.rezamahmoudi.divar.core.util.mapper

import ir.rezamahmoudi.divar.core.data.model.Domain
import ir.rezamahmoudi.divar.core.data.model.Dto
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T : Domain> List<Dto<T>>.asDomain(): ImmutableList<T> = map { it.asDomain() }.toImmutableList()

fun <T : Domain> Result<Dto<T>>.asDomain() = map { it.asDomain() }

fun <T : Domain> Flow<Result<Dto<T>>>.asDomain() = map { it.asDomain() }
