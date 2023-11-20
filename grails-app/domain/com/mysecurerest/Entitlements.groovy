package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/groups',formats=['json', 'xml'])
class Entitlements {
    String entitlementname
    static mapping = {
        version false
        table 'Entitlements'
        id column: 'entitlementid', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"
        columns {
            entitlementname column: 'entitlementname'
        }
    }

    static constraints = {
        entitlementname blank: false
    }
}
