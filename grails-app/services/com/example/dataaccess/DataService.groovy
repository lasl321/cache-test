package com.example.dataaccess

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.w3c.dom.Document

class DataService {
    private static Log LOG = LogFactory.getLog(DataService)

    MarkLogicClient markLogicClient

    @Cacheable('checklist')
    Document getChecklist(String id) {
        markLogicClient.getXmlDocument("/checklist/${id}.xml")
    }

    @CacheEvict('checklist')
    void saveChecklist(String id) {
        if (LOG.debugEnabled) {
            LOG.debug("Saving checklist $id")
        }
    }
}
