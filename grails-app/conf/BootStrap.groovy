import com.mysecurerest.*


class BootStrap {

    def init = { servletContext ->
        //def acct1 = new Accounts(name:"vasanth", email:"aa@gmail.com",role:"developer").save flush:true
        //def acct2 =new Accounts(name:"ananth", email:"bb@gmail.com",role:"admin").save flush:true
        //def acct3 =new Accounts(name:"kamal", email:"cc@gmail.com",role:"hr").save flush:true
        def role1 = new Authority(authority:"ROLE_USER").save flush:true
        def user1 = new User(username:"user1",password:"pwd1").save flush:true
        UserAuthority.create(user1,role1)
    }
    def destroy = {
    }
}
