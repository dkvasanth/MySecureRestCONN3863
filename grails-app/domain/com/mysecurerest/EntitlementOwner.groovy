package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/entitlementowners',formats=['json', 'xml'])
class EntitlementOwner {

    static belongsTo = [entitlementid: Entitlements, email:Users]
    String entitlementid
    String email
    static mapping = {
        version false
        table 'ENTITLEMENTOWNER'
        //id column: 'entownerid', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"
        columns {
            entitlementid column: 'ENTITLEMENTID', type: 'text'
            email column: 'EMAIL', type: 'text'
        }
    }

    static constraints = {
        entitlementid blank: false
        email blank: false

    }
}
