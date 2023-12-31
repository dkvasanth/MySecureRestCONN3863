// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
        log4j = {
            error 'grails.app.controllers', 'grails.app.services', 'grails.app.task', 'grails.app.jobs'
            warn 'grails.app.controllers', 'grails.app.services', 'grails.app.task', 'grails.app.jobs'
            debug 'grails.app.controllers', 'grails.app.services', 'grails.app.task', 'grails.app.jobs', 'com.mysecurerest'

            appenders {
                rollingFile name: 'infoLog', file: 'C:/Workspace/RestApi/MySecureRest3/info.log', threshold: org.apache.log4j.Level.INFO, maxFileSize: '10240KB'
                rollingFile name: 'debugLog', file: 'C:/Workspace/RestApi/MySecureRest3/debugLog.log', threshold: org.apache.log4j.Level.DEBUG, maxFileSize: '102400KB', maxBackupIndex: 100
                rollingFile name: 'warnLog', file: 'C:/Workspace/RestApi/MySecureRest3/warn.log', threshold: org.apache.log4j.Level.WARN, maxFileSize: '10240KB'
                rollingFile name: 'errorLog', file: 'C:/Workspace/RestApi/MySecureRest3/error.log', threshold: org.apache.log4j.Level.ERROR, maxFileSize: '10240KB'
                rollingFile name: 'custom', file: 'C:/Workspace/RestApi/MySecureRest3/custom.log', maxFileSize: '10240KB', maxBackupIndex: 10
            }

            root {
                info 'infoLog', 'debugLog', 'warnLog', 'errorLog', 'custom'
                error()
                additivity = true
            }
        }
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.mysecurerest.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.mysecurerest.UserAuthority'
grails.plugin.springsecurity.authority.className = 'com.mysecurerest.Authority'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                ['permitAll'],
	'/index':           ['permitAll'],
	'/index.gsp':       ['permitAll'],
	'/assets/**':       ['permitAll'],
	'/**/js/**':        ['permitAll'],
	'/**/css/**':       ['permitAll'],
	'/**/images/**':    ['permitAll'],
	'/**/favicon.ico':  ['permitAll'],
    '/api/login':       ['permitAll'],
    '/api/logout':      ['isFullyAuthenticated()'],
    '/api/accounts':    ['isFullyAuthenticated()'],
    '/api/users':    ['isFullyAuthenticated()'],
    '/**':             ['isFullyAuthenticated()']
]
grails.plugin.springsecurity.filterChain.chainMap = [
        '/api/**': 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter, -httpSessionContextIntegrationFilter', // Stateless chain
        '/**': 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'                                                                          // Traditional chain
]
grails.plugin.springsecurity.useBasicAuth = true

//grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
//grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
//grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'


//grails.plugin.springsecurity.rest.token.storage.memcached.hosts = 'localhost:11211'
//grails.plugin.springsecurity.rest.token.storage.memcached.username = ''
//grails.plugin.springsecurity.rest.token.storage.memcached.password = ''
//grails.plugin.springsecurity.rest.token.storage.memcached.expiration = 3

//grails.plugin.springsecurity.rest.token.storage.useJwt	= true
//grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true
//grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'vasanthdevabalanvasanthdevabalan'
//grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 350



