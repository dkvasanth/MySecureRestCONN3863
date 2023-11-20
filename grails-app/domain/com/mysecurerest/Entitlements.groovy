package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/groups',formats=['json', 'xml'])
class Entitlements {
    String entitlementname
    String entitlementid
    static mapping = {
        version false
        table 'ENTITLEMENTS'

        //id column: 'id', generator:'CustomGenerator',   unique:"true"
        columns {
            entitlementid column: 'ENTITLEMENTID', type : 'text'
            entitlementname column: 'ENTITLEMENTNAME', type : 'text'
        }
    }

    static constraints = {
        entitlementid blank: false
        entitlementname blank: false
    }
}
