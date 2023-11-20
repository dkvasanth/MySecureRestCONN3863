package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/entitlementowners',formats=['json', 'xml'])
class EntitlementOwner {

    static belongsTo = [entitlementid: Entitlements, userid:Users]
    long entitlementid
    long userid
    static mapping = {
        version false
        table 'EntitlementOwner'
        id column: 'entownerid', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"
        columns {
            entitlementid column: 'entitlementid'
            userid column: 'userid'
        }
    }

    static constraints = {
        entitlementid blank: false
        userid blank: false

    }
}
