package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/group_memberships',formats=['json', 'xml'])
class Entitlements {
    long id
    String accountname
    String entitlementid
    static mapping = {
        version false
        table 'Entitlements'
        id column: 'id', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"

    }

    static constraints = {
        accountname blank: false
        entitlementid blank: false
        id blank: false


    }
}
