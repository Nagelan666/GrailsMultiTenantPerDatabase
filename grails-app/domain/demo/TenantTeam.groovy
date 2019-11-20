package demo

import grails.gorm.MultiTenant

class TenantTeam implements MultiTenant<TenantTeam>{
    String name
    String tenantId
    static constraints = {
    }
    static mapping = {
        tenantId name: "tenantId"
    }
}
