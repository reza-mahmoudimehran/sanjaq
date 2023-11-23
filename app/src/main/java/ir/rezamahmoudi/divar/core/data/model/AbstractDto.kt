package ir.rezamahmoudi.divar.core.data.model

interface Dto<T : Domain> {
    fun asDomain(): T
}

interface Domain
