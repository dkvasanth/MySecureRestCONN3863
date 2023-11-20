package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/users',formats=['json', 'xml'])
class Users implements Serializable {


    String firstname
    String lastname
    String id
    String status
    String email
    String accountname

    static mapping = {
        version false
        table 'users'
        //id column: 'id', generator: 'assigned'
        id column: 'id', generator:'CustomGenerator',   unique:"true"

    }

    static constraints = {
        firstname blank: false
        lastname blank: false
        id blank: false
        status blank: false
        email blank: false

    }

}
