package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/users',formats=['json', 'xml'])
class Users implements Serializable {


    String firstname
    String lastname
    String status
    String email

    String getAccountname() {
        return firstname + " " + lastname
    }
    String accountname

    static mapping = {
        version false
        table 'USERS'
        //id column: 'id', generator: 'assigned'
        //id column: 'userid', generator:'CustomGenerator',   unique:"true"
        columns{
            email column: 'EMAIL', type: 'text'
            firstname column: 'FIRSTNAME', type: 'text'
            lastname column: 'LASTNAME', type: 'text'
            status column: 'STATUS', type: 'text'
            accountname column: 'ACCOUNTNAME', type: 'text'
        }


    }

    static constraints = {
        firstname blank: false
        lastname blank: false
        status blank: false
        email blank: false
        accountname blank: false
    }

}
