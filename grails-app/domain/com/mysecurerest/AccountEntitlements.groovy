package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/accountentitlements',formats=['json', 'xml'])
class AccountEntitlements {
    static belongsTo = [entitlementid: Entitlements, userid:Users]
    long entitlementid
    long userid
    static mapping = {
        version false
        table 'AccountEntitlements'
        id column: 'acctentid', generator: 'increment'
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
