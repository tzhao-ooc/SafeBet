
let button; // "Create" signup entry
let signupInfo = []; //stores email, user, passwords
let signupStatus = false; // if false, do not send to backend.
let email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // used to validate email


document.addEventListener('DOMContentLoaded', function() {
    
//     button = document.querySelector('input[class="btn"]');
//     button.addEventListener('click', function(evt){

//         evt.preventDefault()
        
//         signupInfo = [];

//         signupInfo.push(document.getElementById('email').value)
//         signupInfo.push(document.getElementById('username').value)
//         signupInfo.push(document.getElementById('password').value)
//         signupInfo.push(document.getElementById('confirmP').value)
        
//         if(email.test(signupInfo[0]) == false)
//         {
//             alert("invalid email address.");
//             document.getElementById('email').value = '';

//             //FUTURE: I want "email" to turn red when users make this mistake.
//         }
//         else if((signupInfo[1]).length < 5)
//         {
//             alert("Username must be at least 5 characters in length");
//             document.getElementById('username').value = "";

//             //FUTURE: I want username to turn red if wrong.
//         }
//         else if(signupInfo[2] != signupInfo[3])
//         {
//             alert("Passwords do not match, they must be identical");
//             document.getElementById('password').value = '';
//             document.getElementById('confirmP').value = '';
            
//             // FUTURE: I want to make it so that "Create a Passowrd" and
//             // "Confirm Password" turn red when a user makes this mistake

//             // FUTURE: make it so passwords have at least 1 number and captial
//         }
//         else
//         {
//             //signupstatus must be true or else DO NOT send to backend.
//             signupStatus = true;
//         }

//         // inspect element on the webpage, and go to console to see what is returned
//         console.log(signupInfo)
//         console.log(signupStatus)


    function showErrMsg(ele) {
        let temp = ele;
        if(temp.nextElementSibling) return;
        ele.style.color = "red";
        ele.style.outlineColor = "red";
        temp.after(document.createElement("span"));
        temp.nextElementSibling.classList.add("errorMsg");
    }


    function ClearErrMsg(ele) {
        let temp = ele;
        if (!temp.nextElementSibling) return;
        ele.style.color = "black";
        ele.style.outlineColor = "lightgray";
        temp.nextElementSibling.remove();
    }

    document.getElementsByName("usrEmail")[0].addEventListener('change', checkEmail);
    document.getElementsByName("username")[0].addEventListener('change', checkUsername)
    document.getElementsByName("password")[0].addEventListener('change', checkPwd)
    document.getElementsByName("confirmP")[0].addEventListener('change', checkConfrimP)

    function checkEmail (evt) {
        var obj = evt.target;
        if (!email.test(obj.value)) {
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/> Email is invalid";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }

    function checkUsername (evt) {
        var obj = evt.target;
        if (obj.value.length < 5) {
           
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/>  Username must be at least 5 characters in length";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }

    function checkPwd (evt) {
        var obj = evt.target;
        if (obj.value.length < 4) {
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/>  Password must be at least 4 characters in length";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }

    function checkConfrimP (evt) {
        var obj = evt.target;
        var pwd = document.getElementsByName("password")[0].value;
        if (obj.value != pwd) {
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/>  Password must match";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }

    function readySubmit () {
        var error = 0;
        let inputElem = document.querySelectorAll('.usrInput');
        for ( let i of inputElem) {
            if (i.value == "") error++;
            if (i.nextElementSibling) error++;
        }
        if (error == 0) {
            document.getElementById("submitBTN").removeAttribute("disabled");
        }
    }

});



   
// });

// function init() {
//     let inputElem = document.querySelectorAll('.usrInput');
//     console.log(inputElem);
//     for ( let i of inputElem) {
//         i.addEventListener('change', handleUserInputChange);
//     }
//  }

// function handleUserInputChange(event) {
//     var obj = event.target;




//     if (!email.test(obj.value)) {
//         showErrMsg(obj);
//         console.log(obj.value);
//         console.log(obj.nextElementSibling);
//         obj.nextElementSibling.innerHtml = "<br/> Email is invalid";
//         return;
//     } else {
//         ClearErrMsg(obj);
//     }
// }

