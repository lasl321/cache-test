package com.example.logging

class LoggingFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if (log.debugEnabled) {
                    final String parameterDetails = request.get ? " - $params" : ''
                    log.debug "Entering $controllerName.$actionName$parameterDetails"
                }
            }
            after = { Map model ->
                if (log.debugEnabled) {
                    log.debug "Exiting $controllerName.$actionName"
                }

            }
            afterView = { Exception e ->
                if (e) {
                    log.error e
                }
            }
        }
    }
}
