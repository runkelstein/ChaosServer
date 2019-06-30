package com.chaoscorp.chaosServer.data.mapper;

import com.chaoscorp.chaosServer.api.model.Document
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Component;

@Component
class DocumentMapper {

    var yamlMapper : ObjectMapper = ObjectMapper(YAMLFactory())

    fun asDocument(str : String? ) : Document? {
        return yamlMapper.readValue(str, Document::class.java);
    }

    fun asString(doc : Document) : String {

        return yamlMapper.writeValueAsString(doc);
    }

}
