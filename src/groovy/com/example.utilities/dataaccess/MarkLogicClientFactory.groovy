package com.example.utilities.dataaccess

import com.marklogic.client.DatabaseClientFactory
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class MarkLogicClientFactory {
    String host
    int port
    String user
    String password
    DatabaseClientFactory.Authentication authentication

    MarkLogicClient createClient() {
        new MarkLogicClient(DatabaseClientFactory.newClient(host, port, user, password, authentication))
    }
}
