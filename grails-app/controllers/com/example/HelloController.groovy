package com.example

class HelloController {
    def dateService

    def index() {
        redirect action: 'getDate'
    }

    def getDate() {
        [date: dateService.dateString]
    }

    def clearCache() {
        dateService.clearCache()

        [success: true]
    }
}
