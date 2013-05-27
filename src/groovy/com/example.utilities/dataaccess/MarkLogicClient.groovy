package com.example.utilities.dataaccess

import com.marklogic.client.DatabaseClient
import com.marklogic.client.document.JSONDocumentManager
import com.marklogic.client.document.XMLDocumentManager
import com.marklogic.client.io.DOMHandle
import com.marklogic.client.io.StringHandle
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.w3c.dom.Document

class MarkLogicClient {
    private static Log LOG = LogFactory.getLog(MarkLogicClient)

    private final DatabaseClient client
    private final XMLDocumentManager xmlDocumentManager
    private final JSONDocumentManager jsonDocumentManager

    MarkLogicClient(DatabaseClient client) {
        this.client = client
        this.xmlDocumentManager = client.newXMLDocumentManager()
        this.jsonDocumentManager = client.newJSONDocumentManager()
    }

    Document getXmlDocument(String uri) {
        DOMHandle handle = new DOMHandle()
        xmlDocumentManager.read(uri, handle)
        handle.get()
    }

    String getJsonString(String uri) {
        final StringHandle handle = new StringHandle()
        jsonDocumentManager.read(uri, handle)
        handle.get()
    }
}
