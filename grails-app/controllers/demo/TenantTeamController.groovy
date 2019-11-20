package demo

import grails.validation.ValidationException
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

@Secured("ROLE_ADMIN")
class TenantTeamController {

    TenantTeamService tenantTeamService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tenantTeamService.list(params), model:[tenantTeamCount: tenantTeamService.count()]
    }

    def show(Long id) {
        respond tenantTeamService.get(id)
    }

    def create() {
        respond new TenantTeam(params)
    }

    def save(TenantTeam tenantTeam) {
        if (tenantTeam == null) {
            notFound()
            return
        }

        try {
            tenantTeamService.save(tenantTeam)
        } catch (ValidationException e) {
            respond tenantTeam.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tenantTeam.label', default: 'TenantTeam'), tenantTeam.id])
                redirect tenantTeam
            }
            '*' { respond tenantTeam, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tenantTeamService.get(id)
    }

    def update(TenantTeam tenantTeam) {
        if (tenantTeam == null) {
            notFound()
            return
        }

        try {
            tenantTeamService.save(tenantTeam)
        } catch (ValidationException e) {
            respond tenantTeam.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tenantTeam.label', default: 'TenantTeam'), tenantTeam.id])
                redirect tenantTeam
            }
            '*'{ respond tenantTeam, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tenantTeamService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tenantTeam.label', default: 'TenantTeam'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tenantTeam.label', default: 'TenantTeam'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
