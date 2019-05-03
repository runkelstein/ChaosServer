package com.chaoscorp.chaosServer.config

import io.ebean.EbeanServer
import org.springframework.beans.factory.FactoryBean
import org.springframework.stereotype.Component
import io.ebean.config.ServerConfig
import io.ebean.EbeanServerFactory
import org.h2.tools.Server
import org.h2.jdbcx.JdbcDataSource


@Component
class EbeanServerFactory : FactoryBean<EbeanServer> {

    override fun getObject(): EbeanServer? {


        val ds = JdbcDataSource()
        ds.setURL("jdbc:h2:~/test")
        ds.user = "sa"

        val config = ServerConfig()
        config.name = "pg"
        config.isDdlGenerate = true
        config.isDdlRun = true
        config.dataSource = ds

        startH2Server()

        val server = EbeanServerFactory.create(config)
        return server;
    }

    fun startH2Server() {

        Server.createWebServer().start()
    }

    override fun getObjectType(): Class<*>? {
        return EbeanServer::class.java
    }

}