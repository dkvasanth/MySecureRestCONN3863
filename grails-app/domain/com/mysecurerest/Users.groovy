package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/users',formats=['json', 'xml'])
class Users implements Serializable {


    String firstname
    String lastname
    String status
    String email
    String accountname

    static mapping = {
        version false
        table 'users'
        //id column: 'id', generator: 'assigned'
        //id column: 'userid', generator:'CustomGenerator',   unique:"true"
        id column: 'userid', generator: 'increment'

    }

    static constraints = {
        firstname blank: false
        lastname blank: false
        status blank: false
        email blank: false

    }

}
