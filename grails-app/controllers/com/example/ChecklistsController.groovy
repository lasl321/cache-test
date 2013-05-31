package com.example

import com.example.dataaccess.DataService
import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable
import groovy.xml.XmlUtil
import org.w3c.dom.Document

import javax.servlet.http.HttpServletResponse

class ChecklistsController {
    DataService dataService

    def index() {
        String id = params.id
        final Document checklist = dataService.getChecklist(id)
        render text: XmlUtil.serialize(checklist.documentElement), contentType: 'application/xml'
    }

    def clearIndex() {
        String id = params.id
        dataService.saveChecklist(id)

        render status: HttpServletResponse.SC_OK
    }
}
