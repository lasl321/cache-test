package com.example.dataaccess

import org.junit.Test
import org.w3c.dom.Document

class DataServiceTests {
    DataService dataService

    @Test
    void shouldGetChecklist() {
        final Document checklist = dataService.getChecklist('f2284957-8809-4de7-9424-ee1f0cc4852c')
        assert checklist
        println checklist.dump()
    }
}
