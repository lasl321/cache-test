package com.example.utilities

import com.example.utilities.dataaccess.MarkLogicClient
import org.junit.Test

class MarkLogicClientIntegrationTest {
    MarkLogicClient markLogicClient

    @Test
    void shouldGetXmlDocument() {
        markLogicClient.getXmlDocument('/xml/one.xml')
    }

    @Test
    void shouldGetJsonDocument() {
        markLogicClient.getJsonString('/json/two.json')
    }
}