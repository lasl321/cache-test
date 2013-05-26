package com.example.utilities

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

import java.text.SimpleDateFormat

class DateService {
    @Cacheable('dateString')
    String getDateString() {
        Thread.sleep(5000)

        def format = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss.SSSZ')
        def currentDate = new Date()
        format.format(currentDate)
    }

    @CacheEvict('dateString')
    void clearCache() {
    }
}