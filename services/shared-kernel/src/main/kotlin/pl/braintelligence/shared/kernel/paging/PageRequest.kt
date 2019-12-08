package pl.braintelligence.shared.kernel.paging

data class PageRequest(
    val pageNumber: Int,
    val pageSize: Int
) {
    val offset = pageNumber * pageSize
}
