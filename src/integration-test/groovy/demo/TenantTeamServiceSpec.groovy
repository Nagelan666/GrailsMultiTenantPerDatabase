package demo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TenantTeamServiceSpec extends Specification {

    TenantTeamService tenantTeamService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TenantTeam(...).save(flush: true, failOnError: true)
        //new TenantTeam(...).save(flush: true, failOnError: true)
        //TenantTeam tenantTeam = new TenantTeam(...).save(flush: true, failOnError: true)
        //new TenantTeam(...).save(flush: true, failOnError: true)
        //new TenantTeam(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tenantTeam.id
    }

    void "test get"() {
        setupData()

        expect:
        tenantTeamService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TenantTeam> tenantTeamList = tenantTeamService.list(max: 2, offset: 2)

        then:
        tenantTeamList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tenantTeamService.count() == 5
    }

    void "test delete"() {
        Long tenantTeamId = setupData()

        expect:
        tenantTeamService.count() == 5

        when:
        tenantTeamService.delete(tenantTeamId)
        sessionFactory.currentSession.flush()

        then:
        tenantTeamService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TenantTeam tenantTeam = new TenantTeam()
        tenantTeamService.save(tenantTeam)

        then:
        tenantTeam.id != null
    }
}
