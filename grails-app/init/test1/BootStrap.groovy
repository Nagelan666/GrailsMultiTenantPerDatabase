package test1

import demo.*

class BootStrap {

    def init = { servletContext ->
        if (User.count < 1 ){
            def user = new User(username: "admin",password: "123456",tenantId: "11111").save(flush:true)
            def role = new Role(authority: "ROLE_ADMIN").save(flush:true)
            new UserRole(user: user,role: role).save(flush:true)
        }
    }
    def destroy = {
    }
}
