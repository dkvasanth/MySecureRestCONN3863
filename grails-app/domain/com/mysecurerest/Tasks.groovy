package com.mysecurerest

import grails.rest.Resource

@Resource(uri='/api/tasks',formats=['json', 'xml'])

class Tasks implements Serializable {
    String short_description
    long id
    static mapping = {
        version false
        table 'Tasks'
        id column: 'id', generator: 'increment'
        //id column: 'id', generator:'CustomGenerator',   unique:"true"

    }

    static constraints = {
        short_description blank: false
        id blank: false

    }
}
