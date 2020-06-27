// create captcha for register
function createCaptcha() {
    let captcha = "";
    document.getElementById("captcha").value = "";
    let arr = [0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z'];
    for(let i=0;i<4;i++) {
        let thisChar = Math.floor(Math.random()*(26*2+10));//隨機亂數取哪個
        captcha+=arr[thisChar];
    }
    if(captcha.length!=4){
        captcha="";
        createCaptcha();
    }else{
        document.getElementById("captcha").placeholder = captcha;//將驗證碼插入空位
    }

}

// regular expression
function check_data() {
    let username = document.userForm.username.value;
    let email = document.userForm.email.value;
    let pw1 = document.userForm.pw1.value;
    let pw2 = document.userForm.pw2.value;
    let captcha = document.userForm.captcha.placeholder;
    let confirmCaptcha = document.userForm.confirmCaptcha.value;

    let usernameValidator = /^[a-zA-Z]\w{7,14}/;
    let emailValidator = /\w+@\w+\.\w+(\.\w+)*/;
    let passwordValidator = /^[a-zA-Z]\w{7,14}/;
    if (!usernameValidator.test(username)){
        alert("Please stick to username rule:a character first and length for 8-15")
    }else if(!emailValidator.test(email)){
        alert("Please input right email.")
    }else if(!passwordValidator.test(pw1)&passwordValidator.test(pw2)){
        alert("Please stick to password rule:a character first and length for 8-15")
    }else if (pw1!=pw2){
        alert("Please confirm input same password");
    }else if(confirmCaptcha!=captcha){
        alert("Wrong captcha");
    }else {
        document.userForm.submit();
    }
}