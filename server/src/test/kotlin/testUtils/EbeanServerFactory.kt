package com.chaoscorp.chaosServer.testUtils

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
@Profile("unittesting")
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

        importTestData();

        return server;
    }

    fun importTestData() {
        val fileResource = resourceLoader.getResource("classpath:ChaosTestData.sql");

        if (!fileResource.isFile) {
            return;
        }

        val sqlContent = fileResource.file.readLines().joinToString("\r\n")
        server.execute(DB.sqlUpdate(sqlContent))
    }

    override fun getObjectType(): Class<*>? {
        return EbeanServer::class.java
    }

}