import demo.*
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    currentUserTenantResolver(CurrentUserTenantResolver)
    customUserDetailsService(CustomUserDetailsService)
}
