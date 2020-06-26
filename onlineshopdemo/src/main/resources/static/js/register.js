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

