import com.example.dataaccess.MarkLogicClientFactory

beans = {
    markLogicClientFactory(MarkLogicClientFactory) {
        host = grailsApplication.config.markLogic.host
        port = grailsApplication.config.markLogic.port
        user = grailsApplication.config.markLogic.user
        password = grailsApplication.config.markLogic.password
        authentication = grailsApplication.config.markLogic.authentication
    }

    markLogicClient(markLogicClientFactory: 'createClient')
}
