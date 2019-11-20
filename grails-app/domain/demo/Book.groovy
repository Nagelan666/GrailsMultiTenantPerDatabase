package demo

import grails.gorm.MultiTenant

class Book implements MultiTenant<Book>{
    String name
    String tenantId
    static constraints = {
    }
    static mapping = {
        tenantId name: "tenantId"
    }
}
