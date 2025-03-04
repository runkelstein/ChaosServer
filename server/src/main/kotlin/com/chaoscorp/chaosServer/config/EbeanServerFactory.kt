package com.chaoscorp.chaosServer.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import io.ebean.DB
import io.ebean.EbeanServer
import org.springframework.beans.factory.FactoryBean
import org.springframework.stereotype.Component
import io.ebean.config.ServerConfig
import io.ebean.EbeanServerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ResourceLoader

@Component
@Profile("!unittesting")
class EbeanServerFactory : FactoryBean<EbeanServer> {

    @Autowired
    private lateinit var resourceLoader : ResourceLoader;

    private lateinit var server : EbeanServer;

    override fun getObject(): EbeanServer? {

        val config = ServerConfig()
        config.name = "db"
        config.loadFromProperties();
        config.objectMapper = ObjectMapper(YAMLFactory())

        server = EbeanServerFactory.create(config)

        return server;
    }


    override fun getObjectType(): Class<*>? {
        return EbeanServer::class.java
    }

}