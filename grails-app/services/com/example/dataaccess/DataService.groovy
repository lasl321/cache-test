package com.example.dataaccess

import com.google.code.ssm.api.InvalidateSingleCache
import com.google.code.ssm.api.ParameterValueKeyProvider
import com.google.code.ssm.api.ReadThroughSingleCache
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.w3c.dom.Document

class DataService {
    private static Log LOG = LogFactory.getLog(DataService)

    MarkLogicClient markLogicClient

    @ReadThroughSingleCache(namespace = 'checklists')
    Document getChecklist(@ParameterValueKeyProvider String id) {
        markLogicClient.getXmlDocument("/checklist/${id}.xml")
    }

    @InvalidateSingleCache(namespace = 'checklists')
    void saveChecklist(@ParameterValueKeyProvider String id) {
        if (LOG.debugEnabled) {
            LOG.debug("Saving checklist $id")
        }
    }
}
