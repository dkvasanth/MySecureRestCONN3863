package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/accountentitlements',formats=['json', 'xml'])
class AccountEntitlements {
    static belongsTo = [entitlementid: Entitlements, email:Users]
    String entitlementid
    String email
    static mapping = {
        version false
        table 'ACCOUNTENTITLEMENT'
        //id column: 'acctentid', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"
        columns {
            entitlementid column: 'ENTITLEMENTID'
            email column: 'EMAIL'
        }
    }

    static constraints = {
        entitlementid blank: false
        email blank: false

    }
}
