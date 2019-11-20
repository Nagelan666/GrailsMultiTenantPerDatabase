package demo

import grails.gorm.services.Service

@Service(TenantTeam)
interface TenantTeamService {

    TenantTeam get(Serializable id)

    List<TenantTeam> list(Map args)

    Long count()

    void delete(Serializable id)

    TenantTeam save(TenantTeam tenantTeam)

}