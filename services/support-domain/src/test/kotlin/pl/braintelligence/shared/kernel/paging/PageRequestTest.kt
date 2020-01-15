package pl.braintelligence.shared.kernel.paging

import org.junit.Test
import kotlin.test.assertEquals

class PageRequestSpec {

    @Test
    fun `Should count offset`() {
        // given
        val pageable1 = PageRequest(pageNumber = 0, pageSize = 10)
        val pageable2 = PageRequest(pageNumber = 1, pageSize = 10)

        // then
        assertEquals(0, pageable1.offset)
        assertEquals(10, pageable2.offset)
    }

}
